package Prog

object UpgradedEuler {
  def solve(func: (Double, Double) => Double, start: (Double, Double), b: Double, h: Double): IndexedSeq[(Double, Double)] = {
    var y0 = start._2
    var xi: Double = start._1
    var data = IndexedSeq[(Double, Double)]((xi, y0))
    println("Усовершенствованный метод Эйлера:\ni   xi   y0    f()   yi+1")
    while (xi < b) {
      val yi = y0 + h / 2 * (func(xi, y0)+ func(xi, y0 + h * func(xi, y0)))
      data = data :+ (xi, yi)
      println(f"${((xi - start._1) / h).toInt}  $xi%1.1f  $y0%1.2f  ${func(xi,y0)}%1.2f  $yi%1.2f" +
        f"")
      xi += h
      y0 = yi
    }
    data
  }
}

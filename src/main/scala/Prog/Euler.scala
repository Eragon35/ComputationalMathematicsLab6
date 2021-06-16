package Prog

object Euler {
  def solve(func: (Double, Double) => Double, start: (Double, Double), b: Double, h: Double): IndexedSeq[(Double, Double)] = {
    var y0 = start._2
    var xi: Double = start._1
    var data = IndexedSeq[(Double, Double)]((xi, y0))
    println("Усовершенствованный метод Эйлера:\ni   xi    yi     f()")
    while (xi < b) {
      val yi = y0 + h * func(xi, y0)
      println(f"${((xi - start._1) / h).toInt}  $xi%1.1f  $y0%1.3f  ${func(xi,y0)}%1.3f ")
      xi += h
      data = data :+ (xi, yi)
      y0 = yi
    }
    data
  }
}

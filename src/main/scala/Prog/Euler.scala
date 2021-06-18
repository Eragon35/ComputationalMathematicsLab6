package Prog

object Euler {
  def solve(func: (Double, Double) => Double, start: (Double, Double), b: Double, h: Double): IndexedSeq[(Double, Double)] = {
    var y0 = start._2
    var xi: Double = start._1
    var data = IndexedSeq[(Double, Double)]((xi, y0))
    println("Метод Эйлера:\ni   xi     yi      f()")
    // Yi+1 = Yi + h * F(Xi, Yi)
    while (xi < b + .00001) {
      val yi = y0 + h * func(xi, y0)
      println(f"${((xi - start._1) / h + 0.1).toInt}  $xi%1.2f  $y0%1.4f  ${func(xi,y0)}%1.4f")
      xi += h
      data = data :+ (xi, yi)
      y0 = yi
    }
    data.dropRight(1)
  }
}

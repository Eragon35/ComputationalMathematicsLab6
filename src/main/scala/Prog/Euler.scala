package Prog

object Euler {
  def solve(equation: Equation): IndexedSeq[(Double, Double)] = {
    var y0 = equation.start._2
    var xi: Double = equation.start._1
    var data = IndexedSeq[(Double, Double)]((xi, y0))
    println("Метод Эйлера:\ni   xi     yi      f()      точное значение")
    // Yi+1 = Yi + h * F(Xi, Yi)
    while (xi < equation.end + .00001) {
      val yi = y0 + equation.h * equation.func(xi, y0)
      println(f"${((xi - equation.start._1) / equation.h + 0.1).toInt}  $xi%1.2f  " +
        f"$y0%1.4f  ${equation.func(xi,y0)}%1.4f   ${equation.solution(xi)}%1.4f")
      xi += equation.h
      data = data :+ (xi, yi)
      y0 = yi
    }
    data.dropRight(1)
  }
}

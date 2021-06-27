package Prog

import scala.annotation.tailrec

object Euler {
  def solve(equation: Equation, h: Double): IndexedSeq[(Double, Double)] = {
    var y0 = equation.start._2
    var xi: Double = equation.start._1
    var data = IndexedSeq[(Double, Double)]((xi, y0))
    var answer = "Метод Эйлера:\ni   xi     yi      f()      точное значение\n"
    // Yi+1 = Yi + h * F(Xi, Yi)
    while (xi + h < equation.end + .00001) {
      val yi = y0 + h * equation.func(xi, y0)
      xi += h
      if (Math.abs(yi - equation.solution(xi)) > equation.accuracy) return solve(equation, h / 2)
      answer += f"${((xi - equation.start._1) / h + 0.1).toInt}  $xi%1.2f  " +
        f"$yi%1.4f  ${equation.func(xi, y0)}%1.4f   ${equation.solution(xi)}%1.4f\n"
      data = data :+ (xi, yi)
      y0 = yi
    }
    println(answer)
    data
  }
}

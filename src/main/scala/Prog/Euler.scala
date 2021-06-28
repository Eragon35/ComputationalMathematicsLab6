package Prog


object Euler {
  def solve(equation: Equation, h: Double): IndexedSeq[(Double, Double)] = {
    var y0 = equation.start._2
    var xi: Double = equation.start._1
    var data = IndexedSeq[(Double, Double)]((xi, y0))
    var answer = "Метод Эйлера:\n\t\t\t\t\t\t  точное\ni   xi     yi      f()   значение погрешность\n"
    // Yi+1 = Yi + h * F(Xi, Yi)
    while (xi + h < equation.end + .00001) {
      val yi = y0 + h * equation.func(xi, y0)
      xi += h
      // calculate R
      val y0r = y0 + h / 2 * equation.func(xi, y0)
      val yir = y0r + h / 2 * equation.func(xi + h / 2, y0r)
      val r = Math.abs(yi - yir) / (2 - 1)
      if (Math.abs(yi - equation.solution(xi)) > equation.accuracy) return solve(equation, h / 2)
      answer += f"${((xi - equation.start._1) / h + 0.1).toInt}  $xi%1.2f  " +
        f"$yi%1.4f  ${equation.func(xi, y0)}%1.4f   ${equation.solution(xi)}%1.4f   $r%1.4f\n"
      data = data :+ (xi, yi)
      y0 = yi
    }
    println(answer)
    data
  }
}

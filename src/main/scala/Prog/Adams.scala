package Prog

import java.lang.Math.pow

object Adams {
  def solve(equation: Equation, h: Double, recursion: Boolean = true): IndexedSeq[(Double, Double)] = {
    var (data, lines) = euler(equation, h)
    var xi: Double = data.last._1 + h
//    var lines = IndexedSeq[String]()
    // Yi+1 = Yi + h * Fi + h^2/2 * ΔFi + 5h^3/12 * Δ^2Fi + 3h^4/8 * Δ^3Fi
    while (xi < equation.end + .00001) {
      val Fmin3 = equation.func(data(data.size - 4)._1, data(data.size - 4)._2)
      val Fmin2 = equation.func(data(data.size - 3)._1, data(data.size - 3)._2)
      val Fmin1 = equation.func(data(data.size - 2)._1, data(data.size - 2)._2)
      val Fi = equation.func(data.last._1, data.last._2)
      val delta1h = 1 / 2 * pow(h, 2) * (Fi - Fmin1) // h^2/2 * ΔFi
      val delta2h = 5 / 12 * pow(h, 3) * (Fi - 2 * Fmin1 + Fmin2) // 5h^3/12 * Δ^2Fi
      val delta3 = Fi - 3 * Fmin1 + 3 * Fmin2 - Fmin3 // Δ^3Fi
      val yi = data.last._2 + h * Fi + delta1h + delta2h + 3 / 8 * pow(h, 4) * delta3 // Yi+1
      // calculate R
      if (Math.abs(yi - equation.solution(xi)) > equation.accuracy) return solve(equation, h / 2)
      lines = lines :+ f"${((xi - equation.start._1) / h + 0.1).toInt}  $xi%1.2f  " +
        f"$yi%1.4f  ${equation.func(xi, yi)}%1.4f   ${equation.solution(xi)}%1.4f"
      data = data :+ (xi, yi)
      xi += h
    }
    if (recursion) {
      val y2h = solve(equation, h / 2 , recursion = false)
      val r = y2h.zipWithIndex.filter { case (_, i) => (i + 1) % 2 != 0 }.map { case (v, _) => v}
      var answer = "Метод Адамса:\n\t\t\t\t\t\t  точное\ni   xi     yi      f()   значение погрешность\n"
      for (i <- lines.indices) answer += lines(i) + f"   ${(data(i)._2 - r(i)._2) / 15}%1.4f\n"
      println(answer)
    }
    data
  }

  private def euler(equation: Equation, h: Double): (IndexedSeq[(Double, Double)], IndexedSeq[String]) = {
    var answer = IndexedSeq[(Double, Double)]((equation.start._1, equation.start._2))
    var lines = IndexedSeq[String]()
    for (i <- 1 until 4) {
      val yi = answer.last._2 + h * equation.func(answer.last._1, answer.last._2)
      lines = lines :+ f"$i  ${equation.start._1 + h * i}%1.2f  $yi%1.4f  " +
        f"${equation.func(answer.last._1, answer.last._2)}%1.4f   ${equation.solution(equation.start._1 + h * i)}%1.4f"
      answer = answer :+ (equation.start._1 + h * i, yi)
    }
    (answer, lines)
  }
}

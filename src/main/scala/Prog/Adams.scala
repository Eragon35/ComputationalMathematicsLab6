package Prog

import java.lang.Math.pow
import scala.annotation.tailrec

object Adams {
  @tailrec
  def solve(equation: Equation, h: Double): IndexedSeq[(Double, Double)] = {
    var data = euler(equation, h)
    var xi: Double = data.last._1 + h
    var answer = "Метод Адамса:\ni   xi     yi      f()      точное значение\n"
    // Yi+1 = Yi + h * Fi + h^2/2 * ΔFi + 5h^3/12 * Δ^2Fi + 3h^4/8 * Δ^3Fi
    try {
      while (xi < equation.end + .00001) {
        val Fmin3 = equation.func(data(data.size - 4)._1, data(data.size - 4)._2)
        val Fmin2 = equation.func(data(data.size - 3)._1, data(data.size - 3)._2)
        val Fmin1 = equation.func(data(data.size - 2)._1, data(data.size - 2)._2)
        val Fi = equation.func(data.last._1, data.last._2)
        val delta1h = 1 / 2 * pow(h, 2) * (Fi - Fmin1) // h^2/2 * ΔFi
        val delta2h = 5 / 12 * pow(h, 3) * (Fi - 2 * Fmin1 + Fmin2) // 5h^3/12 * Δ^2Fi
        val delta3 = Fi - 3 * Fmin1 + 3 * Fmin2 - Fmin3 // Δ^3Fi
        val yi = data.last._2 + h * Fi + delta1h + delta2h + 3 / 8 * pow(h, 4) * delta3 // Yi+1
        if (Math.abs(yi - equation.solution(xi)) > equation.accuracy) throw new Exception
        answer += f"${((xi - equation.start._1) / h + 0.1).toInt}  $xi%1.2f  " +
          f"$yi%1.4f  ${equation.func(xi, yi)}%1.4f   ${equation.solution(xi)}%1.4f\n"
        data = data :+ (xi, yi)
        xi += h
      }
      println(answer)
      data
    } catch {
      case e: Exception =>
        solve(equation, h / 2)
    }
  }

  private def euler(equation: Equation, h: Double): IndexedSeq[(Double, Double)] = {
    var answer = IndexedSeq[(Double, Double)]((equation.start._1, equation.start._2))
    for (i <- 1 until 4) answer  = answer :+ (equation.start._1 + h * i,
      answer.last._2 + h * equation.func(answer.last._1, answer.last._2))
    answer
  }
}

package Prog

object TrueSolution {
  def solve(equation: Equation, h: Double): IndexedSeq[(Double, Double)] = {
    var data = IndexedSeq[(Double, Double)]()
    for (i <- equation.start._1 to equation.end by h / 10) data = data :+ (i, equation.solution(i))
    data
  }
}

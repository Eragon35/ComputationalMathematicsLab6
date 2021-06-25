package Prog

object TrueSolution {
  def solve(equation: Equation): IndexedSeq[(Double, Double)] = {
    var data = IndexedSeq[(Double, Double)]()
    for (i <- equation.start._1 to equation.end by equation.h / 2) data = data :+ (i, equation.solution(i))
    data
  }
}

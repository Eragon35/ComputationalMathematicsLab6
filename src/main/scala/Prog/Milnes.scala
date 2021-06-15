package Prog

object Milnes {
  def solve(func: (Double, Double) => Double, start: (Double, Double), b: Double,
            h: Double, euler: IndexedSeq[(Double, Double)]): IndexedSeq[(Double, Double)] = {
    var y0 = start._2
    var xi: Double = start._1
    var data = euler.slice(0, 4)
    while (xi < b) {
      val inner = 2 * data(data.size - 3)._2 - data(data.size - 2)._2 + 2 * data(data.size - 1)._2
      val predicted = data(data.size - 4)._2 + 4 / 3 * h * (inner)
      val corrected = data(data.size - 2) + h / 3 * (data(data.size - 2) - 4 * data(data.size - 1) + 2 * predicted)

    }
    data
  }

}

package Prog

object Adams {
  def solve(func: (Double, Double) => Double, start: (Double, Double), b: Double,
            h: Double, euler: IndexedSeq[(Double, Double)]): IndexedSeq[(Double, Double)] = {
    var xi: Double = start._1 + h * 4
    var data = euler.slice(0, 4)
    println("Метод Адамса:\ni   xi     yi      f()")
    // Yi+1 = Yi + h * Fi + h^2/2 * ΔFi + 5h^3/12 * Δ^2Fi + 3h^4/8 * Δ^3Fi
    while (xi < b + .00001) {
      val Fmin2 = func(data(data.size - 3)._1, data(data.size - 3)._2)
      val Fmin1 = func(data(data.size - 2)._1, data(data.size - 2)._2)
      val Fi = func(data.last._1, data.last._2)
      val delta = 1 / 2 * Math.pow(h, 2) * (Fi - Fmin1)
      val delta2 = 5 / 12 * Math.pow(h, 3) * (Fi - 2 * Fmin1 + Fmin2)
      val delta3 = Fi - 3 * Fmin1 + 3 * Fmin2 - func(data(data.size - 4)._1, data(data.size - 4)._2)
      val yi = data.last._2 + h * Fi + delta + delta2 + 3 / 8 * Math.pow(h, 4) * delta3
      println(f"${((xi - start._1) / h + 0.1).toInt}  $xi%1.2f  $yi%1.4f  ${func(xi,yi)}%1.4f")
      data = data :+ (xi, yi)
      xi += h
    }
    data
  }
}

package Prog

import scala.io.StdIn

object Main extends App {
  var x: Double = 0.0
  println(
    """ Вариант №2
      | 1) y' = y + (1 + x) * y^2; y(1) = -1
      | 2) y' = (x-y)^2 + 1; y(0) = 0
      | 3) y' = xe^(-x)^2 - 2 * xy; y(-1) = 1 / 2e""".stripMargin)
  // Одношаговые методы - метод Эйлера
  // Многошаговые методы - метод Адамса
  while (true) {
    val equation = ConsoleHandler.inputData()
    val euler = Euler.solve(equation)
    val adams = Adams.solve(equation, euler)
    for (i <- euler.indices) println(s"${euler(i)._1} euler = ${euler(i)._2}; adams = ${adams(i)._2}")
    Graph.show(euler, adams)
  }
}

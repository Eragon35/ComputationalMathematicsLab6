package Prog

import scala.io.StdIn

object Main extends App {
  var x: Double = 0.0
  println(
    """ Вариант №2
      | 1) y' = y + (1 + x) * y^2; y(1) = -1
      | 2) y' = (x-y)^2 + 1; y(0) = 0
      | 3) y' = xe^(-x)^2 - 2 * xy; y(-1) = 1 / 2e
      | 4) y' = x^2 - 2y; y(0) = 1""".stripMargin)
  // Одношаговые методы - метод Эйлера
  // Многошаговые методы - метод Адамса
  while (true) {
    println("Выберите функицю:")
    val tmp = ConsoleHandler.inputFunc(StdIn.readLine())
    val func = tmp._1
    val start = tmp._2
    println("Введите правую границы:")
    val b = ConsoleHandler.inputData(StdIn.readLine())
    println("Введите шаг")
    val step = ConsoleHandler.inputData(StdIn.readLine())
    val euler = Euler.solve(func, start, b, step)
    val adams = Adams.solve(func, start, b, step, euler)
    for (i <- euler.indices) println(s"${euler(i)._1} euler = ${euler(i)._2}; adams = ${adams(i)._2}")
    Graph.show(euler, adams)
  }
}

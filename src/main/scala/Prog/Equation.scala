package Prog

case class Equation(func: (Double, Double) => Double, start: (Double, Double),
                    end: Double, h: Double, solution: Double => Double) { }

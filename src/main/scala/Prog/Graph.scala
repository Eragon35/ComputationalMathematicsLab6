package Prog

import scalax.chart.module.Charting._

object Graph {
  def show(euler: IndexedSeq[(Double, Double)], adams: IndexedSeq[(Double, Double)]): Unit =
    XYLineChart(IndexedSeq(("Метод Эйлера", euler),("Метод Адамса", adams)).toXYSeriesCollection()).show("График функции", scrollable = true)
}

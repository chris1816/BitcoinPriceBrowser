/*
package com.example.domain.utils

import android.graphics.Color.parseColor


class ChartUtils {

    companion object {
        private const val LINECOLOR = "#D81B60"

        fun initChart(chart: LineChart): LineChart {
            return chart
        }

        fun notifyDataSetChanged(chart: LineChart, values: List<Entry>) {
            chart.xAxis.valueFormatter = IAxisValueFormatter {
                    value, axis -> TimeStampUtils.convertTimeStamp(value)}
            chart.invalidate()
            setChartData(chart, values)
        }

        private fun setChartData(chart: LineChart, values: List<Entry>) {
            val lineDataSet: LineDataSet

            if (chart.data != null && chart.data.dataSetCount > 0) {
                lineDataSet = chart.data.getDataSetByIndex(0) as LineDataSet
                lineDataSet.values = values
                chart.data.notifyDataChanged()
                chart.notifyDataSetChanged()
            } else {
                lineDataSet = LineDataSet(values, "")
                lineDataSet.color = parseColor(LINECOLOR)
                lineDataSet.mode = LineDataSet.Mode.CUBIC_BEZIER
                lineDataSet.setDrawCircles(true)
                lineDataSet.setDrawValues(true)
                lineDataSet.isHighlightEnabled = false

                val data = LineData(lineDataSet)
                chart.data = data
                chart.invalidate()
            }
        }
    }
}*/

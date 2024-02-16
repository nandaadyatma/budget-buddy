package com.example.budgetbuddy.ui

import android.graphics.drawable.GradientDrawable
import android.hardware.lights.Light
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.yml.charts.axis.AxisData
import co.yml.charts.common.model.Point
import co.yml.charts.ui.linechart.LineChart
import co.yml.charts.ui.linechart.model.GridLines
import co.yml.charts.ui.linechart.model.IntersectionPoint
import co.yml.charts.ui.linechart.model.Line
import co.yml.charts.ui.linechart.model.LineChartData
import co.yml.charts.ui.linechart.model.LinePlotData
import co.yml.charts.ui.linechart.model.LineStyle
import co.yml.charts.ui.linechart.model.LineType
import co.yml.charts.ui.linechart.model.SelectionHighlightPoint
import co.yml.charts.ui.linechart.model.SelectionHighlightPopUp
import co.yml.charts.ui.linechart.model.ShadowUnderLine
import com.example.budgetbuddy.R
import com.example.budgetbuddy.ui.theme.GreenIncome
import com.example.budgetbuddy.ui.theme.GreyLine
import com.example.budgetbuddy.ui.theme.LightBackground
import com.example.budgetbuddy.ui.theme.RedExpense

@Composable
fun HomeScreen() {
    Box(
        modifier =
        Modifier
            .fillMaxSize()
            .background(LightBackground)
    ) {

    }
    Image(
        painter = painterResource(id = R.drawable.background_gradient),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier.height(200.dp)
    )
    Column {
        GreetingSection()
        DashboardSection(data = DashboardData(20000, 100000, 80000))
        StatisticSection()
    }
}

@Composable
fun GreetingSection(name: String = "Nando") {
    Row(
        modifier = Modifier.padding(15.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.budgetbuddy_logo_white),
            contentDescription = "Logo",
            modifier = Modifier
                .size(50.dp)
                .padding(end = 18.dp)
        )

        Column {
            val greeting1 = stringResource(id = R.string.greeting1, name)
            Text(
                text = greeting1,
                fontSize = 16.sp,
                color = Color.White
            )
            Text(
                text = stringResource(id = R.string.greeting2),
                fontSize = 12.sp,
                color = Color.White
            )
        }
    }
}

@Composable
fun DashboardSection(data: DashboardData) {
    Card(
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color.White)
    ) {
        Column(
            Modifier
                .background(Color.White, RectangleShape)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.remaining_money),
                fontSize = 16.sp,
                modifier = Modifier.padding(top = 25.dp)
            )
            Text(
                text = "Rp${data.remainingMoney}",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 20.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(GreyLine)
            ) {

            }

            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(15.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.income),
                            contentDescription = "Income",
                            Modifier.size(20.dp)
                        )
                        Text(
                            text = stringResource(id = R.string.income),
                            fontSize = 12.sp,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                    Text(text = "Rp${data.income}", fontSize = 20.sp, color = GreenIncome)
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(15.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.expense),
                            contentDescription = "Income",
                            Modifier.size(20.dp)
                        )
                        Text(
                            text = stringResource(id = R.string.expense),
                            fontSize = 12.sp,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                    Text(text = "Rp${data.expense}", fontSize = 20.sp, color = RedExpense)
                }
            }
        }
    }
}

@Composable
fun StatisticSection(year: Int = 2023) {
    val steps = 5;
    val pointsData: List<Point> =
        listOf(
            Point(0f, 40f),
            Point(1f, 90f),
            Point(2f, 20f),
            Point(3f, 60f),
            Point(4f, 10f),
            Point(5f, 30f),
            Point(6f, 10f),
            Point(7f, 70f),
        )

    val pointsData2: List<Point> =
        listOf(
            Point(0f, 20f),
            Point(1f, 30f),
            Point(2f, 30f),
            Point(3f, 40f),
            Point(4f, 50f),
            Point(5f, 20f),
            Point(6f, 40f),
            Point(7f, 20f),
        )

    fun month(i: Int): String{
       when(i){
           0 -> return "Jan"
           1 -> return "Feb"
           2 -> return "Mar"
           3 -> return "Apr"
           4 -> return "May"
           5 -> return "Jun"
           6 -> return "Jul"
           7 -> return "Aug"
           8 -> return "Sep"
           9 -> return "Oct"
           10 -> return "Nov"
           11 -> return "Dec"
           else -> return "Unknown"
       }
    }

    val xAxisData = AxisData.Builder()
        .axisStepSize(50.dp)
        .backgroundColor(Color.Transparent)
        .steps(pointsData.size - 1)
        .labelData { i -> month(i) }
        .labelAndAxisLinePadding(15.dp)
        .axisLineColor(MaterialTheme.colorScheme.tertiary)
        .axisLabelColor(MaterialTheme.colorScheme.tertiary)
        .build()

    val yAxisData = AxisData.Builder()
        .steps(steps)
        .backgroundColor(Color.Transparent)
        .labelAndAxisLinePadding(20.dp)
        .labelData { i ->
            val yScale = 100 / steps
            (i * yScale).toString()

        }
        .axisLineColor(MaterialTheme.colorScheme.tertiary)
        .axisLabelColor(MaterialTheme.colorScheme.tertiary)
        .build()

    val lineChartData = LineChartData(
        linePlotData = LinePlotData(
            lines = listOf(
                Line(
                    dataPoints = pointsData,
                    LineStyle(
                        lineType = LineType.Straight(isDotted = false),
                        color = Color(0xFFEF4E4E),
                        width = 6f
                    ),
                    IntersectionPoint(radius = 3.dp, color = Color(0xffEB3B3B)),
                    SelectionHighlightPoint(),
                    ShadowUnderLine(
                        alpha = 0.5f,
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color(0xffEF4E4E),
                                Color.Transparent
                            )
                        )
                    ),
                    SelectionHighlightPopUp()
                ),
                Line(
                    dataPoints = pointsData2,
                    LineStyle(
                        lineType = LineType.Straight(isDotted = false),
                        color = Color(0xff1E947C),
                        width = 6f
                    ),
                    IntersectionPoint(radius = 3.dp, color = Color(0xff19715F)),
                    SelectionHighlightPoint(),
                    ShadowUnderLine(
                        alpha = 0.5f,
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color(0xff3EBD93),
                                Color.Transparent
                            )
                        )
                    ),
                    SelectionHighlightPopUp()
                ),
            ),
        ),
        xAxisData = xAxisData,
        yAxisData = yAxisData,
        gridLines = GridLines(),
        backgroundColor = Color.White
    )

    Card(
        modifier = Modifier
            .padding(horizontal = 15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color.White)
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {
            Text(
                text = stringResource(id = R.string.statistic),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 20.dp, top = 15.dp)
            )

            Text(
                text = stringResource(id = R.string.transaction_year, year),
                fontSize = 12.sp,
                modifier = Modifier.padding(start = 20.dp)
            )

            Column(Modifier.padding(15.dp)) {
                LineChart(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp),
                    lineChartData = lineChartData
                )
                
                Text(text = stringResource(id = R.string.see_detail_stats), modifier = Modifier.fillMaxWidth(), fontSize = 12.sp, textAlign = TextAlign.Center)

            }
        }

    }

}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}





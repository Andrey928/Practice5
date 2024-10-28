
abstract class Shape {
    abstract fun draw()
}


open class Point(var x: Double, var y: Double) : Shape() {
    open var color: String = "Black"

    override fun draw() {
        println("Point at ($x, $y) with color $color")
    }
}


class ColoredPoint(x: Double, y: Double, override var color: String) : Point(x, y) {
    override fun draw() {
        println("ColoredPoint at ($x, $y) with color $color")
    }
}


open class Line(var start: Point, var end: Point) : Shape() {
    open var color: String = "Black"

    override fun draw() {
        println("Line from ${start.x}, ${start.y} to ${end.x}, ${end.y} with color $color")
    }
}


class ColoredLine(start: Point, end: Point, override var color: String) : Line(start, end) {
    override fun draw() {
        println("ColoredLine from ${start.x}, ${start.y} to ${end.x}, ${end.y} with color $color")
    }
}


class Polygon(private val points: MutableList<Point>) : Shape() {
    var color: String = "Black"

    fun move(dx: Double, dy: Double) {
        for (point in points) {
            point.x += dx
            point.y += dy
        }
    }

    override fun draw() {
        println("Polygon with points:")
        points.forEach { println("(${it.x}, ${it.y})") }
        println("with color $color")
    }
}


fun main() {
    val shapes: Array<Shape> = arrayOf(
        Point(1.0, 2.0),
        ColoredPoint(3.0, 4.0, "Red"),
        Line(Point(0.0, 0.0), Point(5.0, 5.0)),
        ColoredLine(Point(1.0, 1.0), Point(4.0, 4.0), "Blue"),
        Polygon(mutableListOf(Point(0.0, 0.0), Point(1.0, 0.0), Point(1.0, 1.0), Point(0.0, 1.0)))
    )


    for (shape in shapes) {
        shape.draw()
    }


    if (shapes[4] is Polygon) {
        (shapes[4] as Polygon).move(2.0, 3.0)
        shapes[4].draw()
    }
}
@file:Suppress("UNUSED_PARAMETER")
package lesson2.task1

import lesson1.task1.discriminant
import java.lang.Math.*

/**
 * Пример
 *
 * Найти наименьший корень биквадратного уравнения ax^4 + bx^2 + c = 0
 */
fun minBiRoot(a: Double, b: Double, c: Double): Double {
    // 1: в главной ветке if выполняется НЕСКОЛЬКО операторов
    if (a == 0.0) {
        if (b == 0.0) return Double.NaN // ... и ничего больше не делать
        val bc = -c / b
        if (bc < 0.0) return Double.NaN // ... и ничего больше не делать
        return -Math.sqrt(bc)
        // Дальше функция при a == 0.0 не идёт
    }
    val d = discriminant(a, b, c)   // 2
    if (d < 0.0) return Double.NaN  // 3
    // 4
    val y1 = (-b + Math.sqrt(d)) / (2 * a)
    val y2 = (-b - Math.sqrt(d)) / (2 * a)
    val y3 = Math.max(y1, y2)       // 5
    if (y3 < 0.0) return Double.NaN // 6
    return -Math.sqrt(y3)           // 7
}

/**
 * Простая
 *
 * Мой возраст. Для заданного 0 < n < 200, рассматриваемого как возраст человека,
 * вернуть строку вида: «21 год», «32 года», «12 лет».
 */
fun ageDescription(age: Int): String {
    val a = age % 10.0
    val b = age % 100.0
    if ((a == 1.0 || b == 1.0) && (age != 11 && age != 111)) return "$age год"
    if ((a in 2..4 || b in 2..4) && ((age !in 12..14) && (age !in 112..114))) return "$age года"
    if (a == 0.0 || a in 5..9 || b == 0.0 || b in 5..9 || (age in 11..14) || (age in 111..114)) return "$age лет"
    return "$age error"
}

/**
 * Простая
 *
 * Путник двигался t1 часов со скоростью v1 км/час, затем t2 часов — со скоростью v2 км/час
 * и t3 часов — со скоростью v3 км/час.
 * Определить, за какое время он одолел первую половину пути?
 */
fun timeForHalfWay(t1: Double, v1: Double,
                   t2: Double, v2: Double,
                   t3: Double, v3: Double): Double {
    val s = (t1 * v1 + t2 * v2 + t3 * v3)   //весь путь
    val halfS = s / 2                       // половина пути
    val s1 = t1 * v1                        // путь первого участка
    val s2 = t2 * v2                        // путь второго участка
    if (halfS <= s1){
        val t = t1 - ((s1 - halfS) / v1)
        return (t)
    }
    if (halfS <= (s1 + s2)) {
        val t = t1 + (t2 - (((s1 + s2) - halfS) / v2))
        return (t)
    }
    if (halfS < s) {
        val t = t1 + t2 + (t3 - ((s - halfS) / v3))
        return (t)
    }
    return Double.NaN
}



/**
 * Простая
 *
 * Нa шахматной доске стоят черный король и две белые ладьи (ладья бьет по горизонтали и вертикали).
 * Определить, не находится ли король под боем, а если есть угроза, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от первой ладьи, 2, если только от второй ладьи,
 * и 3, если угроза от обеих ладей.
 * Считать, что ладьи не могут загораживать друг друга
 */
fun whichRookThreatens(kingX: Int, kingY: Int,
                       rookX1: Int, rookY1: Int,
                       rookX2: Int, rookY2: Int): Int {
    if ((kingX == rookX1 || kingY == rookY1) && (kingX == rookX2 || kingY == rookY2)) return 3
    if (kingX == rookX2 || kingY == rookY2) return 2
    if (kingX == rookX1 || kingY == rookY1) return 1
    return 0
}

/**
 * Простая
 *
 * На шахматной доске стоят черный король и белые ладья и слон
 * (ладья бьет по горизонтали и вертикали, слон — по диагоналям).
 * Проверить, есть ли угроза королю и если есть, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от ладьи, 2, если только от слона,
 * и 3, если угроза есть и от ладьи и от слона.
 * Считать, что ладья и слон не могут загораживать друг друга.
 */
fun rookOrBishopThreatens(kingX: Int, kingY: Int,
                          rookX: Int, rookY: Int,
                          bishopX: Int, bishopY: Int): Int {
    val x = abs(kingX - bishopX)    // этими действиями я хотел убедиться что на одной ли диагонали находиться слон и король
    val y = abs(kingY - bishopY)    // если х=у то они на одной диагонали, это значит что угроза для короля
    if ((x == y) && (kingX == rookX || kingY == rookY)) return 3
    if (x == y) return 2
    if (kingX == rookX || kingY == rookY) return 1
    return 0
}
/**
 * Простая
 *
 * Треугольник задан длинами своих сторон a, b, c.
 * Проверить, является ли данный треугольник остроугольным (вернуть 0),
 * прямоугольным (вернуть 1) или тупоугольным (вернуть 2).
 * Если такой треугольник не существует, вернуть -1.
 */
fun triangleKind(a: Double, b: Double, c: Double): Int {
    val cMAX = max(max(a , b) , c) // максимальное число
    val a1: Double // первое число
    val b1: Double // второе число
    when (cMAX){
       a -> {
           a1 = b
           b1 = c
       }
       b -> {
           a1 = a
           b1 = c
       }
       else -> {
           a1 = a
           b1 = b
       }
    }
    if (a1 + b1 > cMAX && a1 + cMAX > b1 && cMAX + b1 > a1) {     // если треугольник существует
        if (a1 * a1 + b1 * b1 < cMAX * cMAX) return 2
        if (a1 * a1 + b1 * b1 > cMAX * cMAX) return 0
        if (a1 * a1 + b1 * b1 == cMAX * cMAX) return 1
    }
    return -1
}
/**
 * Средняя
 *
 * Даны четыре точки на одной прямой: A, B, C и D.
 * Координаты точек a, b, c, d соответственно, b >= a, d >= c.
 * Найти длину пересечения отрезков AB и CD.
 * Если пересечения нет, вернуть -1.
 */
fun segmentLength(a: Int, b: Int, c: Int, d: Int): Int {
    if (d > b) {
        if (b < c && c <= d) return -1
        if (a < c && c <= b) return (b - c)
        if (c < a) return (b - a)
    return -1
    }
    if (a < d && d < b) {
        if (a < c && c <= d) return (d - c)
        if (c < a) return (d - a)
    }
    return -1
}

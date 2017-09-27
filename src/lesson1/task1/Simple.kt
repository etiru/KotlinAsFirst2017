@file:Suppress("UNUSED_PARAMETER")
package lesson1.task1

import java.lang.Math.*

/**
 * Пример
 *
 * Вычисление квадрата вещественного числа
 */
fun sqr(x: Double) = x * x

/**
 * Пример
 *
 * Вычисление дискриминанта квадратного уравнения
 */
fun discriminant(a: Double, b: Double, c: Double) = sqr(b) - 4 * a * c

/**
 * Пример
 *
 * Поиск одного из корней квадратного уравнения
 */
fun sqRoot(a: Double, b: Double, c: Double) = (-b + sqrt(discriminant(a, b, c))) / (2 * a)

/**
 * Пример
 *
 * Поиск произведения корней квадратного уравнения
 */
fun quadraticRootProduct(a: Double, b: Double, c: Double): Double {
    val sd = sqrt(discriminant(a, b, c))
    val x1 = (-b + sd) / (2 * a)
    val x2 = (-b - sd) / (2 * a)
    return x1 * x2 // Результат
}

/**
 * Пример главной функции
 */
fun main(args: Array<String>) {
    // Решаем x^2 - 3*x + 2 = 0
    val x1x2 = quadraticRootProduct(1.0, -3.0, 2.0)
    println("Root product: $x1x2")
}

/**
 * Тривиальная
 *
 * Пользователь задает время в часах, минутах и секундах, например, 8:20:35.
 * Рассчитать время в секундах, прошедшее с начала суток (30035 в данном случае).
 */
fun seconds(hours: Int, minutes: Int, seconds: Int): Int  {
    val chas = hours * 3600 // Переводим количество часов в секунды
    val min = minutes * 60  // Переводим количество минут в секунды
    val sec = chas + min + seconds // складываем секунды
    return sec // результат
}

/**
 * Тривиальная
 *
 * Пользователь задает длину отрезка в саженях, аршинах и вершках (например, 8 саженей 2 аршина 11 вершков).
 * Определить длину того же отрезка в метрах (в данном случае 18.98).
 * 1 сажень = 3 аршина = 48 вершков, 1 вершок = 4.445 см.
 */
fun lengthInMeters(sagenes: Int, arshins: Int, vershoks: Int): Double {
    val sahen = sagenes * 48 // переводим саженцы в вершки
    val arsh = arshins * 16 // переводим аршины в вершки
    val sumit = ( ( sahen + arsh + vershoks ) * 4.445 ) / 100 // длина в метрах
    return sumit // результат
}

/**
 * Тривиальная
 *
 * Пользователь задает угол в градусах, минутах и секундах (например, 36 градусов 14 минут 35 секунд).
 * Вывести значение того же угла в радианах (например, 0.63256).
 */
fun angleInRadian(grad: Int, min: Int, sec: Int): Double {
    val ugol = grad + min / 60.0 + sec / 3600.0  // перевод в градусы
    val perevod = ( ugol * PI ) / 180  // перевод в радианы
    return perevod // результат
}

/**
 * Тривиальная
 *
 * Найти длину отрезка, соединяющего точки на плоскости с координатами (x1, y1) и (x2, y2).
 * Например, расстояние между (3, 0) и (0, 4) равно 5
 */
fun trackLength(x1: Double, y1: Double, x2: Double, y2: Double): Double {
    val line = sqrt((sqr((x1 - x2)) + sqr((y1 - y2)))) // вычисление длины отрезка по двум точкам согласно формуле
    return line  // результат

}

/**
 * Простая
 *
 * Пользователь задает целое число, большее 100 (например, 3801).
 * Определить третью цифру справа в этом числе (в данном случае 8).
 */
fun thirdDigit(number: Int): Int {
    val division = number % 1000 // остаток от деления вида *,123 где 1 нужная цифра
    val div = division / 100 // целочисленное деление остатка вида 123 на 100, результат целое число нужная цифра
    return div // результат
}

/**
 * Простая
 *
 * Поезд вышел со станции отправления в h1 часов m1 минут (например в 9:25) и
 * прибыл на станцию назначения в h2 часов m2 минут того же дня (например в 13:01).
 * Определите время поезда в пути в минутах (в данном случае 216).
 */
fun travelMinutes(hoursDepart: Int, minutesDepart: Int, hoursArrive: Int, minutesArrive: Int): Int {
    val allHour = ((hoursArrive - hoursDepart) * 60)  // вычесление кол-во часов в кол-во минут
    val minutes = minutesArrive - minutesDepart  // минуты
    val allTime = allHour + minutes // сложение всех минут
    return allTime // результат

}

/**
 * Простая
 *
 * Человек положил в банк сумму в s рублей под p% годовых (проценты начисляются в конце года).
 * Сколько денег будет на счету через 3 года (с учётом сложных процентов)?
 * Например, 100 рублей под 10% годовых превратятся в 133.1 рубля
 */
fun accountInThreeYears(initial: Int, percent: Int): Double  {
    val allPercent =  percent / 100.0
    val firstYear = initial + (allPercent * initial)
    val secondYear = firstYear + (firstYear * allPercent)
    val thirdYear = secondYear + (secondYear * allPercent)
    return thirdYear
}

/**
 * Простая
 *
 * Пользователь задает целое трехзначное число (например, 478).
 *Необходимо вывести число, полученное из заданного перестановкой цифр в обратном порядке (например, 874).
 */
fun numberRevert(number: Int): Int {
    val firstNuber = (number / 100) // Получили х** целочисленным делением.
    val secondNuber =((number - (firstNuber*100)) / 10) * 10 // Получили *x* умноженное на 10
    val thirdNiber =(number % 10) * 100 // получили **х умноженное на 100
    val perNumber = thirdNiber + secondNuber + firstNuber // сложили
    return perNumber // результат
}
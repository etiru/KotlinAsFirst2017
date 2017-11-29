@file:Suppress("UNUSED_PARAMETER")
package lesson4.task1

import lesson1.task1.discriminant
import lesson2.task1.whichRookThreatens
import lesson3.task1.isPrime
import lesson3.task1.minDivisor
import sun.reflect.generics.tree.Tree
import java.lang.Math.*




/**
 * Пример
 *
 * Найти все корни уравнения x^2 = y
 */
fun sqRoots(y: Double) =
        when {
            y < 0 -> listOf()
            y == 0.0 -> listOf(0.0)
            else -> {
                val root = Math.sqrt(y)
                // Результат!
                listOf(-root, root)
            }
        }

/**
 * Пример
 *
 * Найти все корни биквадратного уравнения ax^4 + bx^2 + c = 0.
 * Вернуть список корней (пустой, если корней нет)
 */
fun biRoots(a: Double, b: Double, c: Double): List<Double> {
    if (a == 0.0) {
        return if (b == 0.0) listOf()
        else sqRoots(-c / b)
    }
    val d = discriminant(a, b, c)
    if (d < 0.0) return listOf()
    if (d == 0.0) return sqRoots(-b / (2 * a))
    val y1 = (-b + Math.sqrt(d)) / (2 * a)
    val y2 = (-b - Math.sqrt(d)) / (2 * a)
    return sqRoots(y1) + sqRoots(y2)
}

/**
 * Пример
 *
 * Выделить в список отрицательные элементы из заданного списка
 */
fun negativeList(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (element in list) {
        if (element < 0) {
            result.add(element)
        }
    }
    return result
}

/**
 * Пример
 *
 * Изменить знак для всех положительных элементов списка
 */
fun invertPositives(list: MutableList<Int>) {
    for (i in 0 until list.size) {
        val element = list[i]
        if (element > 0) {
            list[i] = -element
        }
    }
}

/**
 * Пример
 *
 * Из имеющегося списка целых чисел, сформировать список их квадратов
 */
fun squares(list: List<Int>) = list.map { it * it }

/**
 * Пример
 *
 * По заданной строке str определить, является ли она палиндромом.
 * В палиндроме первый символ должен быть равен последнему, второй предпоследнему и т.д.
 * Одни и те же буквы в разном регистре следует считать равными с точки зрения данной задачи.
 * Пробелы не следует принимать во внимание при сравнении символов, например, строка
 * "А роза упала на лапу Азора" является палиндромом.
 */
fun isPalindrome(str: String): Boolean {
    val lowerCase = str.toLowerCase().filter { it != ' ' }
    for (i in 0..lowerCase.length / 2) {
        if (lowerCase[i] != lowerCase[lowerCase.length - i - 1]) return false
    }
    return true
}

/**
 * Пример
 *
 * По имеющемуся списку целых чисел, например [3, 6, 5, 4, 9], построить строку с примером их суммирования:
 * 3 + 6 + 5 + 4 + 9 = 27 в данном случае.
 */
fun buildSumExample(list: List<Int>) = list.joinToString(separator = " + ", postfix = " = ${list.sum()}")

/**
 * Простая
 *
 * Найти модуль заданного вектора, представленного в виде списка v,
 * по формуле abs = sqrt(a1^2 + a2^2 + ... + aN^2).
 * Модуль пустого вектора считать равным 0.0.
 */
fun abs(v: List<Double>): Double {
    var sum = 0.0
    for (element in v) {
        sum += element * element
    }
    return sqrt(sum)
}

/**
 * Простая
 *
 * Рассчитать среднее арифметическое элементов списка list. Вернуть 0.0, если список пуст
 */
fun mean(list: List<Double>): Double  {
    return if (list.size == 0) 0.0 else list.sum() / list.size
}

/**
 * Средняя
 *
 * Центрировать заданный список list, уменьшив каждый элемент на среднее арифметическое всех элементов.
 * Если список пуст, не делать ничего. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun center(list: MutableList<Double>): MutableList<Double> {
    val averageValue = mean(list)
    for (i in 0 until list.size) {
        list[i] -= averageValue
    }
    return list
}

/**
 * Средняя
 *
 * Найти скалярное произведение двух векторов равной размерности,
 * представленные в виде списков a и b. Скалярное произведение считать по формуле:
 * C = a1b1 + a2b2 + ... + aNbN. Произведение пустых векторов считать равным 0.0.
 */
fun times(a: List<Double>, b: List<Double>): Double {
    var sum = 0.0
    for (i in 0 until a.size) {
        sum += a[i] * b[i]
    }
    return sum
}
/**
 * Средняя
 *
 * Рассчитать значение многочлена при заданном x:
 * p(x) = p0 + p1*x + p2*x^2 + p3*x^3 + ... + pN*x^N.
 * Коэффициенты многочлена заданы списком p: (p0, p1, p2, p3, ..., pN).
 * Значение пустого многочлена равно 0.0 при любом x.
 */
fun polynom(p: List<Double>, x: Double): Double {
    var sum = 0.0
    var i = 0.0
    for (element in p) {
        sum += element * pow(x, i)
        i++
    }
    return sum
}

/**
 * Средняя
 *
 * В заданном списке list каждый элемент, кроме первого, заменить
 * суммой данного элемента и всех предыдущих.
 * Например: 1, 2, 3, 4 -> 1, 3, 6, 10.
 * Пустой список не следует изменять. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun accumulate(list: MutableList<Double>): MutableList<Double> {
    var sum = 0.0
    for(i in 0 until list.size){
        sum += list[i]
        list[i] = sum
    }
    return list
}

/**
 * Средняя
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде списка множителей, например 75 -> (3, 5, 5).
 * Множители в списке должны располагаться по возрастанию.
 */
fun factorize(n: Int): List<Int> {
    val result = mutableListOf<Int>()
    var m = n
    if (isPrime(n)) return mutableListOf(n)
    while (m > 1) {
            result.add(minDivisor(m))
            m /= minDivisor(m)
    }
    return result
}

/**
 * Сложная
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде строки, например 75 -> 3*5*5
 */
fun factorizeToString(n: Int): String = factorize(n).joinToString(separator = "*")


/**
 * Средняя
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием base > 1.
 * Результат перевода вернуть в виде списка цифр в base-ичной системе от старшей к младшей,
 * например: n = 100, base = 4 -> (1, 2, 1, 0) или n = 250, base = 14 -> (1, 3, 12)
 */
fun convert(n: Int, base: Int): List<Int> {
    val result = mutableListOf<Int>()
    var m = n
    if (n == 0) return listOf(0)
    while (m >= 1){
        val d = m % base
        result += d
        m /= base
    }
    return result.reversed()
}

/**
 * Сложная
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием 1 < base < 37.
 * Результат перевода вернуть в виде строки, цифры более 9 представлять латинскими
 * строчными буквами: 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: n = 100, base = 4 -> 1210, n = 250, base = 14 -> 13c
 */
fun convertToString(n: Int, base: Int): String {
    val result = mutableListOf<String>()
    val latin = ('a' .. 'z').toList()
    val convert = convert(n, base)   // list convert

    for (element in convert) {
        if (element < 10) result.add(element.toString())
        else {
            val i = element - 10
            result.add(latin[i].toString())
        }
    }

    return result.joinToString(separator = "")
}

/**
 * Средняя
 *
 * Перевести число, представленное списком цифр digits от старшей к младшей,
 * из системы счисления с основанием base в десятичную.
 * Например: digits = (1, 3, 12), base = 14 -> 250
 */
fun decimal(digits: List<Int>, base: Int): Int {
    var result = 0.0
    var exponentiation = digits.size - 1

    for (element in digits) {
        val sum = element * pow(base.toDouble(), exponentiation.toDouble())
        result += sum
        exponentiation--
    }
    return result.toInt()
}

/**
 * Сложная
 *
 * Перевести число, представленное цифровой строкой str,
 * из системы счисления с основанием base в десятичную.
 * Цифры более 9 представляются латинскими строчными буквами:
 * 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: str = "13c", base = 14 -> 250
 */
fun decimalFromString(str: String, base: Int): Int {
    val strToList = mutableListOf<Int>()
    val abc = ('a' .. 'z').toList()
    val number = ('0' .. '9').toList()

    for (i in 0 until str.length)
        if (str[i] in number) {
            val rank = str[i].toInt() - '0'.toInt() // преобразование символа в число, нашел на
            strToList.add(rank)                     // http://kotlinlang.ru/docs/reference/basic-types.html
        } else {
            val rank = str[i]
            val index = abc.indexOf(rank)
            strToList.add(index + 10)
        }
    return decimal(strToList, base)
}

/**
 * Сложная
 *
 * Перевести натуральное число n > 0 в римскую систему.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: 23 = XXIII, 44 = XLIV, 100 = C
 */
fun roman(n: Int): String {
    val result = StringBuilder("")
    var m = n
    val romanMap: Map<Int, String> = mapOf(1000 to "M", 900 to "CM", 500 to "D", 400 to "CD", 100 to "C", 90 to "XC",
            50 to "L", 40 to "XL", 10 to "X", 9 to "IX", 5 to "V", 4 to "IV", 1 to "I")

    for (key in romanMap.keys) {
        while (m >= key) {
            result.append(romanMap[key])
            m -= key
        }
        if (m == 0) break
    }
    return result.toString()
}

/**
 * Очень сложная
 *
 * Записать заданное натуральное число 1..999999 прописью по-русски.
 * Например, 375 = "триста семьдесят пять",
 * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
 */
fun russianAddition(n: Int): String {
    val russianMap: Map<Int, String> = mapOf(1 to " один", 111 to " одна", 2 to " два", 22 to " две", 3 to " три",
            4 to " четыре", 5 to " пять", 6 to " шесть", 7 to " семь", 8 to " восемь", 9 to " девять", 10 to " десять",
            11 to " одиннадцать", 12 to " двенадцать", 13 to " тринадцать", 14 to " четырнадцать", 15 to " пятнадцать",
            16 to " шестнадцать", 17 to " семнадцать", 18 to " восемнадцать", 19 to " девятнадцать", 20 to " двадцать",
            30 to " тридцать", 40 to " сорок", 50 to " пятьдесят", 60 to " шестьдесят", 70 to " семьдесят",
            80 to " восемьдесят", 90 to " девяносто", 100 to " сто", 200 to " двести", 300 to " триста",
            400 to " четыреста", 500 to " пятьсот", 600 to " шестьсот", 700 to " семьсот", 800 to " восемьсот",
            900 to " девятьсот", 1000 to " тысяча", 1001 to " тысячи", 1002 to " тысяч", 0 to "")

    val index = russianMap.get(n)
    return "$index"
}

fun russian(n: Int): CharSequence {
    val nToList = mutableListOf<Int>()
    val mToList = mutableListOf<Int>()
    var m = n
    val result = StringBuilder()

    while (m > 0) {  // заполню лист разрядами (заполниться в обрантном порядке)
        val category = m % 10
        nToList.add(category)
        m /= 10
    }
    while (nToList.size != 6) { // сделаю размер листа 6, заполню недостающее нулями
        nToList.add(0)
    }

    for (i in 5 downTo 0) { //переверну лист, создав другой (рабочий)
        mToList.add(nToList[i])
    }
/**
 * Я решил перебирать число по разрядам, тоесть мое число имеет вид r1 r2 r3 r4 r5 r6 например 123456 r1 = 1, r2 = 2,
 * r3 = 3, r4 = 4, r5 = 5, r6 = 6; я решил сравнивать каждый разряд на исключения, либо во when либо приписывать
 * сразу значения. Для этого я создал fun russianAddition , при вызове которой с n, она преобразует n в буквенное
 * значение согласно russianMap в этой функции. Аргументы составлял перебирая варианты которые могут быть, например:
 * r1 всегда имеет значиния r1 * 100 где  100 to " сто", 200 to " двести", 300 to " триста", 400 to " четыреста",
 * 500 to " пятьсот", 600 to " шестьсот",
 * 700 to " семьсот", 800 to " восемьсот", 900 to " девятьсот" и т.д.  Так-же я каждый раз во when создавал переменные,
 * значения, которых я мог сразу записать в стрин билдер, однако я этого не делал для более читабельности кода
*/
    val r1 = russianAddition(mToList[0] * 100) //r1
    result.append(r1)

    when { //r2
        mToList[1] == 1 && mToList[2] != 0 -> result.append("")  // в след. when
        else -> {
            val r2 = russianAddition(mToList[1] * 10)
            result.append(r2)
        }
    }

    if (mToList[0] != 0 && mToList[2] == 0) // дополнение
        result.append(" тысяч")

    when { // r3
        mToList[1] == 1 && mToList[2] != 0 -> { // диапазаон 10..19
            val r3 = russianAddition(mToList[1] * 10 + mToList[2])
            result.append(r3)
        }
        else -> {                                      // здесь исключения 102 000 (2 = две)
            val category = mToList[2]
            val declination = when (category) {
                2 -> 22
                1 -> 111
                else -> mToList[2]
            }
            val r3 = russianAddition(declination)
            result.append(r3)
        }
    }

    val addition = when { // дополнение после r3 105 ***тысяч 103 *** тысячи 101*** тысяча
        mToList[2] == 0 -> ""
        mToList[2] == 1 && mToList[1] != 1 -> " тысяча"
        mToList[2] in 2..4 && mToList[1] != 1 -> " тысячи"
        else -> " тысяч"
    }
    result.append(addition)

    when { // r4
        mToList[3] == 0 -> result.append("")
        else -> {
            val r4 = russianAddition(mToList[3] * 100)
            result.append(r4)
        }
    }

    when { //r5
        mToList[4] == 0 -> result.append("")
        mToList[4] == 1 && mToList[5] != 0 -> {
            val r5 = russianAddition(10 + mToList[5])
            result.append(r5)
        }
        else -> {
            val r5 = russianAddition(mToList[4] * 10)
            result.append(r5)
        }
    }

    when { //r6
        mToList[5] == 0 -> result.append("")
        mToList[4] == 1 && mToList[5] != 0 -> result.append("")
        else -> {
            val r6 = russianAddition(mToList[5])
            result.append(r6)
        }
    }

    return result.trim()
}

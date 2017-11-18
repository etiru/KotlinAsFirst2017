@file:Suppress("UNUSED_PARAMETER")

package lesson3.task1

import lesson1.task1.sqr
import java.lang.Math.*

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result *= i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    for (m in 2..Math.sqrt(n.toDouble()).toInt()) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n / 2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
        when {
            n == m -> 1
            n < 10 -> 0
            else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
        }

/**
 * Тривиальная
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 */
fun digitNumber(n: Int): Int {
    var sum = 1
    var number = abs(n)
    while ((number / 10) > 0) {
        number /= 10
        sum++
    }
    return sum
}


/**
 * Простая
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int {
    var fibFirst = 1
    var fibSecond = 1
    var fibSum = 0
    if (n < 3) return 1

    for (i in 3..n) {
        fibSum = fibFirst + fibSecond
        fibFirst = fibSecond
        fibSecond = fibSum
    }
    return fibSum
}

/**
 * Простая
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {
    val greaterNumber = max(m, n)
    val smallNumber = min(m, n)
    var divisor = greaterNumber

    while ((divisor % smallNumber) != 0) {
        divisor += greaterNumber
    }

    return divisor
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */

fun minDivisor(n: Int): Int {
    var divisor = 2
    for (i in 2..(n / 3)) {
        if ((n % divisor) == 0) break
        else divisor += 1
    }
    return if (n % divisor != 0) n else divisor
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    var divisor = n / 2
    for (i in n / 2 downTo 1) {
        if ((n % divisor) == 0) break
        else divisor -= 1
    }
    return divisor
}

/**
 * Простая
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean {
    val greatNumber = max(m, n)
    val smallNumber = min(m, n)
    var divisor: Int

    if (greatNumber > 3) divisor = greatNumber / 3
    else divisor = greatNumber

    if (divisor == 0) return false
    while (((greatNumber % divisor) != 0) || ((smallNumber % divisor) != 0)) {
        divisor -= 1
    }

    return divisor == 1
}

/**
 * Простая
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean =
        m <= sqr(floor(sqrt(n.toDouble())))

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun sin(x: Double, eps: Double): Double {

    var sumSin = 0.0
    val newX = x % (2 * PI)
    var sum: Double
    var n = -1
    var i = 1

    do {
        sum = (pow(newX, i.toDouble())) / factorial(i)
        n *= (-1)
        sumSin += n * sum
        i += 2
    } while (abs(sum) > eps)
    return sumSin
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun cos(x: Double, eps: Double): Double {
    var sumCos = 0.0
    val newX = x % (2 * PI)
    var sum: Double
    var n = -1
    var i = 0

    do {
        sum = (pow(newX, i.toDouble())) / factorial(i)
        n *= (-1)
        sumCos += n * sum
        i += 2
    } while (abs(sum) > eps)
    return sumCos

}

/**
 * Средняя
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 * Не использовать строки при решении задачи.
 */
fun revert(n: Int): Int {
    val countNumber = digitNumber(n)
    var divisor = pow(10.0, countNumber.toDouble()) / 10
    var change = 0
    var number = n

    for (i in (1..(countNumber))) {
        change += (number % 10) * divisor.toInt()
        number /= 10
        divisor /= 10
    }
    return change
}

/**
 * Средняя
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 */
fun isPalindrome(n: Int): Boolean = revert(n) == n

/**
 * Средняя
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 */
fun hasDifferentDigits(n: Int): Boolean {
    val x = n % 10.0
    return digitCountInNumber(n, x.toInt()) != digitNumber(n)
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 */
fun squareSequenceDigit(n: Int): Int {
    var quadrate = 1
    var ratioQuadrate = 1
    var sum = 0

    while (n > sum) {                             // тут я искал квадраты чисел,
        quadrate = ratioQuadrate * ratioQuadrate  // и суммировал кол-во цифр в них,
        sum += digitNumber(quadrate)              // так-же тут находиться последний квадрат в который входит n
        ratioQuadrate++
    }
    var residueQuadrate = sum - n     // действие которое определяет за сколько цифр в квадрете числа,
                                      // вышла n; пример квадрат 13 -> 169 допустим n остановилась на 6 ке,
    while (residueQuadrate != 0) {    // значит нужно отсечь 1 цифру -> 9
        quadrate /= 10              // процесс отсечения цифр/)
        residueQuadrate--
    }
    return quadrate % 10

}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 */
fun fibSequenceDigit(n: Int): Int {
    var fib = 1
    var ratioFib = 1
    var sum = 0

    while (n > sum) {
        fib = fib(ratioFib)
        sum += digitNumber(fib)
        ratioFib++

    }
    var residueFib = sum - n

    while (residueFib != 0) {
        fib /= 10
        residueFib--
    }
    return fib % 10
}

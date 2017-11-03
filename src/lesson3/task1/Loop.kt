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
    for (m in 2..n/2) {
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
    var nVar = n
    for (i in 1..n){
        if (nVar / 10 >= 1)
            sum += 1
        nVar /= 10
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
    return (fibSum)
}

/**
 * Простая
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {
    val max = max(m , n)
    val min = min(m , n)
    var minDel = max

    while ((minDel % min) != 0) {
        minDel += max
    }

    return (minDel)
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */

fun minDivisor(n: Int): Int {
    var minDel = 2
    for (i in 2..n){
        if ((n % minDel) == 0) break
        else minDel += 1
    }
    return (minDel)
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    var maxDel = n-1
    for (i in n-1 downTo 1){
        if ((n % maxDel) == 0) break
        else maxDel -= 1
    }
    return (maxDel)
}
/**
 * Простая
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean  {
    val max = max(m , n)
    val min = min(m , n)
    var minDel = max

    while (((max % minDel) !=0) || ((min % minDel) != 0)) {
        minDel -= 1
    }

    return if (minDel > 1)  (false)
    else (true)
}
/**
 * Простая
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean {
    var k = m

    for (i in m..n){
        val l = sqrt(k.toDouble()).toInt()
        if ((l * l) == k) break
        else k += 1
    }
    return if (k == n + 1) (false) else (true)
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun sin(x: Double, eps: Double): Double = TODO()
    //var sumSin = x
    //var sum = x
    //var n = 2
    //var i = 1.0

    //if (x == 0.0) return 0.0

    //while (abs(sum) >= eps){
    //    sum = pow(-1.0, i) * ((pow(x, n)) / factorial(n.toInt()))
    //    sumSin += sum
    //    n += 2
    //    i++
   // }
   // while (abs(sum) > eps) {
    //    sum = - sum * pow(x , 2.0) / (n * (n + 1))
    //    n += 2
    //    sumSin += sum
    //}

    //return sumSin


/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun cos(x: Double, eps: Double): Double = TODO()

/**
 * Средняя
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 * Не использовать строки при решении задачи.
 */
fun revert(n: Int): Int {
    val digNum = digitNumber(n)
    var del = 1
    var revers = 0
    var m = n
    for (i in 1..(digNum - 1)) {  // нашел делитель для дальнейших вычислений
        del *= 10
    }

    for (i in (1..(digNum))) {
        revers += (m % 10) * del
        m /= 10
        del /= 10
    }
    return (revers)
}

/**
 * Средняя
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 */
fun isPalindrome(n: Int): Boolean =
        revert(n) == n

/**
 * Средняя
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 */
fun hasDifferentDigits(n: Int): Boolean  {
       val x = n % 10.0
       if (digitCountInNumber(n, x.toInt()) == digitNumber(n)) return false
       return true
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 */
fun squareSequenceDigit(n: Int): Int  {TODO()}
//{
  //var allCif = digitNumber(n)
  //var del = 1
    //var quard = 1
//}
  //  for (i in 1..allCif) {
    // del *= 10
   // }
   // for (i in 2..allCif) {
    //    quard *= quard
   // }
//}
/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 */
fun fibSequenceDigit(n: Int): Int = TODO()

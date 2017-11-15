@file:Suppress("UNUSED_PARAMETER")

package lesson3.task1

import java.lang.Math.pow

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result = result * i // Please do not fix in master
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
 * Тривиальная DONE
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 */
fun digitNumber(n: Int): Int {
    if (n == 0) return 1
    else {
        var quantity = 0
        var m = Math.abs(n)
        while (m > 0) {
            quantity = quantity + 1
            m /= 10
        }
        return quantity
    }
}

/**
 * Простая DONE
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int {
    var fib1 = 1
    var fib2 = 1
    var i = 2
    var fibSum = 2
    return if (n == 1 || n == 2) fib1
    else {
        while (i < n) {
            fibSum = fib2 + fib1
            fib1 = fib2
            fib2 = fibSum
            i++
        }
        fibSum
    }
}

/**
 * Простая DONE
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {
    var nod = 1
    var m1 = m
    var n1 = n
    while ((m1 != 0) && (n1 != 0)) {
        if (n1 > m1) {
            n1 %= m1
        } else {
            m1 %= n1
        }
        when {
            (m1 != 0) -> nod = m1
            (n1 != 0) -> nod = n1
        }
    }
    return (m * n / nod)
}

/**
 * Простая DONE
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    var i = 2
    while (n % i != 0) {
        i += 1
    }
    return i
}


/**
 * Простая DONE
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    var i = n - 1
    while ((n % i != 0) && (i < n)) {
        i -= 1
    }
    return i
}


/**
 * Простая DONE
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean {
    var m1 = m
    var n1 = n
    while (m1 != n1) {
        if (m1 > n1) {
            m1 -= n1
        } else {
            n1 -= m1
        }
    }
    return m1 == 1
}

/**
 * Простая DONE
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean {
    var result = false
    var a = m.toDouble()
    val b = n.toDouble()
    return if (n == m) {
        if (Math.sqrt(a) % 1.0 == 0.0) true else result
    } else {
        while (a < b) {
            a += 1.0
            if ((Math.sqrt(a) % 1.0) == 0.0) {
                result = true
                break
            }
        }
        result
    }
}

/**
 * Средняя DONE
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun sin(x: Double, eps: Double): Double {
    var m = x
    while (Math.abs(m) > 2 * Math.PI) {
        if (m < 0) m += 2 * Math.PI
        else m -= 2 * Math.PI
    }
    var k = m
    var l = m
    var i = 0
    while (Math.abs(l) >= eps) {
        i++
        l = Math.pow(m, ((2 * i) + 1).toDouble()) / factorial(2 * i + 1)
        if (i % 2 == 1) k -= l
        else k += l
    }
    return k
}

/**
 * Средняя DONE
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun cos(x: Double, eps: Double): Double {
    var m = 1.0
    var n = m
    var k = x
    var i = 0
    while (Math.abs(k) > 2 * Math.PI) {
        if (k < 0) k += 2 * Math.PI
        else k -= 2 * Math.PI
    }
    while (Math.abs(n) >= eps) {
        i++
        n = Math.pow(k, 2 * i.toDouble()) / factorial(2 * i)
        if (i % 2 == 1) m -= n
        else m += n
    }
    return m
}

/**
 * Средняя DONE
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 * Не использовать строки при решении задачи.
 */
fun revert(n: Int): Int {
    var numb = 0
    var nn = n
    while (nn > 0) {
        numb = (numb * 10 + nn % 10)
        nn /= 10
    }
    return numb
}

/**
 * Средняя DONE
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 */
fun isPalindrome(n: Int): Boolean {
    var aa = n
    var c = 0
    while (aa > 0) {
        c = (c * 10 + (aa % 10))
        aa /= 10
    }
    return (c == n)
}

/**
 * Средняя DONE
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 */
fun hasDifferentDigits(n: Int): Boolean {
    var copy = n
    var now = copy % 10
    var last = 0
    var count = 0
    while (copy > 0) {
        last = now
        now = copy % 10
        if (now != last) count += 1
        copy /= 10
    }
    return count != 0
}

/**
 * отень :с СлоЗная DONE
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 */
fun squareSequenceDigit(n: Int): Int {
    var a = 0
    var b = 0
    var i = 1
    while (b < n) {
        a = i * i
        b += digitNumber(a)
        i++
    }
    val k = b - n
    if (b > n) {
        for (j in 1..k) {
            a /= 10
        }
    }
    return a % 10
}

/**
 * Сложная DONE
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 */
fun fibSequenceDigit(n: Int): Int {
    var copy = n
    var ask = 0.0
    var i = 1
    var sq = 0
    while (true) {
        sq = fib(i)
        if (digitNumber(sq) < copy) {
            copy -= digitNumber(sq)
        } else {
            val num = (digitNumber(sq) - copy).toDouble()
            var sqDob = sq.toDouble()
            sqDob /= pow(10.0, num)
            ask = sqDob % 10
            break
        }
        i++
    }
    val askInt = ask.toInt()
    return askInt
}
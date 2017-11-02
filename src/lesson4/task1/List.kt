@file:Suppress("UNUSED_PARAMETER")

package lesson4.task1

import lesson1.task1.discriminant

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
 * Простая DONE
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
    return Math.sqrt(sum)
}

/**
 * Простая DONE
 *
 * Рассчитать среднее арифметическое элементов списка list. Вернуть 0.0, если список пуст
 */
fun mean(list: List<Double>): Double {
    var sum = 0.0
    if (list.isEmpty()) sum = 0.0
    else {
        for (element in list) {
            sum += element
        }
        sum /= (list.size)
    }
    return sum
}

/**
 * Средняя DONE
 *
 * Центрировать заданный список list, уменьшив каждый элемент на среднее арифметическое всех элементов.
 * Если список пуст, не делать ничего. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun center(list: MutableList<Double>): MutableList<Double> {
    var sum = 0.0
    var srar = 0.0
    for (element in list) {
        sum += element
    }
    srar = sum / (list.size)
    for (i in 0 until list.size) {
        list[i] -= srar
    }
    return list
}

/**
 * Средняя DONE
 *
 * Найти скалярное произведение двух векторов равной размерности,
 * представленные в виде списков a и b. Скалярное произведение считать по формуле:
 * C = a1b1 + a2b2 + ... + aNbN. Произведение пустых векторов считать равным 0.0.
 */
fun times(a: List<Double>, b: List<Double>): Double {
    var c = 0.0
    for (i in 0 until a.size) {
        c += a[i] * b[i]
    }
    return c
}

/**
 * Средняя DONE
 *
 * Рассчитать значение многочлена при заданном x:
 * p(x) = p0 + p1*x + p2*x^2 + p3*x^3 + ... + pN*x^N.
 * Коэффициенты многочлена заданы списком p: (p0, p1, p2, p3, ..., pN).
 * Значение пустого многочлена равно 0.0 при любом x.
 */
fun polynom(p: List<Double>, x: Double): Double {
    var mnog = 0.0
    for (i in 0 until p.size) {
        mnog += p[i] * Math.pow(x, i.toDouble())
    }
    return mnog
}

/**
 * Средняя DONE
 *
 * В заданном списке list каждый элемент, кроме первого, заменить
 * суммой данного элемента и всех предыдущих.
 * Например: 1, 2, 3, 4 -> 1, 3, 6, 10.
 * Пустой список не следует изменять. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun accumulate(list: MutableList<Double>): MutableList<Double> {
    for (i in 1 until list.size) {
        list[i] += list[i - 1]
    }
    return list
}


/**
 * Средняя DONE
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде списка множителей, например 75 -> (3, 5, 5).
 * Множители в списке должны располагаться по возрастанию.
 */
fun factorize(n: Int): List<Int> {
    var i = 2
    var m = n
    val result = mutableListOf<Int>()
    while (m > 1) {
        if (m % i == 0) {
            result.add(i)
            m /= i
        } else {
            i += 1
        }
    }
    return result
}

/**
 * Сложная DONE
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде строки, например 75 -> 3*5*5
 */
fun factorizeToString(n: Int): String {
    var i = 2
    var m = n
    val result = mutableListOf<Int>()
    var res = ""
    while (m > 1) {
        if (m % i == 0) {
            result.add(i)
            m /= i
        } else {
            i += 1
        }
    }

    if (result.size == 1) {
        res = i.toString()
    } else {
        res = result[0].toString()
        for (k in 1 until result.size) {
            res += "*" + result[k].toString()
        }
    }
    return res
}


/**
 * *****************************************************Средняя
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием base > 1.
 * Результат перевода вернуть в виде списка цифр в base-ичной системе от старшей к младшей,
 * например: n = 100, base = 4 -> (1, 2, 1, 0) или n = 250, base = 14 -> (1, 3, 12)
 */
fun convert(n: Int, base: Int): List<Int> {
    var result = mutableListOf<Int>()
    var n1 = n
    while (n1 > base) {
        result.add(0, (n1 % base))
        n1 /= base
    }
    result.add(0, n1)
    return result
}

/**
 * *********************************************************Сложная
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием 1 < base < 37.
 * Результат перевода вернуть в виде строки, цифры более 9 представлять латинскими
 * строчными буквами: 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: n = 100, base = 4 -> 1210, n = 250, base = 14 -> 13c
 */
fun convertToString(n: Int, base: Int): String {
    var list = convert(n, base)
    var str = ""
    var res = ""
    for(i in 0 until list.size) {
        when {
            list[i] == 0 -> str = "0"
            list[i] == 1 -> str = "1"
            list[i] == 2 -> str = "2"
            list[i] == 3 -> str = "3"
            list[i] == 4 -> str = "4"
            list[i] == 5 -> str = "5"
            list[i] == 6 -> str = "6"
            list[i] == 7 -> str = "7"
            list[i] == 8 -> str = "8"
            list[i] == 9 -> str = "9"
            list[i] == 10 -> str = "a"
            list[i] == 11 -> str = "b"
            list[i] == 12 -> str = "c"
            list[i] == 13 -> str = "d"
            list[i] == 14 -> str = "e"
            list[i] == 15 -> str = "f"
            list[i] == 16 -> str = "g"
            list[i] == 17 -> str = "h"
            list[i] == 18 -> str = "i"
            list[i] == 19 -> str = "j"
            list[i] == 20 -> str = "k"
            list[i] == 21 -> str = "l"
            list[i] == 22 -> str = "m"
            list[i] == 23 -> str = "n"
            list[i] == 24 -> str = "o"
            list[i] == 25 -> str = "p"
            list[i] == 26 -> str = "q"
            list[i] == 27 -> str = "r"
            list[i] == 28 -> str = "s"
            list[i] == 29 -> str = "t"
            list[i] == 30 -> str = "u"
            list[i] == 31 -> str = "v"
            list[i] == 32 -> str = "w"
            list[i] == 33 -> str = "x"
            list[i] == 34 -> str = "y"
            list[i] == 35 -> str = "z"
        }
        res += str
    }
    return res
}

/**
 * Средняя DONE
 *
 * Перевести число, представленное списком цифр digits от старшей к младшей,
 * из системы счисления с основанием base в десятичную.
 * Например: digits = (1, 3, 12), base = 14 -> 250
 */
fun decimal(digits: List<Int>, base: Int): Int {
    var result = 0.0
    var n = 0.0
    for (i in digits.size - 1 downTo 0) {
        result += digits[i] * Math.pow(base.toDouble(), n)
        n += 1
    }
    return result.toInt()
}

/**
 * **************************************************Сложная
 *
 * Перевести число, представленное цифровой строкой str,
 * из системы счисления с основанием base в десятичную.
 * Цифры более 9 представляются латинскими строчными буквами:
 * 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: str = "13c", base = 14 -> 250
 */

fun decimalFromString(str: String, base: Int): Int {
    var a = 0
    var res = mutableListOf<Int>()
    for(i in 0 until str.length){
        when {
                str[i] == '0' -> res.add(0)
                str[i] == '1' -> res.add(1)
                str[i] == '2' -> res.add(2)
                str[i] == '3' -> res.add(3)
                str[i] == '4' -> res.add(4)
                str[i] == '5' -> res.add(5)
                str[i] == '6' -> res.add(6)
                str[i] == '7' -> res.add(7)
                str[i] == '8' -> res.add(8)
                str[i] == '9' -> res.add(9)
                str[i] == 'a' -> res.add(10)
                str[i] == 'b' -> res.add(11)
                str[i] == 'c' -> res.add(12)
                str[i] == 'd' -> res.add(13)
                str[i] == 'e' -> res.add(14)
                str[i] == 'f' -> res.add(15)
                str[i] == 'g' -> res.add(16)
                str[i] == 'h' -> res.add(17)
                str[i] == 'i' -> res.add(18)
                str[i] == 'j' -> res.add(19)
                str[i] == 'k' -> res.add(20)
                str[i] == 'l' -> res.add(21)
                str[i] == 'm' -> res.add(22)
                str[i] == 'n' -> res.add(23)
                str[i] == 'o' -> res.add(24)
                str[i] == 'p' -> res.add(25)
                str[i] == 'q' -> res.add(26)
                str[i] == 'r' -> res.add(27)
                str[i] == 's' -> res.add(28)
                str[i] == 't' -> res.add(29)
                str[i] == 'u' -> res.add(30)
                str[i] == 'v' -> res.add(31)
                str[i] == 'w' -> res.add(32)
                str[i] == 'x' -> res.add(33)
                str[i] == 'y' -> res.add(34)
                str[i] == 'z' -> res.add(35)
        }
    }
    return decimal(res, base)
}


/**
 * Сложная DONE
 *
 * Перевести натуральное число n > 0 в римскую систему.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: 23 = XXIII, 44 = XLIV, 100 = C
 */
fun roman(n: Int): String {
    val R = listOf("I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M")
    val A = listOf(1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000)
    var n1 = n
    var i = 12
    var result = ""
    while (n1 > 0) {
        while (A[i] > n1) {
            i--
        }
        result += R[i]
        n1 -= A[i]
    }
    return result
}

/**
 * *********************************************Очень сложная
 *
 * Записать заданное натуральное число 1..999 999 прописью по-русски.
 * Например, 375 = "триста семьдесят пять",
 * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
 */
fun abc (n: Int): String {
    return when{
        n == 11 -> "одиннадцать"
        n == 12 -> "двенадцать"
        n == 13 -> "тринадцать"
        n == 14 -> "четырнадцать"
        n == 15 -> "пятнадцать"
        n == 16 -> "шестнадцать"
        n == 17 -> "семнадцать"
        n == 18 -> "восемнадцать"
        n == 19 -> "девятнадцать"
        else -> "error"
    }
}
fun russian(n: Int): String = TODO()
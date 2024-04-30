package ver_1

class BaseballGame {
    private var gamePlayCount = 0
    private var gamePlayResultMap:MutableMap<Int,Int> = mutableMapOf()

    fun printResult() {
        if (gamePlayResultMap.isNotEmpty()) {
            println("⚾⚾⚾ 일반 야구게임 기록입니다 ⚾⚾⚾")
            gamePlayResultMap.forEach { println("${it.key}번째 게임: 시도 횟수 - ${it.value}회") }
        } else {
            println("게임 기록이 없습니다")
        }
    }

    fun playGame() {
        gamePlayCount++

        val answerNumbArray = getRandomThreeNumbArray()

        println("[안내] 투수가 공을 던지면 1~9까지의 임의의 수 3개를 순서대로 입력해주세요")

        var tryCount = 0

        while (true) {

            tryCount++

            println("투수가 공을 던집니다. \uD83D\uDD90\uFE0F⚾")

            val inputArray = getThreeNumbInputArray()

            var strike = 0
            var ball = 0

            for (i in 0..2) {
                if (answerNumbArray[i] == inputArray[i]) {
                    strike++
                } else if (answerNumbArray.any { it == inputArray[i] }) {
                    ball++
                }
            }

            when {
                strike == 3 -> {println("정답입니다! \uD83C\uDFC6\uD83C\uDFC6\uD83C\uDFC6"); break}
                strike == 0 && ball == 0 -> println("낫씽")
                strike != 0 && ball == 0 -> println("${strike}스트라이크! ${"⚾".repeat(strike)}➡\uFE0F\uD83E\uDDE4")
                strike == 0 && ball != 0 -> println("${ball}볼! ${"⚾".repeat(ball)}")
                else -> println("${strike}스트라이크! ${"⚾".repeat(strike)}➡\uFE0F\uD83E\uDDE4, ${ball}볼! ${"⚾".repeat(ball)}")
            }

        }

        gamePlayResultMap[gamePlayCount] = tryCount

    }

    private fun getThreeNumbInputArray(): IntArray {

        while (true) {

            val inputString = readln()

            if (Regex("[1-9][1-9][1-9]") matches inputString) {
                if (inputString[0] == inputString[1] || inputString[0] == inputString[2]
                    || inputString[1] == inputString[2]
                ) {
                    println("0을 제외한 서로 다른 3개의 숫자를 입력해야합니다. 다시 입력해주세요.")
                } else {
                    return inputString.map { it.digitToInt() }.toIntArray()
                }
            } else {
                println("3개의 숫자만 입력 가능합니다. 다시 입력해주세요")
            }

        }
    }

    private fun getRandomThreeNumbArray(): IntArray {
        val numberArray = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)

        numberArray.shuffle()

        return numberArray.sliceArray(0..2)
    }
}
package ver_2.baseballgames

class BaseballGame: AbstractBaseballGame() {

    override fun printPlayResult() {
        if (gamePlayResultMap.isNotEmpty()) {
            println("⚾⚾⚾ 일반 야구게임 기록입니다 ⚾⚾⚾")
            gamePlayResultMap.forEach { println("${it.key}번째 게임: 시도 횟수 - ${it.value}") }
        }
    }

    override fun playGame() {
        gamePlayCount++

        val answerNumbArray = getRandomThreeNumbArray()

        println("[안내] 투수가 공을 던지면 1~9까지의 임의의 수 3개를 순서대로 입력해주세요")

        var tryCount = 0

        while (true) {

            tryCount++

            println("투수가 공을 던집니다. \uD83D\uDD90\uFE0F⚾")

            val inputArray = getThreeNumbInputArray()

            val (strike, ball) = computeStrikeBall(answerNumbArray, inputArray)

            printStrikeBallResult(strike, ball)

            if (strike == 3) break
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
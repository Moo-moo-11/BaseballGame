package ver_3.baseballgames

class BaseballGameEasy: AbstractBaseballGame() {

    override val gameType = "EASY"

    override fun playGame() {

        val answerNumbArray = getRandomThreeNumbArray()

        println("[안내] Easy 모드에서는 1~7까지의 수만 사용해 난이도가 낮습니다.")
        println("[안내] 투수가 공을 던지면 1~7까지의 임의의 수 3개를 순서대로 입력해주세요")

        var tryCount = 0

        while (true) {

            tryCount++

            println("투수가 공을 던집니다. \uD83D\uDD90\uFE0F⚾")

            val inputArray = getThreeNumbInputString()

            val (strike, ball) = computeStrikeBall(answerNumbArray, inputArray)

            printStrikeBallResult(strike, ball)

            if (strike == 3) break
        }

        val name = getPlayerName()

        saveNameAndScore(name,tryCount)

    }

    private fun getThreeNumbInputString(): String {

        while (true) {

            val inputString = readln()

            if (Regex("[1-7][1-7][1-7]") matches inputString) {
                if (inputString[0] == inputString[1] || inputString[0] == inputString[2]
                    || inputString[1] == inputString[2]
                ) {
                    println("같은 숫자를 두 번 입력할 수 없습니다. 다시 입력해주세요.")
                } else {
                    return inputString
                }
            } else {
                println("1~7 사이 3개의 숫자만 입력 가능합니다. 다시 입력해주세요")
            }

        }

    }

    private fun getRandomThreeNumbArray(): CharArray {
        val numberArray = charArrayOf('1','2','3','4','5','6','7')

        numberArray.shuffle()

        return numberArray.sliceArray(0..2)
    }
}
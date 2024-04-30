package ver_3.baseballgames

class BaseballGame: AbstractBaseballGame() {

    override val gameType = "일반"

    override fun playGame() {

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

        val name = getPlayerName()

        saveNameAndScore(name,tryCount)

    }

    private fun getThreeNumbInputArray():CharArray {

        while (true) {

            val inputString = readln()

            if (Regex("[1-9][1-9][1-9]") matches inputString) {
                if (inputString[0] == inputString[1] || inputString[0] == inputString[2]
                    || inputString[1] == inputString[2]
                ) {
                    println("같은 숫자는 두번 입력할 수 없습니다. 다시 입력해주세요.")
                } else {
                    return inputString.map { it }.toCharArray()
                }
            } else {
                println("0을 제외한 3개의 숫자만 입력 가능합니다. 다시 입력해주세요")
            }

        }

    }

    private fun getRandomThreeNumbArray(): CharArray {
        val numberArray = charArrayOf('1','2','3','4','5','6','7','8','9')

        numberArray.shuffle()

        return numberArray.sliceArray(0..2)
    }
}
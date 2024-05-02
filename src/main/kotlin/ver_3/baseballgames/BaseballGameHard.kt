package ver_3.baseballgames

class BaseballGameHard: AbstractBaseballGame() {

    override val gameType = "HARD"

    override fun playGame() {

        val answerAlphabetArray = getRandomThreeAlphabetArray()

        println("\uD83D\uDE08\uD83D\uDE08\uD83D\uDE08\uD83D\uDE08\uD83D\uDE08 하드모드에 오신 것을 환영합니다 \uD83D\uDE08\uD83D\uDE08\uD83D\uDE08\uD83D\uDE08\uD83D\uDE08")
        println("[주의] 하드 모드는 숫자가 아니라 26개의 소문자 알파벳을 이용합니다! \uD83D\uDD21")
        println("[안내] 투수가 공을 던지면 a~z 까지의 임의의 소문자 알파벳 3개를 순서대로 입력해주세요")

        var tryCount = 0

        while (true) {

            tryCount++

            println("투수가 공을 던집니다. \uD83D\uDD90\uFE0F⚾")

            val inputArray = getThreeAlphabetInputString()

            val (strike, ball) = computeStrikeBall(answerAlphabetArray, inputArray)

            printStrikeBallResult(strike, ball)

            if (strike == 3) break

        }

        val name = getPlayerName()

        saveNameAndScore(name,tryCount)

    }

    private fun getThreeAlphabetInputString():String {

        while (true) {

            val inputString = readln()

            if (Regex("[a-z][a-z][a-z]") matches inputString) {
                if (inputString[0] == inputString[1] || inputString[0] == inputString[2]
                    || inputString[1] == inputString[2]
                ) {
                    println("같은 알파벳은 두 번 입력할 수 없습니다. 다시 입력해주세요.")
                } else {
                    return inputString
                }
            } else {
                println("3개의 소문자 알파벳만 입력 가능합니다. 다시 입력해주세요")
            }

        }

    }

    private fun getRandomThreeAlphabetArray():CharArray {
        val alphabetArray = charArrayOf('a','b','c','d','e','f','g','h','i','j','k',
            'l','m','n','o','p','q','r','s','t','u','v','w','x','y','z')

        alphabetArray.shuffle()

        return alphabetArray.sliceArray(0..2)
    }

}
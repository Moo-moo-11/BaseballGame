package ver_3.baseballgames

abstract class AbstractBaseballGame {
    private var gamePlayResultList: MutableList<Pair<String,Int>> = mutableListOf()

    abstract val gameType:String

    abstract fun playGame()

    fun printHighScore(gameType:String) = if (gamePlayResultList.isNotEmpty()) {

        gamePlayResultList.sortWith(compareBy({ it.second }, { it.first }))

        println("\uD83C\uDFC6\uD83C\uDFC6\uD83C\uDFC6 $gameType 모드 야구게임 명예의 전당 \uD83C\uDFC6\uD83C\uDFC6\uD83C\uDFC6")
        println("🥇 이름: ${gamePlayResultList[0].first}, 시도 횟수 - ${gamePlayResultList[0].second}")

        try {
            println("\uD83E\uDD48 이름: ${gamePlayResultList[1].first}, 시도 횟수 - ${gamePlayResultList[1].second}")
            println("\uD83E\uDD49 이름: ${gamePlayResultList[2].first}, 시도 횟수 - ${gamePlayResultList[2].second}")
            println("_____________________________________________")
        } catch (e: Exception) {
            println("_____________________________________________")
        }

    } else {
        println("아직 플레이 기록이 없습니다")
    }

    protected fun computeStrikeBall(answer:CharArray, input:CharArray):Pair<Int,Int> {

        var strike = 0
        var ball = 0

        for (i in 0..2) {
            if (answer[i] == input[i]) {
                strike++
            } else if (answer.any { it == input[i] }) {
                ball++
            }
        }

        return Pair(strike,ball)
    }

    protected fun printStrikeBallResult(strike:Int, ball:Int) {

        when {
            strike == 3 -> {println("정답입니다! \uD83C\uDFC6\uD83C\uDFC6\uD83C\uDFC6")}
            strike == 0 && ball == 0 -> println("낫씽 \uD83D\uDE45\uD83C\uDFFD")
            strike != 0 && ball == 0 -> println("${strike}스트라이크! ${"⚾".repeat(strike)}➡\uFE0F\uD83E\uDDE4")
            strike == 0 && ball != 0 -> println("${ball}볼! ${"⚾".repeat(ball)}")
            else -> println("${strike}스트라이크! ${"⚾".repeat(strike)}➡\uFE0F\uD83E\uDDE4, ${ball}볼! ${"⚾".repeat(ball)}")
        }

    }

    protected fun getPlayerName():String {

        println("\uD83C\uDFC6 플레이어의 이름을 남겨주세요 \uD83C\uDFC6")

        while(true) {

            val name = readln()

            if (name.length <= 10) {
                return name
            } else {
                println("이름은 10자 이내로 입력가능합니다.")
            }
        }

    }

    protected fun saveNameAndScore(name:String, score:Int) {

        gamePlayResultList.add(name to score)

        println("게임 기록이 성공적으로 저장되었습니다!!!!!")

    }
}
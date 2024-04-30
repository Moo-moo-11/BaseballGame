package ver_2.baseballgames

abstract class AbstractBaseballGame {
    protected var gamePlayCount:Int = 0
    protected var gamePlayResultMap: MutableMap<Int,Int> = mutableMapOf()

    abstract fun printPlayResult()
    abstract fun playGame()

    protected fun computeStrikeBall(answer:IntArray, input:IntArray):Pair<Int,Int> {
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
}
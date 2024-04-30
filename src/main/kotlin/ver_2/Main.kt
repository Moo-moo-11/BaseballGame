package ver_2

import ver_2.baseballgames.BaseballGame
import ver_2.baseballgames.BaseballGameWithZero

fun main() {

    println("⚾⚾⚾ 야구게임에 오신 것을 환영합니다. ⚾⚾⚾")

    val baseballGame = BaseballGame()
    val baseballGameWithZero = BaseballGameWithZero()
    val playGame = PlayGame()

    while(true) {

        println("⚾⚾⚾⚾⚾ 메뉴를 선택해주세요 ⚾⚾⚾⚾⚾")
        println("1. 일반 게임 시작하기, 2. 0이 포함된 게임 시작하기, 3.게임 기록보기, 4.게임 종료하기")

        val initialInput = getInitialInput()

        when (initialInput) {
            1 -> playGame.startGame(baseballGame)
            2 -> playGame.startGame(baseballGameWithZero)
            3 -> {playGame.printPlayResult(baseballGame); playGame.printPlayResult(baseballGameWithZero)}
            4 -> {println("⚾⚾⚾ 게임을 종료합니다. ⚾⚾⚾"); break}
        }

    }

}

fun getInitialInput():Int {

    while (true) {

        when (val input = readln().toIntOrNull()) {
            null -> {
                println("숫자만 입력 가능합니다. 다시 입력해주세요")
            }
            !in (1..4) -> {
                println("1,2,3,4만 입력 가능합니다. 다시 입력해주세요")
            }
            else -> {
                return input
            }
        }

    }
}
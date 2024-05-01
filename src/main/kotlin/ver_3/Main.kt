package ver_3

import ver_3.baseballgames.BaseballGame
import ver_3.baseballgames.BaseballGameEasy
import ver_3.baseballgames.BaseballGameHard

fun main() {

    println("⚾⚾⚾ 야구게임에 오신 것을 환영합니다. ⚾⚾⚾")

    val baseballGameEasy = BaseballGameEasy()
    val baseballGame = BaseballGame()
    val baseballGameHard = BaseballGameHard()
    val playGame = PlayGame()

    while(true) {

        println("⚾⚾⚾⚾⚾ 메뉴를 선택해주세요 ⚾⚾⚾⚾⚾")
        println("1.일반 게임 시작하기, 2. Easy 모드 시작하기, 3. Hard 모드 시작하기, 4. 명예의 전당, 5. 게임 종료하기")

        when (val initialInput = getNumberInputOneToi(5)) {
            1, 2, 3 -> when (initialInput) {
                1 -> baseballGame
                2 -> baseballGameEasy
                else -> baseballGameHard
            }.let {playGame.startGame(it)}
            4 -> {
                while(true) {
                    println("⚾⚾⚾⚾⚾ 기록을 볼 모드를 선택해주세요 ⚾⚾⚾⚾⚾")
                    println("1. 일반 게임, 2. Easy 모드, 3. Hard 모드, 4. 이전 메뉴")
                    val gameSelectInput = getNumberInputOneToi(4)
                    when (gameSelectInput) {
                        1 -> baseballGame
                        2 -> baseballGameEasy
                        3 -> baseballGameHard
                        else -> break
                    }.let { playGame.printHighScore(it) }
                }
            }
            5 -> {println("⚾⚾⚾ 게임을 종료합니다. ⚾⚾⚾"); break}
        }

    }

}

fun getNumberInputOneToi(i:Int):Int {

    while (true) {

        when (val input = readln().toIntOrNull()) {
            null -> {
                println("숫자만 입력 가능합니다. 다시 입력해주세요")
            }
            !in (1..i) -> {
                println("1~${i}만 입력 가능합니다. 다시 입력해주세요")
            }
            else -> {
                return input
            }
        }

    }
}
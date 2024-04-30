package ver_1

fun main() {

    println("⚾⚾⚾ 야구게임에 오신 것을 환영합니다. ⚾⚾⚾")

    val baseballGame = BaseballGame()

    while(true) {

        println("----- 메뉴를 선택해주세요 -----")
        println("1. 일반 게임 시작하기, 2.게임 기록보기, 3.게임 종료하기")

        val initialInput = getInitialInput()

        when (initialInput) {
            1 -> baseballGame.playGame()
            2 -> baseballGame.printResult()
            3 -> {println("⚾⚾⚾ 게임을 종료합니다. ⚾⚾⚾"); break}
        }

    }

}

fun getInitialInput():Int {

    while (true) {

        when (val input = readln().toIntOrNull()) {

            null -> {
                println("숫자만 입력 가능합니다. 다시 입력해주세요")
            }
            !in (1..3) -> {
                println("1,2,3만 입력 가능합니다. 다시 입력해주세요")
            }
            else -> {
                return input
            }
        }
    }

}
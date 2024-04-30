package ver_2

import ver_2.baseballgames.AbstractBaseballGame

class PlayGame {

    fun startGame(game: AbstractBaseballGame) {
        game.playGame()
    }

    fun printPlayResult(game:AbstractBaseballGame) {
        game.printPlayResult()
    }
}
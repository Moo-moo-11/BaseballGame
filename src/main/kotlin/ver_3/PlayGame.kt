package ver_3

import ver_3.baseballgames.AbstractBaseballGame

class PlayGame {

    fun startGame(game: AbstractBaseballGame) {
        game.playGame()
    }

    fun printHighScore(game: AbstractBaseballGame) {
        game.printHighScore(game.gameType)
    }
}
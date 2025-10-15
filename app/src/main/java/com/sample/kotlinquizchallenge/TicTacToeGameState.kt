package com.sample.kotlinquizchallenge

/*
* Model a Tic Tac Toe game with board state and game status.
*
* // Input
* // X _ _
* // O X _
* // O _ X

* // Expected Output
* gameState.status → GameStatus.X_WINS
* gameState.currentPlayer → null (game ended)
* */

/*
* Simpler Tic-Tac-Toe model: board + status + currentPlayer
* Board uses 'X', 'O', '_' (underscore for empty).
*/

enum class GameStatus { IN_PROGRESS, X_WINS, O_WINS, DRAW }

data class GameState(
    val board: Array<CharArray>,
    val status: GameStatus,
    val currentPlayer: Char? // 'X', 'O', or null if game ended
)

fun makeGameState(board: Array<CharArray>): GameState {
    val status = evaluate(board)
    val current = if (status == GameStatus.IN_PROGRESS) nextPlayer(board) else null
    return GameState(board, status, current)
}

private fun evaluate(b: Array<CharArray>): GameStatus {
    fun win(p: Char): Boolean {
        // rows
        for (r in 0..2) if (b[r][0] == p && b[r][1] == p && b[r][2] == p) return true
        // cols
        for (c in 0..2) if (b[0][c] == p && b[1][c] == p && b[2][c] == p) return true
        // diags
        if (b[0][0] == p && b[1][1] == p && b[2][2] == p) return true
        if (b[0][2] == p && b[1][1] == p && b[2][0] == p) return true
        return false
    }

    return when {
        win('X') -> GameStatus.X_WINS
        win('O') -> GameStatus.O_WINS
        b.any { row -> row.any { it == '_' } } -> GameStatus.IN_PROGRESS
        else -> GameStatus.DRAW
    }
}

private fun nextPlayer(b: Array<CharArray>): Char {
    var x = 0; var o = 0
    for (r in 0..2) for (c in 0..2) {
        if (b[r][c] == 'X') x++ else if (b[r][c] == 'O') o++
    }
    return if (x == o) 'X' else 'O' // X starts
}

// Demo
fun main() {
    val board = arrayOf(
        charArrayOf('X','_','_'),
        charArrayOf('O','X','_'),
        charArrayOf('O','_','X')
    )
    val gameState = makeGameState(board)
    println("gameState.status → ${gameState.status}")           // GameStatus.X_WINS
    println("gameState.currentPlayer → ${gameState.currentPlayer}") // null
}

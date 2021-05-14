package com.rssoft.tiktaktoy

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        reset()
        buttonRestart.setOnClickListener {
            reset()
        }
    }

    @SuppressLint("SetTextI18n")
    fun reset() {
        player1.clear()
        player2.clear()
        activePlayer = 1
        textViewCurrPlayer.text = "Player $activePlayer: ${if (activePlayer == 1) "X" else "O"}"
        textViewWinner.text = ""

        button1.text = ""; button2.text = ""; button3.text = ""
        button4.text = ""; button5.text = ""; button6.text = ""
        button7.text = ""; button8.text = ""; button9.text = ""
        val isEnabled = true
        button1.isEnabled = isEnabled; button2.isEnabled = isEnabled; button3.isEnabled = isEnabled
        button4.isEnabled = isEnabled; button5.isEnabled = isEnabled; button6.isEnabled = isEnabled
        button7.isEnabled = isEnabled; button8.isEnabled = isEnabled; button9.isEnabled = isEnabled
        val defaultColor = "#FF808080"
        button1.setBackgroundColor(Color.parseColor(defaultColor))
        button2.setBackgroundColor(Color.parseColor(defaultColor))
        button3.setBackgroundColor(Color.parseColor(defaultColor))
        button4.setBackgroundColor(Color.parseColor(defaultColor))
        button5.setBackgroundColor(Color.parseColor(defaultColor))
        button6.setBackgroundColor(Color.parseColor(defaultColor))
        button7.setBackgroundColor(Color.parseColor(defaultColor))
        button8.setBackgroundColor(Color.parseColor(defaultColor))
        button9.setBackgroundColor(Color.parseColor(defaultColor))
    }

    fun buttonClick(view: View) {
        val buttonClicked = view as Button
        var cellId = 0
        when (buttonClicked.id) {
            button1.id -> cellId = 1
            button2.id -> cellId = 2
            button3.id -> cellId = 3
            button4.id -> cellId = 4
            button5.id -> cellId = 5
            button6.id -> cellId = 6
            button7.id -> cellId = 7
            button8.id -> cellId = 8
            button9.id -> cellId = 9
        }
//        Toast.makeText(buttonClicked.context, "$cellId", Toast.LENGTH_SHORT).show()
        playGame(cellId, buttonClicked)
    }

    private var player1 = arrayListOf<Int>()
    private var player2 = arrayListOf<Int>()
    private var activePlayer = 1

    @SuppressLint("SetTextI18n")
    private fun playGame(cellId: Int, button: Button) {
        val lum = 150
        if (activePlayer == 1) {
            player1.add(cellId)
            button.text = "X"
            button.setBackgroundColor(Color.argb(255, 0, lum, 0))
        } else {
            player2.add(cellId)
            button.text = "O"
            button.setBackgroundColor(Color.argb(255, 0, 0, lum))
        }
        button.setTextColor(Color.WHITE)
        activePlayer = 3 - activePlayer
        textViewCurrPlayer.text = "Player $activePlayer: ${if (activePlayer == 1) "X" else "O"}"
        button.isEnabled = false
        checkWinner()
    }

    @SuppressLint("SetTextI18n")
    private fun checkWinner() {
        val won1 = checkWinnerPlayer(player1)
        val won2 = checkWinnerPlayer(player2)
        if (player1.size + player2.size == 9) {
            textViewCurrPlayer.text = "GAME OVER"
            textViewWinner.text = "Draw!"
            return
        } else if (!won1 && !won2) return

        textViewCurrPlayer.text = "GAME OVER"
        textViewWinner.text = "Player ${if (won1) 1 else 2} won!"

        val isEnabled = false
        button1.isEnabled = isEnabled; button2.isEnabled = isEnabled; button3.isEnabled = isEnabled
        button4.isEnabled = isEnabled; button5.isEnabled = isEnabled; button6.isEnabled = isEnabled
        button7.isEnabled = isEnabled; button8.isEnabled = isEnabled; button9.isEnabled = isEnabled
    }

    private fun checkWinnerPlayer(player: ArrayList<Int>): Boolean {
        //rows
        if (player.contains(1) && player.contains(2) && player.contains(3))
            return true
        if (player.contains(4) && player.contains(5) && player.contains(6))
            return true
        if (player.contains(7) && player.contains(8) && player.contains(9))
            return true
        //cols
        if (player.contains(7) && player.contains(4) && player.contains(1))
            return true
        if (player.contains(8) && player.contains(5) && player.contains(2))
            return true
        if (player.contains(9) && player.contains(6) && player.contains(3))
            return true
        //diagonals
        if (player.contains(1) && player.contains(5) && player.contains(9))
            return true
        if (player.contains(7) && player.contains(5) && player.contains(3))
            return true
        return false
    }
}
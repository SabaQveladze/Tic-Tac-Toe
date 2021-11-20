package com.example.x0

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class MainActivity: AppCompatActivity(), View.OnClickListener{
    private lateinit var bn1: Button
    private lateinit var bn2: Button
    private lateinit var bn3: Button
    private lateinit var bn4: Button
    private lateinit var bn5: Button
    private lateinit var bn6: Button
    private lateinit var bn7: Button
    private lateinit var bn8: Button
    private lateinit var bn9: Button
    private lateinit var resetscore: Button
    private lateinit var bnPlay: Button
    private lateinit var first0:TextView
    private lateinit var second0:TextView
    var firstscore=0
    var secondscore=0
    private var activePlayer = 1
    private var firstPlayer = ArrayList<Int>()
    private var secondPlayer = ArrayList<Int>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bn1 = findViewById(R.id.bn1)
        bn2 = findViewById(R.id.bn2)
        bn3 = findViewById(R.id.bn3)
        bn4 = findViewById(R.id.bn4)
        bn5 = findViewById(R.id.bn5)
        bn6 = findViewById(R.id.bn6)
        bn7 = findViewById(R.id.bn7)
        bn8 = findViewById(R.id.bn8)
        bn9 = findViewById(R.id.bn9)
        resetscore=findViewById(R.id.resetscore)
        first0 = findViewById(R.id.first0)
        second0 = findViewById(R.id.second0)
        bnPlay = findViewById(R.id.bnPlay)
        init()
        bnPlay.setOnClickListener{
            playAgain()
        }
        resetscore.setOnClickListener{
            restartScore()
        }
    }

    private fun restartScore() {
        if (firstscore!=0){
            firstscore=0
        }
        if (secondscore!=0){
            secondscore=0
        }
        first0.text=firstscore.toString()
        second0.text=secondscore.toString()
        playAgain()
    }


    private fun init() {

        bn1.setOnClickListener(this)
        bn2.setOnClickListener(this)
        bn3.setOnClickListener(this)
        bn4.setOnClickListener(this)
        bn5.setOnClickListener(this)
        bn6.setOnClickListener(this)
        bn7.setOnClickListener(this)
        bn8.setOnClickListener(this)
        bn9.setOnClickListener(this)

    }

    override fun onClick(clickedView: View?) {
        var buttonNumber=0


        if (clickedView is Button){
            if (buttonNumber != 0){
                playGame(clickedView,buttonNumber)
            }
            when(clickedView.id){
                R.id.bn1 -> buttonNumber = 1
                R.id.bn2 -> buttonNumber = 2
                R.id.bn3 -> buttonNumber = 3
                R.id.bn4 -> buttonNumber = 4
                R.id.bn5 -> buttonNumber = 5
                R.id.bn6 -> buttonNumber = 6
                R.id.bn7 -> buttonNumber = 7
                R.id.bn8 -> buttonNumber = 8
                R.id.bn9 -> buttonNumber = 9
            }
            if (buttonNumber!=0){
                playGame(clickedView,buttonNumber)
            }
        }
    }

    private fun playGame(clickedView: Button, buttonNumber: Int) {
        if (activePlayer==1){
            clickedView.text= "X"
            clickedView.setBackgroundColor(Color.BLUE)
            activePlayer = 2
            firstPlayer.add(buttonNumber)
        }else{
                clickedView.text= "0"
                clickedView.setBackgroundColor(Color.DKGRAY)
                activePlayer = 1
                secondPlayer.add(buttonNumber)
    }
    clickedView.isEnabled = false
        check()
}
private fun check() {
    var winnerPlayer = 0
    if (firstPlayer.contains(1) && firstPlayer.contains(2)&& firstPlayer.contains(3)){
        winnerPlayer = 1
    }
    if (secondPlayer.contains(1) && secondPlayer.contains(2)&& secondPlayer.contains(3)){
        winnerPlayer = 2
    }
    if (firstPlayer.contains(4) && firstPlayer.contains(5)&& firstPlayer.contains(6)){
        winnerPlayer = 1
    }
    if (secondPlayer.contains(4) && secondPlayer.contains(5)&& secondPlayer.contains(6)){
        winnerPlayer = 2
    }
    if (firstPlayer.contains(7) && firstPlayer.contains(8)&& firstPlayer.contains(9)){
        winnerPlayer = 1
    }
    if (secondPlayer.contains(7) && secondPlayer.contains(8)&& secondPlayer.contains(9)){
        winnerPlayer = 2
    }
    if (firstPlayer.contains(1) && firstPlayer.contains(4)&& firstPlayer.contains(7)){
        winnerPlayer = 1
    }
    if (secondPlayer.contains(1) && secondPlayer.contains(4)&& secondPlayer.contains(7)){
        winnerPlayer = 2
    }
    if (firstPlayer.contains(2) && firstPlayer.contains(5)&& firstPlayer.contains(8)){
        winnerPlayer = 1
    }
    if (secondPlayer.contains(2) && secondPlayer.contains(5)&& secondPlayer.contains(8)){
        winnerPlayer = 2
    }
    if (firstPlayer.contains(3) && firstPlayer.contains(6)&& firstPlayer.contains(9)){
        winnerPlayer = 1
    }
    if (secondPlayer.contains(3) && secondPlayer.contains(6)&& secondPlayer.contains(9)){
        winnerPlayer = 2
    }
    if (firstPlayer.contains(1) && firstPlayer.contains(5)&& firstPlayer.contains(9)){
        winnerPlayer = 1
    }
    if (secondPlayer.contains(1) && secondPlayer.contains(5)&& secondPlayer.contains(9)){
        winnerPlayer = 2
    }
    if (firstPlayer.contains(3) && firstPlayer.contains(5)&& firstPlayer.contains(7)){
        winnerPlayer = 1
    }
    if (secondPlayer.contains(3) && secondPlayer.contains(5)&& secondPlayer.contains(7)){
        winnerPlayer = 2
    }
    if(winnerPlayer==1){
        Toast.makeText(this, "მოგებულია X", Toast.LENGTH_LONG).show()
        firstscore += 1
        first0.text=firstscore.toString()
        firstPlayer.clear()
        secondPlayer.clear()
        bn1.isEnabled=false
        bn2.isEnabled=false
        bn3.isEnabled=false
        bn4.isEnabled=false
        bn5.isEnabled=false
        bn6.isEnabled=false
        bn7.isEnabled=false
        bn8.isEnabled=false
        bn9.isEnabled=false
        if(bn1.text==""){
            bn1.setBackgroundColor(Color.BLACK)
        }
        if(bn2.text==""){
            bn2.setBackgroundColor(Color.BLACK)
        }
        if(bn3.text==""){
            bn3.setBackgroundColor(Color.BLACK)
        }
        if(bn4.text==""){
            bn4.setBackgroundColor(Color.BLACK)
        }
        if(bn5.text==""){
            bn5.setBackgroundColor(Color.BLACK)
        }
        if(bn6.text==""){
            bn6.setBackgroundColor(Color.BLACK)
        }
        if(bn7.text==""){
            bn7.setBackgroundColor(Color.BLACK)
        }
        if(bn8.text==""){
            bn8.setBackgroundColor(Color.BLACK)
        }
        if(bn9.text==""){
            bn9.setBackgroundColor(Color.BLACK)
        }
    }else{
        if(winnerPlayer==2){
            Toast.makeText(this, "მოგებულია O", Toast.LENGTH_LONG).show()
            secondscore += 1
            second0.text=secondscore.toString()
            secondPlayer.clear()
            firstPlayer.clear()
            bn1.isEnabled=false
            bn2.isEnabled=false
            bn3.isEnabled=false
            bn4.isEnabled=false
            bn5.isEnabled=false
            bn6.isEnabled=false
            bn7.isEnabled=false
            bn8.isEnabled=false
            bn9.isEnabled=false
            if(bn1.text==""){
                bn1.setBackgroundColor(Color.BLACK)
            }
            if(bn2.text==""){
                bn2.setBackgroundColor(Color.BLACK)
            }
            if(bn3.text==""){
                bn3.setBackgroundColor(Color.BLACK)
            }
            if(bn4.text==""){
                bn4.setBackgroundColor(Color.BLACK)
            }
            if(bn5.text==""){
                bn5.setBackgroundColor(Color.BLACK)
            }
            if(bn6.text==""){
                bn6.setBackgroundColor(Color.BLACK)
            }
            if(bn7.text==""){
                bn7.setBackgroundColor(Color.BLACK)
            }
            if(bn8.text==""){
                bn8.setBackgroundColor(Color.BLACK)
            }
            if(bn9.text==""){
                bn9.setBackgroundColor(Color.BLACK)
            }
        }

    }
}
    private fun playAgain() {
        bn1.text=""
        bn1.setBackgroundColor(Color.rgb(40,255,0))
        bn1.isEnabled= true
        bn2.text=""
        bn2.setBackgroundColor(Color.rgb(40,255,0))
        bn2.isEnabled= true
        bn3.text=""
        bn3.setBackgroundColor(Color.rgb(40,255,0))
        bn3.isEnabled= true
        bn4.text=""
        bn4.setBackgroundColor(Color.rgb(40,255,0))
        bn4.isEnabled= true
        bn5.text=""
        bn5.setBackgroundColor(Color.rgb(40,255,0))
        bn5.isEnabled= true
        bn6.text=""
        bn6.setBackgroundColor(Color.rgb(40,255,0))
        bn6.isEnabled= true
        bn7.text=""
        bn7.setBackgroundColor(Color.rgb(40,255,0))
        bn7.isEnabled= true
        bn8.text=""
        bn8.setBackgroundColor(Color.rgb(40,255,0))
        bn8.isEnabled= true
        bn9.text=""
        bn9.setBackgroundColor(Color.rgb(40,255,0))
        bn9.isEnabled= true
        firstPlayer.clear()
        secondPlayer.clear()
        activePlayer=1
    }
}
package com.example.scalling

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView

import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {
    lateinit var scalling: Scalling;

    lateinit var textView: TextView;
    lateinit var textBefore: TextView;

    lateinit var seekBar: SeekBar;
    var result:Float = 0.0f;
    lateinit var fromNumScl: EditText;
    lateinit var toNumScl: EditText;

    lateinit var minNumScl: EditText;
    lateinit var maxNumScl: EditText;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        scalling = Scalling();

        fromNumScl = findViewById(R.id.editTextNumber)
        toNumScl = findViewById(R.id.editTextMax)

        fromNumScl.setText("0");
        toNumScl.setText("100");

        minNumScl = findViewById(R.id.editTextScallMin)
        maxNumScl = findViewById(R.id.editTextScallMax)

        minNumScl.setText("0");
        maxNumScl.setText("100");

        textView = findViewById(R.id.textTest)
        textBefore = findViewById(R.id.textTest2)
        seekBar = findViewById(R.id.seekBarScalling)


        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (minNumScl.text.toString() == ""){
                    seekBar?.min=0;
                }else
                    seekBar?.min = Integer.parseInt(fromNumScl.text.toString());
                if(maxNumScl.text.toString() == ""){
                    seekBar?.max=100;
                }else
                    seekBar?.max = Integer.parseInt(toNumScl.text.toString());

                seekBar?.progress?.let {
                    result = scalling.ScallingFun(
                        it.toFloat(),
                        nOneMin = Integer.parseInt(fromNumScl.text.toString()).toFloat(),
                        nTwoMax = Integer.parseInt(toNumScl.text.toString()).toFloat(),
                        sOneMin = Integer.parseInt(minNumScl.text.toString()).toFloat(),
                        sTwoMax = Integer.parseInt(maxNumScl.text.toString()).toFloat(),
                    )
                }
                textView.text = result.toString();
                textBefore.text = seekBar?.progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {    }
            override fun onStopTrackingTouch(seekBar: SeekBar?) {     }
        })
    }
}
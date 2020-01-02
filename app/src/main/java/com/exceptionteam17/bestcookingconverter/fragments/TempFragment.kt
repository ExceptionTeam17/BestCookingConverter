package com.exceptionteam17.bestcookingconverter.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.exceptionteam17.bestcookingconverter.MainActivity.Companion.buttonClickAnim
import com.exceptionteam17.bestcookingconverter.R
import kotlinx.android.synthetic.main.convertor_temp_layout.*
import java.text.DecimalFormat
import java.text.NumberFormat

class TempFragment : Fragment(), View.OnClickListener {
    private var myView: View? = null
    private var editFrom: TextView? = null
    private var editTo: TextView? = null
    private var isCels = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        myView = inflater.inflate(R.layout.convertor_temp_layout, container, false)
        return myView!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialise()
        calculateAll()
    }

    private fun initialise() {
        isCels = true
        editFrom = myView!!.findViewById(R.id.con_edit_1)
        editFrom!!.setText("0")
        //        editFrom.getBackground().setColorFilter(ContextCompat.getColor(view.getContext(), R.color.textColor), PorterDuff.Mode.SRC_ATOP);
        editTo = myView!!.findViewById(R.id.con_edit_2)
        editTo!!.visibility = View.VISIBLE
        editTo!!.setText("0")
        //        editTo.getBackground().setColorFilter(ContextCompat.getColor(view.getContext(), R.color.textColor), PorterDuff.Mode.SRC_ATOP);
        btn_1.setOnClickListener(this)
        btn_2.setOnClickListener(this)
        btn_3.setOnClickListener(this)
        btn_4.setOnClickListener(this)
        btn_5.setOnClickListener(this)
        btn_6.setOnClickListener(this)
        btn_7.setOnClickListener(this)
        btn_8.setOnClickListener(this)
        btn_9.setOnClickListener(this)
        btn_0.setOnClickListener(this)
        btn_dot.setOnClickListener(this)
        btn_del.setOnClickListener(this)
        btn_clear.setOnClickListener(this)
        text_temp_1.setText(R.string.cel)
        text_temp_2.setText(R.string.far)
        arow.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        v.startAnimation(buttonClickAnim)
        when (v.id) {
            R.id.btn_1 -> {
                addNumber(1)
                calculateAll()
            }
            R.id.btn_2 -> {
                addNumber(2)
                calculateAll()
            }
            R.id.btn_3 -> {
                addNumber(3)
                calculateAll()
            }
            R.id.btn_4 -> {
                addNumber(4)
                calculateAll()
            }
            R.id.btn_5 -> {
                addNumber(5)
                calculateAll()
            }
            R.id.btn_6 -> {
                addNumber(6)
                calculateAll()
            }
            R.id.btn_7 -> {
                addNumber(7)
                calculateAll()
            }
            R.id.btn_8 -> {
                addNumber(8)
                calculateAll()
            }
            R.id.btn_9 -> {
                addNumber(9)
                calculateAll()
            }
            R.id.btn_0 -> {
                addNumber(0)
                calculateAll()
            }
            R.id.btn_dot -> addDot()
            R.id.btn_del -> {
                deleteOneChar()
                calculateAll()
            }
            R.id.btn_clear -> {
                clear()
                calculateAll()
            }
            R.id.arow -> {
                isCels = !isCels
                if (isCels) {
                    text_temp_1.setText(R.string.cel)
                    text_temp_2.setText(R.string.far)
                } else {
                    text_temp_2.setText(R.string.cel)
                    text_temp_1.setText(R.string.far)
                }
                calculateAll()
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun addNumber(i: Int) {
        val text = editFrom!!.text.toString().trim { it <= ' ' }
        if (editFrom!!.text.toString().trim { it <= ' ' }.matches("[0-9]{6}+".toRegex())) {
            return
        }
        if (editFrom!!.text.toString().trim { it <= ' ' }.equals("0", ignoreCase = true)) {
            if (i == 0) {
                return
            } else {
                editFrom!!.text = ""
            }
        }
        if (editFrom!!.text.toString().trim { it <= ' ' }.length < 10) {
            if (!(text.length == 1 && text == "0" && i == 0)) {
                if (!editFrom!!.text.toString().trim { it <= ' ' }.matches("[0-9]\\.[0-9]{3}".toRegex())) {
                    editFrom!!.text = editFrom!!.text.toString() + i
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun addDot() {
        val text = editFrom!!.text.toString()
        var countDots = 0
        for (i in 0 until text.length) {
            if (text[i] == '.') {
                countDots++
            }
        }
        if (countDots == 0 && editFrom!!.text.toString().trim { it <= ' ' }.length < 11) {
            editFrom!!.text = editFrom!!.text.toString() + "."
        }
    }

    private fun deleteOneChar() {
        val s = editFrom!!.text.toString()
        if (s.length > 1) {
            editFrom!!.text = s.substring(0, s.length - 1)
        } else {
            editFrom!!.text = "0"
        }
    }

    private fun clear() {
        editFrom!!.text = "0"
    }

    private fun calculateAll() {
        val valInGr = if (isCels) editFrom!!.text.toString().toDouble() * 9 / 5 + 32 else (editFrom!!.text.toString().toDouble() - 32) * 5 / 9
        val formatter: NumberFormat = DecimalFormat("#.###")
        val temp = formatter.format(valInGr)
        editTo!!.text = temp
    }
}
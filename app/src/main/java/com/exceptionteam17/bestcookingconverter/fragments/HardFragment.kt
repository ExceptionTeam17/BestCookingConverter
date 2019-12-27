package com.exceptionteam17.bestcookingconverter.fragments

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import androidx.fragment.app.Fragment
import com.exceptionteam17.bestcookingconverter.R
import com.exceptionteam17.bestcookingconverter.model.Consts
import kotlinx.android.synthetic.main.convertor_layout.*
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

class HardFragment : Fragment(), View.OnClickListener {
    private var myView: View? = null
    private var mainSpin: Spinner? = null
    private var firstSpin: Spinner? = null
    private var secondSpin: Spinner? = null
    private var editFrom: TextView? = null
    private var editTo: TextView? = null
    private var mainSpinePosition = 0
    private var buttonClickAnim: AlphaAnimation? = null
    private var spinerPositionString: String? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        myView = inflater.inflate(R.layout.convertor_layout, container, false)
        buttonClickAnim = AlphaAnimation(2f, 0.7f)
        return myView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialise()
        setValues()
        setSpinnerSettings()
    }

    private fun initialise() {
        mainSpin = myView!!.findViewById(R.id.con_spinner_main)
        mainSpin!!.setVisibility(View.GONE)
        firstSpin = myView!!.findViewById(R.id.con_spiner_1)
        secondSpin = myView!!.findViewById(R.id.con_spinner_2)
        secondSpin!!.setVisibility(View.GONE)
        editFrom = myView!!.findViewById(R.id.con_edit_1)
        editFrom!!.setText("0")
        //        editFrom.getBackground().setColorFilter(ContextCompat.getColor(myView.getContext(), R.color.textColor), PorterDuff.Mode.SRC_ATOP);
        editTo = myView!!.findViewById(R.id.con_edit_2)
        editTo!!.setVisibility(View.GONE)
        myView!!.findViewById<View>(R.id.viewToHide).visibility = View.GONE
        myView!!.findViewById<View>(R.id.viewToHide2).visibility = View.GONE
        myView!!.findViewById<View>(R.id.viewToShow).visibility = View.VISIBLE
        myView!!.findViewById<View>(R.id.viewToShow2).visibility = View.VISIBLE
        con_title.setText(R.string.weight)
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
    }

    private fun setValues() {
        name_1.text = Consts.MG
        vol_1.text = "0"
        name_2.text = Consts.OZ
        vol_2.text = "0"
        name_3.text = Consts.GRAM
        vol_3.text = "0"
        name_4.text = Consts.LB
        vol_4.text = "0"
        name_5.text = Consts.KG
        vol_5.text = "0"
        name_6.text = Consts.ST
        vol_6.text = "0"
        name_7.text = Consts.TON
        vol_7.text = "0"
        name_8.visibility = View.INVISIBLE
        vol_8.visibility = View.INVISIBLE
        name_9.visibility = View.GONE
        vol_9.visibility = View.GONE
        name_10.visibility = View.GONE
        vol_10.visibility = View.GONE
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
        if (countDots == 0) {
            if (editFrom!!.text.toString().trim { it <= ' ' }.length < 11) {
                editFrom!!.text = editFrom!!.text.toString() + "."
            }
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
        val valInGr = editFrom!!.text.toString().toDouble() / Consts.GRAM_TO[spinerPositionString]!!
        val formatter: NumberFormat = DecimalFormat("#.##")
        var temp = formatter.format(valInGr * Consts.GRAM_TO[Consts.MG]!!)
        vol_1.text = if (temp.length > 15) temp.substring(0, 15) else temp
        name_2.text = Consts.OZ
        temp = formatter.format(valInGr * Consts.GRAM_TO[Consts.OZ]!!)
        vol_2.text = if (temp.length > 15) temp.substring(0, 15) else temp
        name_3.text = Consts.GRAM
        temp = formatter.format(valInGr * Consts.GRAM_TO[Consts.GRAM]!!)
        vol_3.text = if (temp.length > 15) temp.substring(0, 15) else temp
        name_4.text = Consts.LB
        temp = formatter.format(valInGr * Consts.GRAM_TO[Consts.LB]!!)
        vol_4.text = if (temp.length > 15) temp.substring(0, 15) else temp
        name_5.text = Consts.KG
        temp = formatter.format(valInGr * Consts.GRAM_TO[Consts.KG]!!)
        vol_5.text = if (temp.length > 15) temp.substring(0, 15) else temp
        name_6.text = Consts.ST
        temp = formatter.format(valInGr * Consts.GRAM_TO[Consts.ST]!!)
        vol_6.text = if (temp.length > 15) temp.substring(0, 15) else temp
        name_7.text = Consts.TON
        temp = formatter.format(valInGr * Consts.GRAM_TO[Consts.TON]!!)
        vol_7.text = if (temp.length > 15) temp.substring(0, 15) else temp
    }

    private fun setSpinnerSettings() {
        val spinnerArray: MutableList<String> = ArrayList()
        spinnerArray.addAll(Consts.GRAM_TO.keys)
        Collections.sort(spinnerArray) { o1, o2 -> o1.compareTo(o2) }
        val adapter = ArrayAdapter(
                myView!!.context, android.R.layout.simple_spinner_dropdown_item, spinnerArray)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        firstSpin!!.adapter = adapter
        val selected = arrayOf(firstSpin!!.selectedItem.toString())
        firstSpin!!.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
                selected[0] = firstSpin!!.selectedItem.toString()
                mainSpinePosition = position
                spinerPositionString = selected[0]
                calculateAll()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        firstSpin!!.viewTreeObserver.addOnGlobalLayoutListener {
            try {
                (firstSpin!!.selectedView as TextView).setTextColor(Color.WHITE)
            } catch (ignored: Exception) {
            }
        }
    }
}
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

class LiquidFragment : Fragment(), View.OnClickListener {
    private var myView: View? = null
    private var mainSpin: Spinner? = null
    private var firstSpin: Spinner? = null
    private var secondSpin: Spinner? = null
    private var editFrom: TextView? = null
    private var editTo: TextView? = null
    private var spinerPositionString: String? = null
    private var secondSpinnerPositionString: String? = null
    private var buttonClickAnim: AlphaAnimation? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        myView = inflater.inflate(R.layout.convertor_layout, container, false)
        buttonClickAnim = AlphaAnimation(2f, 0.7f)
        return myView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialise()
        setSpinnerSettings()
        setSecondSpinnerSettings()
    }

    private fun initialise() {
        secondSpinnerPositionString = Consts.ML_TO.keys.iterator().next()
        mainSpin = myView!!.findViewById(R.id.con_spinner_main)
        mainSpin!!.setVisibility(View.GONE)
        firstSpin = myView!!.findViewById(R.id.con_spiner_1)
        secondSpin = myView!!.findViewById(R.id.con_spinner_2)
        editFrom = myView!!.findViewById(R.id.con_edit_1)
        editFrom!!.setText("0")
        //        editFrom.getBackground().setColorFilter(ContextCompat.getColor(myView.getContext(), R.color.textColor), PorterDuff.Mode.SRC_ATOP);
        editTo = myView!!.findViewById(R.id.con_edit_2)
        editTo!!.setText("0")
        //        editTo.getBackground().setColorFilter(ContextCompat.getColor(myView.getContext(), R.color.textColor), PorterDuff.Mode.SRC_ATOP);
        con_title.setText(R.string.liquids)
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

    override fun onClick(v: View) {
        v.startAnimation(buttonClickAnim)
        when (v.id) {
            R.id.con_spiner_1 -> {
            }
            R.id.con_spinner_2 -> {
            }
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
            R.id.btn_dot -> {
                addDot()
                calculateAll()
            }
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
                if (!editFrom!!.text.toString().trim { it <= ' ' }.matches("[0-9]+\\.[0-9]{3}".toRegex())) {
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

    private fun setSpinnerSettings() {
        val spinnerArray: MutableList<String> = ArrayList()
        spinnerArray.addAll(Consts.ML_TO.keys)
        Collections.sort(spinnerArray) { o1, o2 -> o1.compareTo(o2) }
        val adapter = ArrayAdapter(
                myView!!.context, android.R.layout.simple_spinner_dropdown_item, spinnerArray)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        firstSpin!!.adapter = adapter
        val selected = arrayOf(firstSpin!!.selectedItem.toString())
        firstSpin!!.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
                selected[0] = firstSpin!!.selectedItem.toString()
                spinerPositionString = selected[0]
                calculateAll()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    private fun setSecondSpinnerSettings() {
        val spinnerArray: MutableList<String> = ArrayList()
        spinnerArray.addAll(Consts.ML_TO.keys)
        val adapter = ArrayAdapter(
                myView!!.context, android.R.layout.simple_spinner_dropdown_item, spinnerArray)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        secondSpin!!.adapter = adapter
        val selected = arrayOf(secondSpin!!.selectedItem.toString())
        secondSpin!!.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
                selected[0] = secondSpin!!.selectedItem.toString()
                secondSpinnerPositionString = selected[0]
                val formatter: NumberFormat = DecimalFormat("#.###")
                editTo!!.text = formatter.format(editFrom!!.text.toString().toDouble() / Consts.ML_TO[spinerPositionString]!! * Consts.ML_TO[secondSpinnerPositionString]!!)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        firstSpin!!.viewTreeObserver.addOnGlobalLayoutListener {
            try {
                (firstSpin!!.selectedView as TextView).setTextColor(Color.WHITE)
            } catch (ignored: Exception) {
            }
        }
        secondSpin!!.viewTreeObserver.addOnGlobalLayoutListener {
            try {
                (secondSpin!!.selectedView as TextView).setTextColor(Color.WHITE)
            } catch (ignored: Exception) {
            }
        }
    }

    private fun calculateAll() {
        val valInMl = editFrom!!.text.toString().toDouble() / Consts.ML_TO[spinerPositionString]!!
        val formatter: NumberFormat = DecimalFormat("#.##")
        editTo!!.text = formatter.format(valInMl * Consts.ML_TO[secondSpinnerPositionString]!!)
        var temp = formatter.format(valInMl * Consts.ML_TO[Consts.CUP_METRIC]!!)
        vol_1!!.text = temp
        name_1!!.text = Consts.CUP_METRIC
        temp = formatter.format(valInMl * Consts.ML_TO[Consts.CUP_US_TEA]!!)
        vol_2!!.text = temp
        name_2!!.text = Consts.CUP_US_TEA
        temp = formatter.format(valInMl * Consts.ML_TO[Consts.ML]!!)
        vol_3!!.text = temp
        name_3!!.text = Consts.ML
        temp = formatter.format(valInMl * Consts.ML_TO[Consts.CU_IN]!!)
        vol_4!!.text = temp
        name_4!!.text = Consts.CU_IN
        temp = formatter.format(valInMl * Consts.ML_TO[Consts.FL_OZ_LMP]!!)
        vol_5!!.text = temp
        name_5!!.text = Consts.FL_OZ_LMP
        temp = formatter.format(valInMl * Consts.ML_TO[Consts.FL_OZ_US]!!)
        vol_6!!.text = temp
        name_6!!.text = Consts.FL_OZ_US
        temp = formatter.format(valInMl * Consts.ML_TO[Consts.TBSP_UK]!!)
        vol_7!!.text = temp
        name_7!!.text = Consts.TBSP_UK
        temp = formatter.format(valInMl * Consts.ML_TO[Consts.TBSP_US]!!)
        vol_8!!.text = temp
        name_8!!.text = Consts.TBSP_US
        temp = formatter.format(valInMl * Consts.ML_TO[Consts.TSP_UK]!!)
        vol_9!!.text = temp
        name_9!!.text = Consts.TSP_UK
        temp = formatter.format(valInMl * Consts.ML_TO[Consts.TSP_US]!!)
        vol_10!!.text = temp
        name_10!!.text = Consts.TSP_US
    }
}
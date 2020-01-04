package com.exceptionteam17.bestcookingconverter.fragments

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import androidx.fragment.app.Fragment
import com.exceptionteam17.bestcookingconverter.MainActivity.Companion.buttonClickAnim
import com.exceptionteam17.bestcookingconverter.R
import com.exceptionteam17.bestcookingconverter.model.Consts
import com.exceptionteam17.bestcookingconverter.model.Database
import kotlinx.android.synthetic.main.convertor_layout.*
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

class MassFragment : Fragment(), View.OnClickListener {
    private var myView: View? = null
    private var mainSpin: Spinner? = null
    private var firstSpin: Spinner? = null
    private var secondSpin: Spinner? = null
    private var editFrom: TextView? = null
    private var editTo: TextView? = null
    private var mainSpinnerStr: String? = null
    private var firstSpinerStr: String? = null
    private var secondSpinnerStr: String? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        myView = inflater.inflate(R.layout.convertor_layout, container, false)
        return myView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialise()
        setMainSpinnerSettings()
        setFirstSpinnerSettings()
        setSecondSpinnerSettings()
    }

    private fun initialise() {
        mainSpinnerStr = ""
        firstSpinerStr = ""
        secondSpinnerStr = ""
        mainSpin = myView!!.findViewById(R.id.con_spinner_main)
        firstSpin = myView!!.findViewById(R.id.con_spiner_1)
        secondSpin = myView!!.findViewById(R.id.con_spinner_2)
        editFrom = myView!!.findViewById(R.id.con_edit_1)
        editFrom!!.setText("0")
        //        editFrom.getBackground().setColorFilter(ContextCompat.getColor(myView.getContext(), R.color.textColor), PorterDuff.Mode.SRC_ATOP);
        editTo = myView!!.findViewById(R.id.con_edit_2)
        editTo!!.setText("0")
        //        editTo.getBackground().setColorFilter(ContextCompat.getColor(myView.getContext(), R.color.textColor), PorterDuff.Mode.SRC_ATOP);
        con_title.setVisibility(View.GONE)
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

    private fun setMainSpinnerSettings() {
        val spinnerArray: MutableList<String> = ArrayList()
        spinnerArray.addAll(Database.ingredients.keys)
        val adapter: ArrayAdapter<String> = object : ArrayAdapter<String>(
                myView!!.context, android.R.layout.simple_spinner_dropdown_item, spinnerArray) {
            override fun getDropDownView(position: Int, convertView: View?,
                                         parent: ViewGroup): View {
                val view = super.getDropDownView(position, convertView, parent)
                val tv = view as TextView
                if (position < 9) {
                    tv.setBackgroundColor(Color.parseColor("#ffe7b5"))
                } else {
                    tv.setBackgroundColor(Color.parseColor("#ffffff"))
                }
                return view
            }
        }
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        mainSpin!!.adapter = adapter
        val selected = arrayOf(mainSpin!!.selectedItem.toString())
        mainSpin!!.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
                selected[0] = mainSpin!!.selectedItem.toString()
                mainSpinnerStr = selected[0]
                calculateAll()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    private fun setFirstSpinnerSettings() {
        val spinnerArray: MutableList<String> = ArrayList()
        spinnerArray.addAll(Consts.ML_TO.keys)
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
                firstSpinerStr = selected[0]
                calculateAll()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    private fun setSecondSpinnerSettings() {
        val spinnerArray: MutableList<String> = ArrayList()
        spinnerArray.addAll(Consts.ML_TO.keys)
        spinnerArray.addAll(Consts.GRAM_TO.keys)
        Collections.sort(spinnerArray) { o1, o2 -> o1.compareTo(o2) }
        val adapter = ArrayAdapter(
                myView!!.context, android.R.layout.simple_spinner_dropdown_item, spinnerArray)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        secondSpin!!.adapter = adapter
        val selected = arrayOf(secondSpin!!.selectedItem.toString())
        secondSpin!!.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
                selected[0] = secondSpin!!.selectedItem.toString()
                secondSpinnerStr = selected[0]
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
        secondSpin!!.viewTreeObserver.addOnGlobalLayoutListener {
            try {
                (secondSpin!!.selectedView as TextView).setTextColor(Color.WHITE)
            } catch (ignored: Exception) {
            }
        }
        mainSpin!!.viewTreeObserver.addOnGlobalLayoutListener {
            try {
                val text = mainSpin!!.selectedView as TextView
                text.setTextColor(Color.WHITE)
                text.textSize = 20f
            } catch (ignored: Exception) {
            }
        }
    }

    private fun calculateAll() {
        val formatter: NumberFormat = DecimalFormat("#.##")
        val numberInEditText = editFrom!!.text.toString().toDouble()
        if (Consts.GRAM_TO.containsKey(firstSpinerStr) && Consts.GRAM_TO.containsKey(secondSpinnerStr)) {
            editTo!!.text = formatter.format((numberInEditText
                    / Consts.GRAM_TO[firstSpinerStr]!!) * Consts.GRAM_TO[secondSpinnerStr]!!)
        } else if (Consts.ML_TO.containsKey(firstSpinerStr) && Consts.GRAM_TO.containsKey(secondSpinnerStr)) {
            editTo!!.text = formatter.format((numberInEditText / Consts.ML_TO[firstSpinerStr]!!
                    / Consts.CUP_US_IN_ML) * Database.ingredients[mainSpinnerStr]!! * Consts.GRAM_TO[secondSpinnerStr]!!)
        } else if (Consts.GRAM_TO.containsKey(firstSpinerStr) && Consts.ML_TO.containsKey(secondSpinnerStr)) {
            editTo!!.text = formatter.format((numberInEditText / Consts.GRAM_TO[firstSpinerStr]!!
                    / Database.ingredients[mainSpinnerStr]!!) * Consts.CUP_US_IN_ML * Consts.ML_TO[secondSpinnerStr]!!)
        } else if (Consts.ML_TO.containsKey(firstSpinerStr) && Consts.ML_TO.containsKey(secondSpinnerStr)) {
            editTo!!.text = formatter.format((numberInEditText
                    / Consts.ML_TO[firstSpinerStr]!!) * Consts.ML_TO[secondSpinnerStr]!!)
        }
        /////////////////////
        if (Consts.GRAM_TO.containsKey(firstSpinerStr)) {
            vol_1!!.text = formatter.format((numberInEditText / Consts.GRAM_TO[firstSpinerStr]!!
                    / Database.ingredients[mainSpinnerStr]!!) * Consts.CUP_US_IN_ML * Consts.ML_TO[Consts.CUP_METRIC]!!)
        } else if (Consts.ML_TO.containsKey(firstSpinerStr)) {
            vol_1!!.text = formatter.format((numberInEditText
                    / Consts.ML_TO[firstSpinerStr]!!) * Consts.ML_TO[Consts.CUP_METRIC]!!)
        }
        name_1!!.text = Consts.CUP_METRIC
        /////////////////////
        if (Consts.GRAM_TO.containsKey(firstSpinerStr)) {
            vol_2!!.text = formatter.format((numberInEditText / Consts.GRAM_TO[firstSpinerStr]!!
                    / Database.ingredients[mainSpinnerStr]!!) * Consts.CUP_US_IN_ML * Consts.ML_TO[Consts.CUP_US_TEA]!!)
        } else if (Consts.ML_TO.containsKey(firstSpinerStr)) {
            vol_2!!.text = formatter.format((numberInEditText
                    / Consts.ML_TO[firstSpinerStr]!!) * Consts.ML_TO[Consts.CUP_US_TEA]!!)
        }
        name_2!!.text = Consts.CUP_US_TEA
        /////////////////////
        if (Consts.GRAM_TO.containsKey(firstSpinerStr)) {
            vol_3!!.text = formatter.format((numberInEditText
                    / Consts.GRAM_TO[firstSpinerStr]!!) * Consts.GRAM_TO[Consts.GRAM]!!)
        } else if (Consts.ML_TO.containsKey(firstSpinerStr)) {
            vol_3!!.text = formatter.format((numberInEditText / Consts.ML_TO[firstSpinerStr]!!
                    / Consts.CUP_US_IN_ML) * Database.ingredients[mainSpinnerStr]!! * Consts.GRAM_TO[Consts.GRAM]!!)
        }
        name_3!!.text = Consts.GRAM
        /////////////////////
        if (Consts.GRAM_TO.containsKey(firstSpinerStr)) {
            vol_4!!.text = formatter.format((numberInEditText
                    / Consts.GRAM_TO[firstSpinerStr]!!) * Consts.GRAM_TO[Consts.OZ]!!)
        } else if (Consts.ML_TO.containsKey(firstSpinerStr)) {
            vol_4!!.text = formatter.format((numberInEditText / Consts.ML_TO[firstSpinerStr]!!
                    / Consts.CUP_US_IN_ML) * Database.ingredients[mainSpinnerStr]!! * Consts.GRAM_TO[Consts.OZ]!!)
        }
        name_4!!.text = Consts.OZ
        /////////////////////
        if (Consts.GRAM_TO.containsKey(firstSpinerStr)) {
            vol_5!!.text = formatter.format((numberInEditText / Consts.GRAM_TO[firstSpinerStr]!!
                    / Database.ingredients[mainSpinnerStr]!!) * Consts.CUP_US_IN_ML * Consts.ML_TO[Consts.ML]!!)
        } else if (Consts.ML_TO.containsKey(firstSpinerStr)) {
            vol_5!!.text = formatter.format((numberInEditText
                    / Consts.ML_TO[firstSpinerStr]!!) * Consts.ML_TO[Consts.ML]!!)
        }
        name_5!!.text = Consts.ML
        /////////////////////
        if (Consts.GRAM_TO.containsKey(firstSpinerStr)) {
            vol_6!!.text = formatter.format((numberInEditText / Consts.GRAM_TO[firstSpinerStr]!!
                    / Database.ingredients[mainSpinnerStr]!!) * Consts.CUP_US_IN_ML * Consts.ML_TO[Consts.FL_OZ_US]!!)
        } else if (Consts.ML_TO.containsKey(firstSpinerStr)) {
            vol_6!!.text = formatter.format((numberInEditText
                    / Consts.ML_TO[firstSpinerStr]!!) * Consts.ML_TO[Consts.FL_OZ_US]!!)
        }
        name_6!!.text = Consts.FL_OZ_US
        /////////////////////
        if (Consts.GRAM_TO.containsKey(firstSpinerStr)) {
            vol_7!!.text = formatter.format((numberInEditText / Consts.GRAM_TO[firstSpinerStr]!!
                    / Database.ingredients[mainSpinnerStr]!!) * Consts.CUP_US_IN_ML * Consts.ML_TO[Consts.TBSP_METRIC]!!)
        } else if (Consts.ML_TO.containsKey(firstSpinerStr)) {
            vol_7!!.text = formatter.format((numberInEditText
                    / Consts.ML_TO[firstSpinerStr]!!) * Consts.ML_TO[Consts.TBSP_METRIC]!!)
        }
        name_7!!.text = Consts.TBSP_METRIC
        /////////////////////
        if (Consts.GRAM_TO.containsKey(firstSpinerStr)) {
            vol_8!!.text = formatter.format((numberInEditText / Consts.GRAM_TO[firstSpinerStr]!!
                    / Database.ingredients[mainSpinnerStr]!!) * Consts.CUP_US_IN_ML * Consts.ML_TO[Consts.TBSP_UK]!!)
        } else if (Consts.ML_TO.containsKey(firstSpinerStr)) {
            vol_8!!.text = formatter.format((numberInEditText
                    / Consts.ML_TO[firstSpinerStr]!!) * Consts.ML_TO[Consts.TBSP_UK]!!)
        }
        name_8!!.text = Consts.TBSP_UK
        /////////////////////
        if (Consts.GRAM_TO.containsKey(firstSpinerStr)) {
            vol_9!!.text = formatter.format((numberInEditText / Consts.GRAM_TO[firstSpinerStr]!!
                    / Database.ingredients[mainSpinnerStr]!!) * Consts.CUP_US_IN_ML * Consts.ML_TO[Consts.TSP_METRIC]!!)
        } else if (Consts.ML_TO.containsKey(firstSpinerStr)) {
            vol_9!!.text = formatter.format((numberInEditText
                    / Consts.ML_TO[firstSpinerStr]!!) * Consts.ML_TO[Consts.TSP_METRIC]!!)
        }
        name_9!!.text = Consts.TSP_METRIC
        /////////////////////
        if (Consts.GRAM_TO.containsKey(firstSpinerStr)) {
            vol_10!!.text = formatter.format((numberInEditText / Consts.GRAM_TO[firstSpinerStr]!!
                    / Database.ingredients[mainSpinnerStr]!!) * Consts.CUP_US_IN_ML * Consts.ML_TO[Consts.TSP_UK]!!)
        } else if (Consts.ML_TO.containsKey(firstSpinerStr)) {
            vol_10!!.text = formatter.format((numberInEditText
                    / Consts.ML_TO[firstSpinerStr]!!) * Consts.ML_TO[Consts.TSP_UK]!!)
        }
        name_10!!.text = Consts.TSP_UK
    }
}
package com.exceptionteam17.bestcookingconverter.fragments;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.exceptionteam17.bestcookingconverter.R;
import com.exceptionteam17.bestcookingconverter.model.Consts;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public final class LiquidFragment extends Fragment implements View.OnClickListener{

    private View view;
    private Spinner mainSpin, firstSpin, secondSpin;
    private EditText editFrom, editTo;
    private TextView title, vol_1, name_1,  vol_2, name_2,  vol_3, name_3,  vol_4, name_4,  vol_5, name_5,  vol_6, name_6,
            vol_7, name_7,  vol_8, name_8,  vol_9, name_9,  vol_10, name_10;
    private Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_0, btn_dot, btn_del, btn_clear;
    private String spinerPositionString, secondSpinnerPositionString;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.convertor_layout, container, false);
        initialise();
        setSpinnerSettings();
        setSecondSpinnerSettings();
        return view;
    }

    private void initialise() {
        secondSpinnerPositionString = Consts.ML_TO.keySet().iterator().next();
        mainSpin = view.findViewById(R.id.con_spinner_main);
        mainSpin.setVisibility(View.GONE);
        firstSpin = view.findViewById(R.id.con_spiner_1);
        secondSpin = view.findViewById(R.id.con_spinner_2);

        editFrom = view.findViewById(R.id.con_edit_1);
        editFrom.setText("0");
        editFrom.getBackground().setColorFilter(ContextCompat.getColor(view.getContext(), R.color.textColor), PorterDuff.Mode.SRC_ATOP);
        editTo = view.findViewById(R.id.con_edit_2);
        editTo.setText("0");
        editTo.getBackground().setColorFilter(ContextCompat.getColor(view.getContext(), R.color.textColor), PorterDuff.Mode.SRC_ATOP);

        title = view.findViewById(R.id.con_title);
        title.setText(R.string.liquids);
        vol_1 = view.findViewById(R.id.con_vol_1);
        name_1 = view.findViewById(R.id.con_name_1);
        vol_2 = view.findViewById(R.id.con_vol_2);
        name_2 = view.findViewById(R.id.con_name_2);
        vol_3 = view.findViewById(R.id.con_vol_3);
        name_3 = view.findViewById(R.id.con_name_3);
        vol_4 = view.findViewById(R.id.con_vol_4);
        name_4 = view.findViewById(R.id.con_name_4);
        vol_5 = view.findViewById(R.id.con_vol_5);
        name_5 = view.findViewById(R.id.con_name_5);
        vol_6 = view.findViewById(R.id.con_vol_6);
        name_6 = view.findViewById(R.id.con_name_6);
        vol_7 = view.findViewById(R.id.con_vol_7);
        name_7 = view.findViewById(R.id.con_name_7);
        vol_8 = view.findViewById(R.id.con_vol_8);
        name_8 = view.findViewById(R.id.con_name_8);
        vol_9 = view.findViewById(R.id.con_vol_9);
        name_9 = view.findViewById(R.id.con_name_9);
        vol_10 = view.findViewById(R.id.con_vol_10);
        name_10 = view.findViewById(R.id.con_name_10);

        btn_1 = view.findViewById(R.id.btn_1);
        btn_1.setOnClickListener(this);
        btn_2 = view.findViewById(R.id.btn_2);
        btn_2.setOnClickListener(this);
        btn_3 = view.findViewById(R.id.btn_3);
        btn_3.setOnClickListener(this);
        btn_4 = view.findViewById(R.id.btn_4);
        btn_4.setOnClickListener(this);
        btn_5 = view.findViewById(R.id.btn_5);
        btn_5.setOnClickListener(this);
        btn_6 = view.findViewById(R.id.btn_6);
        btn_6.setOnClickListener(this);
        btn_7 = view.findViewById(R.id.btn_7);
        btn_7.setOnClickListener(this);
        btn_8 = view.findViewById(R.id.btn_8);
        btn_8.setOnClickListener(this);
        btn_9 = view.findViewById(R.id.btn_9);
        btn_9.setOnClickListener(this);
        btn_0 = view.findViewById(R.id.btn_0);
        btn_0.setOnClickListener(this);
        btn_dot = view.findViewById(R.id.btn_dot);
        btn_dot.setOnClickListener(this);
        btn_del = view.findViewById(R.id.btn_del);
        btn_del.setOnClickListener(this);
        btn_clear = view.findViewById(R.id.btn_clear);
        btn_clear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.con_spiner_1:
                break;
            case R.id.con_spinner_2:
                break;
            case R.id.btn_1:
                addNumber(1);
                calculateAll();
                break;
            case R.id.btn_2:
                addNumber(2);
                calculateAll();
                break;
            case R.id.btn_3:
                addNumber(3);
                calculateAll();
                break;
            case R.id.btn_4:
                addNumber(4);
                calculateAll();
                break;
            case R.id.btn_5:
                addNumber(5);
                calculateAll();
                break;
            case R.id.btn_6:
                addNumber(6);
                calculateAll();
                break;
            case R.id.btn_7:
                addNumber(7);
                calculateAll();
                break;
            case R.id.btn_8:
                addNumber(8);
                calculateAll();
                break;
            case R.id.btn_9:
                addNumber(9);
                calculateAll();
                break;
            case R.id.btn_0:
                addNumber(0);
                calculateAll();
                break;
            case R.id.btn_dot:
                addDot();
                calculateAll();
                break;
            case R.id.btn_del:
                deleteOneChar();
                calculateAll();
                break;
            case R.id.btn_clear:
                clear();
                calculateAll();
                break;
        }
    }

    @SuppressLint("SetTextI18n")
    private void addNumber(int i) {

        String text = editFrom.getText().toString().trim();

        if(editFrom.getText().toString().trim().matches("[0-9]{6}+")){
            return;
        }

        if (editFrom.getText().toString().trim().equalsIgnoreCase("0")) {
            if(i == 0) {
                return;
            } else {
                editFrom.setText("");
            }
        }

        if (editFrom.getText().toString().trim().length() < 10) {
            if (!(text.length() == 1 && text.equals("0") && i == 0)) {
                if (!editFrom.getText().toString().trim().matches("[0-9]+\\.[0-9]{3}")) {
                    editFrom.setText(editFrom.getText().toString() + i);
                }
            }
        }
    }


    @SuppressLint("SetTextI18n")
    private void addDot() {
        String text = editFrom.getText().toString();
        int countDots = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '.') {
                countDots++;
            }
        }

        if (countDots == 0) {
            if (editFrom.getText().toString().trim().length() < 11) {
                editFrom.setText(editFrom.getText().toString() + ".");
            }
        }
    }

    private void deleteOneChar() {
        String s = editFrom.getText().toString();
        if (s.length() > 1) {
            editFrom.setText(s.substring(0, s.length()-1));
        } else {
            editFrom.setText("0");
        }
    }

    private void clear(){
        editFrom.setText("0");
    }

    private void setSpinnerSettings() {
        List<String> spinnerArray =  new ArrayList<>();
        spinnerArray.addAll(Consts.ML_TO.keySet());
        Collections.sort(spinnerArray, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                view.getContext(), android.R.layout.simple_spinner_dropdown_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        firstSpin.setAdapter(adapter);

        final String[] selected = {firstSpin.getSelectedItem().toString()};

        firstSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                selected[0] = firstSpin.getSelectedItem().toString();

                spinerPositionString = selected[0];

                calculateAll();
            }

            public void onNothingSelected(AdapterView<?> parent){
            }
        });
    }
    private void setSecondSpinnerSettings() {
        List<String> spinnerArray =  new ArrayList<>();
        spinnerArray.addAll(Consts.ML_TO.keySet());

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                view.getContext(), android.R.layout.simple_spinner_dropdown_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        secondSpin.setAdapter(adapter);

        final String[] selected = {secondSpin.getSelectedItem().toString()};

        secondSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                selected[0] = secondSpin.getSelectedItem().toString();

                secondSpinnerPositionString = selected[0];

                NumberFormat formatter = new DecimalFormat("#.###");
                editTo.setText(formatter.format((Double.parseDouble(editFrom.getText().toString() )/ Consts.ML_TO.get(spinerPositionString)) * Consts.ML_TO.get(secondSpinnerPositionString)));
            }

            public void onNothingSelected(AdapterView<?> parent){
            }
        });

        firstSpin.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                ((TextView) firstSpin.getSelectedView()).setTextColor(Color.WHITE);
            }
        });

        secondSpin.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                ((TextView) secondSpin.getSelectedView()).setTextColor(Color.WHITE);
            }
        });
    }

    private void calculateAll() {
        double valInMl = Double.parseDouble(editFrom.getText().toString()) / Consts.ML_TO.get(spinerPositionString);
        NumberFormat formatter = new DecimalFormat("#.###");

        editTo.setText(formatter.format(valInMl * Consts.ML_TO.get(secondSpinnerPositionString)));

        String temp = formatter.format(valInMl * Consts.ML_TO.get(Consts.CUP_METRIC));
        vol_1.setText(temp);
        name_1.setText(Consts.CUP_METRIC);

        temp = formatter.format(valInMl * Consts.ML_TO.get(Consts.CUP_US_TEA));
        vol_2.setText(temp);
        name_2.setText(Consts.CUP_US_TEA);

        temp = formatter.format(valInMl * Consts.ML_TO.get(Consts.ML));
        vol_3.setText(temp);
        name_3.setText(Consts.ML);

        temp = formatter.format(valInMl * Consts.ML_TO.get(Consts.CU_IN));
        vol_4.setText(temp);
        name_4.setText(Consts.CU_IN);

        temp = formatter.format(valInMl * Consts.ML_TO.get(Consts.FL_OZ_LMP));
        vol_5.setText(temp);
        name_5.setText(Consts.FL_OZ_LMP);

        temp = formatter.format(valInMl * Consts.ML_TO.get(Consts.FL_OZ_US));
        vol_6.setText(temp);
        name_6.setText(Consts.FL_OZ_US);

        temp = formatter.format(valInMl * Consts.ML_TO.get(Consts.TBSP_UK));
        vol_7.setText(temp);
        name_7.setText(Consts.TBSP_UK);

        temp = formatter.format(valInMl * Consts.ML_TO.get(Consts.TBSP_US));
        vol_8.setText(temp);
        name_8.setText(Consts.TBSP_US);

        temp = formatter.format(valInMl * Consts.ML_TO.get(Consts.TSP_UK));
        vol_9.setText(temp);
        name_9.setText(Consts.TSP_UK);

        temp = formatter.format(valInMl * Consts.ML_TO.get(Consts.TSP_US));
        vol_10.setText(temp);
        name_10.setText(Consts.TSP_US);
    }
}

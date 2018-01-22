package com.exceptionteam17.bestcookingconverter.fragments;


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
import java.util.List;

public class HardFragment extends Fragment implements View.OnClickListener{

    private View view;
    private Spinner mainSpin, firstSpin, secondSpin;
    private EditText editFrom, editTo;
    private TextView title, vol_1, name_1,  vol_2, name_2,  vol_3, name_3,  vol_4, name_4,  vol_5, name_5,  vol_6, name_6,
            vol_7, name_7,  vol_8, name_8,  vol_9, name_9,  vol_10, name_10;
    private Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_0, btn_dot, btn_del, btn_clear;
    private int mainSpinePosition;
    private String spinerPositionString;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.convertor_layout, container, false);
        initialise();
        setValues();
        setSpinnerSettings();
        return view;
    }

    private void initialise() {
        mainSpin = view.findViewById(R.id.con_spinner_main);
        mainSpin.setVisibility(View.GONE);
        firstSpin = view.findViewById(R.id.con_spiner_1);
        secondSpin = view.findViewById(R.id.con_spinner_2);
        secondSpin.setVisibility(View.GONE);

        editFrom = view.findViewById(R.id.con_edit_1);
        editFrom.setText("0");
        editFrom.getBackground().setColorFilter(ContextCompat.getColor(view.getContext(), R.color.textColor), PorterDuff.Mode.SRC_ATOP);
        editTo = view.findViewById(R.id.con_edit_2);
        editTo.setVisibility(View.GONE);

        view.findViewById(R.id.viewToHide).setVisibility(View.GONE);
        view.findViewById(R.id.viewToHide2).setVisibility(View.GONE);

        title = view.findViewById(R.id.con_title);
        title.setText(R.string.weight);
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

    private void setValues(){
        name_1.setText(Consts.MG);
        vol_1.setText("0");
        name_2.setText(Consts.OZ);
        vol_2.setText("0");
        name_3.setText(Consts.GRAM);
        vol_3.setText("0");
        name_4.setText(Consts.LB);
        vol_4.setText("0");
        name_5.setText(Consts.KG);
        vol_5.setText("0");
        name_6.setText(Consts.ST);
        vol_6.setText("0");
        name_7.setText(Consts.TON);
        vol_7.setText("0");
        name_8.setVisibility(View.INVISIBLE);
        vol_8.setVisibility(View.INVISIBLE);
        name_9.setVisibility(View.GONE);
        vol_9.setVisibility(View.GONE);
        name_10.setVisibility(View.GONE);
        vol_10.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
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
                if (!editFrom.getText().toString().trim().matches("[0-9]\\.[0-9]{3}")) {
                    editFrom.setText(editFrom.getText().toString() + i);
                }
            }
        }
    }


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

    private void calculateAll(){
        double valInGr = Double.parseDouble(editFrom.getText().toString()) / Consts.GRAM_TO.get(spinerPositionString);

        NumberFormat formatter = new DecimalFormat("#.###");
        String temp = formatter.format(valInGr * Consts.GRAM_TO.get(Consts.MG));
        vol_1.setText(temp.length()>15? temp.substring(0, 15) : temp);
        name_2.setText(Consts.OZ);
        temp = formatter.format(valInGr * Consts.GRAM_TO.get(Consts.OZ));
        vol_2.setText(temp.length()>15? temp.substring(0, 15) : temp);
        name_3.setText(Consts.GRAM);
        temp = formatter.format(valInGr * Consts.GRAM_TO.get(Consts.GRAM));
        vol_3.setText(temp.length()>15? temp.substring(0, 15) : temp);
        name_4.setText(Consts.LB);
        temp = formatter.format(valInGr * Consts.GRAM_TO.get(Consts.LB));
        vol_4.setText(temp.length()>15? temp.substring(0, 15) : temp);
        name_5.setText(Consts.KG);
        temp = formatter.format(valInGr * Consts.GRAM_TO.get(Consts.KG));
        vol_5.setText(temp.length()>15? temp.substring(0, 15) : temp);
        name_6.setText(Consts.ST);
        temp = formatter.format(valInGr * Consts.GRAM_TO.get(Consts.ST));
        vol_6.setText(temp.length()>15? temp.substring(0, 15) : temp);
        name_7.setText(Consts.TON);
        temp = formatter.format(valInGr * Consts.GRAM_TO.get(Consts.TON));
        vol_7.setText(temp.length()>15? temp.substring(0, 15) : temp);

    }

    private void setSpinnerSettings() {
        List<String> spinnerArray =  new ArrayList<String>();
        spinnerArray.addAll(Consts.GRAM_TO.keySet());

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                view.getContext(), android.R.layout.simple_spinner_dropdown_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        firstSpin.setAdapter(adapter);

        final String[] selected = {firstSpin.getSelectedItem().toString()};

        firstSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                selected[0] = firstSpin.getSelectedItem().toString();

                mainSpinePosition = position;
                spinerPositionString = selected[0];

                calculateAll();
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
    }
}

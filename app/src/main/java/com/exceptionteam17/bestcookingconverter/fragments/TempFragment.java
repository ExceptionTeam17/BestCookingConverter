package com.exceptionteam17.bestcookingconverter.fragments;

import android.annotation.SuppressLint;
import android.graphics.PorterDuff;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.core.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.exceptionteam17.bestcookingconverter.R;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class TempFragment extends Fragment implements View.OnClickListener{

    private View view;
    private EditText editFrom, editTo;
    private TextView text1, text2;
    private boolean isCels;
    private Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_0, btn_dot, btn_del, btn_clear;
    private ImageButton arow;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.convertor_temp_layout, container, false);
        initialise();
        calculateAll();
        return view;
    }

    private void initialise() {
        isCels = true;
        editFrom = view.findViewById(R.id.con_edit_1);
        editFrom.setText("0");
        editFrom.getBackground().setColorFilter(ContextCompat.getColor(view.getContext(), R.color.textColor), PorterDuff.Mode.SRC_ATOP);
        editTo = view.findViewById(R.id.con_edit_2);
        editTo.setVisibility(View.VISIBLE);
        editTo.setText("0");
        editTo.getBackground().setColorFilter(ContextCompat.getColor(view.getContext(), R.color.textColor), PorterDuff.Mode.SRC_ATOP);

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

        text1 = view.findViewById(R.id.text_temp_1);
        text1.setText(R.string.cel);
        text2 = view.findViewById(R.id.text_temp_2);
        text2.setText(R.string.far);

        arow = view.findViewById(R.id.arow);
        arow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isCels = !isCels;
                if(isCels){
                    text1.setText(R.string.cel);
                    text2.setText(R.string.far);
                } else {
                    text2.setText(R.string.cel);
                    text1.setText(R.string.far);
                }
                calculateAll();
            }
        });
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
                if (!editFrom.getText().toString().trim().matches("[0-9]\\.[0-9]{3}")) {
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

    private void calculateAll(){
        double valInGr =isCels?
                ((Double.parseDouble(editFrom.getText().toString()) * 9) / 5) + 32 :
                ((Double.parseDouble(editFrom.getText().toString()) - 32) * 5) / 9;

        NumberFormat formatter = new DecimalFormat("#.###");
        String temp = formatter.format(valInGr);
        editTo.setText(temp);
    }
}

package com.miki.powtorka.fragment;

import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.miki.powtorka.R;
import com.miki.powtorka.calculations.Calculations;


public abstract class BaseShapeFragment extends Fragment {


    private EditText[] editTexts;
    private String[] editTextsLabels;
    int imageRes;


    protected BaseShapeFragment(int fields, int imageRes) {
        editTexts = new EditText[fields];
        this.imageRes = imageRes;
    }

    protected BaseShapeFragment(int fields, int imageRes, String[] editTextsLabels) {
        this(fields, imageRes);
        this.editTextsLabels = editTextsLabels;
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.shape_calculation_fragment, container, false);
        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.linearLayout);


        ImageView imgView = new ImageView(rootView.getContext());
        Drawable drawable = getResources().getDrawable(imageRes);
        imgView.setImageDrawable(drawable);
        linearLayout.addView(imgView);

        final TextView resultField = new TextView(rootView.getContext());
        resultField.setTextSize(24);

        for (int i = 0; i < editTexts.length; i++) {
            editTexts[i] = new EditText(rootView.getContext());
            editTexts[i].setInputType(InputType.TYPE_CLASS_NUMBER);
            try {
                editTexts[i].setHint(editTextsLabels[i]);
            } catch (Exception e) {
                char c = (char) (i + 97);
                editTexts[i].setHint(String.valueOf(c));
            }
            linearLayout.addView(editTexts[i]);
        }


        Button buttonArea = new Button(rootView.getContext());
        buttonArea.setText(R.string.area);
        buttonArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Calculations calculation = new Calculations();
                    double result = getArea(calculation);
                    String resultString = String.valueOf(result);
                    resultField.setText(resultString);
                } catch (Exception e) {
                    Toast.makeText(inflater.getContext(), R.string.wrong_data, Toast.LENGTH_SHORT).show();
                }
            }
        });
        linearLayout.addView(buttonArea);

        Button buttonCircuit = new Button(rootView.getContext());
        buttonCircuit.setText(R.string.circuit);
        buttonCircuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Calculations calculation = new Calculations();
                    double result = getCircuit(calculation);
                    String resultString = String.valueOf(result);
                    resultField.setText(resultString);
                } catch (Exception e) {
                    Toast.makeText(inflater.getContext(), R.string.wrong_data, Toast.LENGTH_SHORT).show();
                }

            }

        });
        linearLayout.addView(buttonCircuit);

        linearLayout.addView(resultField);


        return rootView;

    }

    protected double valueOfField(int id) {
        return Double.valueOf(editTexts[id].getText().toString());
    }

    abstract double getCircuit(Calculations calculations);

    abstract double getArea(Calculations calculations);


}




















package com.miki.powtorka.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.miki.powtorka.R;
import com.miki.powtorka.calculations.Calculations;

/**
 * Created by Miki on 03.04.2017.
 */

public class FragmentRectangle extends Fragment{

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.rectangle_fragment, container, false);

        final Calculations calculations = new Calculations();


        final TextView resultDisplay = (TextView) rootView.findViewById(R.id.resultRectangle);
        final EditText sizeA = (EditText) rootView.findViewById(R.id.rectangleAArea);
        final EditText sizeB = (EditText) rootView.findViewById(R.id.rectangleBArea);

        Button buttonArea = (Button) rootView.findViewById(R.id.rectangleAreaButton);
        buttonArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Double a = Double.valueOf(sizeA.getText().toString());
                    Double b = Double.valueOf(sizeB.getText().toString());
                    Double A = calculations.rectangleArea(a,b);
                    resultDisplay.setText(Double.toString(A));
                } catch (Exception e) {
                    Toast.makeText(inflater.getContext(), R.string.wrong_data, Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button buttonCircuit = (Button) rootView.findViewById(R.id.rectangleCircuitButton);
        buttonCircuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Double a = Double.valueOf(sizeA.getText().toString());
                    Double b = Double.valueOf(sizeB.getText().toString());
                    Double O = calculations.rectangleCircuit(a,b);
                    resultDisplay.setText(Double.toString(O));
                } catch (Exception e) {
                    Toast.makeText(inflater.getContext(), R.string.wrong_data, Toast.LENGTH_SHORT).show();
                }
            }
        });


        return rootView;
    }




}

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

public class FragmentCircle extends Fragment {

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.circle_fragment, container, false);

        final Calculations calculations = new Calculations();


        final TextView resultDisplay = (TextView) rootView.findViewById(R.id.resultCircle);
        final EditText radiusArea = (EditText) rootView.findViewById(R.id.radiusArea);

        Button buttonArea = (Button) rootView.findViewById(R.id.circleAreaButton);
        buttonArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Double a = Double.valueOf(radiusArea.getText().toString());
                    Double b = calculations.circleArea(a);
                    resultDisplay.setText(Double.toString(b));
                } catch (Exception e) {
                    Toast.makeText(inflater.getContext(), R.string.wrong_data, Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button buttonCircuit = (Button) rootView.findViewById(R.id.circleCircuitButton);
        buttonCircuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Double a = Double.valueOf(radiusArea.getText().toString());
                    Double b = calculations.circleCircuit(a);
                    resultDisplay.setText(Double.toString(b));
                } catch (Exception e) {
                    Toast.makeText(inflater.getContext(), R.string.wrong_data, Toast.LENGTH_SHORT).show();
                }
            }
        });


        return rootView;
    }
}

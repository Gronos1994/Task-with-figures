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

public class FragmentTriangle extends Fragment {

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.triangle_fragment, container, false);

        final Calculations calculations = new Calculations();


        final TextView resultDisplay = (TextView) rootView.findViewById(R.id.resulttTiangle);
        final EditText sizeA = (EditText) rootView.findViewById(R.id.triangleAArea);
        final EditText sizeH = (EditText) rootView.findViewById(R.id.triangleHArea);

        Button buttonArea = (Button) rootView.findViewById(R.id.triangleAreaButton);
        buttonArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Double a = Double.valueOf(sizeA.getText().toString());
                    Double h = Double.valueOf(sizeH.getText().toString());
                    Double A = calculations.triangleArea(a,h);
                    resultDisplay.setText(Double.toString(A));
                } catch (Exception e) {
                    Toast.makeText(inflater.getContext(), R.string.wrong_data, Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button buttonCircuit = (Button) rootView.findViewById(R.id.triangleCircuitButton);
        buttonCircuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Double a = Double.valueOf(sizeA.getText().toString());
                    Double O = calculations.triangleCircuit(a);
                    resultDisplay.setText(Double.toString(O));
                } catch (Exception e) {
                    Toast.makeText(inflater.getContext(), R.string.wrong_data, Toast.LENGTH_SHORT).show();
                }
            }
        });


        return rootView;
    }

}

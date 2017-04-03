package com.miki.powtorka.fragment;

import com.miki.powtorka.R;
import com.miki.powtorka.calculations.Calculations;

/**
 * Created by Miki on 03.04.2017.
 */

public class FragmentTriangle extends BaseShapeFragment {

    public FragmentTriangle() {
        super(2, R.drawable.triangle_image);
    }

    @Override
    double getCircuit(Calculations calculations) {
        return 0;
    }

    @Override
    double getArea(Calculations calculations) {
        return 0;
    }
}

package com.estrada.practicastec;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class Problema6Fragment extends Fragment {


    @BindView(R.id.PA1)
    AutoCompleteTextView PA1;
    @BindView(R.id.PB1)
    AutoCompleteTextView PB1;
    @BindView(R.id.PA2)
    AutoCompleteTextView PA2;
    @BindView(R.id.PB2)
    AutoCompleteTextView PB2;
    @BindView(R.id.PA3)
    AutoCompleteTextView PA3;
    @BindView(R.id.PB3)
    AutoCompleteTextView PB3;
    @BindView(R.id.Conversion)
    AppCompatButton Conversion;
    @BindView(R.id.resultado5)
    AppCompatTextView resultado5;
    @BindView(R.id.PA4)
    AutoCompleteTextView PA4;
    @BindView(R.id.PB4)
    AutoCompleteTextView PB4;
    int pa1, pa2, pa3, pb1, pb2, pb3, pa4, pb4;

    public Problema6Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment          {}
        View view = inflater.inflate(R.layout.fragment_problema6, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.Conversion)
    public void onClick(View view) {
        Problemas prob = new Problemas();
        if (!PA1.getText().toString().isEmpty() && !PA2.getText().toString().isEmpty() && !PA3.getText().toString().isEmpty() && !PA4.getText().toString().isEmpty() && !PB1.getText().toString().isEmpty()
                && !PB2.getText().toString().isEmpty() && !PB4.getText().toString().isEmpty() && !PB3.getText().toString().isEmpty()) {
            pa1 = Integer.parseInt(PA1.getText().toString());
            pa2 = Integer.parseInt(PA2.getText().toString());
            pa3 = Integer.parseInt(PA3.getText().toString());
            pa4 = Integer.parseInt(PA4.getText().toString());
            pb1 = Integer.parseInt(PB1.getText().toString());
            pb2 = Integer.parseInt(PB2.getText().toString());
            pb3 = Integer.parseInt(PB3.getText().toString());
            pb4 = Integer.parseInt(PB4.getText().toString());
            Double PPA = 0.20 * pa1 + 0.20 * pa2 + 0.25 * pa3 + 0.35 * pa4;
            Double PPB = 0.20 * pb1 + 0.20 * pb2 + 0.25 * pb3 + 0.35 * pb4;
            Double PY = (PPA + PPB) / 2;
            Double PF = 0.30 * PPA + 0.35 * PPB + 0.35 * PY;
            if(PF >= 10.5){
                resultado5.setText("El promedio final es: "+PF+"\nAprobo");
            }   else {
                    resultado5.setText("El promedio final es: "+PF+"\nReprobo");
            }

        } else {
             prob.Snack(view);
        }
    }
}

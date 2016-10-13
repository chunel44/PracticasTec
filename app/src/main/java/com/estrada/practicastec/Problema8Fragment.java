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


public class Problema8Fragment extends Fragment {


    @BindView(R.id.Pies)
    AutoCompleteTextView Pies;
    @BindView(R.id.Metro)
    AutoCompleteTextView Metro;
    @BindView(R.id.calcular)
    AppCompatButton calcular;
    @BindView(R.id.resultado)
    AppCompatTextView resultado;

    public Problema8Fragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_problema8, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.calcular)
    public void onClick(View view) {
        Problemas prob = new Problemas();
        if(!Pies.getText().toString().isEmpty()&&!!Metro.getText().toString().isEmpty()) {
            Double pies = Double.parseDouble(Pies.getText().toString());
            Double metro = Double.parseDouble(Metro.getText().toString());
            Double pul, yar, met, mil;
            pul = (pies * 12) + (metro / 0.0254);
            yar = (pies / 3) + (metro * 1.09361);
            met = (pies * 0.3045) + metro;
            mil = (pies * 0.00019) + (metro * 0.00062);

            resultado.setText("La suma en pulgadas es: " + pul + "\nLa suma en yardas es: " + yar + "\nLa suma en metros es: " + met + "\nLa suma en millas es: " + mil);
        }else{
            prob.Snack(view);
        }
    }
}

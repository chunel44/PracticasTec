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

public class Problema7Fragment extends Fragment {


    @BindView(R.id.CatetoOp)
    AutoCompleteTextView CatetoOp;
    @BindView(R.id.calcular)
    AppCompatButton calcular;
    @BindView(R.id.resultado)
    AppCompatTextView resultado;
    @BindView(R.id.CatetoA)
    AutoCompleteTextView CatetoA;

    public Problema7Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_problema7, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.calcular)
    public void onClick() {
        Double CatetoO = Double.parseDouble(CatetoOp.getText().toString());
        Double CatetoAd = Double.parseDouble(CatetoA.getText().toString());

        Double Hipotenusa = Math.sqrt(Math.pow(CatetoAd,2)+Math.pow(CatetoO,2));

        Double Parametro = CatetoAd + CatetoO + Hipotenusa;

        resultado.setText("Cateto Opuesto: "+CatetoO.toString().replace(".0","")+"\nCateto Adyacente: "+CatetoAd.toString().replace(".0","")+"\nHipotenusa: "+Hipotenusa.toString().replace(".0","")+"\nParametro: "+Parametro.toString().replace(".0",""));
    }
}

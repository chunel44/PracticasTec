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


/**
 * A simple {@link Fragment} subclass.
 */
public class Problema4Fragment extends Fragment {


    @BindView(R.id.Dinero)
    AutoCompleteTextView Dinero;
    @BindView(R.id.calcular4)
    AppCompatButton calcular4;
    @BindView(R.id.resultado4)
    AppCompatTextView resultado4;

    public Problema4Fragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_problema4, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.calcular4)
    public void onClick() {
        double monto = Double.parseDouble(Dinero.getText().toString());
        int billete100, billete200, billete50, billete20, billete10;
        int moneda5, moneda1, moneda50c, moneda10c, monedaCentavo;
        int resto;

        monto = monto * 100;
        billete200 = (int)monto / (200 * 100);
        resto = (int)monto % (200 * 100);
        billete100 = resto / (100 * 100);
        resto = resto % (100 * 100);
        billete50 = resto / (50 * 100);
        resto = resto % (50 * 100);
        billete20 = resto / (20 * 100);
        resto = resto % (20 * 100);
        billete10 = resto / (10 * 100);
        resto = resto % (10 * 100);
        moneda5 = resto / (5 * 100);
        resto = resto % (5 * 100);
        moneda1 = resto / (1 * 100);
        resto = resto % (1 * 100);
        moneda50c = resto / 50;
        resto = resto % 50;
        moneda10c = resto / 10;
        resto = resto % 10;
        monedaCentavo = resto / 1;

        resultado4.setText(" Billetes de 200: " + billete200+"\n Billetes de 100: " + billete100+"\n Billetes de 50: " + billete50+"\n Billetes de 20: " + billete20+"\n Billetes de 10: " + billete10
                +"\n Monedas de 5: " + moneda5+"\n Monedas de 1: " + moneda1+"\n Monedas de 50c: " + moneda50c+"\n Monedas de 10c: " + moneda10c+"\n Monedas de 1c: " + monedaCentavo);
    }
}

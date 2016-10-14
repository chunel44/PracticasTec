package com.estrada.practicastec;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class Problema5Fragment extends Fragment {

    @BindView(R.id.Grados)
    AutoCompleteTextView Grados;
    @BindView(R.id.Conversion)
    AppCompatButton Conversion;
    @BindView(R.id.resultado5)
    AppCompatTextView resultado5;

    public Problema5Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_problema5, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.Conversion)
    public void onClick(View view) {
        Problemas prob = new Problemas();
        if(!Grados.getText().toString().isEmpty()) {
            Double c = Double.parseDouble(Grados.getText().toString());
            Double f = (c * 9 / 5) + (32);
            Double k = c + 273.15;
            Double r = f + 459.7;
            resultado5.setText("Grados Celsius: " + c.toString().replace(".0", "") + "                    Grados Fahrenheit: " + f + "\nGrados Kelvin: " + k + "                 Grados Rankine: " + r);

        }else{
            prob.Snack(view);
        }
    }

}

package com.estrada.practicastec;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class Fragmentproblema2 extends Fragment {
    @BindView(R.id.capital)
    AutoCompleteTextView capital;
    @BindView(R.id.tasa)
    AutoCompleteTextView tasa;
    @BindView(R.id.periodo)
    AutoCompleteTextView periodo;
    @BindView(R.id.boton2)
    AppCompatButton boton2;
    @BindView(R.id.resultado)
    AppCompatTextView resultado;

    Problemas prob;

    public Fragmentproblema2() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragmentproblema2, container, false);
        ButterKnife.bind(this, view);
        prob = new Problemas();
        return view;
    }


    @OnClick(R.id.boton2)
    public void onClick(View view) {
        hideKeyboard();
        //Double Capital, tasa, periodo;
        //String t = capital.getText().toString();
        //Capital = Double.parseDouble(capital.getText().toString());
        if(!capital.getText().toString().isEmpty() && !tasa.getText().toString().isEmpty() && !periodo.getText().toString().isEmpty()) {
            String total = prob.Problema2(Double.parseDouble(capital.getText().toString()), Double.parseDouble(tasa.getText().toString()), Double.parseDouble(periodo.getText().toString()));
            resultado.setText(total);
        }else {
            Snackbar.make(view,"Agregue información",Snackbar.LENGTH_LONG).show();
        }
    }

    private void hideKeyboard() {
        InputMethodManager inputManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);

        try {
            inputManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        } catch (NullPointerException npe) {
            Log.e(getActivity().getLocalClassName(), Log.getStackTraceString(npe));
        }
    }
}

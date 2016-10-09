package com.estrada.practicastec;

import android.content.Context;
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


public class Fragmentproblema1 extends Fragment {
    Problemas prob;

    @BindView(R.id.numero)
    AutoCompleteTextView numero;
    @BindView(R.id.calcular1)
    AppCompatButton calcular1;
    @BindView(R.id.resultado1)
    AppCompatTextView resultado1;

    public Fragmentproblema1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragmentproblema1, container, false);
        ButterKnife.bind(this, view);
        prob = new Problemas();
        return view;
    }


    @OnClick(R.id.calcular1)
    public void onClick(View view) {
        if(!numero.getText().toString().isEmpty()){
            resultado1.setText(prob.Problema1(Integer.parseInt(numero.getText().toString())));

        }else{
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

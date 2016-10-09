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

/**
 * A simple {@link Fragment} subclass.
 */
public class Problema3Fragment extends Fragment {

    Problemas prob;
    @BindView(R.id.numeroD)
    AutoCompleteTextView numeroD;
    @BindView(R.id.calcular3)
    AppCompatButton calcular3;
    @BindView(R.id.resultado3)
    AppCompatTextView resultado3;

    public Problema3Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_problema3, container, false);
        ButterKnife.bind(this, view);
        prob = new Problemas();
        return view;
    }

    @OnClick(R.id.calcular3)
    public void onClick(View view) {
        hideKeyboard();

        if(!numeroD.getText().toString().isEmpty()){
            resultado3.setText(prob.Problema3(Double.parseDouble(numeroD.getText().toString())));
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

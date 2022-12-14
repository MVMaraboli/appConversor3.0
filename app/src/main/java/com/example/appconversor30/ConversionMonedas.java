package com.example.appconversor30;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appconversor30.databinding.FragmentConversionMonedasBinding;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class ConversionMonedas extends Fragment {
    private FragmentConversionMonedasBinding mBinding;
    Spinner spinner;
    EditText txtCantidad;
    TextView resultado;
    TextView valueMoney;

    public ConversionMonedas() {

    }


    public static ConversionMonedas newInstance(String param1, String param2) {
        ConversionMonedas fragment = new ConversionMonedas();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentConversionMonedasBinding.inflate(inflater, container, false);
        View view = mBinding.getRoot();
        makeData();
        mBinding.btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                getActivity().finish();
                System.exit(0);
                startActivity(intent);

            }
        });
        return view;
    }

    private void makeData() {

        String[] items = new String[]{"Seleccione una conversión", "US Dólar a Peso Chileno", "Peso Chileno a US Dólar", "Euro a Peso Chileno", "Peso Chileno a Euro", "Libra Esterlina a Peso Chileno", "Peso Chileno a Libra Esterlina"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, items);

        mBinding.spinner.setAdapter(adapter);
        mBinding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Locale kbSp = new Locale("en","GB");
                int c = mBinding.spinner.getSelectedItemPosition();
                Double nDolarValue = 687.250;
                Double nEuroValue = 913.960;
                Double nLibraValue = 1064.910;
                DecimalFormat formatSp = new DecimalFormat("###,###,###,###.####");
                switch (c) {
                    case 1:
                        try {
                            String strValue = mBinding.txtCantidad.getText().toString();
                            mBinding.valueMoney.setText(Double.toString(nDolarValue) + " Peso por cada US Dólar.");
                            Double tmpValor = Double.parseDouble(strValue);
                            Double tmpConversion = (tmpValor * nDolarValue);
                            mBinding.resultado.setText(Double.toString(tmpConversion) + " Pesos.");
                            String tmpResultado1 = formatSp.format(tmpConversion);
                            mBinding.resultado.setText(tmpResultado1 + " Pesos.");
                            mBinding.spinner.setAdapter(adapter);
                        } catch (Exception e) {
                            Toast.makeText(getActivity(), "Debes ingresar la cantidad para convertir", Toast.LENGTH_LONG).show();
                        }
                        mBinding.spinner.setAdapter(adapter);
                        break;
                    case 2:
                        try {
                            String strValue = mBinding.txtCantidad.getText().toString();
                            mBinding.valueMoney.setText(Double.toString(nDolarValue) + " Pesos por cada Euro.");
                            Double tmpValor = Double.parseDouble(strValue);
                            Double tmpConversion = tmpValor / nDolarValue;
                            String tmpResultado = Double.toString(tmpConversion);
                            String tmpResultado1 = formatSp.format(tmpConversion);
                            mBinding.resultado.setText(tmpResultado1 + " Dólares.");
                            mBinding.spinner.setAdapter(adapter);
                        } catch (Exception e) {
                            Toast.makeText(getActivity(), "Debes ingresar la cantidad para convertir", Toast.LENGTH_LONG).show();
                        }
                        mBinding.spinner.setAdapter(adapter);
                        break;
                    case 3:
                        try {
                            String strValue = mBinding.txtCantidad.getText().toString();
                            Double tmpValor = Double.parseDouble(strValue);
                            Double tmpConversion = tmpValor * nEuroValue;

                            String tmpResultado1 = formatSp.format(tmpConversion);
                            mBinding.resultado.setText(tmpResultado1 + " Pesos.");
                            mBinding.spinner.setAdapter(adapter);
                        } catch (Exception e) {
                            Toast.makeText(getActivity(), "Debes ingresar la cantidad para convertir", Toast.LENGTH_LONG).show();
                        }
                        mBinding.spinner.setAdapter(adapter);
                        break;
                    case 4:
                        try {
                            String strValue = mBinding.txtCantidad.getText().toString();
                            mBinding.valueMoney.setText(Double.toString(nEuroValue) + " Pesos por cada Euro.");
                            Double tmpValor = Double.parseDouble(strValue);
                            Double tmpConversion = tmpValor / nEuroValue;
                            String tmpResultado1 = formatSp.format(tmpConversion);
                            mBinding.resultado.setText(tmpResultado1 + " Euros.");
                            mBinding.spinner.setAdapter(adapter);
                        } catch (Exception e) {
                            Toast.makeText(getActivity(), "Debes ingresar la cantidad para convertir", Toast.LENGTH_LONG).show();
                        }
                        mBinding.spinner.setAdapter(adapter);
                        break;
                    case 5:
                        try {
                            String strValue = mBinding.txtCantidad.getText().toString();
                            mBinding.valueMoney.setText(Double.toString(nLibraValue) + " Pesos por cada Libra Esterlina.");
                            Double tmpValor = Double.parseDouble(strValue);
                            Double tmpConversion = tmpValor * nLibraValue;
                            String tmpResultado1 = formatSp.format(tmpConversion);
                            mBinding.resultado.setText(tmpResultado1 + " Pesos.");
                            mBinding.spinner.setAdapter(adapter);
                        } catch (Exception e) {
                            Toast.makeText(getActivity(), "Debes ingresar la cantidad para convertir", Toast.LENGTH_LONG).show();
                        }
                        mBinding.spinner.setAdapter(adapter);
                        break;
                    case 6:
                        try {
                            String strValue = mBinding.txtCantidad.getText().toString();

                            Double tmpValor = Double.parseDouble(strValue);
                            Double tmpConversion = tmpValor / nLibraValue;
                            String tmpResultado1 = formatSp.format(tmpConversion);
                            mBinding.resultado.setText(tmpResultado1 + " Libras Esterlinas.");
                            mBinding.spinner.setAdapter(adapter);
                        } catch (Exception e) {
                            Toast.makeText(getActivity(), "Debes ingresar la cantidad para convertir", Toast.LENGTH_LONG).show();
                        }
                        mBinding.spinner.setAdapter(adapter);
                        break;
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }



}
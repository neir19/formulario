package com.example.nei.formulario;

import android.app.DatePickerDialog;
import android.app.Dialog;

import java.lang.reflect.Array;
import  java.util.Calendar;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private EditText enombre, ecorreo,epass,erepass;
    private static EditText efecha;
    private TextView tnombre,tcorreo,tpass,tfecha,tciudad,tsexo,tdormir,tleer,tinternet,tdeporte;
    private Button bguardar;
    private RadioButton rmasculino, rfemenino;
    private CheckBox cdormir, cleer,cdeporte,cinternet;
    private Spinner sciudad;

//
//    String[] ciudades= {"ciudad de nacimiento", "medellin", "bogota","manizales","cali"};
    String ciudad;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enombre=findViewById(R.id.enombre);
        ecorreo=findViewById(R.id.ecorreo);
        epass=findViewById(R.id.epass);
        erepass=findViewById(R.id.erepass);
        bguardar=findViewById(R.id.bguardar);
        rmasculino=findViewById(R.id.rmasculino);
        rfemenino=findViewById(R.id.rfemenino);
        cdormir=findViewById(R.id.cdormir);
        cdeporte=findViewById(R.id.cdeporte);
        cleer=findViewById(R.id.cleer);
        cinternet=findViewById(R.id.cinternet);
        sciudad=findViewById(R.id.sciudad);
        efecha=findViewById(R.id.efecha);
        tnombre=findViewById(R.id.tnombre);
        tcorreo=findViewById(R.id.tcorreo);
        tpass=findViewById(R.id.tpass);
        tfecha=findViewById(R.id.tfecha);
        tciudad=findViewById(R.id.tciudad);
        tsexo=findViewById(R.id.tsexo);
        tdormir=findViewById(R.id.tdormir);
        tleer=findViewById(R.id.tleer);
        tdeporte= findViewById(R.id.tdeporte);
        tinternet=findViewById(R.id.tinternet);

        final ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.ciudad, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sciudad.setAdapter(adapter);

        sciudad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            ciudad= adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }



    public void showDatePickerDialog(View view) {


            DialogFragment newFragment = new    DatePickerFragment();
            newFragment.show(getSupportFragmentManager(), "datePickers");
    }
    public void mostrar(View view) {
        if (enombre.getText().toString().trim().equalsIgnoreCase("")) {
            Toast.makeText(getApplicationContext(), "ingrese nombre", Toast.LENGTH_SHORT).show();


        } else if (epass.getText().toString().trim().equalsIgnoreCase("") && erepass.getText().toString().trim().equalsIgnoreCase("")) {

            Toast.makeText(getApplicationContext(), "ingrese contraseña", Toast.LENGTH_SHORT).show();

        } else if (efecha.getText().toString().trim().equalsIgnoreCase("")) {
            Toast.makeText(getApplicationContext(), "ingrese fecha", Toast.LENGTH_SHORT).show();


        }else
            if(ciudad.equals("ciudad de nacimiento")){
                Toast.makeText(getApplicationContext(), "ciudad de nacimiento", Toast.LENGTH_SHORT).show();


        }else{
            if(epass.getText().toString().equals(erepass.getText().toString())){
                tnombre.setText(enombre.getText().toString());
                tcorreo.setText(ecorreo.getText().toString());
                tpass.setText(epass.getText().toString());
                tfecha.setText(efecha.getText().toString());
                tciudad.setText(ciudad);

                if(rfemenino.isChecked()){
                    tsexo.setText(rfemenino.getText());
                }else{
                    tsexo.setText(rmasculino.getText());
                }
                if (cdormir.isChecked()){
                    tdormir.setText(cdormir.getText());
                }else{
                    tdormir.setText("");
                }
                if (cleer.isChecked()){
                    tleer.setText(cleer.getText());
                }else{
                    tleer.setText("");
                }
                if (cdeporte.isChecked()){
                    tdeporte.setText(cdeporte.getText());
                }else{
                    tdeporte.setText("");
                }
                if (cinternet.isChecked()){
                    tinternet.setText(cinternet.getText());
                }else{
                    tinternet.setText("");
                }

            }else{
                Toast.makeText(getApplicationContext(), "contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                epass.setText("");
                erepass.setText("");

            }

        }

    }


    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();

            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }


        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
            efecha.setText( day+  "-"+ (month+1)+ "- "+ year);
        }

    }




}

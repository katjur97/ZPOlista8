package com.android.kasienka.lista8zadanie1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    String choiceGender = null;
    String choiceMethod = null;

    TextView resultText;

    String genders[]={"kobieta","mężczyzna"};
    String methods[]={"wzór Benedicta-Harrisa","wzór Mifflina"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner genderSpinner;
        Spinner choiceSpinner;
        ArrayAdapter adapter;

        genderSpinner = (Spinner) findViewById(R.id.genderSpinner);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,genders);
        genderSpinner.setAdapter(adapter);

        genderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0:
                        choiceMethod="wzór Benedicta-Harrisa";
                        break;
                    case 1:
                        choiceMethod="wzór Mifflina";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                resultText = (TextView) findViewById(R.id.resultCalculatedText);
                resultText.setText("Wybierz dane z listy");
            }
        });

        choiceSpinner = (Spinner) findViewById(R.id.choiceSpinner);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,methods);
        choiceSpinner.setAdapter(adapter);

        choiceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0:
                        choiceGender="kobieta";
                        break;
                    case 1:
                        choiceGender="mężczyzna";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                resultText = (TextView) findViewById(R.id.resultCalculatedText);
                resultText.setText("Wybierz dane z listy");
            }
        });

    }

    public void startBtnClicked(View view) {

        try {
        EditText heightEditText = (EditText) findViewById(R.id.heightEditText);
        EditText massEditText = (EditText) findViewById(R.id.massEditText);
        EditText ageEditText = (EditText) findViewById(R.id.ageEditText);
        resultText = (TextView) findViewById(R.id.resultCalculatedText);

        double height=Double.parseDouble(heightEditText.getText().toString());
        double mass=Double.parseDouble(massEditText.getText().toString());
        double age=Double.parseDouble(ageEditText.getText().toString());

        double result;


            if (height < 10) {
                height = height * 100;
            }

            if (choiceMethod.equals("wzór Benedicta-Harrisa")) {
                PPM ppm = new PPM();
                result = ppm.BHmethod(mass, height, age, choiceGender);
            } else {
                PPM ppm = new PPM();
                result = ppm.Mmethod(mass, height, age, choiceGender);
            }

            DecimalFormat dF = new DecimalFormat("#.##");
            resultText.setText(String.valueOf(dF.format(result)));

        } catch (NumberFormatException e){
            resultText.setText("Podaj odpowiednie parametry");
        }
    }

}



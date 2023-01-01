package com.example.thereceipt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txttitle, txtmessage;
    RadioGroup radiogroup;
    Resources resources;
    RadioButton radioVeg, radioNonVeg;
    Button btntotal,btnreset;
    CheckBox checkbox1,checkbox2,checkbox3;
    LinearLayout chkboxcontainer;
    String[] optionsVeg, optionsNonveg;
    int[] priceVeg, priceNonVeg;
    int total=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        getDetailResources();
        initListeners();
    }
    public void initViews() {
        txttitle = findViewById(R.id.title);
        radiogroup = findViewById(R.id.radioGroup);
        radioVeg = findViewById(R.id.radioVeg);
        radioNonVeg = findViewById(R.id.radioNonVeg);
        txtmessage = findViewById(R.id.txtmessage);
        btntotal=findViewById(R.id.btntotal);
        btnreset=findViewById(R.id.btnreset);
        checkbox1=findViewById(R.id.chk1);
        checkbox2=findViewById(R.id.chk2);
        checkbox3=findViewById(R.id.chk3);
        chkboxcontainer =findViewById(R.id.chkboxcontainer);
    }
    public void getDetailResources() {
        resources = getResources();
        optionsVeg = resources.getStringArray(R.array.vegoptions);
        priceVeg = resources.getIntArray(R.array.priceveg);
        priceNonVeg = resources.getIntArray(R.array.pricenonveg);
        optionsNonveg = resources.getStringArray(R.array.nonvegoptions);

    }
    public void initListeners() {
        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                i = radioGroup.getCheckedRadioButtonId();
                int j = 0;
                switch (i) {
                    case R.id.radioVeg:
                        checkbox1.setChecked(false);
                        checkbox2.setChecked(false);
                        checkbox3.setChecked(false);
                        txtmessage.setVisibility(View.VISIBLE);
                        chkboxcontainer.setVisibility(View.VISIBLE);

                        checkbox1.setText(optionsVeg[j] + " Rs." + priceVeg[j]);
                        checkbox2.setText(optionsVeg[j + 1] + " Rs." + priceVeg[j + 1]);
                        checkbox3.setText(optionsVeg[j + 2] + " Rs." + priceVeg[j + 2]);
                        break;
                    case R.id.radioNonVeg:
                        checkbox1.setChecked(false);
                        checkbox2.setChecked(false);
                        checkbox3.setChecked(false);

                        txtmessage.setVisibility(View.VISIBLE);
                        chkboxcontainer.setVisibility(View.VISIBLE);
                        checkbox1.setText(optionsNonveg[j] + " Rs." + priceNonVeg[j]);
                        checkbox2.setText(optionsNonveg[j + 1] + " Rs." + priceNonVeg[j + 1]);
                        checkbox3.setText(optionsNonveg[j + 2] + " Rs." + priceNonVeg[j + 2]);
                        break;
                }

            }
        });

        btntotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeToast();
            }
        });
        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                total=0;
                checkbox1.setChecked(false);
                checkbox2.setChecked(false);
                checkbox3.setChecked(false);
                radioNonVeg.setChecked(false);
                radioVeg.setChecked(false);
            }
        });
    }

    public void onCheckboxClicked(View view)
    {
        boolean checked = ((CheckBox) view).isChecked();

        switch(view.getId()) {
            case R.id.chk1:

                if (checked)
                {

                   String str=checkbox1.getText().toString();
                   String a[]= str.split("Rs.");
                   int x= Integer.parseInt(a[1]);
                   total=total+x;

                }

                break;
            case R.id.chk2:
                if (checked)
                {
                    String str=checkbox2.getText().toString();
                    String a[]= str.split("Rs.");
                     int x= Integer.parseInt(a[1]);
                    total=total+x;

                }
                break;
            case R.id.chk3:
                if(checked)
                {
                    String str=checkbox3.getText().toString();
                    String a[]= str.split("Rs.");
                    int x= Integer.parseInt(a[1]);

                    total=total+x;

                }
                break;
        }

    }
    public void makeToast()
    {
        Toast.makeText(this,"Bill is Rs."+total,Toast.LENGTH_LONG).show();
    }

}



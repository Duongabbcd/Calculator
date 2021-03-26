package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Spinner sp;
    private Button btn ;
    private EditText edt1 ,edt2 ;
    private TextView tv ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                try{
                    double a = Double.parseDouble(edt1.getText().toString());
                    double b = Double.parseDouble(edt2.getText().toString());
                    String op = sp.getSelectedItem().toString();
                    String str = Calculate(a,b,op);
                    tv.setText(str);
                }catch (NumberFormatException e){
                    System.out.println(e);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    double a = Double.parseDouble(edt1.getText().toString());
                    double b = Double.parseDouble(edt2.getText().toString());
                    String str ="Result : " +(a+b);
                    tv.setText(str);
                }catch (NumberFormatException e){
                    System.out.println(e);
                }
            }
        });
    }

    private String Calculate(double a,double b ,String op){
        String result = " ";
        switch(op) {
            case "+":
                result = "Sum : " + (a + b);
                break;
            case "-":
                result = "Substract : " + (a - b);
                break;
            case "*":
                result = "Multiple : " + (a * b);
                break;
            case "/":
                if (b == 0) {
                    result = "Error ! ";
                } else {
                    result = "Divide :  " + (a / b);
                }
                break;
        }
        return result ;
    }

    private void init(){
        sp =findViewById(R.id.sp);
        btn=findViewById(R.id.bt);
        edt1=findViewById(R.id.n1);
        edt2=findViewById(R.id.n2);
        tv=findViewById(R.id.result);

        String[] str ={"+","-","*","/"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.myspinner,str);
        adapter.setDropDownViewResource(R.layout.myspinner);
        sp.setAdapter(adapter);

    }

}



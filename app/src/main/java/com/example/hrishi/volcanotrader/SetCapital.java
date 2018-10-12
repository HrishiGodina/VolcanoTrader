package com.example.hrishi.volcanotrader;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class SetCapital extends AppCompatActivity {

    EditText Capital;
    String capital;
    String from;
    Button Enter;
    DataBaseHelper dh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);

        getSupportActionBar().hide();
        setContentView(R.layout.activity_set_capital);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int) (width * (0.9)), (int) (height * (0.3)));

        WindowManager.LayoutParams lp = this.getWindow().getAttributes();
        lp.dimAmount = 0.7f;
        this.getWindow().setAttributes(lp);
        this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        Capital = findViewById(R.id.ed_capital);
        Enter = findViewById(R.id.enter_capital);
        from = getIntent().getExtras().getString("from");

        dh = new DataBaseHelper(getApplicationContext());

    }

    public void Enter(View view) {

        capital = Capital.getText().toString();
        if (capital.equals("")){
            Toast.makeText(getApplicationContext(), "Please enter a valid number", Toast.LENGTH_LONG).show();
        }

        else {

            if (from.equals("1")){
                HashMap hm = dh.getAllData1();
                if (hm == null){
                    dh.insertdata1(capital, "0", "0", "0", "0", "0", "0");
                }

                else {
                    if (hm.get("price1").toString().contains("buy")){
                        String price1 = hm.get("price1").toString().replace(" (buy)", "");
                        Float price = Float.parseFloat(price1);
                        Float Quantity = Float.parseFloat(capital) / price;
                        Float stoploss = price - (price/ 100);
                        Float target1 = price * 101/ 100;
                        Float target2 = price * 102/ 100;
                        Float target3 = price * 103/ 100;

                        dh.updateData1(capital, hm.get("price1").toString(), Float.toString(Quantity), Float.toString(stoploss), Float.toString(target1), Float.toString(target2), Float.toString(target3));
                    }

                    if (hm.get("price1").toString().contains("sell")){
                        String price1 = hm.get("price1").toString().replace(" (sell)", "");
                        Float price = Float.parseFloat(price1);
                        Float Quantity = Float.parseFloat(capital) / price;
                        Float stoploss = price + (price/ 100);
                        Float target1 = price * 99/ 100;
                        Float target2 = price * 98/ 100;
                        Float target3 = price * 97/ 100;

                        dh.updateData1(capital, hm.get("price1").toString(), Float.toString(Quantity), Float.toString(stoploss), Float.toString(target1), Float.toString(target2), Float.toString(target3));
                    }
                }
            }

            if (from.equals("2")){
                HashMap hm = dh.getAllData2();
                if (hm == null){
                    dh.insertdata2(capital, "0", "0", "0", "0", "0", "0");
                }

                else {
                    if (hm.get("price2").toString().contains("buy")){
                        String price2 = hm.get("price2").toString().replace(" (buy)", "");
                        Float price = Float.parseFloat(price2);
                        Float Quantity = (float) ((Float.parseFloat(capital) * 3.5) / price);
                        Float stoploss = price - 14;
                        Float target1 = price + 14;
                        Float target2 = price + 28;
                        Float target3 = price +45;

                        dh.updateData2(capital, hm.get("price2").toString(), Float.toString(Quantity), Float.toString(stoploss), Float.toString(target1), Float.toString(target2), Float.toString(target3));
                    }

                    if (hm.get("price2").toString().contains("sell")){
                        String price2 = hm.get("price2").toString().replace(" (sell)", "");
                        Float price = Float.parseFloat(price2);
                        Float Quantity = (float) ((Float.parseFloat(capital) * 3.5) / price);
                        Float stoploss = price + 14;
                        Float target1 = price - 14;
                        Float target2 = price - 28;
                        Float target3 = price - 45;

                        dh.updateData2(capital, hm.get("price2").toString(), Float.toString(Quantity), Float.toString(stoploss), Float.toString(target1), Float.toString(target2), Float.toString(target3));
                    }
                }
            }

            if (from.equals("3")){
                HashMap hm = dh.getAllData3();
                if (hm == null){
                    dh.insertdata3(capital, "0", "0", "0", "0", "0", "0");
                }

                else {
                    if (hm.get("price3").toString().contains("buy")){
                        String price3 = hm.get("price3").toString().replace(" (buy)", "");
                        Float price = Float.parseFloat(price3);
                        Float Quantity = Float.parseFloat(capital) / price / 2;
                        Float stoploss = price - 12;
                        Float target1 = price + 20;
                        Float target2 = price + 35;
                        Float target3 = price + 60;

                        dh.updateData3(capital, hm.get("price3").toString(), Float.toString(Quantity), Float.toString(stoploss), Float.toString(target1), Float.toString(target2), Float.toString(target3));
                    }

                    if (hm.get("price3").toString().contains("sell")){
                        String price3 = hm.get("price3").toString().replace(" (sell)", "");
                        Float price = Float.parseFloat(price3);
                        Float Quantity = Float.parseFloat(capital) / price / 2;
                        Float stoploss = price + 12;
                        Float target1 = price - 20;
                        Float target2 = price -35;
                        Float target3 = price -60;

                        dh.updateData3(capital, hm.get("price3").toString(), Float.toString(Quantity), Float.toString(stoploss), Float.toString(target1), Float.toString(target2), Float.toString(target3));
                    }
                }
            }

            if (from.equals("4")){
                HashMap hm = dh.getAllData4();
                if (hm == null){
                    dh.insertdata4(capital, "0", "0", "0", "0", "0", "0");
                }

                else {
                    if (hm.get("price4").toString().contains("buy")){
                        String price4 = hm.get("price4").toString().replace(" (buy)", "");
                        Float price = Float.parseFloat(price4);
                        Float Quantity = (int) Float.parseFloat(capital) / price / 3;
                        Float stoploss = price - 40;
                        Float target1 = price +70;
                        Float target2 = price + 150;
                        Float target3 = price + 200;

                        dh.updateData4(capital, hm.get("price4").toString(), Float.toString(Quantity), Float.toString(stoploss), Float.toString(target1), Float.toString(target2), Float.toString(target3));
                    }

                    if (hm.get("price4").toString().contains("sell")){
                        String price4 = hm.get("price4").toString().replace(" (sell)", "");
                        Float price = Float.parseFloat(price4);
                        Float Quantity = (int) Float.parseFloat(capital) / price / 3;
                        Float stoploss = price + 40;
                        Float target1 = price - 70;
                        Float target2 = price - 150;
                        Float target3 = price - 200;

                        dh.updateData4(capital, hm.get("price4").toString(), Float.toString(Quantity), Float.toString(stoploss), Float.toString(target1), Float.toString(target2), Float.toString(target3));
                    }
                }
            }

            Intent I = new Intent(getApplicationContext(), MainActivity.class);
            I.putExtra("from", from);
            startActivity(I);
        }
    }
}

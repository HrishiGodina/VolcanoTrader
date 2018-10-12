package com.example.hrishi.volcanotrader;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class SetPrice extends AppCompatActivity {

    String from, buy;
    float price, capital;
    EditText StocksPrice;
    DataBaseHelper dh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_price);
        StocksPrice = findViewById(R.id.ed_stocks_price);
        from = getIntent().getExtras().getString("from");
        buy = getIntent().getExtras().getString("buy");
        dh = new DataBaseHelper(getApplicationContext());

    }

    public void calulations(String from, String buy, float price){

        String price_str;

        if (from.equals("1")) {

            HashMap hm = dh.getAllData1();
            if (hm == null) {
                Toast.makeText(getApplicationContext(), "Please enter Capital for Stocks", Toast.LENGTH_LONG).show();
                Intent I = new Intent(getApplicationContext(), SetCapital.class);
                I.putExtra("from", "1");
                startActivity(I);
                finish();
            }

            else {

                float Quantity, stoploss, target1, target2, target3;

                if (buy.equals("1")) {
                    capital = Float.valueOf(hm.get("capital1").toString());
                    Quantity = capital / price;
                    stoploss = price - (price/ 100);
                    target1 = price * 101/ 100;
                    target2 = price * 102/ 100;
                    target3 = price * 103/ 100;

                    price_str = Float.toString(price) + " (buy)";
                }

                else {
                    capital = Float.valueOf(hm.get("capital1").toString());
                    Quantity = capital / price;
                    stoploss = price + (price/ 100);
                    target1 = price * 99/ 100;
                    target2 = price * 98/ 100;
                    target3 = price * 97/ 100;

                    price_str = Float.toString(price) + " (sell)";
                }

                dh.updateData1(Float.toString(capital), price_str, Float.toString(Quantity), Float.toString(stoploss), Float.toString(target1), Float.toString(target2), Float.toString(target3));

            }
        }

        else if (from.equals("2")){

            HashMap hm = dh.getAllData2();
            if (hm == null) {
                Toast.makeText(getApplicationContext(), "Please enter Capital for Crude Oil", Toast.LENGTH_LONG).show();
                Intent I = new Intent(getApplicationContext(), SetCapital.class);
                I.putExtra("from", "2");
                startActivity(I);
                finish();
            }

            else {

                float Quantity, stoploss, target1, target2, target3;

                if (buy.equals("1")) {
                    capital = Float.valueOf(hm.get("capital2").toString());
                    Quantity = (float) (capital*3.5/price);
                    stoploss = price - 14;
                    target1 = price + 14;
                    target2 = price + 28;
                    target3 = price +45;

                    price_str = Float.toString(price) + " (buy)";
                }

                else {
                    capital = Float.valueOf(hm.get("capital2").toString());
                    Quantity = (float) (capital*3.5/price);
                    stoploss = price + 14;
                    target1 = price - 14;
                    target2 = price - 28;
                    target3 = price - 45;

                    price_str = Float.toString(price) + " (sell)";
                }

                dh.updateData2(Float.toString(capital), price_str, Float.toString(Quantity), Float.toString(stoploss), Float.toString(target1), Float.toString(target2), Float.toString(target3));

            }

        }

        else if (from.equals("3")){

            HashMap hm = dh.getAllData3();
            if (hm == null) {
                Toast.makeText(getApplicationContext(), "Please enter Capital for Nifty", Toast.LENGTH_LONG).show();
                Intent I = new Intent(getApplicationContext(), SetCapital.class);
                I.putExtra("from", "3");
                startActivity(I);
                finish();
            }

            else {

                float Quantity, stoploss, target1, target2, target3;

                if (buy.equals("1")) {
                    capital = Float.valueOf(hm.get("capital3").toString());
                    Quantity = capital / price / 2;
                    stoploss = price - 12;
                    target1 = price + 20;
                    target2 = price + 35;
                    target3 = price + 60;

                    price_str = Float.toString(price) + " (buy)";
                }

                else {
                    capital = Float.valueOf(hm.get("capital3").toString());
                    Quantity = capital / price / 2;
                    stoploss = price + 12;
                    target1 = price - 20;
                    target2 = price -35;
                    target3 = price -60;

                    price_str = Float.toString(price) + " (sell)";
                }

                dh.updateData3(Float.toString(capital), price_str, Float.toString(Quantity), Float.toString(stoploss), Float.toString(target1), Float.toString(target2), Float.toString(target3));

            }
        }

        else if (from.equals("4")){

            HashMap hm = dh.getAllData4();

            if (hm == null) {
                Toast.makeText(getApplicationContext(), "Please enter Capital for Banknifty", Toast.LENGTH_LONG).show();
                Intent I = new Intent(getApplicationContext(), SetCapital.class);
                I.putExtra("from", "4");
                startActivity(I);
                finish();
            }

            else {

                float Quantity, stoploss, target1, target2, target3;

                if (buy.equals("1")) {
                    capital = Float.valueOf(hm.get("capital4").toString());
                    Quantity = (int) capital / price / 3;
                    stoploss = price - 40;
                    target1 = price +70;
                    target2 = price + 150;
                    target3 = price + 200;

                    price_str = Float.toString(price) + " (buy)";
                }

                else {
                    capital = Float.valueOf(hm.get("capital4").toString());
                    Quantity = (int) capital / price / 3;
                    stoploss = price + 40;
                    target1 = price - 70;
                    target2 = price - 150;
                    target3 = price - 200;

                    price_str = Float.toString(price) + " (sell)";
                }

                dh.updateData4(Float.toString(capital), price_str, Float.toString(Quantity), Float.toString(stoploss), Float.toString(target1), Float.toString(target2), Float.toString(target3));

            }
        }


    }

    public void Enter(View view) {

        String pricetext = StocksPrice.getText().toString();

        if (pricetext.equals("")){
            Toast.makeText(getApplicationContext(), "Please enter a valid value", Toast.LENGTH_LONG).show();
        }

        else{

            price = Float.valueOf(StocksPrice.getText().toString());
            calulations(from, buy, price);

            Intent I = new Intent(getApplicationContext(), MainActivity.class);
            I.putExtra("from", from);
            I.putExtra("price", pricetext);
            startActivity(I);
            finish();
        }
    }

}

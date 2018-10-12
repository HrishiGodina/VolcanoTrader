package com.example.hrishi.volcanotrader;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class FirstFragment extends Fragment{

    Button buy_stocks;
    Button sell_stocks;
    View myView;
    DataBaseHelper dh;
    TextView ct;
    TextView pt;
    TextView qt;
    TextView slt;
    TextView t1;
    TextView t2;
    TextView t3;
//    String cts;
//    String pts;
//    String qts;
//    String slts;
//    String t1s;
//    String t2s;
//    String t3s;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.first_layout, container, false);
        getActivity().setTitle("Eqity");

        dh = new DataBaseHelper(getActivity());
        ct = myView.findViewById(R.id.stocks_capital);
        pt = myView.findViewById(R.id.stocks_price);
        qt = myView.findViewById(R.id.stocks_quantity);
        slt = myView.findViewById(R.id.stocks_stoploss);
        t1 = myView.findViewById(R.id.stocks_lesstarget);
        t2 = myView.findViewById(R.id.stocks_mediumtarget);
        t3 = myView.findViewById(R.id.stocks_hightarget);

        HashMap hm = dh.getAllData1();

        if (hm == null){

            Intent I = new Intent(getActivity(), SetCapital.class);
            Toast.makeText(getActivity(), "Please enter Capital for Stocks", Toast.LENGTH_LONG).show();
            I.putExtra("from", "1");
            startActivity(I);
            getActivity().finish();

        }

//        cts = "Capital     : " + (hm != null ? hm.get("capital1").toString() : null);
//        pts = "Price         : " + (hm != null ? hm.get("price1").toString() : null);
//        qts = "Quantity   : " + (hm != null ? hm.get("Quantity1").toString() : null);
//        slts = "Stop loss : " + (hm != null ? hm.get("stoploss1").toString() : null);

        ct.setText("Capital     : " + (hm != null ? hm.get("capital1").toString() : null));
        pt.setText("Price         : " + (hm != null ? hm.get("price1").toString() : null));
        qt.setText("Quantity   : " + (hm != null ? hm.get("Quantity1").toString() : null));
        slt.setText("Stop loss : " + (hm != null ? hm.get("stoploss1").toString() : null));
        t1.setText(hm != null ? hm.get("target11").toString() : null);
        t2.setText(hm != null ? hm.get("target12").toString() : null);
        t3.setText(hm != null ? hm.get("target13").toString() : null);

        buy_stocks = myView.findViewById(R.id.buy_stocks);
        sell_stocks = myView.findViewById(R.id.sell_stocks);
        buy_stocks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent I = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    I = new Intent(getContext(), SetPrice.class);
                    I.putExtra("from", "1");
                    I.putExtra("buy", "1");
                }
                startActivity(I);
            }
        });

        sell_stocks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent I = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    I = new Intent(getContext(), SetPrice.class);
                    I.putExtra("from", "1");
                    I.putExtra("buy", "0");
                }
                startActivity(I);
            }
        });
        return myView;
    }

}

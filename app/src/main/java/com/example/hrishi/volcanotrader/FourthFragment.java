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

public class FourthFragment extends Fragment{

    Button buy_banknifty;
    Button sell_banknifty;
    DataBaseHelper dh;
    TextView ct, pt, qt, slt, t1, t2, t3;
    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fourth_layout, container, false);
        getActivity().setTitle("Banknifty");

        dh = new DataBaseHelper(getActivity());
        ct = myView.findViewById(R.id.banknifty_capital);
        pt = myView.findViewById(R.id.banknifty_price);
        qt = myView.findViewById(R.id.banknifty_quantity);
        slt = myView.findViewById(R.id.banknifty_stoploss);
        t1 = myView.findViewById(R.id.banknifty_lesstarget);
        t2 = myView.findViewById(R.id.banknifty_mediumtarget);
        t3 = myView.findViewById(R.id.banknifty_hightarget);

        HashMap hm = dh.getAllData4();

        if (hm == null){

            Intent I = new Intent(getActivity(), SetCapital.class);
            Toast.makeText(getActivity(), "Please enter Capital for Banknifty", Toast.LENGTH_LONG).show();
            I.putExtra("from", "4");
            startActivity(I);
            getActivity().finish();

        }

        ct.setText("Capital     : " + (hm != null ? hm.get("capital4").toString() : null));
        pt.setText("Price         : " + (hm != null ? hm.get("price4").toString() : null));
        qt.setText("Quantity   : " + (hm != null ? hm.get("Quantity4").toString() : null));
        slt.setText("Stop loss : " + (hm != null ? hm.get("stoploss4").toString() : null));
        t1.setText(hm != null ? hm.get("target41").toString() : null);
        t2.setText(hm != null ? hm.get("target42").toString() : null);
        t3.setText(hm != null ? hm.get("target43").toString() : null);


        buy_banknifty = myView.findViewById(R.id.buy_banknifty);
        sell_banknifty = myView.findViewById(R.id.sell_banknifty);
        buy_banknifty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent I = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    I = new Intent(getContext(), SetPrice.class);
                    I.putExtra("from", "4");
                    I.putExtra("buy", "1");
                }
                startActivity(I);
            }
        });

        sell_banknifty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent I = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    I = new Intent(getContext(), SetPrice.class);
                    I.putExtra("from", "4");
                    I.putExtra("buy", "0");
                }
                startActivity(I);

            }
        });
        return myView;
    }
}

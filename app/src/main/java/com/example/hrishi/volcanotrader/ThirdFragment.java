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

public class ThirdFragment extends Fragment{

    Button buy_nifty;
    Button sell_nifty;
    DataBaseHelper dh;
    TextView ct, pt, qt, slt, t1, t2, t3;
    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.third_layout, container, false);
        getActivity().setTitle("Nifty");

        dh = new DataBaseHelper(getActivity());
        ct = myView.findViewById(R.id.nifty_capital);
        pt = myView.findViewById(R.id.nifty_price);
        qt = myView.findViewById(R.id.nifty_quantity);
        slt = myView.findViewById(R.id.nifty_stoploss);
        t1 = myView.findViewById(R.id.nifty_lesstarget);
        t2 = myView.findViewById(R.id.nifty_mediumtarget);
        t3 = myView.findViewById(R.id.nifty_hightarget);

        HashMap hm = dh.getAllData3();

        if (hm == null){

            Intent I = new Intent(getActivity(), SetCapital.class);
            Toast.makeText(getActivity(), "Please enter Capital for Nifty", Toast.LENGTH_LONG).show();
            I.putExtra("from", "3");
            startActivity(I);
            getActivity().finish();

        }

        ct.setText("Capital     : " + (hm != null ? hm.get("capital3").toString() : null));
        pt.setText("Price         : " + (hm != null ? hm.get("price3").toString() : null));
        qt.setText("Quantity   : " + (hm != null ? hm.get("Quantity3").toString() : null));
        slt.setText("Stop loss : " + (hm != null ? hm.get("stoploss3").toString() : null));
        t1.setText(hm != null ? hm.get("target31").toString() : null);
        t2.setText(hm != null ? hm.get("target32").toString() : null);
        t3.setText(hm != null ? hm.get("target33").toString() : null);

        buy_nifty = myView.findViewById(R.id.buy_nifty);
        sell_nifty = myView.findViewById(R.id.sell_nifty);
        buy_nifty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent I = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    I = new Intent(getContext(), SetPrice.class);
                    I.putExtra("from", "3");
                    I.putExtra("buy", "1");
                }
                startActivity(I);
            }
        });

        sell_nifty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent I = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    I = new Intent(getContext(), SetPrice.class);
                    I.putExtra("from", "3");
                    I.putExtra("buy", "0");
                }
                startActivity(I);

            }
        });
        return myView;
    }
}

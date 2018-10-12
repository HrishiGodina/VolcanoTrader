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

public class SecondFragment extends Fragment{

    Button buy_crude_oil;
    Button sell_crude_oil;

    DataBaseHelper dh;
    TextView ct, pt, qt, slt, t1, t2, t3;

    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.second_layout, container, false);
        getActivity().setTitle("Crude Oil");

        dh = new DataBaseHelper(getActivity());
        ct = myView.findViewById(R.id.crude_oil_capital);
        pt = myView.findViewById(R.id.crude_oil_price);
        qt = myView.findViewById(R.id.crude_oil_quantity);
        slt = myView.findViewById(R.id.crude_oil_stoploss);
        t1 = myView.findViewById(R.id.crude_oil_lesstarget);
        t2 = myView.findViewById(R.id.crude_oil_mediumtarget);
        t3 = myView.findViewById(R.id.crude_oil_hightarget);

        HashMap hm = dh.getAllData2();

        if (hm == null){

            Intent I = new Intent(getActivity(), SetCapital.class);
            Toast.makeText(getActivity(), "Please enter Capital for Crude Oil", Toast.LENGTH_LONG).show();
            I.putExtra("from", "2");
            startActivity(I);
            getActivity().finish();

        }

        ct.setText("Capital     : " + (hm != null ? hm.get("capital2").toString() : null));
        pt.setText("Price         : " + (hm != null ? hm.get("price2").toString() : null));
        qt.setText("Quantity   : " + (hm != null ? hm.get("Quantity2").toString() : null));
        slt.setText("Stop loss : " + (hm != null ? hm.get("stoploss2").toString() : null));
        t1.setText(hm != null ? hm.get("target21").toString() : null);
        t2.setText(hm != null ? hm.get("target22").toString() : null);
        t3.setText(hm != null ? hm.get("target23").toString() : null);

        buy_crude_oil = myView.findViewById(R.id.buy_crude_oil);
        sell_crude_oil = myView.findViewById(R.id.sell_crude_oil);
        buy_crude_oil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent I = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    I = new Intent(getContext(), SetPrice.class);
                    I.putExtra("from", "2");
                    I.putExtra("buy", "1");
                }
                startActivity(I);
            }
        });

        sell_crude_oil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent I = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    I = new Intent(getContext(), SetPrice.class);
                    I.putExtra("from", "2");
                    I.putExtra("buy", "0");
                }
                startActivity(I);
            }
        });
        return myView;
    }
}

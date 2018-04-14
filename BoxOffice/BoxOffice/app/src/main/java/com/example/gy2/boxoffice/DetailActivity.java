package com.example.gy2.boxoffice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    Button btnBack;
    TextView drank, dmovieNm, dopenDt, dsalesAmt, dsalesAcc, daudiCnt, daudiAcc, dscrnCnt, dshowCnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        btnBack = (Button) findViewById(R.id.btnBack);

        drank = (TextView) findViewById(R.id.drank);
        dmovieNm = (TextView) findViewById(R.id.dmovieNm);
        dopenDt = (TextView) findViewById(R.id.dopenDt);
        dsalesAmt = (TextView) findViewById(R.id.dsalesAmt);
        dsalesAcc = (TextView) findViewById(R.id.dsalesAcc);
        daudiCnt = (TextView) findViewById(R.id.daudiCnt);
        daudiAcc = (TextView) findViewById(R.id.daudiAcc);
        dscrnCnt = (TextView) findViewById(R.id.dscrnCnt);
        dshowCnt = (TextView) findViewById(R.id.dshowCnt);

        Intent intent = getIntent();
        String rank = intent.getStringExtra("rank");

        Log.d("값이 넘어온거 맞냐고!!", intent.getExtras().getString("rank"));
        drank.setText(intent.getExtras().getString("rank"));
        dmovieNm.setText(intent.getStringExtra("movieNm"));
        dopenDt.setText(intent.getStringExtra("openDt"));
        dsalesAmt.setText(intent.getStringExtra("salesAmt"));
        dsalesAcc.setText(intent.getStringExtra("salesAcc"));
        daudiCnt.setText(intent.getStringExtra("audiCnt"));
        daudiAcc.setText(intent.getStringExtra("audiAcc"));
        dscrnCnt.setText(intent.getStringExtra("scrnCnt"));
        dshowCnt.setText(intent.getStringExtra("showCnt"));

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}

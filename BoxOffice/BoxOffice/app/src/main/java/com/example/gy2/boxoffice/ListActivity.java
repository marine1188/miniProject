package com.example.gy2.boxoffice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    Button btnReSearch;

    ArrayList<String> tourAttractRank = new ArrayList<>();
    ArrayList<String> tourAttractMovieNm =new ArrayList<>();
    ArrayList<String> tourAttractOpenDt = new ArrayList<>();

    TAContent taContent;

    ListView lv;    MyAdapter myAdapter;    ArrayList<TouristAttraction> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Intent intent = getIntent();
        Log.d("넘겨받은 날짜 값",intent.getExtras().getString("dailyBox"));

        btnReSearch = (Button) findViewById(R.id.btnReSearch);
        lv = (ListView) findViewById(R.id.lv);

        taContent = new TAContent(intent.getExtras().getString("dailyBox"));

        Log.d("날짜 값이 잘 들어갔나?",taContent.date);


        taContent.execute(null, null, null);

        // execute() :
        // AsyncTask를 실행시킨다. execute() 메서드에 의해 가장 먼저 호출되는 메서드가
        // onPreExecute()이고 다음으로 자동으로 호출되는 메서드가 doInBackground() 이다.

        while (true) {

            try {
                Thread.sleep(1000);

                if(taContent.flag == true) {
                    data = taContent.taArr;
                    break;
                }
            } catch (Exception e) { }

        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1,tourAttractRank);

        myAdapter = new MyAdapter(this,data);

        lv.setAdapter(myAdapter);

        btnReSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent1 = new Intent(ListActivity.this, DetailActivity.class);
                Log.d("rank값을 넘겨주기", taContent.tagRank);
                intent1.putExtra("rank",taContent.tagRank);
                intent1.putExtra("movieNm",taContent.tagMovieNm);
                intent1.putExtra("openDt",taContent.tagOpenDt);
                intent1.putExtra("salesAmt",taContent.tagsalesAmt);
                intent1.putExtra("salesAcc",taContent.tagsalesAcc);
                intent1.putExtra("audiCnt",taContent.tagaudiCnt);
                intent1.putExtra("audiAcc",taContent.tagaudiAcc);
                intent1.putExtra("scrnCnt",taContent.tagscrnCnt);
                intent1.putExtra("showCnt",taContent.tagshowCnt);
                startActivity(intent1);
            }
        });
    }
}

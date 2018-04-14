package com.example.gy2.boxoffice;

import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by gy2 on 2018-04-02.
 */

public class TAContent extends AsyncTask<Void, Void, Void> {

    TAContent() {}

    TAContent(String date) {
        this.date = date;
    }

    TouristAttraction temp;
    ArrayList<TouristAttraction> taArr = new ArrayList<>();

    URL url;

    String date;

    String uri;/* = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.xml"
            + "?&key=07e99f25cb8f029019a88019370124b7"
            + "&targetDt=" + date;*/

    String tagName = "", tagRank = "", tagMovieNm = "", tagOpenDt = "";
    String tagsalesAmt = "", tagsalesAcc = "";
    String tagaudiCnt = "", tagaudiAcc = "";
    String tagscrnCnt = "", tagshowCnt = "";

    boolean flag = false;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    protected void onPreExecute() {
        setDate(date);
         uri = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.xml"
                + "?&key=07e99f25cb8f029019a88019370124b7"
                + "&targetDt=" + date;
        Log.d("넘겨받은 값을 출력하장",getDate());
    }

    @Override
    protected Void doInBackground(Void... params) {
        setDate(date);
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();

            factory.setNamespaceAware(true);

            XmlPullParser xpp = factory.newPullParser();

            url = new URL(uri);

            InputStream in = url.openStream();

            xpp.setInput(in, "UTF-8");

            boolean isInItemTag = false;

            int eventType = xpp.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {

                if (eventType == XmlPullParser.START_TAG) {
                    tagName = xpp.getName();

                    if (tagName.equals("dailyBoxOffice")) {
                        isInItemTag = true;
                    }

                } else if (eventType == XmlPullParser.TEXT) {

                    if (tagName.equals("rank") && isInItemTag) {
                        temp = new TouristAttraction();
                        tagRank = xpp.getText();
                        temp.setTaRank(tagRank);
                        Log.d("셋 테스트", temp.getTaRank());

                    } else if (tagName.equals("movieNm") && isInItemTag) {
                        tagMovieNm = xpp.getText();
                        temp.setTaName(tagMovieNm);
                        Log.d("셋 테스트", temp.getTaName());

                    } else if (tagName.equals("openDt") && isInItemTag) {
                        tagOpenDt = xpp.getText();
                        temp.setTaOpen(tagOpenDt);
                        Log.d("셋 테스트", temp.getTaOpen());

                    } else if (tagName.equals("salesAmt") && isInItemTag) {
                        tagsalesAmt = xpp.getText();
                        temp.setTaSalesAmt(tagsalesAmt);
                        Log.d("셋 테스트", temp.getTaSalesAmt());

                    } else if (tagName.equals("salesAcc") && isInItemTag) {
                        tagsalesAcc = xpp.getText();
                        temp.setTaSalesAcc(tagsalesAcc);
                        Log.d("셋 테스트", temp.getTaSalesAcc());

                    } else if (tagName.equals("audiCnt") && isInItemTag) {
                        tagaudiCnt = xpp.getText();
                        temp.setTaAudiCnt(tagaudiCnt);
                        Log.d("셋 테스트", temp.getTaAudiCnt());

                    } else if (tagName.equals("audiAcc") && isInItemTag) {
                        tagaudiAcc = xpp.getText();
                        temp.setTaAudiAcc(tagaudiAcc);
                        Log.d("셋 테스트", temp.getTaAudiAcc());

                    } else if (tagName.equals("scrnCnt") && isInItemTag) {
                        tagscrnCnt = xpp.getText();
                        temp.setTaScrnCnt(tagscrnCnt);
                        Log.d("셋 테스트", temp.getTaScrnCnt());

                    } else if (tagName.equals("showCnt") && isInItemTag) {
                        tagshowCnt = xpp.getText();
                        temp.setTaShowCnt(tagshowCnt);
                        Log.d("셋 테스트", temp.getTaShowCnt());

                        taArr.add(temp);
                    }

                } else if (eventType == XmlPullParser.END_TAG) {
                    tagName = xpp.getName();

                    if (tagName.equals("dailyBoxOffice")) {
                        tagRank = "";
                        tagMovieNm = "";
                        tagOpenDt = "";
                        tagsalesAmt = "";
                        tagsalesAcc = "";
                        tagaudiCnt = "";
                        tagaudiAcc = "";
                        tagscrnCnt = "";
                        tagshowCnt = "";

                        isInItemTag = false;
                    }
                }

                eventType = xpp.next();
            }

            flag = true;

        } catch (Exception e) {
        }
        return null;
    }
}

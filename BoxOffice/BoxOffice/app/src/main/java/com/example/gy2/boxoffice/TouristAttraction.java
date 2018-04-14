package com.example.gy2.boxoffice;

/**
 * Created by gy2 on 2018-04-01.
 */

public class TouristAttraction {
    public String taRank;   // 리스트 뷰 랭킹
    public String taName;   // 리스트 뷰 영화제목
    public String taOpen;   // 리스트 뷰 개봉일
    public String taSalesAmt;
    public String taSalesAcc;
    public String taAudiCnt;
    public String taAudiAcc;
    public String taScrnCnt;
    public String taShowCnt;

    public TouristAttraction() { }

    public TouristAttraction(String taRank, String taName, String taOpen) {
        this.taRank = taRank;
        this.taName = taName;
        this.taOpen = taOpen;
    }

    public String getTaRank() {
        return taRank;
    }

    public void setTaRank(String taRank) {
        this.taRank = taRank;
    }

    public String getTaName() {
        return taName;
    }

    public void setTaName(String taName) {
        this.taName = taName;
    }

    public String getTaOpen() {
        return taOpen;
    }

    public void setTaOpen(String taOpen) {
        this.taOpen = taOpen;
    }

    public String getTaSalesAmt() {
        return taSalesAmt;
    }

    public void setTaSalesAmt(String taSalesAmt) {
        this.taSalesAmt = taSalesAmt;
    }

    public String getTaSalesAcc() {
        return taSalesAcc;
    }

    public void setTaSalesAcc(String taSalesAcc) {
        this.taSalesAcc = taSalesAcc;
    }

    public String getTaAudiCnt() {
        return taAudiCnt;
    }

    public void setTaAudiCnt(String taAudiCnt) {
        this.taAudiCnt = taAudiCnt;
    }

    public String getTaAudiAcc() {
        return taAudiAcc;
    }

    public void setTaAudiAcc(String taAudiAcc) {
        this.taAudiAcc = taAudiAcc;
    }

    public String getTaScrnCnt() {
        return taScrnCnt;
    }

    public void setTaScrnCnt(String taScrnCnt) {
        this.taScrnCnt = taScrnCnt;
    }

    public String getTaShowCnt() {
        return taShowCnt;
    }

    public void setTaShowCnt(String taShowCnt) {
        this.taShowCnt = taShowCnt;
    }
}

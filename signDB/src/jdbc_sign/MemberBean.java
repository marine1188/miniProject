package jdbc_sign;

public class MemberBean {
    String mb_id;
    String mb_pw; 
    String email;
    String mb_name;
    String jumin1;
    String jumin2;
    String birth_year;
    String birth_month;
    String birth_date;
    String interest;
    String introduce;
    String grade;
    long regi_date;
    public String getMb_id() {
        return mb_id;
    }
    public void setMb_id(String mb_id) {
        this.mb_id = mb_id;
    }
    public String getMb_pw() {
        return mb_pw;
    }
    public void setMb_pw(String mb_pw) {
        this.mb_pw = mb_pw;
    }
   
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getMb_name() {
        return mb_name;
    }
    public void setMb_name(String mb_name) {
        this.mb_name = mb_name;
    }
    public String getJumin1() {
        return jumin1;
    }
    public void setJumin1(String jumin1) {
        this.jumin1 = jumin1;
    }
   
    
    public String getJumin2() {
        return jumin2;
    }
    public void setJumin2(String jumin2) {
        this.jumin2 = jumin2;
    }
    public String getBirth_year() {
        return birth_year;
    }
    public void setBirth_year(String birth_year) {
        this.birth_year = birth_year;
    }
    public String getBirth_month() {
        return birth_month;
    }
    public void setBirth_month(String birth_month) {
        this.birth_month = birth_month;
    }
    public String getBirth_date() {
        return birth_date;
    }
    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }
    public String getInterest() {
        return interest;
    }
    public void setInterest(String interest) {
        this.interest = interest;
    }
    public String getIntroduce() {
        return introduce;
    }
    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
    
    public void setGrade(String grade) {
        this.grade = grade;
    }
    public String getGrade() {
        return grade;
    }
    
    
}

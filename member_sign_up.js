let mb_id  //아이디
let mb_pw  //비밀번호
let mb_pw2 //비밀번호 확인
let email  //이메일주소
let name   //이름
let jumin1 //주민등록번호 앞자리
let jumin2 //주민등록번호 뒷자리
let chk    //취미
let introduce //자기소개


function init() {
    mb_id = document.getElementById("mb_id")
    mb_pw = document.getElementById("mb_pw")
    mb_pw2 = document.getElementById("mb_pw2")
    email = document.getElementById("email")
    mb_name  = document.getElementById("mb_name")
    jumin1 = document.getElementById("jumin1")
    jumin2 = document.getElementById("jumin2")
    chk = document.getElementsByName("interest[]");
    introduce = document.getElementById("introduce");
}

function validate() {
    let chkNumCnt = 0; //체크박스 체크 된 수를 저장하는 변수

    if(mb_id.value ==""){
        alert("아이디를 입력하지 않았습니다")
        mb_id.focus()
        return false;
    }

    if(mb_pw.value =="") {
        alert("비밀번호를 입력하지 않았습니다.")
        mb_pw.focus()
        return false;
    }

    if(mb_pw.value.includes(mb_id.value)) {
        alert("패스워드에 아이디를 넣어서는 안됩니다!")
        mb_pw.value = "";
        mb_pw2.value = "";
        mb_pw.focus()
        return false;
    }

    if(!verifyId(mb_id.value)) { //아이디 유효성 검사
        alert("아이디는 4~12자 대소문자,숫자만 입력가능합니다.")
        mb_id.value=""
        mb_id.focus()
        return false;
    }

    if(!verifyPw(mb_pw.value)) { //비밀번호 유효성 검사
        alert("비밀번호는 4~12자 대소문자,숫자만 입력가능합니다.")
        mb_pw.value=""
        mb_pw2.value=""
        mb_pw.focus()
        return false;
    }

    if(mb_pw2.value =="") {
        alert("비밀번호 확인을 입력하지 않았습니다.")
        mb_pw2.focus()
        return false;
    }

    if(mb_pw.value != mb_pw2.value) {
        alert("비밀번호가 일치하지 않습니다.")
        mb_pw1.focus()
        return false;
    }

    if(email.value =="") {
        alert("이메일을 입력하지 않았습니다.")
        email.focus()
        return false;
    }

    if(!verifyEmail(email.value)) { //주민등록번호 유효성 검사
        alert("이메일을 정확하게 입력해주세요.")
        email.value = ""
        email.focus()
        return false;
    }

    if(mb_name.value == "") { //이름 유효성 검사
        alert("이름을 입력해주세요.")
        mb_name.focus()
        return false;
    }

    if(!verifyJumin(jumin1.value, jumin2.value)) { //주민등록번호 유효성 검사
        alert("잘못 된 주민등록번호 입니다.")
        jumin1.value = "" //jumin1를 공백으로 바꾸기
        jumin2.value = "" //jumin2를 공백으로 바꾸기
        jumin1.focus() //jumin1으로 커서를 이동시키기
        return false;
    }


    let birthYear = jumin1.value.substring(0,2);
    let genderNumber = jumin2.value.charAt(0);

    for(let i = 0; i < chk.length; i++){                    //체크박스 유효성 검사                      체크박스의 길이 체크
        if((chk[i].name=="interest[]") && (chk[i].checked))     //체크박스배열의 이름이 같고 체크박스가 체크되어있으면
            chkNumCnt++;                                    //카운트를 올려줌
    }

    if(chkNumCnt == 0){                          //체크박스 유효성 검사
        alert("적어도 하나 이상의 관심분야를 선택하셔야 합니다");
        return false;
    }

    if(introduce.value.length > 80){
        alert("자기소개가 80자를 초과하였습니다");
    } else if(introduce.value.length < 10){
        alert("자기소개를 10자 이상 입력하세요");
    }
    alert("회원 가입에 성공 하셨습니다 \n       감사합니다");
}

function setBirthDay(){
    if(!verifyJumin(jumin1.value, jumin2.value)) { //주민등록번호 유효성 검사
        alert("잘못 된 주민등록번호 입니다.")
        jumin1.value = "" //jumin1를 공백으로 바꾸기
        jumin2.value = "" //jumin2를 공백으로 바꾸기
        jumin1.focus() //jumin1으로 커서를 이동시키기
        return false;
    }

    let birthYear    = jumin1.value.substring(0,2);
    let genderNumber = jumin2.value.charAt(0);

    if(genderNumber == "3" || genderNumber == "4") {//2000년생이후
       document.getElementById("birth_year").value = "20"+birthYear;
    } else if(genderNumber == "1" || genderNumber == "2") {//1900년생이하
       document.getElementById("birth_year").value = "19"+birthYear;
    }

    document.getElementById("birth_month").value = Number(jumin1.value.substring(2,4));
    document.getElementById("birth_date").value  = Number(jumin1.value.substring(4,6));
}

function verifyJumin(jumin1, jumin2) {
    const regJumin1 = /^(?:[0-9]{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[1,2][0-9]|3[0,1]))/g //주민등록번호 앞자리에 대한 정규식
    const regJumin2 = /^[1-4][0-9]{6}/g //주민등록번호 뒷자리에 대한 정규식

    if(!regJumin1.test(jumin1) || !regJumin2.test(jumin2)) { //먼저 정규식으로 앞자리와 뒷자리를 체크함
        return false
    } else { //정규식을 통해 검증하더라도 뒷자리의 마지막 번호를 체크해야함
        const strJumin = jumin1 + jumin2 //주민등록번호 전체를 저장하는 변수
        const juminLen = strJumin.length //주민등록번호의 총 길이를 저장하는 변수 (13)
        let sum = 0 //주민등록번호 검증시 필요한 변수

        for(let i = 0; i < juminLen - 1; i++) { //주민등록번호에서 마지막 번호를 검증 할때 필요한 숫자를 만들기 위해 수행하는 연산
            sum += Number(strJumin[i]) * (2 + i % 8)
        }

        if(Number(strJumin[juminLen - 1]) !=  11 - (sum % 11) % 10) { //주민등록번호 뒷자리의 마지막 번호와 위에서 생성된 숫자를 비교
            return false
        }
    }

    return true //모든 조건을 통과하였다면 true를 반환
}

function verifyId(id) {
    const regId = /^[a-zA-Z0-9]{4,12}/g

    //아이디 유효성 검사(4~12자의 영문 대소문자와 숫자로만 입력)
    if(!(regId.test(id))){
        return false
    }

    return true
}

function verifyPw(pw) {
    const regPw = /^[a-zA-Z0-9]{4,12}/g

    //비밀번호 유효성 검사(4~12자의 영문 대소문자와 숫자로만 입력)
    if(!(regPw.test(pw))){
        return false
    }

    return true
}

function verifyEmail(email) {
    const regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})/g

    //이메일 유효성 검사(4~12자의 영문 대소문자와 숫자로만 입력)
    if(!(regEmail.test(email))){
        return false
    }

    return true
}

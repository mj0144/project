package user.model;

//create table user_info(
//user_num number constraint user_info_user_num_pk PRIMARY KEY,
//user_id varchar2(50)  constraint user_info_user_id_nn not null,
//nickname varchar2(100) constraint user_info_nickname_nn not null,
//pwd varchar2(100) constraint user_info_pwd_nn not null,
//name varchar2(50) constraint user_info_name_nn not null,
//sex char(10) constraint user_info_sex_nn not null,
//email varchar2(50) constraint user_info_email_nn not null,
//user_img varchar2(300),
//birth char(12) constraint user_info_birth_nn not null,
//birth_hh number(2),
//birth_mm number(2),
//user_intro  varchar2(1000),
//saju_year number,
//saju_mon number,
//saju_day number,
//ilju char(6),--foreign key
//approval_status varchar2(50),
//approval_key varchar2(50),

public class UserInfo {
   
   private int SeqUser;
   private int birthHH;
   private int birthMM;
   
   private String id;		// 아이디
   private String password; // 비밀번호
   private String nickname; // 닉네임   
   private String name;		// 이름
   private String birth;	// 생년월일
   private String intro;	// 자기소개
   private String email;	// 이메일
   
   private String file_ori_name; 	// 파일 원본 이름
   private String file_save_path;	// 파일 저장 경로
   private String file_save_name;	// 파일 저장된 이름
  
   private int saju_year;		// 사주년도?
   private int saju_mon;		// 
   private int saju_day;		//
   private String ilju;			// 일주?
   
   private int info_year;		// ?
   private int info_mon; 		//
   private int info_day;		// 
   private String reason;		// ? 
   private String mbti;			// mbti 결과

   private String approval_status;
   private String approval_key;
   
   
	public int getSeqUser() {
		return SeqUser;
	}
	public void setSeqUser(int seqUser) {
		SeqUser = seqUser;
	}
	public int getBirthHH() {
		return birthHH;
	}
	public void setBirthHH(int birthHH) {
		this.birthHH = birthHH;
	}
	public int getBirthMM() {
		return birthMM;
	}
	public void setBirthMM(int birthMM) {
		this.birthMM = birthMM;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFile_ori_name() {
		return file_ori_name;
	}
	public void setFile_ori_name(String file_ori_name) {
		this.file_ori_name = file_ori_name;
	}
	public String getFile_save_path() {
		return file_save_path;
	}
	public void setFile_save_path(String file_save_path) {
		this.file_save_path = file_save_path;
	}
	public String getFile_save_name() {
		return file_save_name;
	}
	public void setFile_save_name(String file_save_name) {
		this.file_save_name = file_save_name;
	}
	public int getSaju_year() {
		return saju_year;
	}
	public void setSaju_year(int saju_year) {
		this.saju_year = saju_year;
	}
	public int getSaju_mon() {
		return saju_mon;
	}
	public void setSaju_mon(int saju_mon) {
		this.saju_mon = saju_mon;
	}
	public int getSaju_day() {
		return saju_day;
	}
	public void setSaju_day(int saju_day) {
		this.saju_day = saju_day;
	}
	public String getIlju() {
		return ilju;
	}
	public void setIlju(String ilju) {
		this.ilju = ilju;
	}
	public int getInfo_year() {
		return info_year;
	}
	public void setInfo_year(int info_year) {
		this.info_year = info_year;
	}
	public int getInfo_mon() {
		return info_mon;
	}
	public void setInfo_mon(int info_mon) {
		this.info_mon = info_mon;
	}
	public int getInfo_day() {
		return info_day;
	}
	public void setInfo_day(int info_day) {
		this.info_day = info_day;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getMbti() {
		return mbti;
	}
	public void setMbti(String mbti) {
		this.mbti = mbti;
	}
	public String getApproval_status() {
		return approval_status;
	}
	public void setApproval_status(String approval_status) {
		this.approval_status = approval_status;
	}
	public String getApproval_key() {
		return approval_key;
	}
	public void setApproval_key(String approval_key) {
		this.approval_key = approval_key;
	}

}
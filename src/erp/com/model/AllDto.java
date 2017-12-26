package erp.com.model;

import java.io.Serializable;

public class AllDto implements Serializable {
	
	private int staff_no;					
	private String staff_name;
	
	private String jumin_no_1;
	private String jumin_no_2;
	
	private int school_code_2;
	private int school_code_3;
	private int school_code_4;
	
	private int religion_code;
	
	private String graduate_day;
	private String skill;
	
	private int start =1;				// 시작 번호
	private int end = 5;					// 끝 번호
	
	private String start_date;
	private String end_date;
	
	private int staff_skill_no;
	
	private int skill_code_2;
	private int skill_code_3;
	private int skill_code_4;
	private int skill_code_5;
	private int skill_code_6;
	
	private int add_skill;
	private String add_skill_condi;
	
	public AllDto() {}

	public AllDto(int staff_no, String staff_name, String jumin_no_1, String jumin_no_2, int school_code_2,
			int school_code_3, int school_code_4, int religion_code, String graduate_day, String skill, int start,
			int end, String start_date, String end_date, int staff_skill_no, int skill_code_2, int skill_code_3,
			int skill_code_4, int skill_code_5, int skill_code_6, int add_skill, String add_skill_condi) {
		super();
		this.staff_no = staff_no;
		this.staff_name = staff_name;
		this.jumin_no_1 = jumin_no_1;
		this.jumin_no_2 = jumin_no_2;
		this.school_code_2 = school_code_2;
		this.school_code_3 = school_code_3;
		this.school_code_4 = school_code_4;
		this.religion_code = religion_code;
		this.graduate_day = graduate_day;
		this.skill = skill;
		this.start = start;
		this.end = end;
		this.start_date = start_date;
		this.end_date = end_date;
		this.staff_skill_no = staff_skill_no;
		this.skill_code_2 = skill_code_2;
		this.skill_code_3 = skill_code_3;
		this.skill_code_4 = skill_code_4;
		this.skill_code_5 = skill_code_5;
		this.skill_code_6 = skill_code_6;
		this.add_skill = add_skill;
		this.add_skill_condi = add_skill_condi;
	}

	public int getStaff_no() {
		return staff_no;
	}

	public void setStaff_no(int staff_no) {
		this.staff_no = staff_no;
	}

	public String getStaff_name() {
		return staff_name;
	}

	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}

	public String getJumin_no_1() {
		return jumin_no_1;
	}

	public void setJumin_no_1(String jumin_no_1) {
		this.jumin_no_1 = jumin_no_1;
	}

	public String getJumin_no_2() {
		return jumin_no_2;
	}

	public void setJumin_no_2(String jumin_no_2) {
		this.jumin_no_2 = jumin_no_2;
	}

	public int getSchool_code_2() {
		return school_code_2;
	}

	public void setSchool_code_2(int school_code_2) {
		this.school_code_2 = school_code_2;
	}

	public int getSchool_code_3() {
		return school_code_3;
	}

	public void setSchool_code_3(int school_code_3) {
		this.school_code_3 = school_code_3;
	}

	public int getSchool_code_4() {
		return school_code_4;
	}

	public void setSchool_code_4(int school_code_4) {
		this.school_code_4 = school_code_4;
	}

	public int getReligion_code() {
		return religion_code;
	}

	public void setReligion_code(int religion_code) {
		this.religion_code = religion_code;
	}

	public String getGraduate_day() {
		return graduate_day;
	}

	public void setGraduate_day(String graduate_day) {
		this.graduate_day = graduate_day;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public int getStaff_skill_no() {
		return staff_skill_no;
	}

	public void setStaff_skill_no(int staff_skill_no) {
		this.staff_skill_no = staff_skill_no;
	}

	public int getSkill_code_2() {
		return skill_code_2;
	}

	public void setSkill_code_2(int skill_code_2) {
		this.skill_code_2 = skill_code_2;
	}

	public int getSkill_code_3() {
		return skill_code_3;
	}

	public void setSkill_code_3(int skill_code_3) {
		this.skill_code_3 = skill_code_3;
	}

	public int getSkill_code_4() {
		return skill_code_4;
	}

	public void setSkill_code_4(int skill_code_4) {
		this.skill_code_4 = skill_code_4;
	}

	public int getSkill_code_5() {
		return skill_code_5;
	}

	public void setSkill_code_5(int skill_code_5) {
		this.skill_code_5 = skill_code_5;
	}

	public int getSkill_code_6() {
		return skill_code_6;
	}

	public void setSkill_code_6(int skill_code_6) {
		this.skill_code_6 = skill_code_6;
	}

	public int getAdd_skill() {
		return add_skill;
	}

	public void setAdd_skill(int add_skill) {
		this.add_skill = add_skill;
	}

	public String getAdd_skill_condi() {
		return add_skill_condi;
	}

	public void setAdd_skill_condi(String add_skill_condi) {
		this.add_skill_condi = add_skill_condi;
	}

	@Override
	public String toString() {
		return "AllDto [staff_no=" + staff_no + ", staff_name=" + staff_name + ", jumin_no_1=" + jumin_no_1
				+ ", jumin_no_2=" + jumin_no_2 + ", school_code_2=" + school_code_2 + ", school_code_3=" + school_code_3
				+ ", school_code_4=" + school_code_4 + ", religion_code=" + religion_code + ", graduate_day="
				+ graduate_day + ", skill=" + skill + ", start=" + start + ", end=" + end + ", start_date=" + start_date
				+ ", end_date=" + end_date + ", staff_skill_no=" + staff_skill_no + ", skill_code_2=" + skill_code_2
				+ ", skill_code_3=" + skill_code_3 + ", skill_code_4=" + skill_code_4 + ", skill_code_5=" + skill_code_5
				+ ", skill_code_6=" + skill_code_6 + ", add_skill=" + add_skill + ", add_skill_condi=" + add_skill_condi
				+ "]";
	}

	
}




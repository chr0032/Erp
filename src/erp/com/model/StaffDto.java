package erp.com.model;

import java.io.Serializable;
import org.apache.ibatis.type.Alias;

public class StaffDto implements Serializable {
	
	private int staff_no;					
	private String staff_name;
	private String jumin_no;
	private String school_code;
	private int religion_code;
	private String graduate_day;
	private String skill;
	
	private int add_skill;
	private String add_skill_condi;
	
	private String start_date;
	private String end_date;
	
	private int recordCountPerPage = 5;
	private int pageNumber = 0;
	
	private int start = 1;
	private int end = 5;
	
	public StaffDto() {}

	public StaffDto(int staff_no, String staff_name, String jumin_no, String school_code, int religion_code,
			String graduate_day, String skill, int add_skill, String add_skill_condi, String start_date,
			String end_date, int recordCountPerPage, int pageNumber, int start, int end) {
		super();
		this.staff_no = staff_no;
		this.staff_name = staff_name;
		this.jumin_no = jumin_no;
		this.school_code = school_code;
		this.religion_code = religion_code;
		this.graduate_day = graduate_day;
		this.skill = skill;
		this.add_skill = add_skill;
		this.add_skill_condi = add_skill_condi;
		this.start_date = start_date;
		this.end_date = end_date;
		this.recordCountPerPage = recordCountPerPage;
		this.pageNumber = pageNumber;
		this.start = start;
		this.end = end;
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

	public String getJumin_no() {
		return jumin_no;
	}

	public void setJumin_no(String jumin_no) {
		this.jumin_no = jumin_no;
	}

	public String getSchool_code() {
		return school_code;
	}

	public void setSchool_code(String school_code) {
		this.school_code = school_code;
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

	public int getRecordCountPerPage() {
		return recordCountPerPage;
	}

	public void setRecordCountPerPage(int recordCountPerPage) {
		this.recordCountPerPage = recordCountPerPage;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
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

	@Override
	public String toString() {
		return "StaffDto [staff_no=" + staff_no + ", staff_name=" + staff_name + ", jumin_no=" + jumin_no
				+ ", school_code=" + school_code + ", religion_code=" + religion_code + ", graduate_day=" + graduate_day
				+ ", skill=" + skill + ", add_skill=" + add_skill + ", add_skill_condi=" + add_skill_condi
				+ ", start_date=" + start_date + ", end_date=" + end_date + ", recordCountPerPage=" + recordCountPerPage
				+ ", pageNumber=" + pageNumber + ", start=" + start + ", end=" + end + "]";
	}
}

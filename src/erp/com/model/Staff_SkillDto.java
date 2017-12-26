package erp.com.model;

import java.io.Serializable;

public class Staff_SkillDto implements Serializable {
	
	private int staff_skill_no;
	private int staff_no;
	private int skill_code;

	public Staff_SkillDto() {}

	public Staff_SkillDto(int staff_skill_no, int staff_no, int skill_code) {
		super();
		this.staff_skill_no = staff_skill_no;
		this.staff_no = staff_no;
		this.skill_code = skill_code;
	}

	public int getStaff_skill_no() {
		return staff_skill_no;
	}

	public void setStaff_skill_no(int staff_skill_no) {
		this.staff_skill_no = staff_skill_no;
	}

	public int getStaff_no() {
		return staff_no;
	}

	public void setStaff_no(int staff_no) {
		this.staff_no = staff_no;
	}

	public int getSkill_code() {
		return skill_code;
	}

	public void setSkill_code(int skill_code) {
		this.skill_code = skill_code;
	}

	@Override
	public String toString() {
		return "Staff_SkillDto [staff_skill_no=" + staff_skill_no + ", staff_no=" + staff_no + ", skill_code="
				+ skill_code + "]";
	}
	
	
}

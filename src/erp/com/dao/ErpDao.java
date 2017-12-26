package erp.com.dao;

import java.util.List;

import erp.com.model.AllDto;
import erp.com.model.StaffDto;
import erp.com.model.Staff_SkillDto;

public interface ErpDao {

	public List<StaffDto> selectAll(StaffDto dto)throws Exception;
	public List<StaffDto> select(AllDto dto)throws Exception;
	
	public boolean insertStaff(StaffDto dto)throws Exception;
	public boolean insertSkill(Staff_SkillDto dto)throws Exception;
	
	public StaffDto getStaff(int seq)throws Exception;
	public List<Staff_SkillDto> getSkill(int seq)throws Exception;
	
	public boolean deleteStaff(int seq)throws Exception;
	public boolean deleteSkill(int seq)throws Exception;
	
	public boolean updateStaff(StaffDto dto)throws Exception;
	public boolean re_insertSkill(Staff_SkillDto dto)throws Exception;
	
	public int getCount()throws Exception;		// 모두검색
	public int selectCount(AllDto dto) throws Exception;
}

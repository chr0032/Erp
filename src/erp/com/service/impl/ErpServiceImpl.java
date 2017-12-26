package erp.com.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import erp.com.controller.ErpController;
import erp.com.dao.ErpDao;
import erp.com.model.AllDto;
import erp.com.model.StaffDto;
import erp.com.model.Staff_SkillDto;
import erp.com.service.ErpService;

@Service
public class ErpServiceImpl implements ErpService {
	
	@Autowired
	ErpDao erpDao;

	private static final Logger logger 
	= LoggerFactory.getLogger(ErpController.class);
	
	@Override
	public List<StaffDto> selectAll(StaffDto dto) throws Exception {
		return erpDao.selectAll(dto);
	}

	@Override
	public List<StaffDto> select(AllDto dto) throws Exception {
		return erpDao.select(dto);
	}

	@Override
	public boolean insertStaff(StaffDto dto) throws Exception {
		return erpDao.insertStaff(dto);
	}

	@Override
	public boolean insertSkill(Staff_SkillDto dto) throws Exception {
		return erpDao.insertSkill(dto);
	}

	@Override
	public StaffDto getStaff(int seq) throws Exception {
		return erpDao.getStaff(seq);
	}

	@Override
	public List<Staff_SkillDto> getSkill(int seq) throws Exception {
		return erpDao.getSkill(seq);
	}

	@Override
	public boolean deleteStaff(int seq) throws Exception {
		return erpDao.deleteStaff(seq);
	}

	@Override
	public boolean deleteSkill(int seq) throws Exception {
		return erpDao.deleteSkill(seq);
	}

	@Override
	public boolean updateStaff(StaffDto dto) throws Exception {
		return erpDao.updateStaff(dto);
	}

	@Override
	public boolean re_insertSkill(Staff_SkillDto dto) throws Exception {
		return erpDao.re_insertSkill(dto);
	}

	@Override
	public int getCount() throws Exception {
		return erpDao.getCount();
	}

	@Override
	public int selectCount(AllDto dto) throws Exception {
		return erpDao.selectCount(dto);
	}
}

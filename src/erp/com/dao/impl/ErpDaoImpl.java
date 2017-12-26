package erp.com.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import erp.com.controller.ErpController;
import erp.com.dao.ErpDao;
import erp.com.model.AllDto;
import erp.com.model.StaffDto;
import erp.com.model.Staff_SkillDto;

@Repository
public class ErpDaoImpl implements ErpDao {
	
	@Autowired
	SqlSession sqlSession;
	
	String ns = "Erp.";
	
	private static final Logger logger 
	= LoggerFactory.getLogger(ErpController.class);

	@Override
	public List<StaffDto> selectAll(StaffDto dto) throws Exception {	
		return sqlSession.selectList(ns+"selectAll", dto);
	}

	@Override
	public List<StaffDto> select(AllDto dto) throws Exception {
		return sqlSession.selectList(ns+"select", dto);
	}

	@Override
	public boolean insertStaff(StaffDto dto) throws Exception {
		int n = sqlSession.insert(ns+"insertStaff", dto);
		return n>0?true:false;
	}

	@Override
	public boolean insertSkill(Staff_SkillDto dto) throws Exception {
		int n = sqlSession.insert(ns+"insertSkill", dto);
		return n>0?true:false;
	}

	@Override
	public StaffDto getStaff(int seq) throws Exception {
		return sqlSession.selectOne(ns+"getStaff", seq);
	}

	@Override
	public List<Staff_SkillDto> getSkill(int seq) throws Exception {
		return sqlSession.selectList(ns+"getSkill", seq);
	}

	@Override
	public boolean deleteStaff(int seq) throws Exception {
		int n = sqlSession.delete(ns+"deleteStaff", seq);
		return n>0?true:false;
	}

	@Override
	public boolean deleteSkill(int seq) throws Exception {
		int n = sqlSession.delete(ns+"deleteSkill", seq);
		return n>0?true:false;
	}

	@Override
	public boolean updateStaff(StaffDto dto) throws Exception {
		int n = sqlSession.update(ns+"updateStaff", dto);
		return n>0?true:false;
	}

	@Override
	public boolean re_insertSkill(Staff_SkillDto dto) throws Exception {
		int n = sqlSession.insert(ns+"re_insertSkill", dto);
		return n>0?true:false;
	}

	@Override
	public int getCount() throws Exception {		
		return sqlSession.selectOne(ns+"getCount");
	}

	@Override
	public int selectCount(AllDto dto) throws Exception {
		return sqlSession.selectOne(ns+"selectCount", dto);
	}


	
	

	
	
}

package erp.com.controller;

//import java.sql.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
//import org.jsoup.helper.DataUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import erp.com.model.AllDto;
import erp.com.model.StaffDto;
import erp.com.model.Staff_SkillDto;
import erp.com.service.ErpService;
import erp.com.util.CalendarUtil;
import erp.com.util.Pagination;

@Controller
public class ErpController {
	
	@Autowired
	ErpService erpService;
	
	private static final Logger logger 
	= LoggerFactory.getLogger(ErpController.class);
	
	@RequestMapping(value="main.do", method=RequestMethod.GET)
	public String login(Model model) {
		logger.info("main");		
		
		model.addAttribute("pageNumber", 0);
		model.addAttribute("pageCountPerScreen", 5);
		model.addAttribute("recordCountPerPage", 5);
		model.addAttribute("totalRecordCount", 0);
		
		return "staff_search_form";
	}
	
	@RequestMapping(value="selectAll.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String selectAll(StaffDto staff, HttpServletRequest req, Model model)throws Exception {
		logger.info("selectAll");	
		
		int sn = staff.getPageNumber();
		int start = (sn) * staff.getRecordCountPerPage() + 1;	//스타트 페이지
		int end = (sn + 1) * staff.getRecordCountPerPage();
		
		// 총 staff수  
		int totalRecordCount = erpService.getCount();
		staff.setStart(start);
		staff.setEnd(end);

		List<StaffDto> list = erpService.selectAll(staff);
		for (int i = 0; i < list.size(); i++) {
			String n = (list.get(i).getJumin_no()).substring(7,8);			
			if(n.equals("1")) {
				list.get(i).setJumin_no("남");
			}else if(n.equals("2")) {
				list.get(i).setJumin_no("여");
			}
		}
		
		System.out.println(list.toString());
		
		model.addAttribute("stafflist", list);
		model.addAttribute("pageNumber", sn);
		model.addAttribute("pageCountPerScreen", 5);
		model.addAttribute("recordCountPerPage", staff.getRecordCountPerPage());
		model.addAttribute("totalRecordCount", totalRecordCount);
		
		return "staff_search_all";
	}
	
	@SuppressWarnings("static-access")
	@RequestMapping(value="select.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String select(HttpServletRequest req, StaffDto staffDto, Model model)throws Exception {		
		logger.info("select");	
		
		CalendarUtil cal = new CalendarUtil();
		
		String s_year = req.getParameter("s_year");
		String s_month = req.getParameter("s_month");
		String s_day = req.getParameter("s_day");
		
		String e_year = req.getParameter("e_year");
		String e_month = req.getParameter("e_month");
		String e_day = req.getParameter("e_day");
		
		s_month = cal.two(Integer.parseInt(s_month));
		s_day = cal.two(Integer.parseInt(s_day));
		e_month = cal.two(Integer.parseInt(e_month));
		e_day = cal.two(Integer.parseInt(e_day));
		
		System.out.println("s_year : " + s_year + " s_month : " + s_month + " s_day : " + s_day);
		System.out.println("e_year : " + e_year + " e_month : " + e_month + " e_day : " + e_day);
		
		s_month = cal.two(Integer.parseInt(s_month));
		
		String start_date = s_year + s_month + s_day;
		String end_date = e_year + e_month + e_day;

		System.out.println("start_date : " + start_date);
		System.out.println("end_date : " + end_date);
		
		staffDto.setStart_date(start_date);
		staffDto.setEnd_date(end_date);
		
		int add_skill = staffDto.getAdd_skill();
		String add_skill_condi = staffDto.getAdd_skill_condi();
		
		if(add_skill == 0) add_skill = 0;
		if(add_skill == 1) add_skill = 6;	//spring
		if(add_skill == 2) add_skill = 7;	//xplatform
		if(add_skill == 3) add_skill = 8;	//전자정부
	
		logger.info("dto : " + staffDto);		
		
		String skill2 = "";
		String skill3 = "";
		String skill4 = "";
		String skill5 = "";
		String skill6 = "";		
		
		int n = 0;
		
		if(staffDto.getSkill() != null && !staffDto.getSkill().equals("")) {
			n = staffDto.getSkill().length();
			
			if(n > 0) {
				skill2 = (staffDto.getSkill()).substring(0,1);
				if(n > 2) {
					skill3 = (staffDto.getSkill()).substring(2,3);
					if(n > 4) {
						skill4 = (staffDto.getSkill()).substring(4,5);	
						if(n > 6) {
							skill5 = (staffDto.getSkill()).substring(6,7);
							if(n > 8) {
								skill6 = (staffDto.getSkill()).substring(8,9);
							}
						}
					}
				}
			}	
		}		

		String school2 = "";
		String school3 = "";
		String school4 = "";
		
		if(staffDto.getSchool_code() != null && !staffDto.getSchool_code().equals("")) {
			int school = staffDto.getSchool_code().length();
			
			if(school > 0) {
				school2 = (staffDto.getSchool_code()).substring(0,1);
				if(school > 2) {
					school3 = (staffDto.getSchool_code()).substring(2,3);
					if(school > 4) {
						school4 = (staffDto.getSchool_code()).substring(4,5);						
					}
				}
			}
		}		
			
		String jumin_1 = "";
		String jumin_2 = "";
		
		if(staffDto.getJumin_no() != null && !staffDto.getJumin_no().equals("")) {
			int ju = staffDto.getJumin_no().length();
			
			if(ju > 0) {
				jumin_1 = (staffDto.getJumin_no()).substring(0,1);
				if(ju > 2) {
					jumin_2 = (staffDto.getJumin_no()).substring(2,3);
					
				}
			}
		}		
		
		/*** 페이지 처리를 위해 ***/
		int sn = staffDto.getPageNumber();
		int start = (sn) * staffDto.getRecordCountPerPage() + 1;	//스타트 페이지
		int end = (sn + 1) * staffDto.getRecordCountPerPage();
		
		/***********			검색할 데이터를 AllDto에 넣어줌          ***************/		
		AllDto all = new AllDto();
		all.setStaff_name(staffDto.getStaff_name());				//	이름
		all.setReligion_code(staffDto.getReligion_code());			//	종교
		all.setStart_date(staffDto.getStart_date());				//	시작일
		all.setEnd_date(staffDto.getEnd_date());					//	끝나는일
		all.setJumin_no_1(jumin_1);
		all.setJumin_no_2(jumin_2);
		all.setAdd_skill(add_skill);								// 추가 스킬
		all.setAdd_skill_condi(add_skill_condi);					// 추가 스킬의 조건
		
		
		if(school2 != null && !school2.equals("")) {
			all.setSchool_code_2(Integer.parseInt(school2));	
		}
		if(school3 != null && !school3.equals("")) {
			all.setSchool_code_3(Integer.parseInt(school3));
		}
		if(school4 != null && !school4.equals("")) {
			all.setSchool_code_4(Integer.parseInt(school4));
		}
					
		if(skill2 != null & !skill2.equals("")) {
			all.setSkill_code_2(Integer.parseInt(skill2));
		}
		if(skill3 != null & !skill3.equals("")) {
			all.setSkill_code_3(Integer.parseInt(skill3));
		}
		if(skill4 != null & !skill4.equals("")) {
			all.setSkill_code_4(Integer.parseInt(skill4));
		}
		if(skill5 != null & !skill5.equals("")) {
			all.setSkill_code_5(Integer.parseInt(skill5));
		}
		if(skill6 != null & !skill6.equals("")) {
			all.setSkill_code_6(Integer.parseInt(skill6));
		}

		logger.info("all : " + all.toString());
				
		// 검색된 staff 수
		int totalRecordCount = erpService.selectCount(all);
		logger.info("totalRecordCount : " + totalRecordCount);
		all.setStart(start);
		all.setEnd(end);
		
		List<StaffDto> stafflist = erpService.select(all);
		
		for (int i = 0; i < stafflist.size(); i++) {
			String n2 = (stafflist.get(i).getJumin_no()).substring(7,8);
			if(n2.equals("1")) {
				stafflist.get(i).setJumin_no("남");
			}else if(n2.equals("2")) {
				stafflist.get(i).setJumin_no("여");
			}
		}
		
		logger.info(stafflist.toString());
		
		int size = stafflist.size();
		logger.info("size : " + size);
		logger.info("StaffDtO : " + staffDto);
		
		model.addAttribute("staffDto", staffDto);
		model.addAttribute("stafflist", stafflist);	
		model.addAttribute("pageNumber", sn);
		model.addAttribute("pageCountPerScreen", 5);
		model.addAttribute("recordCountPerPage", staffDto.getRecordCountPerPage());
		model.addAttribute("totalRecordCount", totalRecordCount);
		
		return "staff_search_form";
	}
	
	@RequestMapping(value="insert.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String insert(Model model)throws Exception {
		logger.info("insert");
		return "staff_input_form";
	}

	@RequestMapping(value="insertStaff.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String insertStaff(HttpServletRequest req, Model model, StaffDto staffDto)throws Exception {
		logger.info("insertStaff");
		
		int year = Integer.parseInt(req.getParameter("year"));
		int month = Integer.parseInt(req.getParameter("month"));
		int day = Integer.parseInt(req.getParameter("day"));
		
		String date = CalendarUtil.toStringDate(year, month, day);
		staffDto.setGraduate_day(date);
		
		String jumin = (staffDto.getJumin_no()).replace(',', '-');
		staffDto.setJumin_no(jumin);
		logger.info("staffDto : " + staffDto);
		
		String skill2 = "";
		String skill3 = "";
		String skill4 = "";
		String skill5 = "";
		String skill6 = "";	
		
		int n = staffDto.getSkill().length();
		
		if(n > 0) {
			skill2 = (staffDto.getSkill()).substring(0,1);
			if(n > 2) {
				skill3 = (staffDto.getSkill()).substring(2,3);
				if(n > 4) {
					skill4 = (staffDto.getSkill()).substring(4,5);	
					if(n > 6) {
						skill5 = (staffDto.getSkill()).substring(6,7);
						if(n > 8) {
							skill6 = (staffDto.getSkill()).substring(8,9);
						}
					}
				}
			}
		}			
								
		// 스태프 추가
		erpService.insertStaff(staffDto);
		
		// 스킬추가
		Staff_SkillDto skillDto = new Staff_SkillDto();
		
		skillDto.setSkill_code(Integer.parseInt(skill2));
		logger.info("skill2 dto : " + skillDto);
		
		erpService.insertSkill(skillDto);
		
		if(skill3 != null && skill3 != "") {
			
			skillDto.setSkill_code(Integer.parseInt(skill3));	
			logger.info("skill3 dto : " + skillDto);
			
			erpService.insertSkill(skillDto);
		}
		
		if(skill4 != null && skill4 != "") {
			
			skillDto.setSkill_code(Integer.parseInt(skill4));	
			logger.info("skill4 dto : " + skillDto);
			
			erpService.insertSkill(skillDto);
		}
		
		if(skill5 != null && skill5 != "") {
			
			skillDto.setSkill_code(Integer.parseInt(skill5));	
			logger.info("skill5 dto : " + skillDto);
			
			erpService.insertSkill(skillDto);
		}
		
		if(skill6 != null && skill6 != "") {
			
			skillDto.setSkill_code(Integer.parseInt(skill6));	
			logger.info("skill6 dto : " + skillDto);
			
			erpService.insertSkill(skillDto);
		}
		
		return "staff_search_form";
	}
	
	@RequestMapping(value="update.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String update(HttpServletRequest req, Model model, int seq)throws Exception {
		logger.info("update");
		logger.info("seq : " + seq);
		
		// 사원 정보 가져오기
		StaffDto staffDto = erpService.getStaff(seq);
		logger.info("staffDto : " + staffDto);
		
		//사원 스킬 가져오기
		List<Staff_SkillDto> skillList = erpService.getSkill(seq);
		logger.info("skillList : " + skillList);
		
		// 주민등록번호 앞 뒤 짜르기
		String jumin_first = staffDto.getJumin_no().substring(0,6);
		String jumin_second = staffDto.getJumin_no().substring(7);
		logger.info("jumin_first : " + jumin_first + "   jumin_second :" + jumin_second);
		
		// 졸업일 년,월,일 로 나누기
		String year = staffDto.getGraduate_day().substring(0,4);
		String month = String.valueOf(staffDto.getGraduate_day().substring(5,7));
		String day = String.valueOf(staffDto.getGraduate_day().substring(8,10));
		logger.info("year : " + year + "   month :" + month + "   day :" + day);		
		
		req.getSession().setAttribute("year", year);
		req.getSession().setAttribute("month", month);
		req.getSession().setAttribute("day", day);
		
		model.addAttribute("jumin_first", jumin_first);
		model.addAttribute("jumin_second", jumin_second);
		
		model.addAttribute("staffDto", staffDto);
		model.addAttribute("skillList", skillList);
				
		return "staff_updel_form";
	}
	
	@RequestMapping(value="deleteStaff.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String deleteStaff(HttpServletRequest req, Model model, int seq)throws Exception {
		logger.info("deleteStaff");
		logger.info("seq : " + seq);
		
		erpService.deleteSkill(seq);
		erpService.deleteStaff(seq);
		
		return "staff_search_form";		
	}
	
	@RequestMapping(value="updateStaff.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String updateStaff(HttpServletRequest req, Model model, StaffDto staffDto)throws Exception {
		

		int year = Integer.parseInt(req.getParameter("year"));
		int month = Integer.parseInt(req.getParameter("month"));
		int day = Integer.parseInt(req.getParameter("day"));
		
		String date = CalendarUtil.toStringDate(year, month, day);
		staffDto.setGraduate_day(date);
		
		String jumin = (staffDto.getJumin_no()).replace(',', '-');
		staffDto.setJumin_no(jumin);
		
		logger.info("staffDto : " + staffDto);
		
		// 스태프 수정
		erpService.updateStaff(staffDto);
		
		// 스킬 모두 삭제
		erpService.deleteSkill(staffDto.getStaff_no());		

		String skill2 = "";
		String skill3 = "";
		String skill4 = "";
		String skill5 = "";
		String skill6 = "";	
		
		int n = staffDto.getSkill().length();
		
		if(n > 0) {
			skill2 = (staffDto.getSkill()).substring(0,1);
			if(n > 2) {
				skill3 = (staffDto.getSkill()).substring(2,3);
				if(n > 4) {
					skill4 = (staffDto.getSkill()).substring(4,5);	
					if(n > 6) {
						skill5 = (staffDto.getSkill()).substring(6,7);
						if(n > 8) {
							skill6 = (staffDto.getSkill()).substring(8,9);
						}
					}
				}
			}
		}	
		
		System.out.println("skill2 : " + skill2);
		System.out.println("skill3 : " + skill3);
		System.out.println("skill4 : " + skill4);
		System.out.println("skill5 : " + skill5);
		System.out.println("skill6 : " + skill6);
						
		// 스킬추가
		Staff_SkillDto skillDto = new Staff_SkillDto();
		skillDto.setStaff_no(staffDto.getStaff_no());
		
		skillDto.setSkill_code(Integer.parseInt(skill2));
		logger.info("skill2 dto : " + skillDto);		
		erpService.re_insertSkill(skillDto);
		
		if(skill3 != null && skill3 != "") {
			
			skillDto.setSkill_code(Integer.parseInt(skill3));	
			logger.info("skill3 dto : " + skillDto);			
			erpService.re_insertSkill(skillDto);
		}
		
		if(skill4 != null && skill4 != "") {
			
			skillDto.setSkill_code(Integer.parseInt(skill4));	
			logger.info("skill4 dto : " + skillDto);			
			erpService.re_insertSkill(skillDto);
		}
		
		if(skill5 != null && skill5 != "") {
			
			skillDto.setSkill_code(Integer.parseInt(skill5));	
			logger.info("skill5 dto : " + skillDto);			
			erpService.re_insertSkill(skillDto);
		}
		
		if(skill6 != null && skill6 != "") {
			
			skillDto.setSkill_code(Integer.parseInt(skill6));	
			logger.info("skill6 dto : " + skillDto);			
			erpService.re_insertSkill(skillDto);
		}
		
		return "redirect:/main.do";
	}

	// 현재 페이지 구하기 

	private int getCurrPage(HttpServletRequest req) {
		int currPage;
		
		if (req.getParameter("page") == null) {
			currPage = 1;
		} else {
			currPage = Integer.parseInt(req.getParameter("page"));
		}
		
		return currPage;
	}
}








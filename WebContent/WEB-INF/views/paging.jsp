<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%
	
	int totalRecordCount;	// 전체 글의 수
	int pageNumber;			// 현재 페이지 번호
	int pageCountPerScreen; // 스크린당 페이지 수 
	int recordCountPerPage; // 페이지당 글의 수 
	
	String st1 = request.getParameter("totalRecordCount");	
	if(st1 == null || "".equals(st1.trim())) totalRecordCount = 1;
	else			totalRecordCount = Integer.parseInt(st1);
	
	String st2 = request.getParameter("pageNumber");
	if(st2 == null || "".equals(st2.trim())) pageNumber = 1;
	else			pageNumber = Integer.parseInt(st2);
	
	String st3 = request.getParameter("pageCountPerScreen");
	if(st3 == null || "".equals(st3.trim())) pageCountPerScreen = 1;
	else			pageCountPerScreen = Integer.parseInt(st3);
	
	String st4 = request.getParameter("recordCountPerPage");
	if(st4 == null || "".equals(st4.trim())) recordCountPerPage = 1;
	else			recordCountPerPage = Integer.parseInt(st4);

	
	int totalPageCount = totalRecordCount / recordCountPerPage;	// 총 페이지 수
	//         1       =      12           /      10     
	
	if((totalRecordCount % recordCountPerPage) != 0){
		totalPageCount++;		// +1  -> 총 페이지 수(totalPageCount) == 2페이지
	}
	
	int screenStartPageIndex = ((pageNumber+1) / pageCountPerScreen) * pageCountPerScreen;
	//                0     =         (0 + 1  /    10) * 10  

	int screenEndPageIndex = (((pageNumber+1) / pageCountPerScreen) * pageCountPerScreen) + pageCountPerScreen;
	//             10     =            (((0 + 1 / 10) * 10) + 10)
	//     [1][2] ~ [10]		
	//	   [1][2] ~ [10] -> [1][2] 	 
	if(screenEndPageIndex > totalPageCount){
		screenEndPageIndex = totalPageCount;	// 끝 페이지 == 2  [1][2]
	}
	
	// 11쪽으로 넘어갔을 때 < 버튼 눌러서 1~10 있는 페이지로 돌아가는 버튼 활성화
	if (((pageNumber+1) % pageCountPerScreen) == 0)	
	{//		9					10								
	    screenStartPageIndex = (((pageNumber+1) / pageCountPerScreen) * pageCountPerScreen) - pageCountPerScreen;
	    //		0					9			/		10			*		10						10
	    screenEndPageIndex = pageNumber+1;
	    //		10				9
	}
%>

<div style="float: left; width: 96%; text-align: center;">
	<a href="#none" title="처음페이지" onclick="goPage('0')">
		<img alt="처음페이지" src="image/arrow_first.gif" style="width:9px; height:9px;">		
	</a>&nbsp;
	
	<%
	// 이전 페이지
	if(screenStartPageIndex > 1){
		%>
		<a href="#none" title="이전페이지" onclick="goPage('<%=screenStartPageIndex-1 %>')">
			<img alt="이전페이지" src="image/arrow_back.gif" style="width:9px; height:9px;">
		</a>&nbsp;		
		<%
	}
	%>
	
	<!-- 페이지 블록 [1][2].... -->
	<%
	for(int i = screenStartPageIndex; i < screenEndPageIndex; i++){
		if(i == pageNumber){ 		//현재페이지   [1] 2 [3] [4] 
			%>
			<span style="font-size: 9pt; color: #000000; font-weight: bold;">
				<%=i+1 %>
			</span>
			<%
		}else{				// 현재페이지 외 블록페이지
			%>
			<a href="#none" title="<%=i+1 %>페이지" onclick="goPage('<%=i %>')"
			 style="width:7.5pt; color: #000000; font-weight: normal;">
				[<%=i+1 %>] 
			</a>
			<%
		}
	}
	%>
	&nbsp;
	<% 
	// 다음 페이지
	if(screenEndPageIndex < totalPageCount){
		%>
		<a href="#none" title="다음페이지" onclick="goPage('<%=screenEndPageIndex %>')">
			<img alt="다음페이지" src="image/arrow_next.gif" style="width:9px; height:9px;">
		</a>&nbsp;
		<%
	}
	
	int end_page = 0;
	if(totalPageCount > 0){
		end_page = totalPageCount - 1;
	}
	%>
	
	<a href="#none" title="마지막페이지" onclick="goPage('<%=end_page %>')">
		<img alt="마지막페이지" src="image/arrow_end.gif" style="width:9px; height:9px;">
	</a>
</div>

<div style="float: left; width: 4%; text-align: center;">
	<span style="font-size: 1em; color: #000000">
		<%=pageNumber+1 %>/<%=totalPageCount %>
	</span>
</div>

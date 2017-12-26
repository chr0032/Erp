<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"    uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"  %>
<fmt:requestEncoding value="UTF-8"/>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>

<!-- js -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script> 

<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:400,600&amp;subset=latin-ext"
	rel="stylesheet">

<link href="${pageContext.request.contextPath }/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath }/css/font-awesome.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath }/style.css"
	rel="stylesheet">


<style>
.table_erp {
	 width:70%; border:1px solid #000000; border-collapse:collapse;
	 margin-left:auto; margin-right:auto; clear:both;
}
.table_erp th {
	 line-height: 1.7em; font-weight:normal; text-align: center;
	 border:1px solid #000000; border-collapse:collapse;
	 padding: auto; margin: auto;
}

.table_erp td {
	 padding-left:5px; text-align:left; line-height: 1.7em;
	 border:1px solid #000000; border-collapse:collapse;
	 padding: auto; margin: auto;
	 text-align: center;
}

.table_erp tfoot td{
	 text-align: center;
	 border:1px solid #FFFFFF; border-collapse:collapse;
	 padding: auto; margin: auto;
}

#paging_wrap { width:70%; border:0; margin-left:auto; margin-right:auto; margin-top:10px; }
</style>

<%
Calendar cal = Calendar.getInstance();
int tyear = cal.get(Calendar.YEAR);
int tmonth = cal.get(Calendar.MONTH) +1;
int tday = cal.get(Calendar.DATE);

String year = String.valueOf(tyear);
String month = String.valueOf(tmonth);
String day =  String.valueOf(tday);

String syear = "2000";
String smonth = "1";
String sday = "1" ;

%>



<div>
	<form id="form" name="form" action="select.do" method="post">
	<table class="table_erp">
		<thead>
		<tr>
			<th colspan="6"> 사원 정보 검색</th>
		</tr>
		</thead>
		
		<tbody>
		<tr>
			<th>이름</th>			
			<td>
				<input type="text" id="staff_name" name="staff_name" >
			</td>
			
			<th>성별</th>			
			<td>
				<input type="checkbox" name="jumin_no" id="man" value="1">남
				<input type="checkbox" name="jumin_no" id="woman" value="2">여
			</td>
			
			<th>종교</th>			
			<td>
				<select name="religion_code">
					<option value="0"></option>
					<option value="2">기독교</option>
					<option value="3">천주교</option>
					<option value="4">불교</option>
					<option value="5">이슬람</option>
					<option value="6">무교</option>
				</select>
			</td>
		</tr>
		
		<tr>
			<th>학력</th>
			<td>
				<input type="checkbox" name="school_code" value="2">고졸
				<input type="checkbox" name="school_code" value="3">초대졸
				<input type="checkbox" name="school_code" value="4">대졸
			</td>
			
			<th>기술</th>
			<td colspan="3">
				<input type="checkbox" name="skill" value="2">java
				<input type="checkbox" name="skill" value="3">jsp
				<input type="checkbox" name="skill" value="4">asp
				<input type="checkbox" name="skill" value="5">php
				<input type="checkbox" name="skill" value="6">delphi
			</td>
		</tr>
		
		<tr>
			<th>졸업일</th>
			<td colspan="5">
				<select name="s_year" id="s_year">
				<%
				for(int i = tyear-34; i <= tyear; i++){		// 일정의 17년전부터 현재까지 년도 설정
					%>
					<option <%=syear.equals(i + "")?"selected='selected'":"" %>
						value="<%=i %>"><%=i %></option>
					<% 
				}
				%>
				</select>년
				
				<select name="s_month" id="s_month">
				<%		// 월  설정
				for(int i = 1; i <= 12; i++){		
					%>
					<option <%=smonth.equals(i + "")?"selected='selected'":"" %>
						value="<%=i %>"><%=i %></option>
					<% 
				}
				%>
				</select>월
				
				<select name="s_day" id="s_day">
				<%		//일 설정
				for(int i = 1; i <= cal.getActualMaximum(Calendar.DAY_OF_MONTH); i++){		
					%>
					<option <%=sday.equals(i + "")?"selected='selected'":"" %>
						value="<%=i %>"><%=i %></option>
					<% 
				}
				%>
				</select>일
				
				<select name="e_year" id="e_year">
				<%
				for(int i = tyear-34; i <= tyear; i++){		// 일정의 17년전부터 현재까지 년도 설정
					%>
					<option <%=year.equals(i + "")?"selected='selected'":"" %>
						value="<%=i %>"><%=i %></option>
					<% 
				}
				%>
				</select>년
				
				<select name="e_month" id="e_month">
				<%		// 월  설정
				for(int i = 1; i <= 12; i++){		
					%>
					<option <%=month.equals(i + "")?"selected='selected'":"" %>
						value="<%=i %>"><%=i %></option>
					<% 
				}
				%>
				</select>월
				
				<select name="e_day" id="e_day">
				<%		//일 설정
				for(int i = 1; i <= cal.getActualMaximum(Calendar.DAY_OF_MONTH); i++){		
					%>
					<option <%=day.equals(i + "")?"selected='selected'":"" %>
						value="<%=i %>"><%=i %></option>
					<% 
				}
				%>
				</select>일
			</td>
		</tr>
		<tr>
			<th>추가기술</th>
			<td colspan="5">
				<select name="add_skill" id="add_skill">
					<option value="0"></option>
					<option value="1">spring</option>
					<option value="2">Xplatform</option>
					<option value="3">전자정부</option>
				</select>
				<select name="add_skill_condi" id="add_skill_condi">
					<option value="0"></option>
					<option value="and">and</option>
					<option value="or">or</option>
				</select>
			</td>
		</tr>
		</tbody>
		
		<tfoot>
		<tr>
			<td colspan="6">
				<input type="button" id="_select" name="_select" value="검색">
<!-- 				<a href="#"><input type="button" id="_select" value="검색"></a> -->
				<a href="selectAll.do"><input type="button"  name="selectAll" value="전부검색"></a>
<!-- 				<a href="reset.do"><input type="button" name="reset" value="초기화" ></a>	 -->
				<button onclick="goBack()">초기화</button>
				<a href="insert.do"><input type="button" name="insert" value="등록" ></a>		
			</td>
		</tr>
		</tfoot>
	</table>
	
	<!-- 페이징 전송부분 -->
	<input type="hidden" name="pageNumber" id="_pageNumber" 
		value="${(empty pageNumber)?0:pageNumber }">
			
	<input type="hidden" name="recordCountPerPage" id="_recordCountPerPage"
		value="${(empty recordCountPerPage)?0:recordCountPerPage }">
	</form>
</div>

<div>
	<table class="table_erp" id="myTable">
		<thead>
			<tr>
				<th onclick="sortTable(0)">번호</th>
				<th onclick="sortTable(1)">이름</th>
				<th onclick="sortTable(2)">성별</th>
				<th onclick="sortTable(3)">종교</th>
				<th onclick="sortTable(4)">졸업일</th>
				<th></th>
			</tr>
		</thead>
		
		<tbody>
			<c:if test="${empty stafflist }">
				<tr><td colspan="9" style="text-align: center">검색된 사원이 없습니다</td></tr>
			</c:if>
			
			<c:forEach items="${stafflist }" var="staff" varStatus="vs">
				<tr>
					<td>${vs.count }</td>
					<td>${staff.staff_name }</td>
					<td>${staff.jumin_no }</td>
					<td>
						<c:if test="${staff.religion_code eq 2 }">기독교</c:if>
						<c:if test="${staff.religion_code eq 3 }">천주교</c:if>
						<c:if test="${staff.religion_code eq 4 }">불교</c:if>
						<c:if test="${staff.religion_code eq 5 }">이슬람</c:if>
						<c:if test="${staff.religion_code eq 6 }">무교</c:if>
					</td>
					<td>${staff.graduate_day }</td>
					<td>
						<a href="update.do?seq=${staff.staff_no }"><button type="button" class="btn btn-primary">수정/삭제</button></a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	
	</table>
</div>

<!-- 실제 페이지 처리  request.getparameter == jsp:param -->
<div id="paging_wrap">
<jsp:include page="/WEB-INF/views/paging.jsp" flush="false">
	<jsp:param value="${pageNumber }" name="pageNumber"/>			
	<jsp:param value="${totalRecordCount }" name="totalRecordCount"/>
	<jsp:param value="${pageCountPerScreen }" name="pageCountPerScreen"/>
	<jsp:param value="${recordCountPerPage }" name="recordCountPerPage"/>
</jsp:include>
</div>

<script type="text/javascript">
$("#_select").click(function(){
	var s_year = $("#s_year option:selected").val();
	var e_year = $("#e_year option:selected").val();
	var s_month = $("#s_month option:selected").val();
	var e_month = $("#e_month option:selected").val();
	var s_day = $("#s_day option:selected").val();
	var e_day = $("#e_day option:selected").val();
	
	var s_ymd = s_year+two(s_month)+two(s_day);
	var e_ymd = e_year+two(e_month)+two(e_day);
	
	s_ymd = Number(s_ymd);
	e_ymd = Number(e_ymd);
	
	var skill = $('#add_skill').val();
	var skill_condi = $('#add_skill_condi').val();
	
	
	
	if(s_ymd > e_ymd){
		alert("졸업일을 확인하십시오");
	}else{
		if(skill != 0 && skill_condi == 0){
			alert("조건을 선택하십시오");
		}else{
			$("#form").attr({"target":"_self", "action":"select.do"}).submit();	
		}		
	}
});


function two(tt){
	return (tt+"").length>1?(tt+""):"0"+tt;
}

function goPage(pageNumber){
	$("#_pageNumber").val(pageNumber);
	$("#form").attr("target","_self").attr("action","select.do").submit();
}

function sortTable(n) {
  var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
  table = document.getElementById("myTable");
  switching = true;
  
  // 정렬 방향을 오름차순으로 설정합니다.
  dir = "asc"; 
  
  // ~까지 계속 될 루프를 만드십시오. 전환이 완료되지 않았습니다.
  while (switching) {
    // 말하기 시작 : 전환 없음
    switching = false;
    rows = table.getElementsByTagName("TR");
    
    // 모든 테이블 행을 반복합니다 (첫째, 테이블 헤더 포함):
    for (i = 1; i < (rows.length - 1); i++) {
      //전환이 없어야한다고 말함으로써 시작하십시오.
      shouldSwitch = false;
      // 비교할 두 요소를 가져오고, 현재 행과 다음 행 중 하나
      x = rows[i].getElementsByTagName("TD")[n];
      y = rows[i + 1].getElementsByTagName("TD")[n];
      
      // 두 행이 자리를 바꿔야하는지, 방향, 오름차순 또는 내림차순에 따라 :
      if (dir == "asc") {
    	  
        if (two(x.innerHTML.toLowerCase()) > two(y.innerHTML.toLowerCase())) {
          //그렇다면 스위치로 표시하고 루프를 중단하십시오.
          shouldSwitch= true;
          break;
        }
        
      } else if (dir == "desc") {
    	  
        if (two(x.innerHTML.toLowerCase()) < two(y.innerHTML.toLowerCase())) {
          //그렇다면 스위치로 표시하고 루프를 중단하십시오.
          shouldSwitch= true;
          break;
        }
      }
      
    }//for
    
    if (shouldSwitch) {
      //스위치에 표시가되어 있으면 스위치를 만듭니다 스위치가 완료되었음을 표시하십시오.
      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
      switching = true;
      //스위치가 완료 될 때마다이 카운트를 1 씩 증가시킵니다
      switchcount ++;      
    } else {
      //전환이 수행되지 않고 방향이 "오름차순"이면 방향을 "desc"로 설정하고 while 루프를 다시 실행하십시오
      if (switchcount == 0 && dir == "asc") {
        dir = "desc";
        switching = true;
      }
    }
    
  }//while
}

function goBack() {
    window.history.go(-2);
}

</script>











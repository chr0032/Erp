<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"    uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"  %>
<fmt:requestEncoding value="UTF-8"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>

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
</style>

<%
Calendar cal = Calendar.getInstance();
int tyear = cal.get(Calendar.YEAR);
int tmonth = cal.get(Calendar.MONTH) +1;
int tday = cal.get(Calendar.DATE);

String year = String.valueOf(tyear);
String month = String.valueOf(tmonth);
String day =  String.valueOf(tday);
%>


<div>
<form id="form" name="form" action="#" method="post">
	<table class="table_erp">
		<thead>
		<tr>
			<th colspan="6"> 사원 정보 등록</th>
		</tr>
		</thead>
		
		
		<tbody>
		<tr>
			<th>이름</th>			
			<td>
				<input type="text" id="staff_name" name="staff_name">
			</td>
			
			<th>주민번호</th>			
			<td>
				<input type="text" name="jumin_no" id="jumin_first">-
				<input type="password" name="jumin_no" id="jumin_second" >
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
				<select name="year">
				<%
				for(int i = tyear-34; i <= tyear; i++){		// 일정의 17년전부터 현재까지 년도 설정
					%>
					<option <%=year.equals(i + "")?"selected='selected'":"" %>
						value="<%=i %>"><%=i %></option>
					<% 
				}
				%>
				</select>년
				
				<select name="month">
				<%		// 월  설정
				for(int i = 1; i <= 12; i++){		
					%>
					<option <%=month.equals(i + "")?"selected='selected'":"" %>
						value="<%=i %>"><%=i %></option>
					<% 
				}
				%>
				</select>월
				
				<select name="day">
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
		</tbody>
		
		<tfoot>
		<tr>
			<td colspan="6">
				<input type="button" id="insertBtn" value="등록">
				<button onclick="goBack()">초기화</button>				
			</td>
		</tr>
		</tfoot>				
	</table>
</form>	
</div>



<script type="text/javascript">
$(document).ready(function(){
	//getter
	$("select[name='month']").change(function(){
		var lastday = (new Date($("select[name='year']").val()+"",
						$("select[name='month']").val()+"", 0)).getDate();
		
		//적용
		var str = "";
		for(i = 1; i <= lastday; i++){
			str += "<option value='" + i + "'>" + i + "</option>";
		}
		
		$("select[name='day']").html(str);
		
	});
	
	$("select[name='year']").change(function(){
		var lastday = (new Date($("select[name='year']").val()+"",
						$("select[name='month']").val()+"", 0)).getDate();
		
		//적용
		var str = "";
		for(i = 1; i <= lastday; i++){
			str += "<option value='" + i + "'>" + i + "</option>";
		}
		
		$("select[name='day']").html(str);		
	});
	
	
	//라디오 요소처럼 동작시킬 체크박스 그룹 셀렉터
    $('input[type="checkbox"][name="school_code"]').click(function(){
        //클릭 이벤트 발생한 요소가 체크 상태인 경우
        if ($(this).prop('checked')) {
            //체크박스 그룹의 요소 전체를 체크 해제후 클릭한 요소 체크 상태지정
            $('input[type="checkbox"][name="school_code"]').prop('checked', false);
            $(this).prop('checked', true);
        }
    }); 
});


$("#insertBtn").click(function(){
	
	if($.trim($('#staff_name').val()) == ''){
		alert("이름을 입력하십시오.");
	    $('#staff_name').focus();
	    return false;
	}
	
	if($.trim($('#jumin_first').val()) == ''){
		alert("주민번호를 입력하십시오.");
	    $('#jumin_first').focus();
	    return false;
	}
	
	if($.trim($('#jumin_second').val()) == ''){
		alert("주민번호를 입력하십시오.");
	    $('#jumin_second').focus();
	    return false;
	}
	
	var sch_check = $("input:checkbox[name='school_code']").is(":checked");
	var skill_check = $("input:checkbox[name='skill']").is(":checked");  
	
	// -----------------체크 확인 
	// 학력 체크 안된경우
	if (!sch_check) {
		alert("학력중 하나를 선택하시오");
		$('#high').focus();
		return false;
	}
	// 기술 체크 안된경우
	if (!skill_check) {
		alert("기술을 선택하시오");
		$('#java').focus();
		return false;
	}

	// 모두 체크 되어 있을 떄
	if (sch_check && skill_check) {
		
		if (confirm("정말 저장 하시겠습니까?") == true){
			$("#form").attr({
				"target" : "_self",
				"action" : "insertStaff.do"
			}).submit();
		}else{
			return;
		}						
	}
});
	
function goBack() {
    window.history.go(-2);
}	
	
	
</script>













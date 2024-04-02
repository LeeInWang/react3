<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://cdn.datatables.net/2.0.2/js/dataTables.js"></script>
<script src="https://cdn.datatables.net/2.0.2/js/dataTables.bootstrap5.js"></script>
	


<style>

	.wrap{
		margin-top: 100px;
		width: 85%;
		height: 80%;
		display: block;
	
		float: right;
	}
	

  
 
.user_btn_update {
	

    display: inline-block;
    padding: 5 10px;
    font-size: 10px;
    text-align: center;
    text-decoration: none;
    cursor: pointer;
    border: 0.1px #f8f9fa;
    border-radius: 5px;
    background-color: #f8f9fa;
    color: #c5c1c1;
    transition: background-color 0.3s, color 0.3s, border-color 0.3s;
  }

  /* 버튼 호버 효과 */
  .user_btn_update:hover {
    background-color: #ffffff;
    color: #5898d8;
  }
  
  .user_btn_delete {
  	margin-left:10px;
  	
    display: inline-block;
    padding: 5 10px;
    font-size: 10px;
    text-align: center;
    text-decoration: none;
    cursor: pointer;
    border: 0.1px #f8f9fa;
    border-radius: 5px;
    background-color: #f8f9fa;
    color: #c5c1c1;
    transition: background-color 0.3s, color 0.3s, border-color 0.3s;
  }

  /* 버튼 호버 효과 */
  .user_btn_delete:hover {
    background-color: #ffffff;
    color: #d85872;
  }
  
  .th2, .td2{
  	text-align: center;
  }
</style>


<script>
document.addEventListener('DOMContentLoaded', function(){

  new DataTable('#example',{
	// 표시 건수기능 숨기기
	  lengthChange: false,
	// 정보 표시 숨기기
	    info: false,
	    lengthMenu: [ 10, 20, 30, 40, 50 ], // -셋트1(같이사용해야 기능이 사용됩니다.)
	 // 기본 표시 건수를 20건으로 설정
	    displayLength: 10, 					// -셋트1(같이사용해야 기능이 사용됩니다.)
	  
	  columnDefs: [
		  // 1번재 항목 열을 숨김
	        { targets: 0, width: 70 },
	    
	        // 2번째 항목의 넓이를 100px로 설정
	        { targets: 4, width: 100 }
	        
	    ]
  
  
 
	 
    
	   
  });
	
	
});


  
</script>




</head>
<body>
	<header>
		 <jsp:include page="/WEB-INF/phone/header.jsp" flush="true"/>		
	</header>
<div class=".wrapper">
	<div class= "wrap">
	
	
		 <table id="example" class="table table-striped" style="width:100%">
		   <thead>
        <tr>
			<th class="th1" >체크</th>
			<th class="th1" >아이디</th>
			<th class="th1" >이름</th>
			<th class="th1" >이메일</th>
			<th class="th1" >핸드폰</th>
			<th class="th1" >가입일</th>
			<th class="th1" >최근접속일</th>
			<th class="th2" >공란</th>
			
		</tr>
    </thead>
    <tbody>

		<c:forEach items="${userList}" var="b" varStatus="i">
		<tr>
			<td class="td1"><input="checkbox"/></td>
			<td class="td1"><a href="getUser.do2?userId=${b.getUserId()}">${ b.getUserId()}</a></td>
			<td class="td1">${b.getUserName()}</td>
			<td class="td1">${b.getUserEmail()}</td>
			<td class="td1">${b.getUserPhoneNumber()}</td>
			<td class="td1">${b.getUserJoinDate()}</td>
			<td class="td1">${b.getUserLastLoginDate()}</td>
			
			<td class="td2">
			<button class="user_btn_update">수정</button>
			<button class="user_btn_delete">삭제</button>
			</td>
		</tr>
		</c:forEach>
		
		</tbody>

</table>
		
		
		
		
	</div>
	<aside class="side">
	 <jsp:include page="/WEB-INF/phone/user/useraside.jsp" flush="true"/>
	</aside>
</div>
	<footer>
		<jsp:include page="/WEB-INF/phone/footer.jsp" flush="true"/>	
	</footer>

</body>
</html>
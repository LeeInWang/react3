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
		margin-top: 200px;
		width: 60%;
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
	    displayLength: 20, 					// -셋트1(같이사용해야 기능이 사용됩니다.)
	 // 검색 기능 숨기기
    searching: false,
    // 페이징 기능 숨기기
    paging: false,
	    
	  
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
	
	
		 <table id="example" class="table table-striped" style="width:60%">
		   <thead>
        <tr>
			<th class="th1" >등급순서</th>
			<th class="th1" >등급명</th>
			<th class="th1" >회원수</th>
			<th class="th1" >평가조건</th>
			<th class="th1" >혜택</th>
			<th class="th2" >등록일</th>
			<th class="th2" >관리</th>
		</tr>
    </thead>
    <tbody>

		<c:forEach items="${boardList}" var="b" varStatus="i">
		<tr>
			<td class="td1">${b.getSeq()}</td>
			<td class="td1"></td>
			<td class="td1">${b.getWriter()}</td>
			<td class="td1">${b.getRegDate()}</td>
			<td class="td1">${b.getCount()}</td>
			<td class="td1">${b.getCount()}</td>
			
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
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member List</title>
<link rel="stylesheet" type="text/css" href="/euns/css/w3.css">
<link rel="stylesheet" type="text/css" href="/euns/css/cls.css">
<script type="text/javascript" src="/euns/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="/euns/js/member.js"></script>
<style>
	h5, span {
		height: 20px;
		line-height: 30%;
	}
	.pdh10 > h5 {
		font-size: 10.5pt;
	}
</style>
</head>
<body>
	<form id="frm" encType="multipart/form-data">
		<input type="hidden" name="mno" id="mno">
	</form>

	<div class="w3-content w3-center mw700">
		<h1 class="w3-pink w3-card-4 w3-padding w3-margin-bottom">Member List</h1>
		<div class="w3-col w3-margin-top w3-margin-bottom w3-padding w3-border-bottom w3-border-grey">
<c:forEach var="data" items="${LIST}" varStatus="st">
			<div class="w3-col m3 pdh10">
	<c:if test="${COLOR.get(st.index) != 'w3-light-grey'}">
				<h5 class="w3-col w3-button ${COLOR.get(st.index)} w3-hover-light-green listBtn" id="${data.mno}">${data.name}</h5>
	</c:if>
	<c:if test="${COLOR.get(st.index) == 'w3-light-grey'}">
				<h5 class="w3-col w3-button ${COLOR.get(st.index)} w3-hover-light-green w3-border listBtn" id="${data.mno}">${data.name}</h5>
	</c:if>
			</div>
</c:forEach>			
		</div>
		<div class="w3-col" id="infobox" style="display: none;">
			<h2 class="w3-pink w3-card-4 w3-padding w3-margin-bottom"><span id="tname"></span> 회원 정보</h2>
			<div class="w3-col w3-margin-top w3-margin-bottom w3-padding w3-border-bottom w3-border-grey">
				<div class="w3-col">
					<div class="w3-col w250 pd10">
						<div class="w3-border infoAvtBox">
							<img src="" class="infoAvtBox" id="avt">
						</div>
					</div>
					<div class="w3-rest pdr10">
						<div class="w3-col w3-display-container contBox">
							<div class="w3-col w3-display-middle">
								<div class="w3-col w3-text-grey ft18px mh3"><span class="w3-third w3-right-align">회원번호 : </span><span class="w3-twothird w3-center" id="no"></span></div>
								<div class="w3-col w3-text-grey ft18px mh3"><span class="w3-third w3-right-align">회원이름 : </span><span class="w3-twothird w3-center" id="mname"></span></div>
								<div class="w3-col w3-text-grey ft18px mh3"><span class="w3-third w3-right-align">아 이 디 : </span><span class="w3-twothird w3-center" id="mid"></span></div>
								<div class="w3-col w3-text-grey ft18px mh3"><span class="w3-third w3-right-align">회원메일 : </span><span class="w3-twothird w3-center" id="mmail"></span></div>
								<div class="w3-col w3-text-grey ft18px mh3"><span class="w3-third w3-right-align">회원성별 : </span>
									<span class="w3-twothird w3-center" id="gen"></span>
								</div>
								<div class="w3-col w3-text-grey ft18px mh3"><span class="w3-third w3-right-align">가 입 일 : </span><span class="w3-twothird w3-center" id="jdate"></span></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
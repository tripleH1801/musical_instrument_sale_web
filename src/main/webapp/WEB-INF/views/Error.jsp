<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

    <title>Oops!</title>

    <!-- Google font -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,900" rel="stylesheet">

    <!-- Custom stlylesheet -->
    <link type="text/css" rel="stylesheet" href='<c:url value = "/static/assets/css/error.css"/>' />
    
</head>
<body>
	    <div id="notfound">
        <div class="notfound">
            <div class="notfound-404">
                <h1>Oops!</h1>
            </div>
            <h2>Đã xảy ra lỗi</h2>
            <a href='<c:url value ="/"/>'>Trờ về trang chủ</a>
        </div>
    </div>
</body>
</html>
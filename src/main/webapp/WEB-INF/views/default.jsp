<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%--<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"--%>
		<%--"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">--%>
<%--<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">--%>
<!DOCTYPE html/>
<html lang="ru">
	<head>
		<meta charset="utf-8" />
		<%--<link rel="stylesheet" type="text/css" href="/css/styles.css" />--%>
		<%--<spring:url value="/resources/css/kia.css" var="mainCss"/>--%>
		<%--<link href="${mainCss}" rel="stylesheet"/>--%>
		<spring:theme code="styleSheet" var="app_css"/>
		<spring:url value="/${app_css}" var="app_css_url"/>
		<link rel="stylesheet" type="text/css" href="${app_css_url}" media="screen"/>
		<title>ЗАО "КИА Системы". Внутренний портал компании</title>
	</head>
	<body>
		<%@ include file="/templates/header.jsp" %>
		<%@ include file="/templates/navbar.jsp" %>
		
		<div id = "main-content">
			<div class="container">
				<h3>Добро пожаловать!</h3>
				<p>
					Наш портал открылся, и мы рады приветствовать Вас на нем!
				</p>
			</div>
		</div>

	</body>
</html>
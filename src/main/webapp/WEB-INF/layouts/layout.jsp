<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html/>
<html lang="ru">
	<head>
		<meta charset="utf-8" />
		<spring:theme code="styleSheet" var="app_css"/>
		<spring:url value="/${app_css}" var="app_css_url"/>
		<link rel="stylesheet" type="text/css" href="${app_css_url}" media="screen"/>
		<title>ЗАО "КИА Системы". Внутренний портал компании</title>
	</head>
	<body>
		<tiles:insertAttribute name="header"/>
		<tiles:insertAttribute name="menu"/>
		<tiles:insertAttribute name="body"/>
		<tiles:insertAttribute name="footer" />
	</body>
</html>
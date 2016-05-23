<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/themes" var="showThemeUrl"/>
<div class="main-content">
        <div class="container">
            <h1>Список тем</h1>
            <a href="${showThemeUrl}/?form" class="btn theme-btn">Добавить тему</a>
            <c:if test="${not empty themes}">
                <table class="items-table">
                    <thead>
                    <tr>
                        <th>Название</th>
                        <th>Дата открытия</th>
                        <th>Дата закрытия</th>
                        <th/>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${themes}" var="theme">
                            <tr>
                                <td><a href="${showThemeUrl}/${theme.id}?form">${theme.title}</a></td>
                                <td>${theme.startDate}</td>
                                <td>${theme.closeDate}</td>
                                <td>
                                    <a href="${showThemeUrl}/delete/${theme.id}">
                                        <img class="btn delete-btn" src="<c:url value="/resources/imgs/delete_big.png"/>" width="25" height="25" alt="Удалить">
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
    </div>

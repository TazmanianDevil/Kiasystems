<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


    <div class="main-content">
        <div class="container">

            <h2>Тема</h2>
            <c:if test="${not empty message}">
                <div id="message" class="$message.type">${message.message}</div>
            </c:if>
            <table>
                <tr>
                    <th>Название темы</th>
                    <td>${theme.title}</td>
                </tr>
                <tr>
                    <th>Дата открытия</th>
                    <td>${theme.startDate}</td>
                </tr>
                <tr>
                    <th>Дата закрытия</th>
                    <td>${theme.closeDate}</td>
                </tr>
            </table>
        </div>
    </div>
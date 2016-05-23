<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<spring:eval expression="theme.id==null?'Создать новую тему':'Обновить тему'" var="formTitle"/>
    <div class="main-content">
        <div class="container">

            <h2>${formTitle}</h2>
            <form:form modelAttribute="theme" id="themeupdateForm" method="post">
                <c:if test="${not empty message}">
                    <div id="message" class="${message.type}">${message.message}</div>
                </c:if>
                <table>
                    <tr>
                        <th>
                            <form:label path="title">Название темы</form:label>
                        </th>
                        <td>
                            <form:input path="title"/>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            <form:label path="startDate">Дата открытия</form:label>
                        </th>
                        <td>
                            <form:input path="startDate" id="startDate"/>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            <form:label path="closeDate">Дата закрытия</form:label>
                        </th>
                        <td>
                            <form:input path="closeDate" id="closeDate"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <button type="submit">Сохранить</button>
                        </td>
                        <td>
                            <button type="reset">Сбросить</button>
                        </td>
                    </tr>
                </table>
                <div>
                    <form:errors cssClass="error" path="startDate"/>
                </div>
                <div>
                    <form:errors cssClass="error" path="closeDate"/>
                </div>
                <div>
                    <form:errors path="title" cssClass="error"/>
                </div>
            </form:form>
        </div>
    </div>
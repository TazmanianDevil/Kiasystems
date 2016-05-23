<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="menu">
    <div class="container">
        <nav class="main-menu">
            <ul>
                <li> <a href="#">Конструкторский отдел</a>
                    <ul class="constructor-menu">
                        <li><a href="#">Таблица учета номеров</a></li>
                        <li><a href="#">Архив</a></li>
                    </ul>
                </li>
                <li> <a href="#">Лаборатория систем управления</a>
                    <ul class="it-menu">
                        <li><a href="#">Учет СПО</a></li>
                        <li><a href="#">Меморандум</a></li>
                    </ul>
                </li>
                <li><a href="#">Другое</a></li>
            </ul>
        </nav>
    </div>
</div>
<%--<div id="navbar">--%>
    <%--<ul class="menu">--%>
        <%--<li> <a href="#">Конструкторский<br />отдел</a>--%>
            <%--<ul class="constructormenu">--%>
                <%--<li><a href="#">Таблица учета<br />номеров</a></li>--%>
                <%--<c:if test="${pageContext.request.isUserInRole('Admin')}">--%>
                    <%--<li><a href="#">Журнал таблицы учета<br />децимальных номеров</a></li>--%>
                <%--</c:if>--%>
            <%--</ul>--%>
        <%--</li>--%>
        <%--<li><a href="/Kiasystems">Отдел технического<br />контроля</a></li>--%>
        <%--<li><a href="/Kiasystems">Другое</a></li>--%>
    <%--</ul>--%>
<%--</div>--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<header class="main-header">
    <div class="container">
        <div class="logo">
            <img src="<c:url value="/resources/imgs/Kia_logo.png"/>" alt="Логотип компании КИА Системы"/>
        </div>
        <div class="login">
            <a href="#" class="btn btn-blue">Войти</a>
        </div>
    </div>
</header>

<%--<div id="wrapperHeader">--%>
    <%--<div id="header">--%>
        <%--<a href="http://www.kiasystems.ru/wordpress"><img id="logo" src="<c:url value="/resources/imgs/Kia_logo.png"/>" alt="Логотип компании КИА Системы"></a>--%>
        <%--<div id="headContact">--%>
            <%--<p id="headAddress">111024, г.Москва, 2-ая ул. Энтузиастов, д.5, корп.34 <br />Территория завода "Компрессор"</p>--%>
            <%--<p id="headPhone">+7 (495) 783-08-35</p>--%>
            <%--<p>--%>
                <%--<c:choose>--%>
                    <%--<c:when test='${empty pageContext.request.getRemoteUser()}'>--%>
                        <%--<a href="login2.jsp" class="addButton">Войти</a><br />--%>
                    <%--</c:when>--%>
                    <%--<c:when test='${not empty pageContext.request.getRemoteUser()}'>--%>
                        <%--<a href="logout.do" class="addButton">Выйти</a><br />--%>
                    <%--</c:when>--%>
                <%--</c:choose>--%>

                <%--<!--<c:if test='${empty pageContext.request.getRemoteUser()}'>--%>
						<%--</c:if>--%>
						<%--${not empty pageContext.request.getRemoteUser()} <br />--%>
						<%--<c:if test="${not empty pageContext.request.getRemoteUser()}">--%>
							<%--<a href="login.jsp" class="addButton">Выйти</a>--%>
						<%--</c:if>-->--%>

            <%--</p>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>

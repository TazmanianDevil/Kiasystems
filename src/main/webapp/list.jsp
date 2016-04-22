<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <%--<link rel="stylesheet" type="text/css" href="css/styles.css" />--%>
        <title>Kiasystem's page</title>
    </head>
    <body>
        <h3>Все пользователи:</h3>
    <ol>
        <c:forEach items="${themes}" var="theme">
            <li>
                    ${theme.title} ${theme.startDate}

            </li>
        </c:forEach>
    </ol>
    </body>

</html>
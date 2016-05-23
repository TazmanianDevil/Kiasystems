<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="main-content">
    <div class="container">
        <h2>Таблица учета децимальных номеров</h2>
        <c:if test="${pageContext.request.isUserInRole('Admin')}">
            <%--<a href="metricnumbers.edit" class="addbutton"/>Добавить</a>--%>
            <a href="#" class="addbutton"/>Добавить</a>
        </c:if>
        <table class="items-table">
            <tr>
                <th>Децимальный номер</th><th>Наименование</th><th>Примечание</th>
                <c:if test="${pageContext.request.isUserInRole('Admin')}">
                    <th></th><th></th>
                </c:if>
            </tr>
            <c:forEach var="metricNumber" items="${metricNumbers}" >
                <tr>
                    <td>
                        <%--<a id="tableLink" href="products.show?metricNumberId=${number.id}">${number.name}</a>--%>
                        <a href="#">${metricNumber.name}</a>
                    </td>
                    <td>${metricNumber.title}</td>
                    <td>${metricNumber.description}</td>
                    <c:if test="${pageContext.request.isUserInRole('Admin')}">
                        <td>
                            <%--<a href="metricnumbers.edit?id=${number.id}"><img id="editbutton" src="imgs/edit.gif" alt="Редактировать"></a>--%>
                                <a href="#"><img id="editbutton" src="imgs/edit.gif" alt="Редактировать"></a>
                        </td>
                        <td>
                            <%--<a href="metricnumbers.delete?id=${number.id}"><img id="deletebutton" src="imgs/delete_big.png" alt="Редактировать" width="24" height="24"></a>--%>
                            <a href="#"><img id="deletebutton" src="imgs/delete_big.png" alt="Редактировать" width="24" height="24"></a>
                        </td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
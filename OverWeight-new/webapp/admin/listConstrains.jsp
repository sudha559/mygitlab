<%@ include file="admin_header.jsp" %>

<div class="tbcenter">
<h3>User Constraints </h3>

<div class="datagrid">
    <table>
        <thead>
            <tr>
                <th>User Name</th>
                <th>Email</th>
                <th>Constrains</th>
<!--                 <th>Role</th> -->
<!--                 <th >Action</th> -->
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${constrains}" var="user">
                <tr>
                    <td><c:out value="${user.name}" /></td>
                    <td><c:out value="${user.email}" /></td>
                    <td><c:out value="${user.comments}" /></td>
<%--                     <td><a href="${pageContext.request.contextPath}/list_UserServelet?action=delete&userId=<c:out value="${user.userid}"/>">Delete</a></td> --%>
                </tr>
            </c:forEach>
        </tbody>
    </table>
 </div>
 </div>

<%@ include file="afooter.jsp" %>
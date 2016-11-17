<%@ include file="admin_header.jsp" %>

<div class="tbcenter">
<h3>User List</h3>

<div class="datagrid">
    <table>
        <thead>
            <tr>
                <th>User Id</th>
                <th>Name</th>
                <th>password</th>
                <th>Role</th>
                <th >Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td><c:out value="${user.userid}" /></td>
                    <td><c:out value="${user.name}" /></td>
                    <td><c:out value="******" /></td>
                    <td><c:out value="${user.role}" /></td>
                    <td><a href="${pageContext.request.contextPath}/list_UserServelet?action=delete&userId=<c:out value="${user.userid}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
 </div>
 </div>

<%@ include file="afooter.jsp" %>
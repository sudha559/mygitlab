<%@include file="doctor_header.jsp" %>

 
<div class="center">

<p><a href="${pageContext.request.contextPath}/course_Doctor?action=new">Add Course</a></p>

<div class="datagrid">
		<table>
			<thead>
				<tr>
<!-- 			    <th>Id</th> -->
                <th>Level</th>
                <th>Description</th>
                <th colspan=2>Action</th>
				</tr>
			</thead>
			<tfoot>
				<tr>
					<td colspan="4"><div id="no-paging">&nbsp;</div>
				</tr>
			</tfoot>
        <tbody>
            <c:forEach items="${listCources}" var="cource">
                <tr >
<%--                     <td><c:out value="${cource.id}" /></td> --%>
                    <td><c:out value="${cource.level}" /></td>
                    <td><c:out value="${cource.description}" /></td>
                    <td><a href="${pageContext.request.contextPath}/course_Doctor?action=view&Id=<c:out value="${cource.id}"/>">View</a></td>
                    <td><a href="${pageContext.request.contextPath}/course_Doctor?action=delete&Id=<c:out value="${cource.id}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    </div>
    </div>
    
 
 
<%@include file="footer.jsp" %>
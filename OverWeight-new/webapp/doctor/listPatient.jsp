<%@ include file="doctor_header.jsp" %>

<div class="center">


<h5>
		<span style="color: blue">${msg}</span>
	</h5>

<%-- <p><a href="${pageContext.request.contextPath}/assign_Patient?action=new">Add Patient</a></p> --%>

<div class="datagrid">
		<table>
			<thead>
				<tr>
			    <th>Patient Id</th>
                <th>Name</th>
                <th>phone Number</th>
                <th colspan=2>Action</th>
				</tr>
			</thead>
			<tfoot>
				<tr>
					<td colspan="4"><div id="no-paging">&nbsp;</div>
				</tr>
			</tfoot>
        <tbody>
            <c:forEach items="${patients}" var="patient">
                <tr class="alt">
                    <td><c:out value="${patient.pid}" /></td>
                    <td><c:out value="${patient.name}" /></td>
                    <td><c:out value="${patient.ph}" /></td>
                    <td><a href="${pageContext.request.contextPath}/list_Patients?action=view&PId=<c:out value="${patient.pid}"/>">View</a></td>
                    <td><a href="${pageContext.request.contextPath}/list_Patients?action=delete&PId=<c:out value="${patient.pid}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    </div>
    </div>
    

<%@ include file="dfooter.jsp" %>
<%@ include file="doctor_header.jsp" %>

<div class="tbcenter">
<h3>Waiting Patients List for Assigning</h3>
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
                    <%-- <td><a href="${pageContext.request.contextPath}/list_Patients?action=view&PId=<c:out value="${patient.pid}"/>">View</a></td>
                    <td><a href="${pageContext.request.contextPath}/list_Patients?action=delete&PId=<c:out value="${patient.pid}"/>">Delete</a></td> --%>
                    <td><a href="${pageContext.request.contextPath}/list_Patients?action=approvePatient&PId=<c:out value="${patient.pid}"/>">Assign</a></td>
                    <td><a href="${pageContext.request.contextPath}/list_Patients?action=deletePatient&PId=<c:out value="${patient.pid}"/>">Deny</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    </div>
    </div>
<%@ include file="dfooter.jsp" %>
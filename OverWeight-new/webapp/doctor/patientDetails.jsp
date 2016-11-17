<%@ include file="doctor_header.jsp" %>
	<div class="center">
	
	<!-- <p><a href="${pageContext.request.contextPath}/list_Patients?action=Level1&PID=${PID}">Enter Patient Report</a></p>-->
	
<%-- 	<p><a href="${pageContext.request.contextPath}/assign_Patient?action=Level1&PID=${PID}">Add Patient Report</a></p> --%>
	<h3>Patient Id:${PID}</h3>
	<div class="datagrid">
		<table>
			<thead>
				<tr>
			    <th>Level</th>
                <th>BP</th>
                <th>Sugar</th>
                <th>weight</th>
				</tr>
			</thead>
			<tfoot>
				<tr>
					<td colspan="4"><div id="no-paging">&nbsp;</div>
				</tr>
			</tfoot>
        <tbody>
            <c:forEach items="${patientDetails}" var="treatment">
                <tr class="alt">
                    <td><c:out value="${treatment.level}" /></td>
                    <td><c:out value="${treatment.bp}" /></td>
                    <td><c:out value="${treatment.sugar}" /></td>
                    <td><c:out value="${treatment.weight}" /></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    </div>
	</div>
	<div >
	<center>
	<h4>Patient Report in BarChart:</h4>
	<jsp:include page="patientBarChart.jsp?PID=${PID}"></jsp:include>
	</center>
	</div>
<%@ include file="dfooter.jsp" %>
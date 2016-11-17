<%@ include file="patient_header.jsp" %>

<div  class="center">
<h3>${PID}</h3>
<div class="datagrid">
 <table >
        <thead>
            <tr>
<!--                 <th>Patient Id</th> -->
				<th>Level</th>
				<th>Weight</th>
				<th>BMI</th>
                <th>BP</th>
                <th>Sugar</th>
                <!-- <th>Result</th>-->
                <th >Action</th> 
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${treatmentList}" var="treatment">
                <tr>
<%--                     <td><c:out value="${treatment.pid}" /></td> --%>
					<td><c:out value="${treatment.level}" /></td>
					<td><c:out value="${treatment.weight}" /></td>
					<td><c:out value="${treatment.bmi}" /></td>
                    <td><c:out value="${treatment.bp}" /></td>
                    <td><c:out value="${treatment.sugar}" /></td>
                    
                    
                    
                    <td><a href="${pageContext.request.contextPath}/treatment_Servelet?action=guidLines&Id=<c:out value="${treatment.id}"/> "> View Doctor Guide Lines</a></td>
                    
                </tr>
            </c:forEach>
        </tbody>
    </table>
    </div>
<%--     <p><a href="${pageContext.request.contextPath}/treatment_Servelet?action=nextLevel">next Level</a></p> --%>

<center>
	<h4>Patient Report in BarChart:</h4>
	<jsp:include page="patientBarChart.jsp?PID=${PID}"></jsp:include>
<%-- 	<%@ include file="patientBarChart.jsp?PID=${PID}" %>  --%>
<%-- <%@ include file="${pageContext.request.contextPath}/patient/patientBarChart.jsp?PID=${PID}" %> --%>
	</center>
</div>
<jsp:include page="pfooter.jsp"/>
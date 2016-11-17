 <%@ include file="patient_header.jsp" %>

	

<div class="acount_center">
		<center><h4>Account Details</h4></center>
	<hr>

	<h5>
		<span style="color: red">${msg}</span>
	</h5>
	<form method="POST" action="${pageContext.request.contextPath}/aboutMe?action=patient" class="fms" name="frmUpdatepatient">
		<table>
			<tr>
				 
				<td><input type="text" readonly="readonly" name="id" hidden="true"
					value="<c:out value="${patient.id}" />" /></td>
			</tr>
			<tr>
				<td>Patient RegisterId :</td>
				<td><input type="text" name="registerId" readonly="readonly"
					value="<c:out value="${patient.pid}"/>" /></td>
					<td><span  style="font-size:10px">It must start with 'P'. like: P00565</span></td>
			</tr>
			<tr>
				<td>Name :</td>
				<td><input type="text" name="name"
					value="<c:out value="${patient.name}" />" /></td>
					<td><span style="font-size:10px">Enter FName+LName</span></td>
			</tr>


			<tr>
				<td>Phone :</td>
				<td><input type="text" name="phone"
					value="<c:out value="${patient.ph}" />" /></td>
					<td><span  style="font-size:10px">Should be numeric[0-9]</span></td>
			</tr>
				<tr>
				<td>Password :</td>
				<td><input type="password" name="password"
					value="<c:out value="${patient.password}" />" /></td><%--
					<td><span  style="font-size:10px">Please enter Password</span></td> --%>
			</tr>
			<tr>
				<td>Confirm Password :</td>
				<td><input type="password" name="cpassword"
					value="<c:out value="${patient.password}" />" /></td>
					<td><span  style="font-size:10px">Should be match with Password</span></td>
			</tr>
			 
			<tr>
				<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td>
				<td><center><input type="submit" style="width: 80px;" value="Submit" /></center></td>
				
			</tr>
		</table>
	</form>
</div>
 

<jsp:include page="pfooter.jsp"/>

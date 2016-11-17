<%@ include file="doctor_header.jsp"%>

<div class="acount_center">
	<center><h4>AboutMe</h4></center>
	<h5>
	<hr>
		<span style="color: red">${msg}</span>
	</h5>
	<form method="POST" action='${pageContext.request.contextPath}/aboutMe?action=doctor' class="fms" name="frmUpdateDoctor">
		<table>
			<tr>
				 
				<td><input type="text" readonly="readonly" name="id" hidden="true"
					value="<c:out value="${doctor.id}" />" /></td>
			</tr>
			<tr>
				<td>RegisterId :</td>
				<td><input type="text" name="registerId" readonly="readonly"
					value="<c:out value="${doctor.REGISTERID}"/>" /></td>
					<td><span  style="font-size:10px">It must start with 'D'. like: D00565</span></td>
			</tr>
			<tr>
				<td>Name :</td>
				<td><input type="text" name="name"
					value="<c:out value="${doctor.NAME}" />" /></td>
					<td><span  style="font-size:10px">like: Josef</span></td>
			</tr>


			<tr>
				<td>Phone :</td>
				<td><input type="text" name="phone"
					value="<c:out value="${doctor.PHONE}" />" /></td>
				<td><span  style="font-size:10px"> like: 674900565</span></td>
			</tr>
			<tr>
			<td>Address :</td>
			<td><input type="text" name="address"
				value="<c:out value="${doctor.ADDRESS}" />" /></td>
			<td><span  style="font-size:10px">Please enter Address</span></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" name="password"
					value="<c:out value="${doctor.password}" />" /></td>
				<td><span  style="font-size:10px">Please enter Password</span></td>
			</tr>
			<tr>
				<td>Confirm Password :</td>
				<td><input type="password" name="cpassword"
					value="<c:out value="${doctor.password}" />" /></td>
				<td><span  style="font-size:10px">Should be match with Password</span></td>
			</tr>
			<tr>
				<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td>
				<td><center><input type="submit" style="width: 80px;" value="Submit" /></center></td>
			</tr>
		</table>
	</form>
</div>
<%@ include file="dfooter.jsp"%>

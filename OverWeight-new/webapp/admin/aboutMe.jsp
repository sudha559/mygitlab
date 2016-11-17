<%@ include file="admin_header.jsp"%>

<div class="acount_center">
<center><h4>About Me</h4></center>
<hr>
	<h5>
		<span style="color: red">${msg}</span>
	</h5>
	<form method="POST" action="${pageContext.request.contextPath}/aboutMe?action=admin" class="fms" name="frmUpdateAdmin">
		<table>
			<tr>
				<td>ID :</td>
				<td><input type="text" readonly="readonly" name="id"
					value="<c:out value="${user.id}" />" /></td>
			</tr>
			<tr>
				<td>UserId :</td>
				<td><input type="text" name="registerId" readonly="readonly"
					value="<c:out value="${user.userid}"/>" /></td>
			</tr>
			<tr>
				<td>Name :</td>
				<td><input type="text" name="name"
					value="<c:out value="${user.name}" />" /></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" name="password"
					value="<c:out value="${user.password}" />" /></td>
			</tr>
			<tr>
				<td>Confirm Password :</td>
				<td><input type="password" name="cpassword"
					value="<c:out value="${user.password}" />" /></td>
			</tr>

 			<tr>
				
				<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td>
				<td><center><input type="submit" style="width: 80px;" value="Submit" /></center></td>
			</tr>
		</table>
	</form>
</div>
<%@ include file="afooter.jsp"%>

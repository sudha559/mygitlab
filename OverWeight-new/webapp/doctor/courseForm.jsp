<%@include file="doctor_header.jsp" %>

 
<div class="center">
<div class="signin_center">
<h4>Course</h4>
<h5>
		<span style="color: red">${msg}</span>
	</h5>

	<form method="POST" action='course_Doctor?action=create' class="fms" name="frmUpdateDoctor">
		<table>
			 <tr><input name="id" hidden="true" value="${cources.id }"></tr>
			<tr>
				<td>Course :</td>
				<td><select name="level"  value="${cources.level}">
					  <option value="Level1">Level1</option>
					  <option value="Level2">Level2</option>
					  <option value="Level3">Level3</option>
					  <option value="Level4">Level4</option>
					  <option value="Level5">Level5</option>
					  
					  <option value="Level6">Level6</option>
					  <option value="Level7">Level7</option>
					  <option value="Level8">Level8</option>
					  <option value="Level9">Level9</option>
					  <option value="Level10">Level10</option>
					  
					</select>
				</td>
			</tr>
			 
			<tr>
				<td>Description:</td>
				<td><textarea rows="6" cols="50"  name="description"><c:out value="${cources.description }"/></textarea> </td>
<%-- 				<td><input name="description" value="<c:out value="${cources.description }"/>"></td> --%>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form>
</div>
</div>
<%@include file="dfooter.jsp" %>

 

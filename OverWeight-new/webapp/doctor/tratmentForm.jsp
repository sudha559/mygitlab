 <%@ include file="doctor_header.jsp" %>
 
 <div class="signin_center">
	<h4>Test Report Form:</h4>
	<h5>
		<span style="color: red">${msg}</span>
	</h5>
 
 
<form action="/treatment_Servelet?action=doctorEnter" method="post" class="fms">
	<table>

		<tr>
			<td><label>PatientID:</label></td>
			<td><input type="text" value="${PID}" id="patientId" readonly name="patientId"></td>
		</tr>
			<tr>
				<td>BP:</td>
				<td><input type="text" name="bp" value=""></td>
			</tr>
			<tr>
				<td>Sugar:</td>
				<td><input type="text" name="sugar" value=""></td>
			</tr>
			<tr>
				<td>Weight:</td>
				<td><input type="text" name="weight" value=""></td>
			</tr>	
			<tr>
				<td>BMI:</td>
				<td><input type="text" name="bmi" value=""></td>
			</tr>		 
		<tr>
			<td>&nbsp;</td>
			<td class="right"><button type="submit" value="Register">Submit</button>
			</td>
		</tr>
	</table> 
</form>

<form action="" class="sidefm">
</form>
 
 </div>
 
 <%@ include file="dfooter.jsp" %>
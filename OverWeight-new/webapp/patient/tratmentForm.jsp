<%@ include file="patient_header.jsp" %>
<br><br>
<div class="tr_center">
<center>
	<h4>Treatment Form:</h4></center>
	
	<hr>
		<span style="color: red">${msg}</span>
	<form action="${pageContext.request.contextPath}/treatment_Servelet?action=create" method="post" class="fms">
		<table>
			<tr>
				<td>Treatment Level:</td>
				<td><select name="level" value="">
				<option>Level1</option>
				<option>Level2</option>
				<option>Level3</option>
				<option>Level4</option>
				</select>
				</td>
				<td><span  style="font-size:14px">Select the Treatment level</span></td>
			</tr>
			<tr>
				<td>BP*:</td>
				<td><input type="text" name="bp" value="${bp }" pattern="[\d]*/[\d]*" placeholder="ex: 130/40" required></td>
				<td><span  style="font-size:14px">[0-9]/[0-9]</span></td>
			</tr>
			<tr>
				<td>Sugar*:</td>
				<td><input type="number" name="sugar" value="${sugar}" placeholder="ex: 220" required></td>
				<td><span  style="font-size:14px">Should be numeric</span></td>
			</tr>
			<tr>
				<td>Weight*:</td>
				<td><input type="number" name="weight" value="${weight}" placeholder="ex: 150" required></td>
 			 <td><span  style="font-size:14px"> enter Weight in Pounds</span></td>
			</tr>
			<tr>
				<td>BMI:</td>
				<td><input type="number" name="bmi" value="${bmi}" placeholder="ex: 35" required></td>
				<%--<td><span  style="font-size:14px">Please enter BMI</span></td> --%>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>
					<button type="submit" value="Submit">Submit</button>
					<button type="reset" value="Reset">Clear</button>
				</td>
			</tr>
		</table>
	</form>	
	
</div>
<%@ include file="pfooter.jsp" %>

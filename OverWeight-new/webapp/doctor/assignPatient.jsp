<%@ include file="doctor_header.jsp" %> 

<div class="ap_center">
<center><h1>Patient Details </h1></center>
<h5>
		<span style="color: red">${msg}</span>
	</h5>
<form action="assign_Patient" method="post" class="fms">
	<table>

		<tr>
			<td><label>PatientID*:</label></td>
			<td><input type="text" value="${patientId}" id="patientId"  name="patientId" placeholder="ex:P0001"></td>
			<td><span style="font-size:10px">Please enter PatientId,Must be start's with 'P'</span></td>
		</tr>

		<tr>
			<td><label>Patient Name*:</label></td>
			<td><input type="text" value="" id="name" name="name" placeholder="ex:Jon"></td>
			<td><span style="font-size:10px">Please enter name</span></td>
		</tr>
		<tr>

			
			 <td>Gender*:</td>
				<td><select name="sex" >
					  <option value="Men">Men</option>
					  <option value="Women">Women</option>
					  <option value="Others">Others</option>
					</select>
				</td>
				<td><span style="font-size:10px">Please select patient gender</span></td>
			    
		</tr>
		 
		<tr >
			<td>&nbsp;</td>
			<td class="right"><button type="submit" value="Register">Assign</button><button type="reset" value="Reset">Clear</button></td>
		</tr>
	</table> 
</form>
 
 
 
</div>
</div>
</div>
 
<%@ include file="dfooter.jsp" %>
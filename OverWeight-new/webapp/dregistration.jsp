 <%@ include file="header.jsp" %>
 
 
<div class="fm_center">
		<center><h3>Enter Doctor Details:</h3></center>
 <hr>
<span style="color:red">${msg}</span>
<form action="register_Doctor" method="post" class="fms">
	<table>
		<tr>
			<td><label class="right">RegisterID*:</label></td>
			<td><input type="text" value="${registerId }" id="registerId" name="registerId" placeholder="Please enter Doctor RegisterID" required></td>
			
			<td ><label class="right">Name*:</label></td>
			<td><input type="text" value="${dname }" id="dname" placeholder="Ex:Josef" name="dname" required></td>
			
		</tr>
		
		<tr>
			<td>&nbsp;</td>
			<td><span  style="font-size:14px">It must start with 'D'. like: D00565</span></td>
			<td>&nbsp;</td>
			<td><span  style="font-size:14px">Enter only characters[A-Z or a-z]</span></td>
		</tr>
		<tr height="10"> </tr>
		<tr>
			<td align="right"><label>Best way to Contact*:</label></td>
				<td><input type="text" value="${ph }" id="ph" name="ph" placeholder="Ex:6300556565" required></td>
			<td><label class="right">Email:</label></td>
			<td><input type="email" value="${email }" id="email" name="email" placeholder="Ex:abc@gmail.com" required></td>
			
		</tr>


		<tr>
			<td>&nbsp;</td>
			<td><span  style="font-size:14px">It should be numeric[0-9].</span></td>
			<td>&nbsp;</td>
			<td><span  style="font-size:14px">[Like *@*.*]</span></td>
		</tr>
		<tr height="10"> </tr>
		<tr>
			<td><label class="right">Address1:</label></td>
			<td><input type="text"  value="${address }"   id="address" name="address" placeholder="Address1" ></td>
		
			<td><label class="right">Address2:</label></td>
			<td><input type="text"  value="${address2 }"   id="address2" name="address2" placeholder="Address2"></td>
			
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td><span  style="font-size:14px">Enter street </span></td>
			<td>&nbsp;</td>
			<td><span  style="font-size:14px">Enter city </span></td>
		</tr>
		<tr height="10"> </tr>
		<tr>
				<td><label class="right">State*:</label></td>
				<td><input type="text" value="${state }" id="state" name="state" placeholder="ex:NY" required></td>
				
				<td><label class="right">Zipcode*:</label></td>
				<td><input type="text" value="${zipcode }" id="zipcode" name="zipcode" placeholder="Ex: 06825" required></td>
				
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td><span  style="font-size:14px">Enter State Code</span></td>
			<td>&nbsp;</td>
			<td><span  style="font-size:14px"></span></td>
		</tr>
		<tr height="10"> </tr>
		 

		<tr >
			<td>&nbsp;</td>
			<td colspan="2" ><button type="submit" value="Register">Register</button><button type="reset" value="Reset">Clear</button>
			
			</td>
		</tr>
	</table> 
</form>
<hr>
<span>Note:   All * symbols are mandatory</span>
	</div>
 
 
<%@ include file="footer.jsp" %>
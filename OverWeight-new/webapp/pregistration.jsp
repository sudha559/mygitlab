
<%@ include file="header.jsp" %>

<c:set var="sxp" scope="session" value=""/>

<script type="text/javascript">

$(document).ready(function() {

	/* $('#exp').change(function(event) {
	        var expD = $("select#exp").val();
	        $.get('filterDoctorServlet', {
	        	expD : expD
	        }, function(response) {

	        var select = $('#doctor');
	        select.find('option').remove();
	          $.each(response, function(index, value) {
	        	  
	          $('<option>').val(value.REGISTERID).text(value.NAME).appendTo(select);
	      });
	        });
	        });
	}); */
	
	
</script>


<div class="fm_center">
	<center><h3>Enter Patient Details:</h3></center>
	<hr>
		<span style="color: red">${msg}</span>
	<form action="register_Patient" method="post"  class="fms">
		<table>
			<tr>
				<td><label class="right">PatientID*:</label></td>
				<td><input type="text" value="${PID }" id="PID" name="PID" placeholder="ex: P065" required></td>
			 
				<td><label class="right" style="padding-left: 10px">Name*:</label></td>
				<td><input type="text" value="${uname}" id="uname" name="uname" placeholder="Ex:Jonf" required>
			</td>
			</tr>
			<tr>
			<td>&nbsp;</td>
			<td><span style="font-size:14px">Like "P followed by[A-Z/a-z/0-9]</span></td>
			<td>&nbsp;</td>
			<td><span style="font-size:14px">Enter only characters[A-Z or a-z]</span></td>
			</tr>
			<tr height="10"> </tr>
			<tr>
			<td><label class="right">DOB*:</label></td>
			<td> <input type="date" name="dob" id="dob"  placeholder=" ex: 11/20/1980" required
           			 value="<fmt:formatDate pattern="MM/DD/YYYY" value="${dob}" />" />
            </td>
				<td><label class="right">Best way to Contact*:</label></td>
				<td><input type="text" value="${ph }" id="ph" name="ph" placeholder="Ex:6300556565" required></td>
			</tr>
			<tr>
			<td>&nbsp;</td>
			<td><span style="font-size:14px">Follow this format: mm/dd/yyyy</span></td>
			<td>&nbsp;</td>
			<td><span  style="font-size:14px">like[0-9]followed by [0-9]</span></td>
			</tr>
			<tr height="10"> </tr>
			<tr>
				<td><label class="right" >State*:</label></td>
				<td><input type="text" value="${state }" id="state" name="state" placeholder="New York" required></td>
				<td><label class="right" style="padding-left: 10px">Zipcode*:</label></td>
				<td><input type="text" value="${zipcode }" id="zipcode" name="zipcode" placeholder="ex: 06825" required></td>
			</tr>
			<tr>
			<td>&nbsp;</td>
			<td><span  style="font-size:14px">Enter State Name</span></td>
			<td>&nbsp;</td>
			<td><span  style="font-size:14px"></span></td> 
			</tr>
			<tr height="10"> </tr>

		<!-- 	<tr>
				<td><label class="right">Password:</label></td>
				<td><input type="password" value="" id="upsw" name="upsw" placeholder="Password">
				</td>
				<td><label class="right" style="padding-left: 10px">ConfirmPassword:</label></td>
				<td><input type="password" value="" id="cupsw" name="cupsw" placeholder="Confirm Password">
				</td>
			</tr>
			<tr>
			<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>
			<td><span  style="font-size:14px">Match with password</span></td>
			<td>&nbsp;</td>
			<td><span  style="font-size:14px"></span></td> 
			</tr>
			 -->
			
			<tr>
				 
				<td><label class="right" style="padding-left: 10px">Select Your Doctor:</label></td>
				<td><select name="doctor" id="doctor"  required>
				<c:forEach items="${doctors}" var="d">
	            		  <option value="${d.REGISTERID }">${d.NAME}-${d.REGISTERID }</option>
	        		</c:forEach>
				</select>
				</td>
			</tr>
			<tr>
			<td>&nbsp;</td>
			<td><span  style="font-size:14px">Select one Doctor</span></td>
			<td>&nbsp;</td>
			<td><span  style="font-size:14px">&nbsp;</span></td>
			<td>&nbsp;</td>
			<td><span  style="font-size:14px"></span></td> 
			</tr>
			
			
			<tr height="10"> </tr>
			<tr>
				<td>&nbsp;</td>
				<td colspan="2">
				<center>
					<button type="submit" value="Registration">Registration</button>&nbsp;&nbsp;
					<button type="reset" value="Reset">Clear</button>&nbsp;&nbsp;
					</center>
				</td>
				<td>&nbsp;</td>
			</tr>
		</table>
	</form>
	<hr>
<span>Note:   All * symbols are mandatory</span>
</div>

<%@ include file="footer.jsp" %>
<%@ include file="header.jsp" %>

 
<br><br><br><br>
<div class="signin_center">

<c:if test="${empty ut || ut =='2'}">
<center><h2><u>Patient Details</u></h2></center>
</c:if>
<c:if test="${ut =='1'}">
<center><h2><u>Create password</u></h2></center>

</c:if>

<form action="servlet_login" method="post" class="fms">
<table>
<tr>
<td>
<label>PatientID:</label>
</td>
<td>
<input type="text" value="${uname }"  id="uname" ${rd} name="uname" title="" required>
</td>
<td><span style="font-size:14px">Please enter PatientId</span></td>

</tr>
 <c:if test="${uname!=null }">
<tr>
<td>
<label>Password:</label>
</td>
<td>
<input type="password" value="" id="upsw" name="upsw" required>
</td> 
</tr>
<c:if test="${ut=='1' }">
<tr>
<td><label class="right">ConfirmPassword*:</label></td>
			<td><input type="password" value="" id="cdpsw" name="cdpsw" placeholder="Confirm Password" required></td>
</tr>
</c:if>
</c:if>

<tr>
<td>
  <input type="text" name="type" value="Patient" hidden="true">
  </td>
  
  </tr>
<tr>
 <td>&nbsp;</td>
<td  class="right">
<!-- <input type="submit" value="login" class="loginc"> -->
<button type="submit"  value="login">Submit</button>&nbsp;&nbsp;
</td>
</tr>
</table> 
</form>
<h5 ><span style="color:red">${msg}</span></h5>
</div>

<%@ include file="footer.jsp" %>
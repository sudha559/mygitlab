<%@ include file="header.jsp" %>
<br><br><br><br>

<div class="signin_center">
<center><h2> <u>Sign Up as Doctor</u></h2></center>

<form action="/register_Doctor?action=signup" method="post" class="fms">
<table>
<tr>
<td>
<label>DoctorID:</label>
</td>
<td>
<input type="text" value="" id="registerId" name="registerId" title="">
</td>
<td><span style="font-size:14px">Enter RegisteredId</span></td>

</tr>
 
<tr>
<td>
<label>Password:</label>
</td>
<td>
<input type="password" value="" id="dpsw" name="dpsw">
</td><%--
<td><span style="font-size:14px">Please enter password</span></td> --%>
</tr>
<tr>
<tr>
<td>
<label>Confirm Password:</label>
</td>
<td>
<input type="password" value="" id="cdpsw" name="cdpsw">
</td> 
<td><span style="font-size:14px">Should be match with Password</span></td> 
</tr>
<tr>
<td>
  <input type="text" name="type" value="Doctor" hidden="true">
  
  </td>
  
  </tr>
 <tr>
 <td>&nbsp;</td>
<td  class="right">
<!-- <input type="submit" value="login" class="loginc"> -->
<button type="submit"  value="login">Login</button>&nbsp;&nbsp;
</td>
</tr>
</table> 
</form>
<h5 ><span style="color:red">${msg}</span></h5>
</div>

 <br><br><br>
<%@ include file="footer.jsp" %>
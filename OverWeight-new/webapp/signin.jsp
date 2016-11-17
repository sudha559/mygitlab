<%@ include file="header.jsp" %>
<br><br><br><br>

<div class="signin_center">
<h2><center>Admin Details</center></h2>

<form action="servlet_login" method="post" class="fms">
<table style="align:center">
<tr>
<td style="margin-left:20px">
<label>AdminID:</label>
</td>
<td>
<input type="text" value="" id="uname" name="uname" required title="">
</td><%--
<td><span style="font-size:14px">Enter Registered Id</span></td>
  --%>
</tr>
 
<tr>
<td>
<label>Password:</label>
</td>
<td>
<input type="password" value="" id="upsw" required name="upsw">
</td><%--
<td><span style="font-size:14px">Please enter password</span></td> --%>
</tr>
<tr>
<td>
  <input type="text" name="type" value="Admin" hidden="true">
  </td>
  
  </tr>
 
<tr>
<td>&nbsp;</td>
<td  class="right">
<!-- <input type="submit" value="login" class="loginc"> -->
<button type="submit"  value="login">Submit</button>&nbsp;&nbsp;

</td>
<!-- <td><INPUT TYPE="button" VALUE="Back" class="loginc"  onClick="history.go(-1);"></td> -->
</tr>
</table> 
</form>
<h5 ><span style="color:red">${msg}</span></h5>
</div>

<br><br><br>
<%@ include file="footer.jsp" %>
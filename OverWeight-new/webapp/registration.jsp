 <jsp:include page="header.jsp"></jsp:include> 
<div class="signin_center">

<center><h2> Registration </h2></center>

<%--form --%>
<form action="switch_registration" method="post" class="fms">
<table>
 
<tr>
<td>
<%--radio buttons --%>
  <input type="radio" name="type" value="Doctor">
  </td>
  <td>
   Doctor<br>
  </td>
  </tr>
<tr>
  <td>
  <input type="radio" name="type" value="Patient"> 
  </td>
  <td>
  Patient<br>
  </td>
  </tr>
 
<tr>
<td>&nbsp;</td>
<td>
<input type="submit" value="Start Registration">
</td>
</tr>
</table> 
</form>

</div>
<jsp:include page="footer.jsp"></jsp:include>
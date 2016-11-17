<%@ include file="doctor_header.jsp" %>
 
 <div class="format" style="margin-left:32px;margin-right:50px;text-align:justify;">
  
<!-- <td colspan="3" align="left" style="vertical-align: top; text-align: left;"> -->
<b>${msg}</b>
<center><h3>Constrains</h3></center>
<div class="constrains">


<form action="${pageContext.request.contextPath}/servlet_constrains" method="post" class="fms">

<table align="center">
<tr>
<td>
Name:</td>
<td><input type="text" name="name">
</td>
</tr>
<tr>
<td>
Email:</td>
<td><input type="email" name="email"></td>
</tr>
<tr>
<td>
Your Message:</td>
<td><textarea rows="4" cols="50" name="comment" placeholder="Please enter your suggestion[max 50 words.]"></textarea></td>
 </tr>
 <tr>
	<td colspan="2" align="center">
		<button type="submit" value="Submit">Submit</button>&nbsp;&nbsp;
		<button type="reset" value="Reset">Clear</button>&nbsp;&nbsp;
	</td>
</tr>
</table>
</form>


<center><h3>Contact Details</h3></center>
<center>
<div style="align:center;">
<!-- <div id="content"> -->
<div class="contact">
	 <p align="center">
	  		<b>Role: UI Designer<br>
	  		Name: Nallola Ritesh Rao<br>
			Email:nallolar@mail.sacredheart.edu</b>
 	</p>
	</div>
 <div class="contact">
	<p align="center">
	        <b>Role: DB Admin<br>
	  		Name: Maram Sudhakar Reddy<br>
			Email:marams@mail.sacredheart.edu</b>
	  		
 	</p>
	</div>
 <div class="contact">
	  		<p align="center">
	  		<b>Role:  Programmer<br>
	  		Name:  Paleti Lakshmi Thrisunamba<br>
			Email: paletil@mail.sacredheart.edu</b>
 	</p>
	</div>
	</div>
	</center>
	<br><br><br><br>
	<br>
 <%--<center><h3>Address</h3></center> --%>
<center>
<h4>SACREDHEART UNIVERSITY, 5151 Park Ave, Fairfield,CT 06825</h4>
</center>
 </div>
 
  <%@ include file="dfooter.jsp" %>
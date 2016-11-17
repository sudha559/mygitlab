<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Welcome to  Overweight Monitoring & Diagnosis system</title>

      <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/custom.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/table.css">
    
</head>

<body>
  <div class="container">
<center>
 <h1 style="align:center;font-size:45px">Overweight Monitoring & Diagnosis system</h1></center>
   
 
<nav id="navigation">
 
       <ul>
        
               
            <li>    <a  href="${pageContext.request.contextPath}/patient/Patient.jsp" id="">Home</a></li>
            <li>    <a  href="${pageContext.request.contextPath}/patient/aboutUs.jsp" id="">AboutUs</a></li>
            <li>    <a  href="${pageContext.request.contextPath}/patient/patient_contactus.jsp" id="">ContactUs</a></li>
            <li>    <a  href="${pageContext.request.contextPath}/patient/tratmentForm.jsp" id="">Request For New Treatment</a></li>
            <li>    <a  href="${pageContext.request.contextPath}/patient/treatment.jsp" id="">View Records</a> </li>
            <ul style="float:right;list-style-type:none;">
    			<li><a  href="${pageContext.request.contextPath}/aboutMe">My Account</a></li>
    			<li><a href="${pageContext.request.contextPath}/index.jsp">LogOff</a></li>
  		</ul>
        </ul>
    </nav>
	
     
 
        <div class="col-xs-10">
            <!-- Main content -->
            <div class="content container">
            </div>
        </div>
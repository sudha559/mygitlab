<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Welcome.. </title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/custom.css">
</head>

<body>
 
 <div class="container">
 <center>
 <h1 style="align:center;font-size:40px">Overweight Monitoring & Diagnosis</h1>
</center>

 <nav id="navigation">
 
       <ul>
        
            <li><a  href="${pageContext.request.contextPath}/index.jsp" id="content">Home</a></li>
            <li><a  href="${pageContext.request.contextPath}/aboutus.jsp" id="content">AboutUs</a></li>
            <li><a  href="${pageContext.request.contextPath}/contactus.jsp" id="content">ContactUs</a></li>
            
          
            <ul style="float:right;list-style-type:none;">
            <li>  <a href="#">SignIn as  &#9662;</a>
            <ul class="dropdownMenu">
             <li><a href="${pageContext.request.contextPath}/signin.jsp">Admin </a></li>
                <li><a href="${pageContext.request.contextPath}/signinDoctor.jsp">Doctor </a></li>
                <li><a href="${pageContext.request.contextPath}/signinPatient.jsp">Patient </a></li>
            </ul>
            </li>
    			<li><a href="#">Registration &#9662;</a>
    			<ul class="dropdownMenu">
<!-- 	                <li><a href="${pageContext.request.contextPath}/registration.jsp">Admin </a></li> -->
	                <li><a href="${pageContext.request.contextPath}/dregistration.jsp">Doctor </a></li>
	                <li><a href="${pageContext.request.contextPath}/register_Patient">Patient </a></li>
	            </ul>
    			</li>
  			</ul>
        </ul>
    </nav>
     
 
	
 
        <div class="col-xs-10">
            <!-- Main content -->
            <div class="content container">
            
            </div>
        </div>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Welcome to  Overweight Monitoring & Diagnosis</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/custom.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/table.css">

  
</head>

<body>
 <div class="container">
<center>
 <h1 style="align:center;font-size:45px">Overweight Monitoring & Diagnosis</h1></center>
  
	<nav id="navigation">
 
          <ul>
        
            <li>    <a  href="${pageContext.request.contextPath}/admin/Admin.jsp" id="">Home</a></li>
            <li>    <a  href="${pageContext.request.contextPath}/admin/aboutUs.jsp" id="">AboutUs</a></li>
            <li>  <a href="#">Manage Users  &#9662;</a>
            <ul class="dropdownMenu">
            <li>   <a  href="${pageContext.request.contextPath}/admin/manageusers.jsp" id="">List Users</a>
            </li>
            <li>  <a  href="${pageContext.request.contextPath}/list_UserServelet?action=unapprovedlistUser" id="">Un-approved Users</a></li>
            </ul>
            </li>
            <li>    <a  href="${pageContext.request.contextPath}/servlet_constrains" id="">Constrains</a></li>
          
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
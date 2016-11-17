<%@ include file="patient_header.jsp" %>

 
<div class="center">
<c:if test="${doctorTreatment=='Level1'}">
	<jsp:include page="/treatment/level1.jsp"></jsp:include>
</c:if>
<c:if test="${doctorTreatment=='Level2'}">
	<jsp:include page="/treatment/level2.jsp"></jsp:include>
</c:if>
<c:if test="${doctorTreatment=='Level3'}">
	<jsp:include page="/treatment/level3.jsp"></jsp:include>
</c:if>
<c:if test="${doctorTreatment=='Level4'}">
	<jsp:include page="/treatment/level4.jsp"></jsp:include>
</c:if>

 </div>

 
<%@ include file="pfooter.jsp" %>
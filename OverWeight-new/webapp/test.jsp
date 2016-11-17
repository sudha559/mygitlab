<!DOCTYPE html>
<html lang="en">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<head>
    <script src="../js/jquery-1.8.1.min.js"></script>
</head>
<body>
    <c:set var="authors" value="aaa,bbb,ccc,ddd,eee,fff,ggg" scope="application" />
    <c:out value="Before : ${param.Author}"/>
    <form action="TestSelect.action">
        <label>Author
            <select id="Author" name="Author">
                <c:forEach items="${fn:split(authors, ',')}" var="author">
                    <option value="${author}" ${author == param.Author ? 'selected' : ''}>${author}</option>
                </c:forEach>
            </select>
        </label>
        <button type="submit" value="submit" name="Submit"></button>
        <Br>
        <c:out value="After :   ${param.Author}"/>
    </form>
</body>
</html>
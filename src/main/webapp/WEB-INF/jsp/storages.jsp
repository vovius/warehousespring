<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table>
  <c:set var="i" value="0" />
  <c:forEach var="storage" items="${storages}">
	  <tr>
	    <td><c:out value="${i}" /><c:set var="i" value="${i+1}" />&nbsp;&nbsp;&nbsp;<c:out value="${storage.name()}" /></td>
	  </tr>
  </c:forEach>
</table>  

</body>
</html>
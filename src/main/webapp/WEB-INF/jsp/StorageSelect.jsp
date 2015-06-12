<%@ page import="java.util.List" %>
<%@ page import="com.dio.javamentoring.warehouse.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Storage selection</title>
</head>
<body>
<form action="StorageAction.html" method="post">
	The following storage(s) are initialized:<br/>
	<table>
	  <c:forEach var="item" items="${storageFactory.storages}" varStatus="status">
	    <tr>
	      <td><input type="radio" name="storages" id="${item.type}" value="${item.type}" ${item.type == storageWebState.storageSelected ? 'checked' :''} /><c:out value="${item.type}" /></td>
	    </tr> 
	   </c:forEach>
	   <tr>
	    <td><input type="submit" value="Next ->" /></td>
	   </tr>
	</table>
</form>


<h5>Period 1: ${lifeCounter1.lifePeriod}</h5>
<h5>Period 2: ${lifeCounter2.lifePeriod}</h5>
<h5>Period 3: ${lifeCounter3.lifePeriod}</h5>
<h5>Period 4: ${lifeCounter4.lifePeriod}</h5>

</body>
</html>
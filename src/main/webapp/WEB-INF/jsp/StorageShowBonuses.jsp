<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bonuses</title>
</head>
<body>

<fmt:parseNumber var="itemId" value="${param['storageItemId']}" />
<c:set var="item" value="${storageWebState.currentStorage.getItemById(itemId)}"></c:set>
Bonuses for the item:&nbsp;<c:out value="${item}" />


<table>
	<c:forEach items="${bonusList}" var="bonus">
	  <tr>
	  <td><input type="checkbox" name="bonuses" id="${bonus}" value="${bonus}" ${item.bonusList.contains(bonus) ? 'checked' : ''} ></td>
	  <td><c:out value="${bonus}"></c:out></td>
	  </tr>
	</c:forEach>
</table>

</body>
</html>

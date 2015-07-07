<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="bt" uri="/WEB-INF/bonusestags.tld"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bonuses</title>
</head>
<body>

<fmt:parseNumber var="itemId" value="${param['storageItemId']}" />
<c:set var="item" value="${storageWebState.currentStorage.getItemById(itemId)}" /><br/>
Bonuses for the item:&nbsp;<c:out value="${item}" /><br/>
Bonus list size:&nbsp;<c:out value="${item.bonuses.size()}" /><br/>

<c:choose>
  <c:when test="${'UpdateBonusList' eq param['action']}">
    <bt:UpdateBonuses tvItem="${item}" bonusName="${param['bonusName']}" action="${item.getBonusByName(param['bonusName']) != null ? 'remove' : 'add'}" />
  </c:when>
  <c:when test="${'Close' eq param['action']}">
    <jsp:forward page="/WEB-INF/jsp/StorageAction.jsp" />
  </c:when>
</c:choose>


<c:forEach items="${item.bonuses}" var="bonus">
  <c:out value="${bonus}" /><br/>
</c:forEach>

<table>
	<c:forEach items="${bonusList}" var="bonus">
	  <tr>
	  <td>
	    <form action="StorageShowBonuses.html" method="get">
	      <input type="checkbox" name="bonuses" id="${bonus}" value="${bonus}" ${item.getBonusByName(bonus) != null ? 'checked' : ''} onclick="submit();" />
        <input type="hidden" name="bonusName" value="${bonus}" id="${bonus}" />
	      <input type="hidden" name="action" value="UpdateBonusList" id="${bonus}" />
        <input type="hidden" name="storageItemId" value="${param['storageItemId']}" />
	    </form>
	  </td>
	  <td><c:out value="${bonus}"></c:out></td>
	  </tr>
	</c:forEach>
</table>

<form action="StorageAction.html">
  <input type="submit" name="action" value="Close" />
  <input type="hidden" name="storages" value="${storageWebState.currentStorage.type}" />
</form>

</body>
</html>

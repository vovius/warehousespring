<%@ page import="java.util.List" %>
<%@ page import="com.dio.javamentoring.warehouse.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="sat" uri="WEB-INF/storageactiontags.tld"%>
<%@ taglib uri="http://www.vova.com/storagefunctions" prefix="sfn" %>

<c:if test="${param['storages'] != null}">
  <c:set target="${storageWebState}" property="storageSelected" value="${param['storages']}" />
</c:if>
 
 <c:choose>
  <c:when test="${'Delete' eq param['action']}"><sat:Delete id="${param['deleteId']}" /></c:when>
  <c:when test="${'SaveStorage' eq param['action']}"><sat:SaveStorage storageWebState="${storageWebState}" /></c:when>
</c:choose>
 
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Storage Action Selection</title>
</head>
<body>
Storage <c:out value="${storageWebState.storageSelected}" /> has been selected<br/>
Content:<br/>

<table>
  <c:forEach var="item" items="${storageWebState.currentStorage.storageList}" varStatus="status">
    <tr>
      <td><c:out value="${item}" /></td>
      <td><form action="StorageItemMaintain.jsp" method="get"><input type="submit" name="action" value="Edit" id="${item.id}" /><input type="hidden" value="${item.id}" name="editId" /></form></td>
      <td><form action="StorageAction.jsp" method="get"><input type="submit" name="action" value="Delete" id="${item.id}"/><input type="hidden" value="${item.id}" name="deleteId" /></form></td>
      <td><c:out value="${fn:length(item.description)}" /></td>
      <td><c:if test="${item.description != null}"><c:out value="${fn:length(fn:split(item.description,' '))}" /></c:if></td>
      <td><c:if test="${item.description != null}"><c:out value="${sfn:isPalindrom(item.description)}" /></c:if></td>
    </tr> 
   </c:forEach>
</table>
	
<form action="StorageItemMaintain.jsp" method="get">
	<input type="submit" value="Add new item ->" />
</form>	

<form action="StorageAction.jsp" method="post">
  <input type="submit" name="action" value="SaveStorage" />
</form>


<form action="StorageSelect.jsp" method="post">
  <input type="submit" value="<- Back" />
</form>

</body>
</html>
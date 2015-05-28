<%@page import="com.dio.warehousespring.*"%>
<%@ page import="com.dio.javamentoring.warehouse.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sat" uri="/WEB-INF/storageactiontags.tld"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><c:out value="${param['action']}"></c:out></title>
<script src="datetimepicker_css.js"></script>
</head>
<body>

<c:choose>
  <c:when test="${'SaveNClose' eq param['action']}">
    <fmt:parseDate value="${param['dateMade']}" var="parsedDateMade" pattern="MM/dd/yyyy" /> 
    <jsp:useBean id="item" class="com.dio.javamentoring.warehouse.TV">
      <jsp:setProperty name="item" property="id" value="${param['id']}"/>
      <jsp:setProperty name="item" property="brand" value="${param['brand']}"/>
      <jsp:setProperty name="item" property="diagonal" value="${param['diagonal']}"/>
      <jsp:setProperty name="item" property="matrixType" value="${param['matrixType']}"/>
      <jsp:setProperty name="item" property="dateMade" value="${parsedDateMade}"/>
      <jsp:setProperty name="item" property="description" value="${param['description']}"/>
    </jsp:useBean>
    <sat:SetItem item="${item}" storageWebState="${storageWebState}" />
    <jsp:forward page="StorageAction.jsp"></jsp:forward>
  </c:when>
  <c:when test="${'Close' eq param['action']}">
    <jsp:forward page="StorageAction.jsp"></jsp:forward>
  </c:when>
</c:choose>

<form action="StorageItemMaintain.jsp">
<table>
  <tr id="id">
    <td>id:</td><td>${param['editId']}<input type="hidden" name="id" value="${param['editId']}" /></td>
  </tr>
  <tr>
    <td>brand:</td><td><input type="text" value="${item.brand}" name="brand" /></td>
  </tr>
  <tr>
    <td>diagonal:</td><td><input type="text" value="${item.diagonal}" name="diagonal" /></td>
  </tr>
  <tr>
    <td>matrixType:</td>
    <td>
	    <select name="matrixType">
		    <c:forEach var="matrixTypeItem" items="<%=MatrixType.values()%>">
		      <option><c:out value="${matrixTypeItem.name()}"/></option>
		    </c:forEach>
	    </select>
    </td>
  </tr>
  <tr>
    <td>dateMade:</td>
    <td>
      <input type="text" value="${item.getDateMadeStr()}" name="dateMade" id="dateMade"/>
      <img src="images/cal.gif" onclick="javascript:NewCssCal('dateMade','mmddyyyy')" style="cursor:pointer"/> 
    </td>
  </tr>
  <tr>
    <td>description:</td><td><input type="text" value="${item.description}" name="description" /></td>
  </tr>
</table>
<input type="submit" name="action" value="SaveNClose" />
<input type="submit" name="action" value="Close" />
</form>

</body>
</html>
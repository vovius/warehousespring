<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
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

<fmt:parseNumber var="editId" value="${param['editId']}" />
<c:set var="currentStorage" value="${storageWebState.currentStorage}" />
<c:set var="item" value="${currentStorage.getItemById(editId)}" />

<c:choose>
  <c:when test="${'SaveNClose' eq param['action']}">
    <fmt:parseDate value="${param['dateMade']}" var="parsedDateMade" pattern="MM/dd/yyyy" /> 
    <jsp:useBean id="itemSave" class="com.dio.javamentoring.warehouse.TV">
     <jsp:setProperty name="itemSave" property="id" value="${param['id']}"/>
     <jsp:setProperty name="itemSave" property="brand" value="${param['brand']}"/>
     <jsp:setProperty name="itemSave" property="diagonal" value="${param['diagonal']}"/>
     <jsp:setProperty name="itemSave" property="matrixType" value="${param['matrixType']}"/>
     <jsp:setProperty name="itemSave" property="dateMade" value="${parsedDateMade}"/>
     <jsp:setProperty name="itemSave" property="description" value="${param['description']}"/>
     <sat:SetItem item="${itemSave}" storageWebState="${storageWebState}" />
    </jsp:useBean>
    <jsp:forward page="/WEB-INF/jsp/StorageAction.jsp"></jsp:forward>
  </c:when>
  <c:when test="${'Close' eq param['action']}">
    <jsp:forward page="/WEB-INF/jsp/StorageAction.jsp"></jsp:forward>
  </c:when>
</c:choose>

<form action="StorageItemMaintain.html">
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
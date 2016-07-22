<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/views/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>
	<fmt:message key="titulo"/>
</title>
</head>
<body>
<h1><fmt:message key="encabezado"/></h1>
<p>
	<fmt:message key="mensaje"/>
	<c:out value="${modelo.ahora}"/>
</p>
<h3>Productos</h3>
	<c:forEach items="${modelo.productos}" var="pro">
		<c:out value="${pro.descripcion} "/><i>$<c:out value="${pro.precio}"/></i></br></br>		
	</c:forEach>
	<br />
	<a href="<c:url value="incrementaprecio.htm"/>">Incrementar precios</a>
</body>
</html>
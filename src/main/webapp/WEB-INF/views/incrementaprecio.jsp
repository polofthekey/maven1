<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title><fmt:message key="titulo"/></title>
<style>.error {color:red;}</style>
</head>
<body>
<h1><fmt:message key="incrementaprecio.encabezado" /></h1>
<form:form method="post" commandName="incrementaPrecio">
	<table>
		<tr>
			<td align="right" width="20%">Incremento (%):</td>
			<td width="20%">
				<form:input path="porcentaje"/>
			</td>
			<td width="60%">
				<form:errors path="porcentaje" cssClass="error"/>
			</td>
		</tr>
	</table>
	<br />
	<input type="submit" value="Aplicar" />
</form:form>
<a href="<c:url value="hello.htm"/>">Inicio</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="bean" uri="/WEB-INF/tld/struts-bean.tld" %>
<%@ taglib prefix="html" uri="/WEB-INF/tld/struts-html.tld" %>    
<%@ taglib prefix="tiles" uri="/WEB-INF/tld/struts-tiles.tld" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="lightgreen">
	<table width="100%" height="100%" border="1">
		<tr height="20%">
			<td colspan="2"><tiles:insert attribute="header"/></td>		
		</tr>
		<tr height="60">
			<td width="20%"><tiles:insert attribute="menu"/></td>
			<td width="*"><tiles:insert attribute="body"/></td>
		</tr>
		<tr>
			<td colspan="2"><tiles:insert attribute="footer"/></td>
		</tr>
	</table>
</body>
</html:html>
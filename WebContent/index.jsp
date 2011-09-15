<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSF Test Startseite</title>
</head>
<body>
	<f:view>
        Hallo.
        <br />
		<br />
        Die Zahl ist: ${ param['zahl'] }
        <br />
        Dein Browser ist ein: ${ header['User-Agent'] }
        <br />
        Das Cookie "JSESSIONID" hat den Wert: ${ cookie['JSESSIONID'].value }
        <br />
        Deine Session-ID ist: ${ session.id }
        <br />
        Drei mal Sieben ist: ${ 3*7 }
        <br />
		<br />
		<a href="index.jsf?zahl=12">klick mich</a>
	</f:view>
</body>
</html>
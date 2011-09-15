<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<f:view>
	<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
<title>Welcome</title>
<link href="mycss.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<center>

		<h:form>
			<h:panelGrid width="100%" columns="1" border="0"
				style="padding-left:10px; 
  padding-top:10px; " styleClass="top_bg">
				<h:dataTable id="dt1" border="0" cellpadding="0" cellspacing="0"
					var="ab">
					<h:column>
						<f:facet name="header">
							<h:outputText value="RoseIndia" styleClass="style4" />
						</f:facet>
					</h:column>
				</h:dataTable>
			</h:panelGrid>
			<h:panelGrid width="100%" columns="1" border="0">
				<f:verbatim>&nbsp;</f:verbatim>
				<h:outputText value=" " />
				<h:outputText value=" " />
				<h:outputText value=" " />
			</h:panelGrid>
			<h:outputText value="Welcome ....."
				style="color:green; font-weight:bold" />
		</h:form>
	</center>
</body>
	</html>
</f:view>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>

<f:view>
	<html>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<head>
<title>User Login</title>
<link href="pages/mycss.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<center>

		<h:panelGrid width="100%" columns="1" border="0"
			style="padding-left:10px;  padding-top:10px; " styleClass="top_bg">
			<h:dataTable id="dt1" border="0" cellpadding="0" cellspacing="0"
				var="ab">
				<h:column>
					<f:facet name="header">
						<h:outputText value="RoseIndia" styleClass="style4" />
					</f:facet>
				</h:column>
			</h:dataTable>
		</h:panelGrid>

		<h:panelGrid width="175px" columns="3" border="0" cellspacing="0"
			cellpadding="0">
			<h:outputText value=" " />
			<h:graphicImage id="gi3" value="images/verticle_line.gif" width="4"
				height="18"></h:graphicImage>
			<h:panelGroup>
				<h:dataTable id="dt2" border="0" cellpadding="0" cellspacing="0"
					width="250" var="gh">
					<h:column>
						<f:facet name="header">
							<h:outputText value="User Login" styleClass="style1" />
						</f:facet>
					</h:column>
				</h:dataTable>
			</h:panelGroup>

			<h:graphicImage id="gi4" value="images/horizontal_line.gif"
				width="25" height="4"></h:graphicImage>
			<h:graphicImage id="gi8" value="images/horizontal_line.gif" width="5"
				height="4"></h:graphicImage>
			<h:graphicImage id="gi6" value="images/horizontal_line.gif"
				width="260" height="4"></h:graphicImage>
			<h:outputText value=" " />
			<h:graphicImage id="gi7" value="images/verticle_line.gif" width="5"
				height="100%"></h:graphicImage>

			<h:panelGroup>
				<h:form>
					<h:panelGrid width="75px" columns="2" border="0">
						<f:facet name="header">
							<h:outputText value="User Name or Password is incorrect"
								style="color:red; font-weight: bold;"
								rendered="#{CheckValidUser.exist}" />
						</f:facet>
						<h:panelGroup>
							<h:outputText value=" " />
							<h:outputText value="User Name" styleClass="style2" />
						</h:panelGroup>
						<h:panelGroup>
							<h:inputText id="UserName" value="#{CheckValidUser.userName}"
								size="27" required="true" />
							<f:verbatim>
								<br />
							</f:verbatim>
							<h:message for="UserName" styleClass="errors" />
						</h:panelGroup>
						<h:panelGroup>
							<h:outputText value="Password" styleClass="style2" />
						</h:panelGroup>

						<h:panelGroup>
							<h:inputSecret id="Password" value="#{CheckValidUser.pwd}"
								size="27" required="true" />
							<f:verbatim>
								<br />
							</f:verbatim>
							<h:message for="Password" styleClass="errors" />
						</h:panelGroup>
						<h:outputText value=" " />
						<h:panelGroup>
							<h:commandButton image="images/submit_button.gif"
								action="#{CheckValidUser.checkUser}" />
						</h:panelGroup>
					</h:panelGrid>
				</h:form>

				<h:form>
					<h:commandLink value="New User?" action="reg" styleClass="style3" />
				</h:form>
			</h:panelGroup>
		</h:panelGrid>
	</center>
</body>
	</html>
</f:view>
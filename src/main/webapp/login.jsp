<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>

<f:view>
	<html>
<h:form>
	<f:facet name="header">
		<h:outputText rendered="#{CheckValidUser.exist}">User Name or Password is incorrect.</h:outputText>
	</f:facet>
	<h:inputText id="UserName" value="#{CheckValidUser.userName}" size="27"
		required="true"></h:inputText>
	<h:message for="UserName"></h:message>
	<h:inputSecret id="Password" value="#{CheckValidUser.password}"
		required="true"></h:inputSecret>
	<h:message for="Password"></h:message>
	<h:commandButton action="#{CheckValidUser.checkUser}"></h:commandButton>
</h:form>
	</html>
</f:view>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE = html>
<html>
<head>
<link type="text/css"
         rel ="stylesheet"
         href = "${pageContext.request.contextPath}/resources/css/customer.css" />
</head>
<body>

<div id="header">
<h2>Enter details of new customer to be added</h2>
</div>

<div id="form">

<form:form action="saveCustomer" modelAttribute="customer" method="POST">
	<form:hidden path="id"/>
    <table>
    <tbody>
    <tr>
     <td><label>First Name</label></td>
     <td><form:input path="firstName"/></td>
    </tr>
    <tr>
     <td><label>Last Name</label></td>
     <td><form:input path="lastName"/></td>
     </tr>
     <tr>
     <td><label>Email</label></td>
     <td><form:input path="email"/></td>
     </tr>
     <tr>
     <td><input type="submit" value="Save Customer"/></td>
     </tr>
     
     </tbody>
     </table>

</form:form>
 
</div>

</body>

</html>
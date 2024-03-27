<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
 
<head>
   <title>
   This is the list of Customers
   </title>
   <link type="text/css"
         rel ="stylesheet"
         href = "${pageContext.request.contextPath}/resources/css/customer.css" />
</head>

<body>
 
<div id="header">

<h2> Here is the list of customers </h2>

</div>


<div id = "content">

<table>
	<tr>
	<th>First Name</th>
	<th>Last Name</th>
	<th>Email</th>
	<th>Action</th>

	
	</tr>
	
	<c:forEach var="tmpcustomer" items="${customers}">
	
		<c:url var="updateurl" value="/customer/update">
						<c:param name="customerId" value = "${tmpcustomer.id}" />
		</c:url>
		
		<c:url var="deleteurl" value="/customer/delete">
						<c:param name="customerId" value = "${tmpcustomer.id}" />
		</c:url>
	
		<tr>
		<td> ${tmpcustomer.firstName}</td>
		<td> ${tmpcustomer.lastName}</td>
		<td> ${tmpcustomer.email}</td>
		<td>
		<a href="${updateurl}">Update</a>
		|
		<a href="${deleteurl}" onclick="if(!(confirm('Are you sure'))) return false">
		Delete
		</a>
		</td>
		
		</tr>
	
	</c:forEach>
	
</table>
<br><br>

 
<input type="button" value="Add Customer" 
             onclick="window.location.href='add'; return False;"
             class="btn"/>

</div>


</body>

</html>
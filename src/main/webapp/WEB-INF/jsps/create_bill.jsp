<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create | Bill</title>
</head>
<body>
       <h2>Create|Bill</h2>
       <hr>
       <form action="generateBill" method="post">
       <pre>
       FirstName:<input type="text" name="firstName" value="${contact.firstName}"/>
       LastName:<input type="text" name="lastName" value="${contact.lastName}"/>
       Email:<input type="email" name="email" value="${contact.email}"/>
       Mobile:<input type="number" name="mobile" value="${contact.mobile}"/>
       Product:<input type="text" name="product"/>
       Amount:<input type="text" name="amount"/>
              <input type="submit" value="generateBill"/>
       </pre>
       </form>

</body>
</html>
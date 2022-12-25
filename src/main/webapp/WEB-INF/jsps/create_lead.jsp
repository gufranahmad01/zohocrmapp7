<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create | Lead</title>
</head>
<body>
       <h2>Create|Lead</h2>
       <hr>
       <form action="save" method="post">
       <pre>
       FirstName:<input type="text" name="firstName"/>
       LastName:<input type="text" name="lastName"/>
       Email:<input type="email" name="email"/>
       Mobile:<input type="number" name="mobile"/>
       Source:
       <select name="source">
       <option value="radio">radio</option>
       <option value="newspaper">newspaper</option>
       <option value="websites">websites</option>
       <option value="trade show">trade show</option>
       </select>
              <input type="submit" value="save"/>
       </pre>
       </form>

</body>
</html>
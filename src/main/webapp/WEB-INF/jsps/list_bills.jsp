<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="menu.jsp" %>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Bills</title>
</head>
<body>
      <h2>All Billing </h2>
      <table>
      <tr>
          <th>FirstName</th> 
          <th>LastName</th> 
          <th>Email</th> 
          <th>Mobile</th>
          <th>Product</th>
          <th>Amount</th>
          <th>GeneratePDF</th>
          
      </tr>
           <c:forEach var="billing" items="${billings}">
      <tr>
           <td>${billing.firstName}</td>
           <td>${billing.lastName}</td>
           <td>${billing.email}</td>
           <td>${billing.mobile}</td>
           <td>${billing.product}</td>
           <td>${billing.amount}</td>
           <td><a href="generatePdf?invoiceId=${billing.invoiceNumber}">generatePDF</a></td>
           
      </tr>
           </c:forEach>      
      </table>
</body>
</html>
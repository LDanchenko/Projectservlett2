<%@ page import="classes.Database" %><%--
  Created by IntelliJ IDEA.
  User: root
  Date: 04.10.18
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="classes.Logistic"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Title</title>
</head>
<body>
<table>
    <tr><th>id</th>
        <th>Town</th>
        <th>Represenation</th>
        <th>Route</th>
        <th>Address</th>
        <th>Goods</th>
        <th>Client</th>
        <th>Transport</th>
        <th>Store</th>
        <th>Status</th>


        <th></th>
    </tr>
    <c:forEach var="logistic" items="${logistics}">
        <tr><td>${logistic.id}</td>
        <td>${logistic.town}</td>
            <td>${logistic.representation}</td>
            <td>${logistic.route}</td>
            <td>${logistic.address}</td>
            <td>${logistic.good}</td>
            <td>${logistic.client}</td>
            <td>${logistic.transport}</td>
            <td>${logistic.store}</td>
            <td>${logistic.status}</td>

        </tr>
    </c:forEach>
</table>
<form action="${pageContext.request.contextPath}/database" method="post">
    Select status:
<select name = "status">
    <c:forEach var="stat" items="${status}">
        <option value="${stat}">${stat}</option>
    </c:forEach>
</select>
    <br/><br/>
    <%--<input type="submit" name="button1" value="Submit" />--%>
    <%--<input type="submit" name="button2" value="Button 1" />--%>
    <button type="submit" name="button" value="button1">Status</button>
    <button type="submit" name="button" value="button2">Sort</button>
</form>
<h2>counter</h2>
<%
    String name = Integer.toString((Integer) request.getAttribute("count"));
    out.println(name);
%>
</body>
</html>
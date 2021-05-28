<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28/5/2021
  Time: 9:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<html>
<head>
    <title>Danh Sách Học Sinh</title>
</head>
<body>
        <h2 style="color: mediumblue">Danh sach Hoc Sinh</h2>
        <table border="1 solid" width="50%">
            <tr>
                <th>Name</th>
                <th>Age</th>
                <th>Country</th>
            </tr>
            <c:forEach items="${students}" var="students">
                <tr>
                    <td>${students.name}</td>
                    <td>${students.age}</td>
                    <td>${students.country.name}</td>
                </tr>
            </c:forEach>
        </table>


</body>
</html>

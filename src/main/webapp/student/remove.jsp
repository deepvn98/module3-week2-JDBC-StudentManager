<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 29/5/2021
  Time: 1:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Form</title>
</head>
<body>
<form action="" method="post">
    <h2 style="color: mediumblue">Student Delete Form </h2>
    <table border="1 solid">
        <tr>
            <th>Name</th>
            <th>Age</th>
            <th>Country</th>
            <th>Action</th>
        </tr>
        <tr>
            <td>${student.name} </td>
            <td>${student.age}</td>
            <td>${country.name}</td>
            <td><input type="submit" value="Remove"></td>
        </tr>
    </table>
</form>


</body>
</html>

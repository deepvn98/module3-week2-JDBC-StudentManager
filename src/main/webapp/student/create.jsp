<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28/5/2021
  Time: 10:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create Form</title>
</head>
<body>
<form action="" method="post">
    <h2 style="color: mediumblue">Student Create Form </h2>
    <table>
        <tr>
            <th>Name</th>
            <th>Age</th>
            <th>Country</th>
        </tr>
        <tr>
            <td><input type="text" name="name" placeholder="Name"></td>
            <td><input type="number" name="age" placeholder="age"></td>
            <td><input type="text" name="country" placeholder="country"></td>
        </tr>
    </table>


</form>

</body>
</html>

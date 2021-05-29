<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 29/5/2021
  Time: 11:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update Form</title>
</head>
<body>
<form action="" method="post">
    <h2 style="color: mediumblue">Student Update Form </h2>
    <table>
        <tr>
            <th>Name</th>
            <th>Age</th>
            <th>Country</th>
        </tr>
        <tr>
            <td><input type="text" name="name" value="${student.getName()}"></td>
            <td><input type="number" name="age" value="${student.getAge()}"></td>
            <td>
                <select name="country" id="">
                    <c:forEach items="${countryList}" var="countryList">
                        <option value="${countryList.id}">${countryList.name}</option>
                    </c:forEach>
                </select>
            </td>
            <td><input type="submit" value="Update"></td>
        </tr>
    </table>
</form>

</body>
</html>

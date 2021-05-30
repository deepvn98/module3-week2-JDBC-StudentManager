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
            <th>Course</th>
        </tr>
        <tr>
            <td><input type="text" name="name" placeholder="Name"></td>
            <td><input type="number" name="age" placeholder="age"></td>
            <td>
            <select name="country" id="">
                <c:forEach items="${countrylist}" var="country">
                    <option value="${country.id}">${country.name}</option>
                </c:forEach>
            </select>
           </td>
            <td>
                <select name="course" id="course" multiple>
                    <c:forEach items="${course}" var="c">
                        <option value="${c.id}">${c.name}</option>
                    </c:forEach>
                </select>
            </td>
            <td><input type="submit" value="create"></td>
        </tr>
    </table>
</form>

</body>
</html>

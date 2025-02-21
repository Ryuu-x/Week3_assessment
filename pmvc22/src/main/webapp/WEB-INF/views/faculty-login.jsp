<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Faculty Login</title>
</head>
<body>
    <h2>Faculty Login</h2>
    <form action="validate-login" method="post">
    <label>Email:</label>
    <input type="email" name="email" required><br>
    <label>Password:</label>
    <input type="password" name="pass" required><br>
    <input type="submit" value="Login">
</form>


    <%-- Display assigned courses after login --%>
    <c:if test="${not empty list}">
        <h3>Assigned Courses</h3>
        <table border="1">
            <tr>
                <th>Course ID</th>
                <th>Course Name</th>
                <th>Duration</th>
            </tr>
            <c:forEach var="course" items="${list}">
                <tr>
                    <td>${course.id}</td>
                    <td>${course.name}</td>
                    <td>${course.duration}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</body>
</html>

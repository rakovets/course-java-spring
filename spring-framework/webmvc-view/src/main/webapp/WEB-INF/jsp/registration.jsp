<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" action="${pageContext.request.contextPath}/registration">
        <label for="name">Name: </label>
        <input type="text" id="name" name="name"/>
        <label for="password">Password: </label>
        <input type="password" id="password" name="password"/>
        <button type="submit">Save</button>
    </form>
</body>
</html>

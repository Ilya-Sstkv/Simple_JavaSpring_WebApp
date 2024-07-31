<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home page</title>
</head>
<body>

<h1 style="text-align: center; font-size: 50px; color: #17a9b2; padding-top: 15px; height: 43px">WELCOME!</h1>
<hr>

<a href="${pageContext.request.contextPath}/cars"
   style="text-decoration: none; display: flex; justify-content: center">
    <button type="button" style="text-align: center; width: 180px; height: 50px; background-color: #93ef93">
        <b>
            SEE THE CAR LIST
        </b>
    </button>
</a>

</body>
</html>
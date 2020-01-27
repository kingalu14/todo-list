<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="net.kinginfotech.util.Mappings" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Todo List Applicaiton</title>
</head>
<body>
    <div align="center">
           <c:url var="itemsLink" value="${Mappings.ITEMS}" />
           <h2> <a href="${itemsLink}"> Show TOdo Items </a></h2>

    </div>
</body>
</html>
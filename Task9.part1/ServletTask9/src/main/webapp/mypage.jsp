<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
    <body>
    <h1>Hello!</h1>
    <form  method="Post">
        String to decode: <input type="text" name="s">
        <br>
        Decoded string: ${s}
    </form>
    <p><a href="/">Go to menu</a></p>
    </body>
</html>
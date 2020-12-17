<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="login.css"/>
</head>
<body>
<div id="login">
<h1>Login</h1>
<form method="post" action="${pageContext.request.contextPath}/login">
    <input type="text" required="required" placeholder="用户名" name="username"></input>
    <input type="password" required="required" placeholder="密码" name="password"></input>
    <button class="but" type="submit">登录</button>
</form>
</div>
</body>
</html>
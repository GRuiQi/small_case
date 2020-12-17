<%@ page isELIgnored="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta name="viewport" content="width=device-width",initial-scale="1.0">
  <title>login</title>
  <link href="plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">


</head>
<body>

<h2 class="text-center"><small>输入用户名和密码</small></h2>
<hr/>
<form action="${pageContext.request.contextPath}/login" method="post" class="form-inline text-center">
  <label>username:</label>
  <input type="text" class="form-control" name="username"/>

  <br/>
  <br/>

  <label>password:</label>
  <input type="password" class="form-control" name="password"/>

  <br/>
  <br/>

  <input type="submit" value="登录" class="btn btn-default"/>
</form>


</body>
</html>

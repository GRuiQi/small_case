<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="utf-8">
    <title>在线用户</title>
    <link href="plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="page-header">
        <h1>当前在线用户</h1>
    </div>
    <div class="row">
        <div class="col-md-3">

        </div>

        <div class="col-md-6">
            <table class="table table-script table-bordered">
                <thead>
                    <tr>
                        <td>序号</td>
                        <td>用户</td>
                        <td>操作</td>
                    </tr>
                </thead>
                <tbody>
                   <%-- <tr>
                        <td>1</td>
                        <td>Alice</td>
                        <td>
                            <a href="#" class="btn btn-sm btn-primary">踢出</a>
                        </td>
                    </tr>--%>
                 <%--  items：将要进行迭代的集合。
                   var：当前迭代的集合中的元素。
                   varStatus：状态项。该属性比其他的复杂，因为它的属性值中包含多个属性。
                   count属性：当前迭代的元素是集合中第几个元素，从1开始。
                 --%>
                   <c:forEach items="${applicationScope.map}" var="m" varStatus="obj">
                        <tr>
                            <td>${obj.count}</td>
                            <td>${m.key}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/offlineUser?username=${m.key}"
                                   class="btn btn-sm btn-primary">踢出</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

    </div>
</div>

</body>
</html>

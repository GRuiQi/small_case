<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>用户注册</title>
    <link href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.css">

  </head>
  <body>
    <form class="form-inline">
      <div>
        <label>用户名:</label>
        <input type="text" id="name" class="form-control">
      </div>
      <span id="msg"></span>
    </form>

  </body>

<script src="${pageContext.request.contextPath}/plugins/jquery-3.5.0.min.js"></script>
<script>
  $(function(){
      $("#name").blur(function () {
          //鼠标离开输入框，触发事件
          var name =  $("#name").val();

          $.ajax({
              type:"get",
              url:"${pageContext.request.contextPath}/regist?name="+name,
              success:function (result) {
                  if(result==true){
                      $("#msg").html("<font color='red'>可以使用<font>");
                  }else{
                      $("#msg").html("<font color='red'>用户名已存在<font>");

                  }
              }

          });
      });
  });
</script>
</html>
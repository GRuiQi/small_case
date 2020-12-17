<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta charset="UTF-8">
  <title>双色球彩票随机号码</title>
  <link rel="stylesheet" href="plugins/bootstrap/css/bootstrap.css"/>
  <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<div class="container">
  <div id="msg">

  </div>
  <hr>
  <div class="row">
    <h1>
      双色球选号系统:
      <small>随机生成<input type="text" maxlength="3" size="3" id="num">注
        <button type="button" class="btn btn-sm btn-primary"  id="getBall">确定</button>
      </small>
    </h1>
  </div>
  <div class="col-sm-3"></div>
  <div class="col-sm-3">
    <div class="panel panel-danger">
      <div class="panel-heading">
        <h3 class="panel-title">
          红球区<small>每注共6个球</small>
        </h3>
      </div>

      <div class="panel-body" id="red">
        <span class="label label-danger label-circle">02</span>
        <span class="label label-danger label-circle">08</span>
        <span class="label label-danger label-circle">11</span>
        <span class="label label-danger label-circle">19</span>
        <span class="label label-danger label-circle">20</span>
        <span class="label label-danger label-circle">30</span>

        <hr>
        <span class="label label-danger label-circle">02</span>
        <span class="label label-danger label-circle">08</span>
        <span class="label label-danger label-circle">11</span>
        <span class="label label-danger label-circle">19</span>
        <span class="label label-danger label-circle">20</span>
        <span class="label label-danger label-circle">30</span>

      </div>

    </div>
  </div>

  <div class="col-sm-2">
    <div class="panel panel-info">
      <div class="panel-heading">
        <h3 class="panel-title">
          篮球区<small>每注共1个篮球</small>
        </h3>
      </div>

      <div class="panel-body" id="blue">
        <span class="label label-info label-circle">13</span>
        <hr>
        <span class="label label-info label-circle">13</span>
      </div>
    </div>
  </div>

</div>

<script src="plugins/jquery-3.5.0.min.js"></script>
<script src="plugins/bootstrap/js/bootstrap.min.js"></script>
</body>
<script>
  $(function () {
      $("#getBall").click(function () {
          //校验用户的输入
          var num = $("#num").val();

          //正则表达式，输入小于30的正整数
          var reg = /^([1-9]|[1-2]\d])$/;
          if (!reg.test(num)){
              var msg = '<div class="alert alert-danger"><strong>注意！</strong></div>'
              $("#msg").html(msg);

              //让提示信息在3秒自动消失
              setTimeout(function () {
                  $("#msg").empty();
              },3000)

              return;
          }

          //使用ajax处理请求和响应
          $.ajax({
              type:"post",
              url:"${pageContext.request.contextPath}/colorBall",
              data:{num:num},
              dataType:"json",
              success:function (result) {

                  var redBall = "";
                  var blueBall = "";
                   //返回servlet中的返回结果
                  $.each(result,function (index,element) {

                      console.log(index+":"+element)
                      /**
                       * 双色球开奖号码不按顺序，只要号码对上即可，唯一的排序就是前6个是红球，最后一位是篮球！
                       */
                      if(element<10){
                          element = "0"+element;
                      }


                      //因为数组下标是从0开始，所以需要做+1运算
                      if((index+1)%7==0){
                          //拼接蓝球
                          blueBall += ' <span class="label label-info label-circle">'+element+'</span>'

                          $("#blue").empty();
                          $("#blue").html(blueBall);

                      }else{

                          if(index != 0 && index % 7 ==0){
                              blueBall += '<hr>';
                              redBall += '<hr>';
                          }

                          //拼接红球
                          redBall += ' <span class="label label-danger label-circle">'+element+'</span>';
                          $("#red").empty();
                          $("#red").html(redBall);
                      }

                  });

                  //生成的html代码

                  // $("#blue").html(blueBall);
                  // $("#red").html(redBall);
              }
          });
      })
  })
</script>

</html>
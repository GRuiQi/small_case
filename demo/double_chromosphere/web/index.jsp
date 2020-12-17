<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
                <small>随机生成<input type="text" id="num">注
                    <button type="button" class="btn btn-sm btn-primary" id="getBall">确定</button>
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
    $(function(){

    });
</html>
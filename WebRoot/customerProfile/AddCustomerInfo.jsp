<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <base href="<%=basePath%>">
    <title>售后系统 | 新增用户信息</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.5 -->
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css"> -->
    <link rel="stylesheet" href="bootstrap/css/font-awesome.min.css">
    <!-- Ionicons -->
    <!-- <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css"> -->
    <link rel="stylesheet" href="bootstrap/css/ionicons.min.css">
    <!--bootstrap-table  -->
    <link rel="stylesheet" href="plugins/bootstrap-table/bootstrap-table.min.css">
    <!--select2  -->
    <link rel="stylesheet" href="plugins/select2/select2.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. We have chosen the skin-blue for this starter
          page. However, you can choose any other skin. Make sure you
          apply the skin class to the body tag so the changes take effect.
    -->
    <link rel="stylesheet" href="dist/css/skins/skin-blue.min.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <!--
  BODY TAG OPTIONS:
  =================
  Apply one or more of the following classes to get the
  desired effect
  |---------------------------------------------------------|
  | SKINS         | skin-blue                               |
  |               | skin-black                              |
  |               | skin-purple                             |
  |               | skin-yellow                             |
  |               | skin-red                                |
  |               | skin-green                              |
  |---------------------------------------------------------|
  |LAYOUT OPTIONS | fixed                                   |
  |               | layout-boxed                            |
  |               | layout-top-nav                          |
  |               | sidebar-collapse                        |
  |               | sidebar-mini                            |
  |---------------------------------------------------------|
  -->
  <body class="hold-transition skin-blue sidebar-mini">
    <div class="wrapper">

      <!-- Main Header -->
      <header class="main-header">
		<jsp:include page="/Frame/top.jsp"></jsp:include>
      </header>
      <!-- Left side column. contains the logo and sidebar -->
      <aside class="main-sidebar">
      	<jsp:include page="/Frame/left.jsp"></jsp:include>
      </aside>

      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
            	新增用户信息
            <small>客户档案管理</small>
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
            <li><a href="#">客户档案管理</a></li>
            <li class="active">新增用户信息</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">
			<div class="box box-primary">
                <div class="box-body">
                  <!-- 左侧列 -->
                  <div class="col-xs-0 col-sm-3"></div>
                  <div class="col-sm-6">
	                  <div class="form-group">
	                    <label>客户名称:</label>
	                    <div class="input-group">
	                      <div class="input-group-addon">
	                        <i class="fa fa-user"></i>
	                      </div>
	                      <input type="text" class="form-control pull-right" id="customerName">
	                    </div><!-- /.input group -->
	                  </div><!-- /.form group -->
		              <!-- <div class="form-group">
	                    <label>客户所在地</label>
	                    <select class="form-control select2" multiple="multiple" data-placeholder="Select a State" style="width: 100%;">
	                      <option>北京</option>
	                      <option>上海</option>
	                      <option>江苏</option>
	                      <option>浙江</option>
	                      <option>安徽</option>
	                      <option>河南</option>
	                      <option>山东</option>
	                    </select>
	                  </div> --> <!-- /.form-group-->
	                  <div class="form-group">
	                    <label>客户地址:</label>
	                    <div class="input-group">
	                      <div class="input-group-addon">
	                        <i class="fa fa-automobile"></i>
	                      </div>
	                      <input type="text" class="form-control pull-right" id="customerName">
	                    </div><!-- /.input group -->
	                  </div><!-- /.form group -->
	                  <div class="form-group">
	                    <label>客户联系人:</label>
	                    <div class="input-group">
	                      <div class="input-group-addon">
	                        <i class="fa fa-user"></i>
	                      </div>
	                      <input type="text" class="form-control pull-right" id="customerName">
	                    </div><!-- /.input group -->
	                  </div><!-- /.form group -->
	                  <div class="form-group">
	                    <label>联系人固话:</label>
	                    <div class="input-group">
	                      <div class="input-group-addon">
	                        <i class="fa fa-user"></i>
	                      </div>
	                      <input type="text" class="form-control pull-right" id="customerName">
	                    </div><!-- /.input group -->
	                  </div><!-- /.form group -->
	                  <div class="form-group">
	                    <label>联系人手机:</label>
	                    <div class="input-group">
	                      <div class="input-group-addon">
	                        <i class="fa fa-user"></i>
	                      </div>
	                      <input type="text" class="form-control pull-right" id="customerName">
	                    </div><!-- /.input group -->
	                  </div><!-- /.form group -->
	                  <div class="form-group">
	                    <label>联系人邮箱:</label>
	                    <div class="input-group">
	                      <div class="input-group-addon">
	                        <i class="fa fa-envelope"></i>
	                      </div>
	                      <input type="text" class="form-control pull-right" id="customerName">
	                    </div><!-- /.input group -->
	                  </div><!-- /.form group -->
	                  <div>
	                  	<div class="col-sm-3"></div>
	                  	<div class="col-sm-3 col-xs-6">
	                  		<input type="button" class="btn btn-primary " name="ensure" value="确定">	
	                  	</div>
	                  	<div class="col-sm-3 col-xs-6">
	                  		<input type="button" class="btn btn-primary" name="ensure" value="清空">	
	                  	</div>
	                  	
	                  </div>
				  </div>
				  <!-- <div class="col-sm-6">
				  	
				  </div> -->
                </div><!-- /.box-body -->
              </div><!-- /.box -->
        </section><!-- /.content -->
      </div><!-- /.content-wrapper -->

      <!-- Main Footer -->
      <%@include file="/Frame/footer.jsp" %>
    </div><!-- ./wrapper -->

    <!-- REQUIRED JS SCRIPTS -->

    <!-- jQuery 2.1.4 -->
    <script src="plugins/jQuery/jQuery-2.1.4.min.js"></script>
    <!-- Bootstrap 3.3.5 -->
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <!-- AdminLTE App -->
    <script src="dist/js/app.min.js"></script>
    <!-- bootstrap-table -->
    <script src="plugins/bootstrap-table/bootstrap-table.min.js"></script>
    <!-- select2 -->
    <script src="plugins/select2/select2.full.min.js"></script>
	<!-- put your locale files after bootstrap-table.js -->
	<script src="plugins/bootstrap-table/bootstrap-table-zh-CN.min.js"></script>
	<!-- userMana.js -->
	<script src="system/js/UserMana.js"></script>
    <!-- Optionally, you can add Slimscroll and FastClick plugins.
         Both of these plugins are recommended to enhance the
         user experience. Slimscroll is required when using the
         fixed layout. -->
  </body>
</html>
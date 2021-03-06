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
    <title>售后系统 | 用户列表</title>
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
    <script type="text/javascript">
	function closeAdd(){
		$("#addModal").hide();
	}
    </script>
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
            	用户列表
            <small>用户管理</small>
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
            <li><a href="#">系统管理</a></li>
            <li class="active">用户管理</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">
			<div class="row">
            <div class="col-xs-12">
              <div class="box">
               <!--  <div class="box-header">
                  <h3 class="box-title">用户列表</h3>
                </div>/.box-header -->
                <div id="toolbar">
			        <button id="addButton" class="btn btn-primary" data-target="#addTable">
			            <i class="glyphicon glyphicon-plus"></i> 新增
			        </button>
			        <button id="remove" class="btn btn-danger">
			            <i class="glyphicon glyphicon-remove"></i> 删除
			        </button>
			    </div>
                <div class="box-body table-responsive">
                  <table id="userTable">
                    
                  </table>
                </div>	
              </div><!-- /.box -->
            </div>
           </div> 
        </section><!-- /.content -->
      </div><!-- /.content-wrapper -->

      <!-- Main Footer -->
      <%@include file="/Frame/footer.jsp" %>
      
      <!--新增用户对话框   开始-->
      <div class="modal" id="addModal" style="hidden:true;">
              <div class="modal-dialog">
                <div class="modal-content">
                  <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="closeAdd()"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">新增用户</h4>
                  </div>
                  <div class="modal-body">
                  	<form class="form-group">
                    <label>用户名</label>
                    <input type="text" class="form-control" name="loginAccoount">
                    <label>姓名</label>
                    <input type="text" class="form-control" name="name">
                    <label>邮箱</label>
                    <input type="email" class="form-control" name="email"> 
                    </form>
                  </div>
                  <div class="modal-footer">
                    <button type="button" class="btn btn-default pull-left" data-dismiss="modal" onclick="closeAdd();">关闭</button>
                    <button type="button" class="btn btn-primary">保存</button>
                  </div>
                </div><!-- /.modal-content -->
              </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->
      <!--新增用户对话框 结束  -->

      
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
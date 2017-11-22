<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Creative - Bootstrap 3 Responsive Admin Template">
    <meta name="author" content="GeeksLabs">
    <meta name="keyword" content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
    <link rel="shortcut icon" href="img/favicon.png">

    <title>登录</title>

    <!-- Bootstrap CSS -->    
    <link href="<@ps.s/>/css/bootstrap.min.css" rel="stylesheet">
    <!-- bootstrap theme -->
    <link href="<@ps.s/>/css/bootstrap-theme.css" rel="stylesheet">
    <!--external css-->
    <!-- font icon -->
    <link href="<@ps.s/>/css/elegant-icons-style.css" rel="stylesheet" />
    <link href="<@ps.s/>/css/font-awesome.css" rel="stylesheet" />
    <!-- Custom styles -->
    <link href="<@ps.s/>/css/style.css" rel="stylesheet">
    <link href="<@ps.s/>/css/style-responsive.css" rel="stylesheet" />
	<script src="<@ps.s/>/js/jquery-1.8.3.min.js"></script>
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 -->
    <!--[if lt IE 9]>
    <script src="<@ps.s/>/js/html5shiv.js"></script>
    <script src="<@ps.s/>/js/respond.min.js"></script>
    <![endif]-->
    <style>
    .captcha{
    width:50% !important;
    margin-right:20px;
    }
    </style>
</head>

  <body class="login-img3-body">

    <div class="container">

      <form class="login-form" action="/dologin" id="loginForm">        
        <div class="login-wrap">
            <p class="login-img"><i class="icon_lock_alt"></i></p>
            <div class="input-group">
              <span class="input-group-addon"><i class="icon_profile"></i></span>
              <input type="text" class="form-control" name="username" id="username"  placeholder="username" autofocus>
            </div>
            <div class="input-group">
                <span class="input-group-addon"><i class="icon_key_alt"></i></span>
                <input type="password" class="form-control" placeholder="Password" value="111111" name="password" id="password">
            </div>
            <div class="input-group">
                <span class="input-group-addon"></span>
                <input type="text" class="form-control captcha" placeholder="验证码" name="code" id="code"/>
                <img id="imgObj" alt="验证码" src="/code" width="100px" height="42px"/> 
            </div>
            <button class="btn btn-primary btn-lg btn-block" type="button" onclick="login_val()">登录</button>
            <button class="btn btn-info btn-lg btn-block" type="reset">取消</button>
        </div>
      </form>

    </div>
    
    <script type="text/javascript">
    
    $('#imgObj').click(function() {
         $('#imgObj').attr("src", "/code?timestamp=" + (new Date()).valueOf());
    }); 
    
$('#password').keydown(function(e){
	if(e.keyCode==13){
		login_val();
	}
	});
function cancel(){
	$("#username").val("");
	$("#password").val("")
}
function login_val(){
	var username = $("#username").val();
	var password = $("#password").val();
	var code = $("#code").val();
	if(username=="" || password==""){
		alert("用户名或密码不能为空！")
			return false;
	}
	$.ajax({
		url: "/user/validate",
		data: {"username":username,"password":password,"code":code},
		async: true,
		type: 'POST',
		dataType: 'jsonp',
		jsonp: 'jsonpcallback',
		success:function(data){
			if(data.message=="OK"){
				/* var formElement = document.getElementById("loginForm");
				formElement.submit(); */
				$("#loginForm").submit();
				
			}else{
				alert(data.message);
				return false;
			}
			
		}
	});
}

</script>
  </body>
</html>

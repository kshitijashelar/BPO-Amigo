<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login :: Call Center Data Analysis</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Shoppy Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all">
<!-- Custom Theme files -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!--js-->
<script src="js/jquery-2.1.1.min.js"></script>
<!--icons-css-->
<link href="css/font-awesome.css" rel="stylesheet">
<!--Google Fonts-->
<link href='//fonts.googleapis.com/css?family=Carrois+Gothic'
	rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Work+Sans:400,500,600'
	rel='stylesheet' type='text/css'>
<!--static chart-->
<script type="text/javascript">
	function validation() {
		var a = document.getElementById("pass").value;

		if (a == "") {
			alert("Please Enter Your Password");
			document.getElementById("pass").focus();
			return false;
		}
		if ((a.length < 8) || (a.length > 12)) {
			alert("Your Password must be 8 to 12 Character");
			document.getElementById("pass").select();
			return false;
		}
	}
</script>
<!-- <script type="text/javascript">
	history.pushState(null, null, document.URL);
	window.addEventListener('popstate', function() {
		history.pushState(null, null, document.URL);
	});
</script> -->
</head>
<body>
	<div class="login-page">
		<div class="login-main">
			<div class="login-head">
				<h1>Login</h1>
			</div>
			<div class="login-block">
				<form action="./UserLogin" method="post"
					onsubmit="return validation()">
					<%
						if (session.getAttribute("msg") != null && session.getAttribute("flag") != null) {
							if (session.getAttribute("flag").equals("1")) {
					%>
					<div class="alert alert-success">
						<strong>Success!</strong><%=session.getAttribute("msg")%></div>
					<%
						session.removeAttribute("msg");
								session.removeAttribute("flag");
							} else {
					%>
					<div class="alert alert-danger">
						<strong>Warning!</strong><%=session.getAttribute("msg")%></div>
					<%
						session.removeAttribute("msg");
								session.removeAttribute("flag");
							}
						}
					%>
					<input type="email" name="email_id_text" placeholder="Email-id" 
						required=""> <input type="password" id="pass"
						name="password_text" placeholder="Password" required=""
						maxlength="12"> <input type="submit" name="Sign In"
						value="Login">
					<h3>
						Not a member?<a href="choose_user_type.jsp"> Sign up now</a>
					</h3>
					<!--					<h2>or login with</h2>
                                                                <div class="login-icons">
                                                                        <ul>
                                                                                <li><a href="#" class="facebook"><i class="fa fa-facebook"></i></a></li>
                                                                                <li><a href="#" class="twitter"><i class="fa fa-twitter"></i></a></li>
                                                                                <li><a href="#" class="google"><i class="fa fa-google-plus"></i></a></li>						
                                                                        </ul>
                                                                </div>-->
				</form>

			</div>
		</div>
	</div>
	<!--inner block end here-->
	<!--copy rights start here-->
	<jsp:include page="./footer.jsp"></jsp:include>
	<!--COPY rights end here-->

	<!--scrolling js-->
	<script src="js/jquery.nicescroll.js"></script>
	<script src="js/scripts.js"></script>
	<!--//scrolling js-->
	<script src="js/bootstrap.js"></script>
	<!-- mother grid end here-->
</body>
</html>





<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Signup :: Call Center Data Analysis</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords"
              content="Shoppy Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
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
        <!--//charts-->
        <script src="js/register12.js"></script>
        <script type="text/javascript">
            function validation() {
                var a = document.getElementById("pass12").value;

                if (a == "") {
                    alert("Please Enter Your Password");
                    document.getElementById("pass12").focus();
                    return false;
                }
                if ((a.length < 8) || (a.length > 12)) {
                    alert("Your Password must be 8 to 12 Character");
                    document.getElementById("pass12").select();
                    return false;
                }
            }
        </script>
    </head>
    <body>
        <!--inner block start here-->
        <div class="signup-page-main">
            <div class="signup-main">
                <div class="signup-head">
                    <h1>Sign Up</h1>
                </div>
                <div class="signup-block">
                    <form action="./SignUp" method="post" onsubmit="return validation()">
                        <%
                            if (session.getAttribute("msg") != null
                                    && session.getAttribute("flag") != null) {
                                if (session.getAttribute("flag").equals("1")) {
                        %>
                        <div class="alert alert-success"><strong>Success!</strong><%=session.getAttribute("msg")%></div>
                        <%
                            session.removeAttribute("msg");
                            session.removeAttribute("flag");
                        } else {
                        %>
                        <div class="alert alert-danger"><strong>Warning!</strong><%=session.getAttribute("msg")%></div>
                        <%
                                    session.removeAttribute("msg");
                                    session.removeAttribute("flag");
                                }
                            }
                        %>
                        <%
                           String userType = request.getParameter("user_type");
                           
                        %>
                        <input type="text" name="full_name_text" placeholder="Fulll Name" required="" pattern=".{3,20}" title="3 to 20 characters" onkeypress="return isCharacterKey(event)">
                        <input type="text" name="mobile_number_text" placeholder="Mobile Number" required="" pattern=".{10,10}" title="Please enter 10 digit mobile number" maxlength="10" onkeypress="return isNumberKey(event)">
                        <label>Login Credential</label>
                        <input type="email" name="email_id_text" placeholder="Email id" required=""> 
                        <input type="password" id="pass12" name="password_text"  placeholder="Password" required="">
                        <input type="text" id="pass12" name="user_type"  placeholder="User Type" required="" value="<% if(userType != null){out.print(userType);} %>" readonly>
                        <% if(userType.equals("Manager")){ %>
                           <input type="text" id="pass12" name="product_name"  placeholder="Product Name" required="" pattern=".{3,20}" title="3 to 20 characters" onkeypress="return isCharacterKey(event)">
                        <% } %>
                        <input type="submit" name="Sign In" value="Sign up">
                    </form>
                    <div class="sign-down">
                        <h4>
                            Already have an account? <a href="./login.jsp"> Login here.</a>
                        </h4>
                    </div>
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





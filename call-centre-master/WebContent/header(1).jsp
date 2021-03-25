<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title> Header</title>
    </head>
    <body>

        <div class="header-main">
            <div class="header-left">
                <div class="logo-name">
                    <a href="home.jsp">
                       <h1>BPO-Amigo</h1> <!--<img id="logo" src="" alt="Logo"/>-->
                    </a>
                </div>
                <!--search-box-->
              <!--  <div class="search-box">
                    <form>
                        <input type="text" placeholder="Search..." required="">
                        <input type="submit" value="">
                    </form>
                </div>
                <!--//end-search-box-->
                <div class="clearfix"></div>
            </div>
            <div class="header-right">

                <!--notification menu end -->
                <div class="profile_details">
                    <ul>
                        <li class="dropdown profile_details_drop"><a href="#"
                                                                     class="dropdown-toggle" data-toggle="dropdown"
                                                                     aria-expanded="false">
                                <div class="profile_img">
                                    <span class="prfil-img"><img src="images/11.png" style="width: 40px;" alt=""> </span>
                                    <div class="user-name">
                                        <p><% if (session.getAttribute("user_name_session") != null) {
                                                                                                        out.println(session.getAttribute("user_name_session"));
                                                                                                    } %></p>
                                        <span><% if (session.getAttribute("user_type") != null) {
                                                                                                        out.println(session.getAttribute("user_type"));
                                                                                                    }%></span>
                                    </div>
                                    <i class="fa fa-angle-down lnr"></i> <i
                                        class="fa fa-angle-up lnr"></i>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                            <ul class="dropdown-menu drp-mnu">
                                <li><a href="#"><i class="fa fa-cog"></i> Settings</a></li>
                                <li><a href="#"><i class="fa fa-user"></i> Profile</a></li>
                                <li><a href="./logout.jsp"><i class="fa fa-sign-out"></i> Logout</a>
                                </li>
                            </ul></li>
                    </ul>
                </div>
                <div class="clearfix"></div>
            </div>
            <div class="clearfix"></div>
        </div>
        <!-- script-for sticky-nav -->
        <script>
            $(document).ready(function () {
                var navoffeset = $(".header-main").offset().top;
                $(window).scroll(function () {
                    var scrollpos = $(window).scrollTop();
                    if (scrollpos >= navoffeset) {
                        $(".header-main").addClass("fixed");
                    } else {
                        $(".header-main").removeClass("fixed");
                    }
                });

            });
        </script>
        <!-- /script-for sticky-nav -->

    </body>
</html>
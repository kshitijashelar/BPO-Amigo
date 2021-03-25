<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>side-bar menu</title>
</head>
<body>

<div class="sidebar-menu">
			<div class="logo">
				<a href="#" class="sidebar-icon"> <span class="fa fa-bars"></span>
				</a> <a href="#"> <span id="logo"></span> <!--<img id="logo" src="" alt="Logo"/>-->
				</a>
			</div>
			<div class="menu">
				<ul id="menu">
					<li id="menu-home"><a href="./home.jsp"><i
							class="fa fa-tachometer"></i><span>Dashboard</span></a></li>
					<li><a href="#"><i class="fa fa-cogs"></i><span>Call Info</span><span
							class="fa fa-angle-right" style="float: right"></span></a>
						<ul>
						    <li><a href="./add_call.jsp">Add Text Data</a></li>
						    <li><a href="./add_audio_call.jsp">Add audio Data</a></li>
                            <li><a href="./view_call.jsp">View</a></li>
                                                 <!--    <li><a href="./assign_teacher.jsp">Assign Teacher</a></li>
                                                    <li><a href="./view_teachers.jsp">View Teachers</a></li> -->
						</ul>
					</li>

					<li id="menu-academico"><a href="#"><i
							class="fa fa-bar-chart"></i><span>Graph</span><span
							class="fa fa-angle-right" style="float: right"></span></a>
						 <ul id="menu-academico-sub">
							<li id="menu-academico-boletim"><a href="./view_analysis_graph.jsp">View Graph</a></li>
							<!-- <li id="menu-academico-avaliacoes"><a href="./send_question_paper.jsp">Send Paper</a></li> -->
						</ul></li>

					
					
				</ul>
			</div>
		</div>
	<script>
		var toggle = true;

		$(".sidebar-icon").click(
				function() {
					if (toggle) {
						$(".page-container").addClass("sidebar-collapsed")
								.removeClass("sidebar-collapsed-back");
						$("#menu span").css({
							"position" : "absolute"
						});
					} else {
						$(".page-container").removeClass("sidebar-collapsed")
								.addClass("sidebar-collapsed-back");
						setTimeout(function() {
							$("#menu span").css({
								"position" : "relative"
							});
						}, 400);
					}
					toggle = !toggle;
				});
	</script>
	<!--scrolling js-->
	<script src="js/jquery.nicescroll.js"></script>
	<script src="js/scripts.js"></script>
	<!--//scrolling js-->

</body>
</html>
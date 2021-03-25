
<%@page import="com.model.Call"%>
<%@page import="java.util.List"%>
<%@page import="com.service.impl.CallServiceImpl"%>
<%@page import="com.service.CallService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>View Calls :: MANAGER HOME</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="web design" />
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
<script src="js/Chart.min.js"></script>
<!--//charts-->

<script src="//cdn.jsdelivr.net/modernizr/2.8.3/modernizr.min.js"
	type="text/javascript"></script>
<script>
	window.modernizr
			|| document
					.write('<script src="lib/modernizr/modernizr-custom.js"><\/script>')
</script>
<!--<script src="lib/html5shiv/html5shiv.js"></script>-->
<!-- Chartinator  -->
<script src="js/chartinator.js"></script>

<script src="js/skycons.js"></script>
<!--//skycons-icons-->
</head>
<body>
	<div class="page-container">
		<div class="left-content">
			<div class="mother-grid-inner">
				<!--header start here-->
				<jsp:include page="./header.jsp"></jsp:include>
				<!--header end here-->

				<!--inner block start here-->
				<div class="inner-block">
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

					<!--mainpage chit-chating-->
					<div class="chit-chat-layer1">
						<div class="col-md-12 chit-chat-layer1-left">
							<div class="work-progres">
								<div class="chit-chat-heading">View All Call Info.</div>
								<div class="table-responsive">
									<table class="table table-hover">
										<thead>
											<tr class="alert alert-success">
												<th>Sr No</th>
												<th>Call ID</th>
												<th>File Name</th>
												<th>Call Text</th>
												<th>Add Date</th>
											</tr>
										</thead>
										<tbody>
											<%
											if(session.getAttribute("user_id_session") != null){
											   CallService callService = new CallServiceImpl();
											   List<Call> calls = callService.findByUser(Integer.parseInt(session.getAttribute("user_id_session").toString()));
											   if(calls.size() == 0){
												   %>
											           <tr class="alert alert-danger">
												           <td colspan="5">Not find records</td>
											            </tr>	   
												   <%
											   }else{
												   int count = 1;
												   for(Call call : calls){
												   %>
												     <tr>
												         <td><%=count %></td>
												         <td><%=call.getCallId() %></td>
												         <td><%=call.getAudioFilePath() %></td>
												         <td><%=call.getCallText() %></td>
												         <td><%=call.getAddCallDate() %></td>
												     </tr>
												   <%
												   count++;
												   }

											   }
											   
											}else{
											%>
											<tr class="alert alert-danger">
												<td colspan="5">Not find records</td>
											</tr>
											<% } %>
										</tbody>
									</table>
								</div>
							</div>
						</div>
						<div class="clearfix"></div>
					</div>


				</div>
				<!--inner block end here-->
				<!--copy rights start here-->
				<jsp:include page="./footer.jsp"></jsp:include>
				<!--COPY rights end here-->
			</div>
		</div>
		<!--slider menu-->
		<jsp:include page="./sidebar_menu.jsp"></jsp:include>
		<div class="clearfix"></div>
	</div>
	<!--slide bar menu end here-->

	<script src="js/bootstrap.js"></script>
	<!-- mother grid end here-->
</body>
</html>

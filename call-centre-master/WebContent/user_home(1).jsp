<%@page import="com.model.ComparisionProductResult"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.model.Result"%>
<%@page import="java.util.List"%>
<%@page import="com.service.impl.ResultServiceImpl"%>
<%@page import="com.service.ResultService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Home :: USER HOME</title>
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
				<jsp:include page="./user_header.jsp"></jsp:include>
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
								<div class="chit-chat-heading">All product call's analysis</div>
								<% 
								    ResultService resultService = new ResultServiceImpl();
									List<Result> results = resultService.findAllResult();
									StringBuilder builderLabel = new StringBuilder();
									Set<String> labels = new HashSet<String>();
									for(Result result : results){
										String aspectResult = result.getAspectResult();
										String[] lines = aspectResult.split("\n");
										for(String line : lines ){
											String[] categoryNameProbability = line.split(",");
											String[] aspectNameSentiment = categoryNameProbability[0].split("=");
											String[] aspectNameArray = aspectNameSentiment[1].split("-");
											String aspectName = aspectNameArray[0];
											labels.add(aspectName);
										}
									}
									
								%>
								<span>Select Label Name :: </span>
								<form action="./AspectComparision" method="post">
								 <%
								   for(String labelName : labels){
								 %>
								 <div class="checkbox">
									  <label><input type="checkbox" name="labelNames" value="<%=labelName %>"><%=labelName %></label>
								 </div>
								 <%
								   }
								 %>
                                <%
                                  if(!labels.isEmpty()){
                                %>
                                    <input type="submit" value="Next" class="btn btn-info">
                                <% } %>
                                </form>
							</div>
							<% if(session.getAttribute("comparisonResult") != null){ %>
							<div class="work-progres">
							    <div class="chit-chat-heading">Comparison Result</div>
							     <%
                  
				                    if(session.getAttribute("predictProduct") != null){
				                	  List<ComparisionProductResult> com = (List<ComparisionProductResult>)session.getAttribute("predictProduct");
				                	   String productName = com.get(0).getProductName();
				                	   double predictValue = com.get(0).getProbabilityValue();
				                	   %>
				                	   <div class="alert alert-success">Predicted Product Name :: <%=productName %>&nbsp;&nbsp;Average Value::<%=predictValue %></div>
				                	   <%
				                	   session.removeAttribute("predictProduct");
				                   }
				                 %>
							     <%
							        Map<String, Map<String, Double>> comparisonResult = (Map<String, Map<String, Double>>) session.getAttribute("comparisonResult");
							     int counter = 0;   
							 %>
							 <table class="table">
							 <%    
							     for(Map.Entry<String,Map<String,Double>> result : comparisonResult.entrySet()){
							    	if(counter == 0){
							     %>
							     <tr>
							     <% } %>
							     <td>
							     <div class="row" style="width: 100%;">
							    
									 <!--  <div class="col-md-4">
									  </div> -->
										  <!-- <div class="col-md-4"> -->
											    <div class="panel panel-default">
											      <div class="panel-heading" ><%=result.getKey() %></div>
											      <div class="panel-body">
											      <%
											          Map<String,Double> aspectProbaility = result.getValue();
											          if(aspectProbaility.isEmpty()){
											        	  out.print("NOT FOUND ASPECT COMPARISION DATA");
											          }else{
											      %>
											       <table class="table">
											       <thead>
											          <tr>
											              <th>Aspect Name </th><th>Probability</th>
											          </tr>
											       </thead>
											       <tbody>
											      <%
											          for(Map.Entry<String,Double> aspectMap : aspectProbaility.entrySet()){
											      %>
											        	 <tr>
											        	     <td><%=aspectMap.getKey().toUpperCase() %></td><td><%=aspectMap.getValue() %></td> 
											        	 </tr>
											      <%
											          }
											      %>
											      </tbody>
											      </table>
											      <% } %>
											      <!-- </div> -->
											    </div>
										  </div>
									 <!--  <div class="col-md-4">
									  
									  </div> -->
								  
								</div>
								</td>
								<% if(counter == 1){ %>
								</tr>
								<% } %>
								<%
								   counter++;
								} %>
							 </table>
							</div>
							<% 
							    session.removeAttribute("comparisonResult");
							} %>
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
		<jsp:include page="./user_sidebar_menu.jsp"></jsp:include>
		<div class="clearfix"></div>
	</div>
	<!--slide bar menu end here-->

	<script src="js/bootstrap.js"></script>
	<!-- mother grid end here-->
</body>
</html>

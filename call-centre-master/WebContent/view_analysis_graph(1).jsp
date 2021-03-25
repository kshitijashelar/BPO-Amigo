
<%@page import="com.model.User"%>
<%@page import="com.service.impl.UserServiceImpl"%>
<%@page import="com.service.UserService"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
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
<title>Home :: MANAGER HOME</title>
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
<script type="text/javascript" src="js/jscharts.js"></script>
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
								<div class="chit-chat-heading"> call analysis report</div>
								<canvas id="bar" height="300" width="400"
									style="width: 400px; height: 300px;">Not found data..</canvas>

								<%
									ResultService resultService = new ResultServiceImpl();
								    UserService userService = new UserServiceImpl();
								    User user = userService.findByUserId(Integer.parseInt(session.getAttribute("user_id_session").toString()));
									List<Result> results = resultService.findAllResult(user.getUserId());
									System.out.println("Find All user call result :: "+results.size());
									StringBuilder builderLabel = new StringBuilder();

									StringBuilder builderPositive = new StringBuilder();

									StringBuilder builderNegative = new StringBuilder();

									ArrayList<String> labels = new ArrayList<String>();
									ArrayList<Integer> positive = new ArrayList<Integer>();
									ArrayList<Integer> negative = new ArrayList<Integer>();
									ArrayList<Integer> neutral = new ArrayList<Integer>();
 									Map<String, Map<String,Integer>> sentimentResult = new HashMap<String, Map<String,Integer>>();
									
									for (Result result : results) {
										String aspectResult = result.getAspectResult();
										String[] lines = aspectResult.split("\n");
										for(String line : lines){
												String[] aspectSplit = line.split(",");
												String aspectCategoryResult = aspectSplit[0];
												String[] aspectCategory = aspectCategoryResult.split("=");
												String[] multiCategoryNames = aspectCategory[1].split(",");
												if(multiCategoryNames.length > 0){
													int count = 0;
													for(String aspCatNm : multiCategoryNames){
														String[] aspCatName = aspCatNm.split("-");
														String aspectName = aspCatName[0];
														String categoyName  = aspCatName[1];
														if(sentimentResult.containsKey(aspectName)){
															Map<String , Integer> resultMap = sentimentResult.get(aspectName);
															if(!resultMap.containsKey(categoyName)){
																resultMap.put(categoyName, 1);
															}else{
																resultMap.put(categoyName, resultMap.get(categoyName)+1);
															}
															sentimentResult.put(aspectName, resultMap);
														}else{
															Map<String, Integer> map2 = new HashMap<String, Integer>();
															map2.put(categoyName, 1);
															sentimentResult.put(aspectName, map2);
														}
														count++;
													}
												}else{
													String[] aspCatName = aspectCategory[1].split("-");
													String aspectName = aspCatName[0];
													String categoyName  = aspCatName[1];
													if(sentimentResult.containsKey(aspectName)){
														Map<String , Integer> resultMap = sentimentResult.get(aspectName);
														if(!resultMap.containsKey(categoyName)){
															resultMap.put(categoyName, 1);
														}else{
															resultMap.put(categoyName, resultMap.get(categoyName)+1);
														}
														sentimentResult.put(aspectName, resultMap);
													}else{
														Map<String, Integer> map2 = new HashMap<String, Integer>();
														map2.put(categoyName, 1);
														sentimentResult.put(aspectName, map2);
													}
											   }
										}
									}
									
									for(Map.Entry<String,Map<String,Integer>> map : sentimentResult.entrySet()){
										labels.add(map.getKey());
										int positiveValue = 0 ; 
										int negativeValue = 0;
										int neutralValue = 0;
										Map<String, Integer> resultSent = map.getValue();
										if(resultSent.containsKey("positive")){
											positive.add(resultSent.get("positive"));
										}else{
											positive.add(positiveValue);
										}
										
										if(resultSent.containsKey("negative")){
											negative.add(resultSent.get("negative"));
										}else{
											negative.add(negativeValue);
										}
									}
									
									
									
									builderLabel.append("[");
                                    for (int labelCount = 0; labelCount < labels.size(); labelCount++) {
                                        builderLabel.append("\"").append(labels.get(labelCount)).append("\"");
                                        if (labelCount + 1 < labels.size()) {
                                            builderLabel.append(",");
                                        }
                                    }
                                    builderLabel.append("]");
                                    System.out.println("Array : " + builderLabel.toString());
                                    
                                    builderNegative.append("[");
                                    for (int negativeCount = 0; negativeCount < negative.size(); negativeCount++) {
                                        builderNegative.append(negative.get(negativeCount));
                                        if (negativeCount + 1 < negative.size()) {
                                            builderNegative.append(",");
                                        }
                                    }
                                    builderNegative.append("]");
                                    System.out.println("Negative : " + builderNegative.toString());
                                    
                                    builderPositive.append("[");
                                    for (int positiveCount = 0; positiveCount < positive.size(); positiveCount++) {
                                        builderPositive.append(positive.get(positiveCount));
                                        if (positiveCount + 1 < positive.size()) {
                                            builderPositive.append(",");
                                        }
                                    }
                                    builderPositive.append("]");
                                    System.out.println("Positive : " + builderPositive.toString());
								%>
								<script type="text/javascript">
									var barChartData = {
										labels : <%=builderLabel.toString()%>,
										datasets : [ {
											fillColor : "#00aced",
											strokeColor : "#00aced",
											data :<%=builderPositive.toString()%>
									}, {

											fillColor : "#ef553a",
											strokeColor : "#ef553a",
											data : <%=builderNegative.toString()%>
									}]

									};
									new Chart(document.getElementById("bar")
											.getContext("2d"))
											.Bar(barChartData);
								</script>
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

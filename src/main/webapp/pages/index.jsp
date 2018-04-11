<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Ski Calculation</title>
		<meta name="viewport" content="width=device-width" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<head>
	<body>
		<h1>Kitzbühel Ski Resort</h1>
		Map file path: <input type="text" id="filepath"><br><br>
		Numbers on map are between <input type="text" size="5" id="lowestPoint" /> and <input type="text" size="5" id="highestPoint" /><br><br>
		Length of calculated path: <span id="lengthPath"></span><br>
		Drop of calculated path: <span id="dropPath"></span><br>
		Calculated path: <span id="path"></span><br>
		Calculated path axis: <span id="axis"></span><br><br>
		<button id="calculate">Calculate</button><br><br>
		<span id="errorMessage"></span>
	</body>
	<script src='${pageContext.request.contextPath}/lib/jquery-2.2.4.min.js'/></script>
	<script type="text/javascript">
		$("#calculate").click(function(){
			if ($("#filepath").val() != "") {
				$.ajax({
					url: "${pageContext.request.contextPath}/api/ski-calculation",
					type: "GET",
					data: {
						filepath: $("#filepath").val(),
						lowestPoint: $("#lowestPoint").val(),
						highestPoint: $("#highestPoint").val()
					}
				}).done(function(response) {
					if (null != response.data && response.statusCode == 200) {
						$("#errorMessage").text("");
						$("#lengthPath").text(response.data.lengthPath);
						$("#dropPath").text(response.data.dropPath);
						var path = "[ ";
						$.each(response.data.path, function(index, value){
							path += value + " - ";
						});
						$("#path").text(path.substring(0, path.length-2) + " ]");
						
						var axis = "[ ";
						$.each(response.data.axis, function(index, value){
							axis += value + " - ";
						});
						$("#axis").text(axis.substring(0, axis.length-2) + " ]");
					} else {
						$("#errorMessage").text(response.messageCode);
					}
				});
			}
		});
	</script>
</html>
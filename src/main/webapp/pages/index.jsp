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
		<h1>Hello, World!</h1>
	</body>
	<script src='${pageContext.request.contextPath}/lib/jquery-2.2.4.min.js'/></script>
	<script type="text/javascript">
		$.ajax({
			url: "${pageContext.request.contextPath}/api/ski-calculation",
			type: "GET"
		}).done(function(response) {
			
		});
	</script>
</html>
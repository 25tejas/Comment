<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="sp" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
	<sp:form modelAttribute="comment" action="/comment/add" method="post">
			<div class="form-group">
				<label>Title</label>
				<sp:input path="posttitle" placeholder="Enter Post Title" class="form-control"/>
				<sp:errors path="posttitle" class="text-danger"></sp:errors>
			</div>
			
			<div class="form-group">
				<label>Post Summary</label>
				<sp:textarea path="message" placeholder="Enter Message" class="form-control"/>
				<sp:errors path="message" class="text-danger"></sp:errors>
			</div>
			
			<div class="form-group">
				<input type="submit" value="Submit" class="btn btn-primary btn-block"/>
				<input type="reset" value="Reset" class="btn btn-danger btn-block"/>
			</div>
	</sp:form>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>CNP Validator</title>
	<meta name="viewport" content="width=device-width, initial-scale=1" charset="UTF-8">
	<style> <%@include file="../css/index.css" %> </style>
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.0/jquery.min.js"></script>
	<script><%@include file="../javascript/display-message-after-click.js" %></script>
</head>
<body>
	<p class="page-title">CNP Validator</p>
	<div class="container">
		<form action="validator" class="validation-form" id="validation-form" method="post">
			<input type="text" placeholder="Enter a CNP" class="insert-text" id="cnp" name="cnp">
			<input type="submit" class="form-button" id="check-button" value="Check">
		</form>
	</div>
	
	<div id="msg">
	</div>
</body>
</html>

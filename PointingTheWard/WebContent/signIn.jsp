<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" >

<link rel="stylesheet" href="css/signIn/signIn.css">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
	  <div class="panel panel-default">
	  	<div class="panel-body">
	  		<form class="form-horizontal" role="form" id="signInRequest" method="post" action="signIn">
			    <div class="form-group">
			      <label class="control-label col-sm-2" for="email">Email:</label>
			      <div class="col-sm-10">
			        <input type="email" class="form-control" id="email" name="email" placeholder="Enter email">
			      </div>
			    </div>
		    	<div class="form-group">
			      <label class="control-label col-sm-2" for="pwd">Password:</label>
			      <div class="col-sm-10">          
			        <input type="password" class="form-control" id="pwd" name="pwd" placeholder="Enter password">
			      </div>
			    </div>
			    <div class="form-group">        
			      <div class="col-sm-offset-2 col-sm-10">
			        <div class="checkbox">
			          <label><input type="checkbox"> Remember me</label>
			        </div>
			      </div>
			    </div>
			    <div class="form-group">        
			      <div class="col-sm-offset-2 col-sm-10">
			        <input type="submit" class="btn btn-default" value="SignIn"/>
			        <a href='<c:url value="/signUpPage"/>'>
			        	<input type="button" class="btn btn-default" value="SignUp"/>
			        </a>
			      </div>
			    </div>
		  </form>
	  	</div>
	  </div>
	</div>
</body>
</html>
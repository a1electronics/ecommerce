<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>A1 electronics e-commerce site</title>
   <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.css"/>
	<link rel="stylesheet" type="text/css" href="assets/css/app.css"/>    
</head>
<body>

<div class="container">
	<div id="header" class="col-md-12">
		<h1>A1 electronics e-commerce site</h1>
	</div>
	<div id="categories" class="col-md-3"></div>
	<div id="products" class="col-md-9"></div>
</div>

<div id="templates" style="display:none;">
	<div id="categoryTemplate">
		<div><div class='categoryName'></div><div class='categoryDescription'></div></div>
	</div>
	<div id="productTemplate">
		<div class="col-md-4">
			<div class='productImage'></div>
			<div class='productName'></div>
			<div class='productPrice'></div>
			<div class='productQnty'></div>
			<div class='productDescription'></div>
		</div>
	</div>
</div>>
<script type="text/javascript" src="assets/js/jquery-2.1.3.min.js" ></script>
<script type="text/javascript" src="assets/js/app.js" ></script>
</body>
</html>
$(document).ready(function(){
	$("body").on("click",".category",function() {
		console.log("Clicked on category");
		var category = $(this).data("category");
		getProducts(category.id).then(function(products){
			appendProducts(products);
		})
	})
	$("body").on("click",".product",function() {
		console.log("Clicked on product");
	})
	
	getCategories().then(function(categories){
		appendCategories(categories);
		$("#categories .category:nth(0)").trigger("click");
	})
	
})

function getCategories(){
	return $.ajax({
		url:"categories",
		method:"get"
	})
}

function getProducts(category_id){
	return $.ajax({
		url:"products/"+category_id,
		method:"get"
	})
}

function appendCategories(categoriesData){
	$.each(categoriesData,function(index,eachCategory){
		var categoryDiv = $("#categoryTemplate div:nth(0)").clone();
		$(categoryDiv).addClass("category");
		$(categoryDiv).find(".categoryName").text(eachCategory.categoryName);
		$(categoryDiv).find(".categoryDescription").html(eachCategory.description);
		$(categoryDiv).data("category",eachCategory);
		$("#categories").append(categoryDiv);
	})
}

function appendProducts(productsData){
	$("#products").empty();
	$.each(productsData,function(index,eachProduct){
		var productDiv = $("#productTemplate div:nth(0)").clone();
		$(productDiv).addClass("product");		
		$(productDiv).find(".productImage").css("background-image","url('assets/images/"+eachProduct.imagePath+"')");
		$(productDiv).find(".productName").text(eachProduct.productName);
		$(productDiv).find(".productPrice").text("Price : "+eachProduct.price);
		$(productDiv).find(".productQnty").text("Quantity : "+eachProduct.quantity);
		$(productDiv).find(".productDescription").html(eachProduct.description);
		$(productDiv).data("product",eachProduct);		
		$("#products").append(productDiv);
	})
}
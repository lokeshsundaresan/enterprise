<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="model.BroadBandmodel" %>
<%@ page import="model.DTHmodel" %>
<%@ page import="model.HAmodel" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous"> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <style>
    .col-sm-11 ul li a
    {
        color:whitesmoke;
    }
    .col-sm-11 ul li a:hover
    {
        color:indianred;
        background-color: white;
        font-weight: bolder;
        font-style: italic;
    }
     
    body
    {
    margin: 0 -15px;
    background-image: url("03.jpg");
    background-repeat: no-repeat;
    background-size: cover;
    overflow-x:hidden;
    }
    .nav
    {
   
    overflow:hidden;
    height:100%;
    } 
    
        .card
    {
     background-image: url("09.jpg");
    background-repeat: no-repeat;
    background-size: cover;
    overflow-x:hidden;
    }
    </style>

</head>
<body>

<%@ include file="adminnavbar.html"%>
<% ArrayList<HAmodel> ha=(ArrayList<HAmodel>)session.getAttribute("ha"); %>
<% ArrayList<DTHmodel> dt=(ArrayList<DTHmodel>)session.getAttribute("dth"); %>
<% ArrayList<BroadBandmodel> bb=(ArrayList<BroadBandmodel>)session.getAttribute("broadband"); %>


<!-- Nav tabs -->
<div class="row">
<div class="col-sm-2">
<ul class="nav nav-tabs flex-column bg-dark" id="myTab" role="tablist">
  <li class="nav-item">
    <a class="nav-link "  href="ProductList" role="tab" >List of Products</a>
  </li>
  <li class="nav-item">
    <a class="nav-link active" id="profile-tab" data-toggle="tab" href="#AddBestSell" role="tab" aria-controls="AddBestSell" aria-selected="false">Add Best Selling</a>
  </li>
  <li class="nav-item">
    <a class="nav-link"  href="CurrentBestSelling"  > Current Best Selling</a>
  <li class="nav-item">
    <a class="nav-link" id="settings-tab" data-toggle="tab" href="#settings" role="tab" aria-controls="settings" aria-selected="false">New Arrivals</a>
  </li>
</ul>
</div>
<div class="col-sm-10">

<div class="row"> 
      		 <%for(HAmodel alist:ha){ %>  
       		     <div class="col-sm-4">   
       			 <div class="card my-2 mx-1 py-2 px-2 ">
       			  <div class="card-title text-danger text-center">Home Products</div>
		         <div class="card-body">
		         <div class="input-group mb-3">
		         <div class="input-group-append">
		         <span class="input-group-text text-white bg-secondary">Home Applicances </span>
		         </div>
		         <input type="text" class="form-control text-uppercase text-primary bg-light font-weight-bolder" value="<%=alist.getHome_applicances()%>" readonly>
		         </div>
		         <div class="input-group mb-3">
		         <div class="input-group-append">
		         <span class="input-group-text text-white bg-secondary">Product Name &nbsp;&nbsp;&nbsp;</span>
		         </div>
		         <input type="text" class="form-control text-uppercase text-primary bg-light font-weight-bolder " value="<%=alist.getProduct_name()%>" readonly>
		         </div>
		         <div class="input-group mb-3">
		         <div class="input-group-append">
		         <span class="input-group-text text-white bg-secondary">Brand &nbsp;&nbsp;&nbsp;</span>
		         </div>
		         <input type="text" class="form-control text-uppercase text-primary bg-light font-weight-bolder " value="<%=alist.getBrand()%>" readonly>
		         </div>
		         <div class="input-group mb-3">
		         <div class="input-group-append">
		         <span class="input-group-text text-white bg-secondary">Prize &nbsp;&nbsp;&nbsp;</span>
		         </div>
		         <input type="text" class="form-control text-uppercase text-primary bg-light font-weight-bolder " value="Rs.<%=alist.getPrize()%>/-" readonly>
		         </div>
		          <a href="BestSelling?doc=<%=alist.getProduct_id() %>&cat=has" class="btn btn-sm btn-danger">Add to Best Seller</a>
		         </div>
		         </div>
		         </div>
		         <%} %>   
		        
		         
		         <!-- BROADBAND PLANS SCHEME -->
		
   			
      		 <%for(BroadBandmodel bbm:bb){ %>  
       		     <div class="col-sm-4">   
       			 <div class="card my-2 mx-1 py-2 px-2 ">
       			  <div class="card-title text-danger text-center">BroadBand Plan</div>
		         <div class="card-body">
		         <div class="input-group mb-3">
		         <div class="input-group-append">
		         <span class="input-group-text text-white bg-secondary">BroadBand Name </span>
		         </div>
		         <input type="text" class="form-control text-uppercase text-primary bg-light font-weight-bolder" value="<%=bbm.getBroadband()%>" readonly>
		         </div>
		         <div class="input-group mb-3">
		         <div class="input-group-append">
		         <span class="input-group-text text-white bg-secondary">Plan Name &nbsp;&nbsp;&nbsp;</span>
		         </div>
		         <input type="text" class="form-control text-uppercase text-primary bg-light font-weight-bolder " value="<%=bbm.getPlanname()%>" readonly>
		         </div>
		         <div class="input-group mb-3">
		         <div class="input-group-append">
		         <span class="input-group-text text-white bg-secondary">Plan Id &nbsp;&nbsp;&nbsp;</span>
		         </div>
		         <input type="text" class="form-control text-uppercase text-primary bg-light font-weight-bolder " value="<%=bbm.getPlanid()%>" readonly>
		         </div>
		         <div class="input-group mb-3">
		         <div class="input-group-append">
		         <span class="input-group-text text-white bg-secondary">Prize &nbsp;&nbsp;&nbsp;</span>
		         </div>
		         <input type="text" class="form-control text-uppercase text-primary bg-light font-weight-bolder " value="Rs.<%=bbm.getPrize()%>/-" readonly>
		         </div>
		         <a href="BestSelling?doc=<%=bbm.getPlanid() %>&cat=bbpl" class="btn btn-sm btn-danger">Add to Best Seller</a>
		         </div>
		         </div>
		         </div>
		         <%} %>   
		
      		 <%for(DTHmodel dth:dt){ %>  
       		     <div class="col-sm-4">   
       			 <div class="card my-2 mx-1 py-2 px-2 ">
       			  <div class="card-title text-danger text-center">DTH SetUp Box</div>
		         <div class="card-body">
		         <div class="input-group mb-3">
		         <div class="input-group-append">
		         <span class="input-group-text text-white bg-secondary">Connection Name </span>
		         </div>
		         <input type="text" class="form-control text-uppercase text-primary bg-light font-weight-bolder" value="<%=dth.getConnection_Name()%>" readonly>
		         </div>
		         <div class="input-group mb-3">
		         <div class="input-group-append">
		         <span class="input-group-text text-white bg-secondary">SetUp Box Name &nbsp;&nbsp;&nbsp;</span>
		         </div>
		         <input type="text" class="form-control text-uppercase text-primary bg-light font-weight-bolder " value="<%=dth.getSetBoxName()%>" readonly>
		         </div>
		         <div class="input-group mb-3">
		         <div class="input-group-append">
		         <span class="input-group-text text-white bg-secondary">Box Id &nbsp;&nbsp;&nbsp;</span>
		         </div>
		         <input type="text" class="form-control text-uppercase text-primary bg-light font-weight-bolder " value="<%=dth.getBoxid()%>" readonly>
		         </div>
		         <div class="input-group mb-3">
		         <div class="input-group-append">
		         <span class="input-group-text text-white bg-secondary">Prize &nbsp;&nbsp;&nbsp;</span>
		         </div>
		         <input type="text" class="form-control text-uppercase text-primary bg-light font-weight-bolder " value="Rs.<%=dth.getPrize()%>/-" readonly>
		         </div>
		        <a href="BestSelling?doc=<%=dth.getBoxid()%>&cat=dth" class="btn btn-sm btn-danger">Add to Best Seller</a>
		         </div>
		         </div>
		         </div>
		         <%} %>   
		         </div>   
		         




</div>
</div>
</body>
</html>
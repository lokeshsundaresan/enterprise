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
    <a class="nav-link active" id="home-tab" data-toggle="tab" href="#list" role="tab" aria-controls="list" aria-selected="true">List of Products</a>
  </li>
  <li class="nav-item">
    <a class="nav-link"  href="AddBestSellingItem.jsp" role="tab">Add Best Selling</a>
  </li>
  <li class="nav-item">
    <a class="nav-link"  href="CurrentBestSelling"  > Current Best Selling</a>
  <li class="nav-item">
    <a class="nav-link" id="settings-tab" data-toggle="tab" href="#settings" role="tab" aria-controls="settings" aria-selected="false">New Arrivals</a>
  </li>
</ul>
</div>


<div class="col-sm-10">
<div class="tab-content">
 
 
               <%if(request.getAttribute("status")!=null){%>
               <script type="text/javascript">
               alert(<%=request.getAttribute("status") %>);
               </script>
              <%   }
            	   %>

<div class="tab-pane active" id="list" role="tabpanel" aria-labelledby="list-tab">
<h3 class="font-weight-bolder text-left text-warning btn-sm btn-danger my-3">Home Applicances</h3>
   			<div class="row"> 
      		 <%for(HAmodel alist:ha){ %>  
       		     <div class="col-sm-4">   
       			 <div class="card my-2 mx-1 py-2 px-2 ">
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
		   
		         </div>
		         </div>
		         </div>
		         <%} %>   
		         </div>   
		         
		         <!-- BROADBAND PLANS SCHEME -->
		         <h3 class="font-weight-bolder text-left text-warning btn-sm btn-danger my-3">BroadBand </h3>
   			<div class="row"> 
      		 <%for(BroadBandmodel bbm:bb){ %>  
       		     <div class="col-sm-4">   
       			 <div class="card my-2 mx-1 py-2 px-2 ">
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
		   
		         </div>
		         </div>
		         </div>
		         <%} %>   
		         </div>   
		         
		         <!-- SetUP Box -->
		         
			<h3 class="font-weight-bolder text-left text-warning btn-sm btn-danger my-3">SetUp Box</h3>
   			<div class="row"> 
      		 <%for(DTHmodel dth:dt){ %>  
       		     <div class="col-sm-4">   
       			 <div class="card my-2 mx-1 py-2 px-2 ">
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
		   
		         </div>
		         </div>
		         </div>
		         <%} %>   
		         </div>   
		         
		         
</div>   
</div>
</div>
</div>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>
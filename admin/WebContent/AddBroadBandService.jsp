<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous"> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style type="text/css">
    body
    {
    background-image: url("8.jpg");
    background-repeat: no-repeat;
    background-size: cover;
    height:100%;
    overflow-x:hidden;
    }
    .card
    {
     background-image: url("5.jpg");
    background-repeat: no-repeat;
    background-size: cover;
    overflow-x:hidden;
    }
    </style>
</head>
<body>


  <%@ include file="adminnavbar.html" %>
  <%@ include file="Broadband.jsp" %>
  
  

    <div class="tab-content">
        <div id="newconnection" class="container tab-pane active my-3"><br>
            <div class="row">
                <div class="col-sm-2"></div>
                <div class="col-sm-8 mx-auto  card  mb-4 mt-3 py-5 ">
                    <form action="AddBroadBandService"  method="get">
                      <div class="form-group">
                        <label for="bbname" class=" font-weight-bolder">BoardBand Name:</label>
                        <input type="text" class="form-control text-danger font-italic font-weight-bolder" placeholder="Enter BroadBand Service Name" name="bbname" required>
                      </div>
                      <div class="form-group">
                        <label for="cid" class=" font-weight-bolder">BoardBane Id:</label>
                        <input type="number" class="form-control text-danger font-italic font-weight-bolder" placeholder="Enter BroadBand Service Id" name="bid" required>
                      </div>
                      <button type="submit" class="btn btn-danger btn-md">Add BroadBand Service</button>
                    </form>
                    <%
   						 if(null!=request.getAttribute("status"))
    					{%>
    					    <div class="card  bg-danger py-3 my-3">
       						<div class=" card-body  text-warning "><%=request.getAttribute("status") %></div>
    				        </div>
    				<%	}
					  %>
                </div>
                <div class="col-sm-2"></div>
            </div> 
        </div>
        </div>
        
        

   


</body>
</html>
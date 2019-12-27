<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    background-image: url("03.jpg");
    background-repeat: no-repeat;
    background-size: cover;
    overflow-x:hidden;
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
            
            <!-- Nav tabs -->
    <div class="row " style="background-color: #4e4e50">
        <div class="col-sm-11 ">
            <ul class="nav nav-pills nav-tabs" role="tablist">
              <li class="nav-item">
                <a class="nav-link "  href="AddBroadBandService.jsp">Add BroadBand Service</a>
              </li>
              <li class="nav-item">
                <a class="nav-link"  href="LoadBroadBand">Add BroadBand Plans</a>
              </li>
              <li class="nav-item">
                <a class="nav-link"  href="ModifyBroadBandService">Modify BroadBand Service</a>
              <li class="nav-item">
                <a class="nav-link"  href="ModifyBroadBandPlan">Modify BroadBand Plans</a>
              </li>
            </ul>
        </div>
    </div>
</body>
</html>
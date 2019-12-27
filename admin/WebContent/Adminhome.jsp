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

       <%@ include file="adminnavbar.html" %>

    <div class="row">
  <div class="col-sm-4 mx-auto mt-5 mb-3">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title text-warning font-weight-bolder font-italic">Add DTH Connection</h5>
        <p class="card-text text-dark font-weight-bolder">You can add the new DTH Connection Services</p>
        <a href="NewDTHConnection.jsp" class="btn btn-danger btn-sm">Click Here</a>
      </div>
    </div>
  </div>
  <div class="col-sm-4 mx-auto mt-5 mb-3">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title text-warning font-weight-bolder font-italic">Add DTH Set Up Box</h5>
        <p class="card-text text-dark font-weight-bolder">You can add the new DTH SetUp Box Services.</p>
        <a href="NewDTHSetBox" class="btn btn-danger btn-sm"> Click Here</a>
      </div>
    </div>
  </div>
  <div class="col-sm-4 mx-auto mt-5 mb-3">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title text-warning font-weight-bolder font-italic">Add  BroadBand</h5>
        <p class="card-text text-dark font-weight-bolder">You can add the new BroadBand  Services.</p>
        <a href="LoadBroadBand" class="btn btn-danger btn-sm">Click Here</a>
      </div>
    </div>
  </div>
  <div class="col-sm-4 mx-auto mt-5 mb-3">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title text-warning font-weight-bolder font-italic">Add Home Applicances</h5>
        <p class="card-text text-dark font-weight-bolder">You can add the new Home Applicances Products.</p>
        <a href="#" class="btn btn-danger btn-sm"> Click Here</a>
      </div>
    </div>
  </div>
 
</div>


    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

</body>
</html>
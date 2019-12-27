<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="model.DTHmodel" %>

<!DOCTYPE html>
<html>
<head>
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
        <div class="col-sm-11  ">
            <ul class="nav nav-pills nav-tabs" role="tablist">
              <li class="nav-item">
                <a class="nav-link "  href="NewDTHConnection.jsp">Add New DTH Connection</a>
              </li>
              <li class="nav-item">
                <a class="nav-link"  href="NewDTHSetBox">Add New DTH SetBox</a>
              </li>
              <li class="nav-item">
                <a class="nav-link"  href="ModifyDTHConnection">Modify DTH Connection</a>
              <li class="nav-item">
                <a class="nav-link"  href="ModifyDTHSetBox">Modify DTH SetBox</a>
              </li>
            </ul>
        </div>
    </div>
         
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
  </body></html>
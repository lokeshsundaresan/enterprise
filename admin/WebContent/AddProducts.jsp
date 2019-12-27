<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.*" %>
<%@ page import="model.HAmodel" %>
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
       <%@ include file="ha.jsp" %>
 
   
      <% ArrayList<HAmodel> ar=(ArrayList<HAmodel>)session.getAttribute("bbdata"); %>
      <div id="NewDTHBox" class="container mb-5"><br>
           <div class="row">
             <div class="col-sm-2">
             </div>
               <div class="col-sm-8 mx-auto card mb-4 mt-3 py-3">
                  <form action="AddProduct"  method="get">        <%
   						 if(null!=request.getAttribute("status"))
    					{%>
    					    <div class="card  py-3 my-3">
       						<div class=" card-body bg-danger text-warning "><%=request.getAttribute("status") %></div>
    				        </div>
    				<%	}
					  %>
                  
    			
    				<div class="form-group">
      				  <label for="cname" class=" font-weight-bolder">Applicances Category:</label>
      					<select class="form-control text-danger font-italic font-weight-bolder" name="cname">
      					<%for(HAmodel model:ar){ %>
      				      <option><%=model.getHome_applicances() %></option>
      				      <%} %>
      				    </select>   
    				</div>
				    <div class="form-group">
				      <label for="appname" class=" font-weight-bolder">Applicances Name</label>
				      <input type="text" class="form-control text-danger  font-italic font-weight-bolder"  placeholder="Applicances Name" name="appname" required autofocus>
				    </div>
				     <div class="form-group">
				      <label for="appname" class=" font-weight-bolder">Brand Name</label>
				      <input type="text" class="form-control text-danger  font-italic font-weight-bolder"  placeholder="Brand" name="brandname"  required>
				    </div>
				    <div class="form-group">
				      <label for="app Id " class=" font-weight-bolder">Applicances ID</label>
				      <input type="number" class="form-control text-danger font-italic font-weight-bolder" placeholder="Applicances Id" name="appid" required>
				    </div>
				    <div class="form-group">
				      <label  for="inlineFormInputGroup" class=" font-weight-bolder">Prize</label>
				      <div class="input-group mb-2">
				        <div class="input-group-prepend">
				          <div class="input-group-text"><i class="fas fa-rupee-sign"></i></div>
				        </div>
				        <input type="number" class="form-control text-danger font-italic font-weight-bolder" name="cash" placeholder="Prize for Product" required>
				      </div>
				    </div>

				    <div class="form-group">
				      <label for="splapp " class=" font-weight-bolder">Special Content 1</label>
				      <input type="text"class="form-control text-danger  font-italic font-weight-bolder"  placeholder="Special Content" name="spl1">
				    </div>
				      <div class="form-group">
				      <label for="splapp " class=" font-weight-bolder">Special Content 2</label>
				      <input type="text"class="form-control text-danger  font-italic font-weight-bolder"  placeholder="Special Content" name="spl2">
				    </div>
				      <div class="form-group">
				      <label for="splapp " class=" font-weight-bolder">Special Content 3</label>
				      <input type="text"class="form-control text-danger  font-italic font-weight-bolder"  placeholder="Special Content" name="spl3">
				    </div>
				      <div class="form-group">
				      <label for="features "class=" font-weight-bolder">Specification</label>
				    <textarea class="form-control text-danger font-italic font-weight-bolder" name="Specification" rows="6"></textarea>
				    </div>
				<!--      <div class="form-group">
				    <label for="exampleInputFile">Image Upload</label>
				    <input type="file" class="form-control-file" name="pics" id="exampleInputFile" aria-describedby="fileHelp">
				    <small id="fileHelp" class="form-text text-muted">Upload a setbox image file</small>
				  </div>  --> 
				      
				
				    <button type="submit" class="btn btn-danger btn-md">Add Product</button>
				  </form>
      			  
                        </div>
                        <div class="col-sm-2"></div>
                    </div> 
              </div>
     


</body>
</html>
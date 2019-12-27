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
</head>
<body >
 
	<%@ include file="adminnavbar.html" %>
    <%@ include file="ha.jsp" %>
    
     <% ArrayList<HAmodel> ar=(ArrayList<HAmodel>)session.getAttribute("data"); %>
     
          <%if(ar.isEmpty())
    	 {%>
    	 <div class="text-danger text-center font-weight-bolder my-4">
    	 <p class=" card bg-light">"No Products added yet."</p>
    	 </div>
     <%} %>
     
       <div class="container">
       <div class="row">
       <%for(HAmodel alist:ar){ %>  
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
         <input type="text" class="form-control text-uppercase text-primary bg-light font-weight-bolder " value="<%=alist.getPrize()%>" readonly>
         </div>
  
         <a href="EditProduct?ids=<%=alist.getProduct_id() %>" class="btn btn-md px-3 btn-danger mt-2 ml-5">Edit</a>
         <a href="RemoveProduct?ids=<%=alist.getProduct_id()%>" class="btn btn-md px-3 btn-danger mt-2 ml-4">Delete</a>
         
         </div>
         </div>
         </div>
         <%} %>   
         </div>       
        </div>
        
        
        <%
   						 if(null!=request.getAttribute("status"))
    					{%>
    					
    					   <script>
    					   alert(<%=request.getAttribute("status") %>);
    					   </script>
    					
    				
    				<%	}
					  %>
   
       
        
            
        
</body>
</html>
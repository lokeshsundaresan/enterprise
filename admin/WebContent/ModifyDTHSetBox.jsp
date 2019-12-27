<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="model.DTHmodel" %>
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
    <%@ include file="DTH.jsp" %>
    
     <% ArrayList<DTHmodel> ar=(ArrayList<DTHmodel>)session.getAttribute("sbox"); %>
     
     <%if(ar.isEmpty())
    	 {%>
    	 <div class="text-danger text-center font-weight-bolder my-4">
    	 <p class=" card bg-light">"No SetUp Box added yet."</p>
    	 </div>
     <%} %>
       <div class="container">
       <div class="row">
       <%for(DTHmodel alist:ar){ %>  
       <div class="col-sm-4">   
        <div class="card my-2 mx-1 py-2 px-2 bg-warning">
        
         <div class="card-title text-center text-dark text-uppercase font-weight-bolder"><%=alist.getConnection_Name() %></div>
         <div class=" my-1 mx-1 py-1 px-1">
         <div class="card-body">
         <div class="input-group mb-3">
         <div class="input-group-append">
         <span class="input-group-text text-white bg-secondary">SetBoxName:</span>
         </div>
         <input type="text" class="form-control text-uppercase text-primary bg-light font-weight-bolder" value="<%=alist.getSetBoxName()%>" readonly>
         </div>
          <div class="input-group mb-3">
         <div class="input-group-append">
         <span class="input-group-text text-white bg-secondary">Prize:</span>
         </div>
         <input type="text"   class="form-control text-uppercase text-primary bg-light font-weight-bolder" value="Rs.<%=alist.getPrize()%> /-" readonly>
         </div>
                  <a href="EditDTHSetBox?boxids=<%=alist.getBoxid() %>" class="btn btn-md btn-danger mr-2 ml-4">Edit</a>
         <a href="RemoveDTHSetBox?boxids=<%=alist.getBoxid() %>" class="btn btn-md btn-danger ml-5 mr-5">Delete</a>
         </div>
         </div>

         </div>
         </div>
         <%} %>       
        </div>
        <%
   						 if(null!=request.getAttribute("status"))
    					{%>
    					    <div class="card bg-danger py-3 my-3">
       						<div class=" card-body  text-warning "><%=request.getAttribute("status") %></div>
    				        </div>
    				<%	}
					  %>
        </div>
       
        
            
        
</body>
</html>
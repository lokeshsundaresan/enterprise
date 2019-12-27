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
 
   
      <% ArrayList<DTHmodel> ar=(ArrayList<DTHmodel>)session.getAttribute("data"); %>
      <div id="NewDTHBox" class="container "><br>
           <div class="row">
             <div class="col-sm-2">
             </div>
               <div class="col-sm-8 mx-auto  card py-3 mb-5 mt-3">
                  <form action="AddDTHSetBox" method="get">        <%
   						 if(null!=request.getAttribute("status"))
    					{%>
    					   <script>
    					   alert(<%=request.getAttribute("status") %>);
    					   </script>
    				<%	}
					  %>
                  
    				<div class="form-group">
      				  <label for="cname" class=" font-weight-bolder">Connection Name:</label>
      					<select class="form-control text-danger font-italic font-weight-bolder" name="cname">
      					<%for(DTHmodel model:ar){ %>
      				      <option><%=model.getConnection_Name() %></option>
      				      <%} %>
      				    </select>   
    				</div>
				    <div class="form-group">
				      <label for="setbox "class=" font-weight-bolder">SetBox Name</label>
				      <input type="text" class="form-control text-danger font-italic font-weight-bolder" id="sbox" placeholder="SetBox Name" name="sbox">
				    </div>
				    <div class="form-group">
				      <label for="setbox Id "class=" font-weight-bolder">SetBox ID</label>
				      <input type="number" class="form-control text-danger font-italic font-weight-bolder" id="bid" placeholder="SetBox Id" name="boxid">
				    </div>
				    <div class="form-group">
				      <label  for="inlineFormInputGroup" class=" font-weight-bolder">Prize</label>
				      <div class="input-group mb-2">
				        <div class="input-group-prepend">
				          <div class="input-group-text"><i class="fas fa-rupee-sign"></i></div>
				        </div>
				        <input type="number" class="form-control text-danger font-italic font-weight-bolder" name="cash" placeholder="Prize for SetBox">
				      </div>
				    </div>
				    <div class="form-group">
				      <label for="setbox "class=" font-weight-bolder">Special Content</label>
				      <input type="text" class="form-control text-danger font-italic font-weight-bolder"  placeholder="Important Notification to Users" name="small">
				    </div>
				      <div class="form-group">
				      <label for="features " class="font-weight-bolder">Features</label>
				    <textarea class="form-control text-danger font-italic font-weight-bolder" name="features" rows="6"></textarea>
				    </div>
				     <div class="form-group">
				    <label for="exampleInputFile">Image Upload</label>
				    <input type="file" class="form-control-file" name="pics" id="exampleInputFile" aria-describedby="fileHelp">
				    <small id="fileHelp" class="form-text text-muted">Upload a setbox image file</small>
				  </div>
				      
				
				    <button type="submit" class="btn btn-danger btn-md ">Add SetUp Box</button>
				  </form>
      			  
                        </div>
                        <div class="col-sm-2"></div>
                    </div> 
              </div>
     


</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.*" %>
<%@ page import="model.BroadBandmodel" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous"> 
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   
</head>
<body>

      <%@ include file="adminnavbar.html" %>
       <%@ include file="Broadband.jsp" %>
 
      <% ArrayList<BroadBandmodel> ak=(ArrayList<BroadBandmodel>)session.getAttribute("bbdata"); %>
      <% ArrayList<BroadBandmodel> ar=(ArrayList<BroadBandmodel>)session.getAttribute("editConnection"); %>
      <div id="NewDTHBox" class="container "><br>
           <div class="row">
             <div class="col-sm-2">
             </div>
               <div class="col-sm-8 mx-auto card mt-3 mb-5 py-3">
                  <form action="UpdateBroadBandPlan" method="get">        <%
   						 if(null!=request.getAttribute("status"))
    					{%>
    					    <div class="card  py-3 my-3">
       						<div class=" card-body bg-danger text-warning "><%=request.getAttribute("status") %></div>
    				        </div>
    				<%	}
					  %>
                  <%for(BroadBandmodel model:ar){ %>
    			
    				<div class="form-group">
      				  <label for="cname" class="font-weight-bolder">BroadBand Name:</label>
      					<select class="form-control font-weight-bolder text-danger" name="cname">
      					<option><%=model.getBroadband() %></option>
      					<%for(BroadBandmodel mod:ak){ %>
      				      <option><%=mod.getBroadband() %></option>
      				      <%} %>
      				    </select>   
    				</div>
				    <div class="form-group">
				      <label for="setbox " class="font-weight-bolder">Plan Name</label>
				      <input type="text" class="form-control font-weight-bolder text-danger"  placeholder="BroadBand Plan Name" value="<%=model.getPlanname() %>" name="planname">
				    </div>
				    <div class="form-group">
				      <label for="setbox Id " class="font-weight-bolder">Plan ID</label>
				      <input type="number" class="form-control font-weight-bolder text-danger" placeholder="BroadBand Plan Id" value="<%=model.getPlanid() %>" name="ppid" readonly>
				    </div>
				    <div class="form-group">
				      <label  for="inlineFormInputGroup " class="font-weight-bolder">Prize</label>
				      <div class="input-group mb-2">
				        <div class="input-group-prepend">
				          <div class="input-group-text font-weight-bolder"><i class="fas fa-rupee-sign"></i></div>
				        </div>
				        <input type="number" class="form-control font-weight-bolder text-danger" name="cash" value="<%=model.getPrize() %>" placeholder="Prize for SetBox">
				      </div>
				    </div>
				    <div class="form-group">
				      <label for="setbox " class="font-weight-bolder">Range From</label>
				      <input type="number" class="form-control font-weight-bolder text-danger" value="<%=model.getSpeed()%>" placeholder="speed in MB/s" name="speed">
				    </div>
				    <div class="form-group">
				      <label for="setbox " class="font-weight-bolder">Data </label>
				      <input type="number" class="form-control font-weight-bolder text-danger"  placeholder="data in GB" value="<%=model.getGb() %>"name="gb">
				    </div>
				      <div class="form-group">
				      <label for="features "class="font-weight-bolder">Features</label>
				    <textarea class="form-control font-weight-bolder text-danger" name="features" rows="6"><%=model.getFeatures()%></textarea>
				    </div>
				<!--      <div class="form-group">
				    <label for="exampleInputFile">Image Upload</label>
				    <input type="file" class="form-control-file" name="pics" id="exampleInputFile" aria-describedby="fileHelp">
				    <small id="fileHelp" class="form-text text-muted">Upload a setbox image file</small>
				  </div>  --> 
				      
				    <%} %>
				    <button type="submit" class="btn btn-danger">Update</button>
				  </form>
      			  
                        </div>
                        <div class="col-sm-2"></div>
                    </div> 
              </div>
 


</body>
</html>
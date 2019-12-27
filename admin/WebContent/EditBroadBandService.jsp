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
       
      <% ArrayList<BroadBandmodel> al=(ArrayList<BroadBandmodel>)session.getAttribute("editConnection"); %>
      
       
    <div class="tab-content">
        <div id="newconnection" class="container tab-pane active"><br>
            <div class="row">
                <div class="col-sm-2"></div>
                <%for(BroadBandmodel model:al) {%>
                <div class="col-sm-8 mx-auto  card my-auto py-3">
                    <form action="UpdateBroadBandService"  method="get">
                      <div class="form-group">
                        <label for="cname" class="font-weight-bolder">BroadBand Service Name:</label>
                        <input type="text" class="form-control font-weight-bolder text-danger "  placeholder="Enter BroadBand Service Name" name="cname" value="<%=model.getBroadband() %>">
                      </div>
                      <div class="form-group">
                        <label for="cid" class="font-weight-bolder">BroadBand Service Id:</label>
                        <input type="number" class="form-control font-weight-bolder text-danger" name="bid" value="<%=model.getBid()%>" readonly>
                      </div>
                    <%} %>
                      <button type="submit" class="btn btn-danger btn-md">Update</button>
                    </form>
                </div>
                <div class="col-sm-2"></div>
            </div> 
        </div>
        </div>
        
        


</body>
</html>
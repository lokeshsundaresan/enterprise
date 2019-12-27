<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.HAmodel" %>
<%@ page import="java.util.*" %>
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
     <%@ include file="ha.jsp" %>
       
      <% ArrayList<HAmodel> al=(ArrayList<HAmodel>)session.getAttribute("editConnection"); %>
      
       
    <div class="tab-content">
        <div id="newconnection" class="container tab-pane active my-5"><br>
            <div class="row">
                <div class="col-sm-2"></div>
                <div class="col-sm-8 py-3 my-5 mt-3 card py-3 ">
               <% for(HAmodel model:al){ %>
                    <form action="UpdateHomeApplicances" method="get">
                      <div class="form-group">
                        <label for="cname" class=" font-weight-bolder">Home Applicances Name:</label>
                        <input type="text" class="form-control text-danger font-italic font-weight-bolder"  placeholder="Enter New Applicances Name" name="haname"  value="<%=model.getHome_applicances() %>" required>
                      </div>
                      <div class="form-group">
                        <label for="cid" class="font-weight-bolder">Home Applicances Id:</label>
                        <input type="number" class="form-control text-danger font-italic font-weight-bolder"  name="hid"  value="<%=model.getHid()%>"readonly>
                      </div>
                      <button type="submit" class="btn btn-danger mx-auto my-auto btn-md">Update</button>
                      <%} %>
                    </form>
                    <%
   						 if(null!=request.getAttribute("status"))
    					{%>
    					    <script>
    					   alert(<%=request.getAttribute("status")%>);
    					   </script>
    				<%	}
					  %>
                </div>
                <div class="col-sm-2"></div>
            </div> 
        </div>
        </div>
        


</body>
</html>
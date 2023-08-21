<!DOCTYPE html>
<%@page import="com.lms.librarymanagementsystem.models.Registration"%>
<%@page import="java.util.List"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        body {
            
            font-family: Helvetica, Arial, sans-serif;
            overflow-x: hidden; /* To hide horizontal scrollbar */
            background: #282a36;
            color: aliceblue;
            position: relative;
            height: 100vh;
        }

table {
  border-collapse: collapse;
  width: 100%;
  max-width: 100%;
  white-space: nowrap; /* To prevent line breaks in table cells */
}

th,
td {
  padding: 10px;
  text-align: left;
  border: 1px solid #2c2c2c;
}

th {
  background-color: #010044;
}

tr:nth-child(even) {
  background-color: #3a3a3a;
}

/* Custom scrollbar for the table */
.scrollTo {
  overflow-y: scroll;
  max-height: 100vh;
  scrollbar-width: thin;
  /* scrollbar-color: #ccc #f5f5f5; */
}

.scrollTo::-webkit-scrollbar {
  width: 8px;
}

.scrollTo::-webkit-scrollbar-corner{
  display: none;
}
.scrollTo::-webkit-scrollbar {
  width: 8px;
}

.scrollTo::-webkit-scrollbar-thumb {
    background-color: #585858;
    border-radius: 10px;
    /* border: 2px solid #f5f5f5; */
}

.scrollTo::-webkit-scrollbar-thumb:hover {
    background-color: #5c5e6f;
}

button {
        padding: 8px 12px;
        border-radius: 4px;
        border: none;
        background-color: #4CAF50;
        color: white;
        cursor: pointer;
        font-size: 14px;
        }

        button:hover {
        background-color: #3e8e41;
        }

        .rejectbtn {
            
        padding: 8px 12px;
        border-radius: 4px;
        border: none;
        background-color: #f44336;
        color: white;
        cursor: pointer;
        font-size: 14px;
        }

        .rejectbtn:hover {
        background-color: #cc2e24;
        }

        /* add styles for the rejection form */
        .rejection {
            border-radius: 5px;
            width: fit-content;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            transition: all .5s cubic-bezier(0.215, 0.610, 0.355, 1);
            background-color: #454545;
            padding: 20px;
            /* box-shadow: 0 0 10px rgba(0, 0, 0, 0.3); */
            -webkit-box-shadow: 2px 3px 60px -13px rgba(19,182,214,0.64);
            -moz-box-shadow: 2px 3px 60px -13px rgba(19,182,214,0.64);
            box-shadow: 2px 3px 60px -13px rgba(19,182,214,0.64);
        }

        .rejection textarea {
            resize: none;
            background-color: #3a3a3a;
            color: aliceblue;
            /* width: 100%; */
            border-radius: 5px;
            height: 200px;
            margin-bottom: 10px;
            padding: 10px;
            font-size: 16px;
            font-family: Helvetica, Arial, sans-serif;
        }
        

        .rejection textarea:focus{
            outline: 3px solid #8fd4ffd6;
        }

        .rejection button {
            background-color: #008CBA;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
        }

        .rejection button:hover {
            background-color: #006080;
        }

        .Cancelbtn {
            width: fit-content;
            background-color: #f44336;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
        }

        .Cancelbtn:hover {
            background-color: #d32f2f;
        }



/* Responsive table */
@media only screen and (max-width: 600px) {
  table,
  thead,
  tbody,
  th,
  td,
  tr {
    display: block;
  }
  
  /* Hide table headers */
  thead tr {
    position: absolute;
    top: -9999px;
    left: -9999px;
  }
  
  /* Show vertical scrollbar */
  .scrollTo {
    overflow-y: scroll;
    max-height: none;
  }
  
  /* Styling for table cells */
  td {
    border: none;
    position: relative;
    padding-left: 50%;
    text-align: left;
  }
  
  td:before {
    position: absolute;
    top: 6px;
    left: 6px;
    width: 45%;
    padding-right: 10px;
    white-space: nowrap;
    content: attr(data-column);
    font-weight: bold;
    text-align: left;
  }
}

.text-center{
    text-align: center;
}

.modal-canvas{
    width: fit-content;
    height: fit-content;
    padding: 20px;
    border-radius: 10px;
    position: absolute;
    top: 50%;
    background: #343542;
    left: 50%;
    display: none;
    transform: translate(-50%, -50%);
    box-shadow: rgba(0, 0, 0, 0.3) 0px 19px 38px, rgba(0, 0, 0, 0.22) 0px 15px 12px;
}

    #myDiv {
        display: none;
        width: fit-content;
        height: 400px;
        background: cyan;
        margin-bottom: 20px;
    }

    #capturedElement {
        border: none;
        outline: none;
        background-color: transparent;
        color: aliceblue;
    }

    </style>
</head>
<% 
    List<Registration> registrations=(List<Registration>) request.getAttribute("registrations");
	String category="Pending "+(String)request.getAttribute("category")+" Requests";
%>
<body>
    <h1 class="text-center"><%=category%></h1>
	<% if(registrations.isEmpty()) { %>
        <h1>No Pending Requests are Found</h1>
    <% } else { %>
          <div class="scrollTo">
            <table border="1">
                <tr>
                    <th>RSID</th>
                    <th>USERNAME</th>
                    <th>PROFILEPICTURE</th>
                    <th>FIRSTNAME</th>
                    <th>LASTNAME</th>
                    <th>GENDER</th>
                    <th>DOB</th>
                    <th>PHONE</th>
                    <th>EMAIL</th>
                    <th>CATEGORY</th>
                    <th>PAID</th>
                    <%if(((String)request.getAttribute("category")).equals("paid")){%>
                        <th>TRANSACTION</th>
                    <%}%>
                    <th>APPROVE</th>
                    <th>REJECT</th>
                </tr>
                <%for(Registration registration:registrations){ %>
                    <tr>
                        <td><%=registration.getRsid()%></td>
                        <td><%=registration.getUsername()%></td>
                        <td><img src="/uploads/profilePictures/<%=registration.getProfilePicture()%>" alt="image" width="100" height="100"></td>
                        <td><%=registration.getFirstName()%></td>
                        <td><%=registration.getLastName()%></td>
                        <td><%=registration.getGender() %></td>
                        <td><%=registration.getDob() %></td>
                        <td><%=registration.getPhone() %></td>
                        <td><%=registration.getEmail() %></td>
                        <td><%=registration.getCategory() %></td>
                        <td><%=registration.getPaid() %></td>
                        <%if(((String)request.getAttribute("category")).equals("paid")){%>
                            <td><%=registration.getTransaction() %></td>
                        <%}%>
                        <td>
                            <form action="/admin/approveuser" method="post">
                                <input type="number" value="<%=registration.getRsid()%>" name="rsid" hidden>
                                <input type="text"  name="membershipexpire" id="membershipexpire" hidden>
                                <input type="text" value="<%=(String)request.getAttribute("category")%>" name="pay" hidden>
                                <textarea name="libraryCard" hidden id="capturedElement" maxlength="52428899"></textarea>
                                <button>APPROVE</button>
                            </form>
                        </td>
                        <td>
                            <button class="rejectbtn" onclick="createRejectForm('<%=registration.getRsid()%>','<%=registration.getUsername()%>')">REJECT</button>
                        </td>
                    </tr>
                <%} %>
            </table>
          </div>
            <form action="/admin/rejectuser" method="post" class="rejection" hidden>
                <input type="number"  name="rsid" class="rejectionrsid" hidden >
                <!-- <input type="text"  name="username" class="username" hidden > -->
                <input type="text" value='<%= (String)request.getAttribute("category") %>' name="pay" hidden>
                <textarea name="message" cols="80" placeholder="Write the reason..."></textarea>
                <button  style="display: inline;">Send Message</button>
                <div onclick="hideForm()" style="display: inline; float: right;"  class="Cancelbtn"hidden >Cancel</div>
            </form>
        <% } %>
</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/0.5.0-beta4/html2canvas.min.js"></script>
<script src="/js/registrationRequest.js"></script>
</html>
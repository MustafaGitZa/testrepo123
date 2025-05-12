<%-- 
    Document   : dashboard
    Created on : May 2, 2025, 2:56:49 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>MM Mobile Mechanic Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f0f2f5;
            margin: 0;
            padding: 0;
        }
        /* Navbar Styles */
        .navbar {
            background-color: #007bff;
            padding: 15px 20px;
            color: white;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .navbar h1 {
            margin: 0;
            font-size: 22px;
        }
        .navbar a {
            color: white;
            text-decoration: none;
            margin-left: 20px;
            font-size: 16px;
        }
        .navbar a:hover {
            text-decoration: underline;
        }

        /* Dashboard Content */
        .dashboard {
            background: white;
            padding: 30px;
            border-radius: 10px;
            max-width: 600px;
            margin: 40px auto;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        .dashboard h2 {
            margin-bottom: 20px;
        }
        .nav-link {
            display: block;
            margin: 12px 0;
            font-size: 18px;
            color: #007bff;
            text-decoration: none;
        }
        .nav-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

    <%
        String username = (String)session.getAttribute("username");
       
    %>
    <!-- Navbar -->
    <div class="navbar">
        <h1>MM Mobile Mechanic</h1>
        <div>
            <a href="LogOutServlet.do">Logout</a>
        </div>
    </div>

    <!-- Dashboard Content -->
    <div class="dashboard">
        <h2>Welcome, <%=username%></h2>
        <p>What would you like to do today?</p>

        <a class="nav-link" href="bookAppointment.jsp">? Book an Appointment</a>
        <a class="nav-link" href="viewAppointments.jsp">? View My Appointments</a>
        <a class="nav-link" href="profile.jsp">? View/Edit Profile</a>
    </div>

</body>
</html>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Questions</title>
<style>
    body {
        font-family: 'Arial', sans-serif;
        background: linear-gradient(to bottom right, #008CBA, #f44336); /* Gradient background color */
        text-align: center;
        margin: 0;
        padding: 0;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        height: 100vh;
    }

    h1 {
        color: white;
        text-shadow: 2px 2px 4px #333;
        margin-bottom: 20px;
        font-size: 24px;
        animation: fadeInUp 1s ease-in-out;
    }

    /* Stylish button styles with hover effect */
    input[type="submit"] {
        background-color: #3498DB; /* Blue background color */
        color: #fff;
        border: none;
        padding: 10px 20px;
        cursor: pointer;
        border-radius: 5px;
        transition: background-color 0.3s;
        font-size: 16px;
        margin: 10px;
        animation: fadeInUp 1s ease-in-out;
    }

    input[type="submit"]:hover {
        background-color: #0074D9; /* Darker blue background color on hover */
    }

    table {
        width: 80%; /* Adjust the table size */
        margin-top: 20px;
        animation: fadeInUp 1s ease-in-out;
    }

    @media only screen and (max-width: 600px) {
        h1 {
            font-size: 18px;
        }
        input[type="submit"] {
            font-size: 14px;
        }
        table {
            width: 90%;
        }
    }

    /* Animation keyframes */
    @keyframes fadeInUp {
        from {
            opacity: 0;
            transform: translateY(20px);
        }
        to {
            opacity: 1;
            transform: translateY(0);
        }
    }
</style>
</head>
<body>
    <h1>Questions Page</h1>
     <h1>Your Q_ID : ${q_id}</h1>
    <!-- Table to display questions -->
    ${q_id_table}
     
    <!-- Button to go back to home -->
    <form action="back" method="post">
        <input type="submit" value="Back to Home">
    </form>

    <!-- Button to go back to createquiz -->
    <form action="createquiz.jsp" method="post">
        <input type="submit" value="Back to createquiz">
    </form>
</body>
</html>

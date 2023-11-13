<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Quiz Questions</title>
<style>
    /* Stylish button styles */
    input[type="submit"] {
        background-color: #4CAF50; /* Green background color */
        color: #fff;
        border: none;
        padding: 12px 24px;
        cursor: pointer;
        border-radius: 5px;
        transition: background-color 0.3s;
        font-size: 16px;
    }

    input[type="submit"]:hover {
        background-color: #45a049; /* Darker green background color on hover */
    }

    body {
        font-family: 'Arial', sans-serif;
        text-align: center;
        background: linear-gradient(to bottom right, #008CBA, #f44336); /* Gradient background color */
        margin: 0;
        padding: 0;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        height: 100vh;
        animation: fadeIn 1.5s ease-out; /* Added fade-in animation */
    }

    form {
        background-color: #f5f5f5;
        border: 1px solid #ccc;
        border-radius: 10px;
        padding: 20px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
        max-width: 600px;
        width: 90%;
        box-sizing: border-box;
        margin-top: 20px;
        animation: fadeInUp 1.5s ease-out; /* Added fade-in-up animation */
    }

    h1 {
        color: #fff;
        text-shadow: 2px 2px 4px #333;
        margin-top: 20px;
        animation: fadeInDown 1.5s ease-out; /* Added fade-in-down animation */
    }

    .table-container {
        width: 80%; /* Adjusted table width */
        margin-top: 20px;
        border-collapse: collapse;
        overflow-y: auto; /* Added scroll for overflow */
        max-height: 400px; /* Set a maximum height for the container */
        animation: fadeInUp 1.5s ease-out; /* Added fade-in-up animation */
    }

    table {
        width: 100%;
    }

    table, th, td {
        border: 1px solid #ddd;
    }

    th, td {
        padding: 12px;
        text-align: left;
    }

    th {
        background-color: #4CAF50; /* Green background color */
        color: #fff;
    }

    @media only screen and (max-width: 600px) {
        form {
            width: 100%;
        }

        .table-container {
            width: 100%;
            max-height: none; /* Remove max height for smaller screens */
        }
    }

    @keyframes fadeIn {
        from {
            opacity: 0;
        }
        to {
            opacity: 1;
        }
    }

    @keyframes fadeInUp {
        from {
            transform: translateY(20px);
            opacity: 0;
        }
        to {
            transform: translateY(0);
            opacity: 1;
        }
    }

    @keyframes fadeInDown {
        from {
            transform: translateY(-20px);
            opacity: 0;
        }
        to {
            transform: translateY(0);
            opacity: 1;
        }
    }
</style>
</head>
<body>
    
    <form action="showquestions" method="post">
        <label for="q_id">Enter Quiz ID:</label>
        <input type="text" id="q_id" name="q_id_name" placeholder="Type quiz ID here" required>
        <input type="submit" value="Show Questions">
    </form>
    
    <!-- Table container with scroll -->
    <div class="table-container">
        <h1>${quiz_question_table}</h1>
    </div>
  
    <form action="back" method="post">
        <input type="submit" value="Back to Home">
    </form>
     
    <form action="createquiz.jsp" method="post">
        <input type="submit" value="Back to Create Quiz">
    </form>
</body>
</html>

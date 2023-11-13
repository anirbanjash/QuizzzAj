<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Quiz History</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background: linear-gradient(to bottom right, #008CBA, #f44336);
            text-align: center;
            margin: 0;
            padding: 0;
            color: #fff;
            overflow: hidden;
        }

        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            overflow-x: auto;
            overflow-y: auto; /* Add this line for vertical scroll */
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            border-radius: 10px;
            background-color: #fff;
            color: #333;
        }

        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #4CAF50;
            color: #fff;
        }

        tr:hover {
            background-color: #f5f5f5;
        }

        .back-button {
            margin-top: 20px;
            background-color: #3498DB;
            color: #fff;
            border: none;
            padding: 12px 24px;
            cursor: pointer;
            border-radius: 5px;
            transition: background-color 0.3s;
            font-size: 16px;
            text-decoration: none;
        }

        .back-button:hover {
            background-color: #0074D9;
        }
    </style>
</head>
<body>
    <table>
        ${hist_table}
    </table>

    <form action="back" method="post">
        <button type="submit" class="back-button">Back to Home</button>
    </form>
</body>
</html>

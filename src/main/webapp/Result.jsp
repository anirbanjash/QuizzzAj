<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quiz Result</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background: linear-gradient(to bottom right, #008CBA, #f44336);
            text-align: center;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
            color: #fff;
        }

        .container {
            background-color: #fff;
            border: 1px solid #ccc;
            border-radius: 10px;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            max-width: 800px;
            width: 90%;
            box-sizing: border-box;
            margin-top: 20px;
            overflow: auto;
        }

        h1 {
            color: #333;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
            overflow: auto;
        }

        table, th, td {
            border: 1px solid #ddd;
        }

        th, td {
            padding: 12px;
            text-align: left;
        }

        th {
            background-color: #4CAF50;
            color: #fff;
        }

        .score-message {
            margin-top: 20px;
            font-size: 18px;
        }

        .back-form {
            margin-top: 20px;
        }

        .back-button {
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

    <div class="container">
        <h1>Quiz Result</h1>
        <div class="score-message">
            ${score_res}
        </div>
        
        <div class="table-container">
            ${miaaa}
        </div>
        <br></br>
        <form class="back" action="back" method="post">
            <button class="back-button" type="submit">Back to Home</button>
        </form>
    </div>

</body>
</html>

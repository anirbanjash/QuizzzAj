<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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
        }

        /* Stylish button styles */
        input[type="submit"] {
            background-color: #3498DB; /* Blue background color */
            color: #fff;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
            margin: 10px;
            border-radius: 5px;
            transition: background-color 0.3s;
            font-size: 16px;
        }

        input[type="submit"]:hover {
            background-color: #0074D9; /* Darker blue background color on hover */
        }

        @media only screen and (max-width: 600px) {
            h1 {
                font-size: 18px;
            }
            input[type="submit"] {
                font-size: 14px;
            }
        }
    </style>
</head>
<body>
    <h1>Show your Questions</h1>

    <!-- Button to Show Questions -->
    <form action="examlastpage" method="post">
        <input type="submit" value="Show Questions">
    </form>

    <!-- Button to Go Back to Home -->
    <form action="back" method="post">
        <input type="submit" value="Back to Home">
    </form>
</body>
</html>

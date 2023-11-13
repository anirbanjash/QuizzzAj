<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quiz Entry</title>
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
        }

        .form-container {
            background-color: #f5f5f5;
            border: 1px solid #ccc;
            border-radius: 10px;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            max-width: 600px;
            width: 90%;
            box-sizing: border-box;
        }

        .container-heading {
            color: #008CBA;
            text-shadow: 2px 2px 4px #333;
            margin-bottom: 20px;
            font-size: 24px;
        }

        label {
            display: block;
            font-weight: bold;
            margin-bottom: 10px;
            color: #333;
            font-size: 16px;
        }

        input[type="text"] {
            width: 100%;
            padding: 12px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
            font-size: 16px;
        }

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

        .back-button {
            background-color: #f44336; /* Red background color */
            color: #fff;
            border: none;
            padding: 12px 24px;
            cursor: pointer;
            border-radius: 5px;
            transition: background-color 0.3s;
            font-size: 16px;
        }

        .back-button:hover {
            background-color: #d32f2f; /* Darker red background color on hover */
        }

        @media only screen and (max-width: 600px) {
            .form-container {
                width: 100%;
            }
        }
    </style>
</head>

<body>

    <div class="form-container">
        <h1 class="container-heading">Quiz Entry</h1>
        <form action="usertable" method="post">
            <label for="name">Enter your Name:</label>
            <input type="text" id="name" name="myname" placeholder="Enter your name" required>

            <label for="phone">Phone Number:</label>
            <input type="text" id="phone" name="phone" placeholder="Enter your phone number" required>

            <label for="q_id">Quiz ID:</label>
            <input type="text" id="q_id" name="q_id" placeholder="Enter the Quiz ID" required>

            <input type="submit" value="Let's Go for the Quiz">
        </form>
        <br></br>
        <form action="userhistory" method="post">
        
            <label for="q_id">Check Your History</label>
            <label for="q_id">Phone Number</label>
            <input type="text" id="q_id" name="ph_no" placeholder="Enter the Phone Number" required>
             
            <input type="submit" value="History">
        </form>
        <br></br>
        <!-- Form for "Back to Home" button -->
        <form action="back" method="post">
            <button class="back-button" type="submit">Back to Home</button>
        </form>
        <div class="success-message">
                <strong>${mui}</strong>
            </div>
    </div>
<script>
    // Remove the message after 2 seconds
    setTimeout(() => {
      const successMessages = document.querySelectorAll('.success-message');
      successMessages.forEach(message => {
        message.style.display = 'none';
      });
    }, 4000);
  </script>
</body>

</html>

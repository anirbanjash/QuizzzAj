<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>QuizzzyyAj - Create Exam</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background: linear-gradient(to bottom right, #008CBA, #f44336);
            text-align: center;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
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

        input[type="text"],
        input[type="submit"],
        .back-button,
        .view-buttons {
            width: 100%;
            padding: 12px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
            font-size: 16px;
        }

        input[type="submit"],
        .back-button,
        .view-buttons {
            background-color: #008CBA;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background 0.3s;
            text-decoration: none;
            display: inline-block;
            margin-top: 10px;
            width: auto;
        }

        input[type="submit"]:hover,
        .back-button:hover,
        .view-buttons:hover {
            background-color: #005580;
        }

        .back-button {
            background-color: #f44336;
            margin-top: 10px;
        }

        .back-button:hover {
            background-color: #d32f2f;
        }

        .view-buttons {
            background-color: #4CAF50;
            margin-top: 10px;
        }

        .view-buttons:hover {
            background-color: #45a049;
        }

        .success-message {
            strong {
                color: green;
            }
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
        <h1 class="container-heading">QuizzzyyAj - Create Exam</h1>
        <form action="createquiz" method="post">
            <label for="examTopic">Enter Your Exam Topic:</label>
            <input type="text" id="examTopic" name="examTopic" placeholder="Type your exam topic here" required>
            <input type="submit" value="Create Quiz">
        </form>
        
        <!-- Another form for the "Back to Home" button -->
        <form action="back" method="post">
            <button type="submit" class="back-button">Back to Home</button>
        </form>
        
        <!-- Buttons for viewing quiz list, quiz scores, and quiz questions -->
        <form action="quizlist" method="post">
            <button type="submit" class="view-buttons">Show Quiz List</button>
        </form>
        
        <form action="AdminQuizscore.jsp" method="post">
            <input type="submit" value="Show Quiz Score">
        </form>
        <form action="DeleteQuiz.jsp" method="post">
            <input type="submit" value="Delete Quiz">
        </form>
        <form action="viewquizquestion.jsp" method="post">
            <button type="submit" class="view-buttons">Show Quiz Questions</button>
        </form>

        <div class="success-message">
            <strong>${mess}</strong>
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

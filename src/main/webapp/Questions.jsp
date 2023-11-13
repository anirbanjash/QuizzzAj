<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>QuizzzAJ - Add Question</title>
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
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.3);
            max-width: 600px;
            width: 90%;
            box-sizing: border-box;
        }

        .container-heading {
            margin-bottom: 20px;
        }

        .exam-name {
            color: black;
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.8);
            background: linear-gradient(to bottom right, #E0E0E0, #BDBDBD);
            padding: 10px;
            border-radius: 5px;
        }

        .exam-id {
            color: black;
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.8);
            background: linear-gradient(to bottom right, #FFF176, #FFEB3B);
            padding: 10px;
            border-radius: 5px;
        }

        label {
            display: block;
            font-weight: bold;
            margin-bottom: 10px;
            color: #333;
        }

        input[type="text"],
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }

        input[type="submit"],
        .finish-button {
            background-color: #008CBA;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background 0.3s;
            text-decoration: none;
            display: inline-block;
            margin-top: 10px;
        }

        input[type="submit"]:hover,
        .finish-button:hover {
            background-color: #005580;
        }

        .finish-button {
            background-color: #f44336;
            margin-left: 10px;
        }

        .finish-button:hover {
            background-color: #d32f2f;
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
        <h1 class="container-heading exam-name">QuizzzAJ - Add Question</h1>
        
        <h2 class="container-heading exam-name">${exam_name}</h2>
        <h2 class="container-heading exam-id">Your Exam ID: ${q_id}</h2>
        
        <!-- Form 1 for Adding Question -->
        <form action="questionadd" method="post">
            <label for="question">Enter Your Question: ${q_no}</label>
            <input type="text" id="question" name="question" placeholder="Type your question here" required>

            <label for="option1">Enter Option 1:</label>
            <input type="text" id="option1" name="option1" placeholder="Type option 1" required>

            <label for="option2">Enter Option 2:</label>
            <input type="text" id="option2" name="option2" placeholder="Type option 2" required>

            <label for="option3">Enter Option 3:</label>
            <input type="text" id="option3" name="option3" placeholder="Type option 3" required>

            <label for="option4">Enter Option 4:</label>
            <input type="text" id="option4" name="option4" placeholder="Type option 4" required>

            <label for="answer">Enter Correct Answer:</label>
            <input type="text" id="answer" name="answer" placeholder="Type the correct answer" required>

            <input type="submit" value="Add">
        </form>

        <!-- Form 2 for Finish Button -->
        <form action="Examlastpageprev.jsp" method="post"><button class="finish-button">Finish Questions</button></form>
        <br></br>
        <form action="midquizdelete" method="post"><button class="finish-button">Back to Createquiz</button></form>
        <div class="success-message">
                <strong>${me}</strong>
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

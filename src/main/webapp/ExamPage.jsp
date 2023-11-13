<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quiz Form</title>
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

        form {
            background-color: #fff;
            border: 1px solid #ccc;
            border-radius: 10px;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            max-width: 600px;
            width: 90%;
            box-sizing: border-box;
            margin-top: 20px;
            overflow: auto;
        }

        h1 {
            color: #3498DB;
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
            width: calc(100% - 24px);
            padding: 12px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
            font-size: 16px;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: #fff;
            border: none;
            padding: 12px 24px;
            cursor: pointer;
            border-radius: 5px;
            transition: background-color 0.3s;
            font-size: 16px;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        #timer {
            font-size: 18px;
            color: #FF0000; /* Red color */
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
   <% int totaltime = (Integer)session.getAttribute("total") * 30; %>
    <form action="result" method="post" id="quizForm">
        <div id="timer"></div>
        <h1>Welcome ${myname}</h1>
        <h1 style="font-size: 32px; text-transform: uppercase;">Exam Paper: ${quiz_name}</h1>
        <h1>Quiz_ID: ${q_id}</h1>
        <h1>Write your answer fully without option no like if your answer is 1.C, you have to write "C" only. It is not Case sensitive.</h1>
        ${user_quiz_table}
        <input type="submit" value="Submit Answer">
    </form>

     <script>
        // Automatically start the timer when the page loads
        startTimer();

        function startTimer() {
            let seconds = <%= totaltime %>;
            const timerInterval = setInterval(function () {
                document.getElementById('timer').innerText = seconds + " seconds remaining";
                seconds--;

                if (seconds < 0) {
                    clearInterval(timerInterval);
                    document.getElementById("timer").innerHTML = "Time's up!";
                    // Automatically submit the form when the timer reaches 0
                    document.getElementById("quizForm").submit();
                }
            }, 1000); // Update every 1 second
        }
    </script>

</body>
</html>

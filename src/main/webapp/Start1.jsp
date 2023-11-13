<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Attractive Page</title>
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

        h1 {
            text-shadow: 2px 2px 4px #333;
            margin-bottom: 20px;
        }

        #startForm {
            margin-top: 20px;
        }

        #startButton {
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
            background-color: #4CAF50;
            color: #fff;
            border: none;
            border-radius: 5px;
            transition: background-color 0.3s;
        }

        #timer {
            font-size: 24px;
            margin-top: 20px;
        }

        @media only screen and (max-width: 600px) {
            #startButton {
                font-size: 14px;
            }
        }
    </style>
</head>
<body>

    <h1>Waiting Page</h1>

    <form id="startForm" action="userquestions" method="post">
        <button id="startButton">Start</button>
    </form>

    <div id="timer"></div>

    <script>
        // Automatically start the timer when the page loads
        startTimer();

        function startTimer() {
            let seconds = 5;
            const timerInterval = setInterval(function () {
                document.getElementById('timer').innerText = seconds + " seconds remaining";
                seconds--;

                if (seconds < 0) {
                    clearInterval(timerInterval);
                    document.getElementById("timer").innerHTML = "Lets Goo!";
                    // Automatically submit the form when the timer reaches 0
                    document.getElementById("startForm").submit();
                }
            }, 1000); // Update every 1 second
        }
    </script>

</body>
</html>

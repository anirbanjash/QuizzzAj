<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Quizzz App - Register</title>
    <style>
        body {
            display: flex;
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
            max-width: 400px;
            width: 90%;
            box-sizing: border-box;
        }

        .container-heading {
            color: #008CBA;
            text-shadow: 2px 2px 4px #333;
            margin-bottom: 20px;
        }

        label {
            display: block;
            font-weight: bold;
            margin-bottom: 10px;
            color: #333;
        }

        input[type="text"],
        input[type="password"],
        input[type="tel"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }

        input[type="submit"],
        .redirect-button,
        .register-button {
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
        .redirect-button:hover,
        .register-button:hover {
            background-color: #005580;
        }

        .redirect-button,
        .register-button {
            margin-top: 20px;
        }

        .redirect-button:hover,
        .register-button:hover {
            color: #005580;
        }

        .quote {
            font-size: 12px;
            color: #333;
            margin-top: -10px;
            text-align: left;
        }

        @media only screen and (max-width: 600px) {
            h1 {
                font-size: 24px;
            }
            .form-container {
                font-size: 14px;
            }
        }
    </style>
</head>

<body>

    <div class="form-container">
        <h1 class="container-heading">Quizzz App - Register</h1>
        <form action="registrationFormadmin" method="post">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" placeholder="Enter Your Name" required>
            <label for="phoneNumber">Phone Number:</label>
            <input type="text" id="phoneNumber" name="phoneNumber" placeholder="Enter Your Phone Number" required>
            <label for="username">Username:</label>
            
            <input type="text" id="username" name="username" placeholder="Username=Your firstname + Ph no" required>
            
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" placeholder="Enter Password" required>
            <label for="confirmPassword">Confirm Password:</label>
            <input type="password" id="confirmPassword" name="confirmPassword" placeholder="Confirm Password" required>
            <input type="submit" value="Register">
        </form>
        <a href="adminLogin.jsp" class="redirect-button">Back to Login</a>
       
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

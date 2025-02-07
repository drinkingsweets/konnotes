@param String username
@param java.util.List<String> errors

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign up</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            text-align: center;
        }

        .container {
            text-align: center;
            max-width: 400px;
            padding: 30px;
            background-color: #ffffff;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .title {
            font-size: 36px;
            font-weight: bold;
            margin-bottom: 20px;
            color: royalblue;
            display: flex;
            align-items: center;
            justify-content: center;
            position: relative;
        }

        .title::before {
            position: absolute;
            content: "";
            width: 18px;
            height: 18px;
            border-radius: 50%;
            background-color: royalblue;
            left: 10px;
        }

        .title::after {
            position: absolute;
            content: "";
            width: 18px;
            height: 18px;
            border-radius: 50%;
            background-color: royalblue;
            left: 10px;
            animation: pulse 1s infinite;
        }

        @keyframes pulse {
            0% {
                transform: scale(0.9);
                opacity: 1;
            }
            100% {
                transform: scale(1.8);
                opacity: 0;
            }
        }

        .error-messages {
            margin-bottom: 20px;
            padding: 10px;
            background-color: #ffdddd;
            border: 1px solid #ff5c5c;
            border-radius: 5px;
            color: #d8000c;
            font-size: 14px;
            text-align: left;
        }

        .form-group {
            margin-bottom: 20px;
        }

        .form-group label {
            display: block;
            font-size: 16px;
            margin-bottom: 5px;
        }

        .form-group input {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }

        .button {
            display: inline-block;
            padding: 10px 20px;
            font-size: 16px;
            color: #fff;
            background-color: royalblue;
            border: none;
            border-radius: 5px;
            text-decoration: none;
            cursor: pointer;
            transition: background-color 0.3s ease;
            width: 100%;
            box-sizing: border-box;
        }

        .button:hover {
            background-color: #4169e1;
        }

        .button:active {
            background-color: #27408b;
        }

        .link {
            display: block;
            margin-top: 15px;
            font-size: 14px;
            text-decoration: none;
            color: #007bff;
        }

        .link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="title">Sign up</div>
        @if (!errors.isEmpty())
            <div class="error-messages">
                <ul>
                    @for (String error : errors)
                        <li>${error}</li>
                    @endfor
                </ul>
            </div>
        @endif
        <form method="post" action="/perform_register">
            <div class="form-group">
                <label for="username">Username</label>
                <input type="text" id="username" name="username" required>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" required>
            </div>
            <div class="form-group">
                <label for="confirmPassword">Confirm Password</label>
                <input type="password" id="passwordConfirmation" name="passwordConfirmation" required>
            </div>
            <button type="submit" class="button">Sign up</button>
        </form>
        <a href="/login" class="link">Already have an account? Login here</a>
    </div>
</body>
</html>

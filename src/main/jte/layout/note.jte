@param String title
@param String content

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Note</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: white; /* Set the background color to white */
            margin: 0;
            padding: 0;
            height: 100vh;
            display: flex;
            flex-direction: column; /* Stack the elements vertically */
            align-items: center; /* Center elements horizontally */
            width: 100%; /* Ensure the page uses the full width of the screen */
        }

        h1 {
            font-size: 36px;
            margin: 0;
            text-align: left; /* Align text to the left */
            color: royalblue;
            padding-top: 20px; /* Add some padding at the top */
            padding-left: 20px; /* Add left padding */
            width: 95%; /* Use 95% of screen width */
            word-wrap: break-word; /* Allow text to wrap */
        }

        input[type="text"], textarea {
            width: 95%; /* Use 95% of screen width */
            padding: 15px;
            font-size: 24px;
            background-color: white;
            outline: none;
            margin: 0;
            text-align: left; /* Align text to the left */
            border: none; /* Remove border */
            word-wrap: break-word; /* Allow text to wrap inside the input fields */
            margin-bottom: 20px; /* Add space between elements */
        }

        input[type="text"]:focus, textarea:focus {
            outline: none; /* No outline on focus */
        }

        textarea {
            flex-grow: 1; /* Make the textarea grow to fill the remaining space */
            font-size: 18px;
            line-height: 1.6;
            padding: 20px;
            resize: none; /* Prevent resizing */
            height: calc(100vh - 180px); /* Adjust height to fill screen minus title and button */
            overflow-y: auto; /* Enable scrolling if needed */
        }

        form {
            display: flex;
            flex-direction: column;
            align-items: center; /* Center content horizontally */
            height: 100%;
            width: 100%;
        }

        button {
            padding: 12px 20px;
            background-color: royalblue;
            color: white;
            border: none;
            cursor: pointer;
            font-size: 16px;
            width: 95%; /* Use 95% of screen width */
            margin-top: 20px;
        }

        button:hover {
            background-color: #4169e1;
        }

        button:active {
            background-color: #27408b;
        }
    </style>
</head>
<body>

    <form action="/notes/save" method="POST" accept-charset="UTF-8">
        <!-- Title input field at the top -->
        <input type="text" name="title" placeholder="Note title" required value="${title}">

        <!-- Main note content area, which fills the remaining space -->
        <textarea name="content" placeholder="Write your note..." required>${content}</textarea>

        <!-- Save button at the bottom -->
        <button type="submit">Save Note</button>
    </form>

</body>
</html>

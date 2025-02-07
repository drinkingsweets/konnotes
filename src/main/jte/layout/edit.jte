@param String title
@param String content
@param long id

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Note</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: white;
            margin: 0;
            padding: 0;
            height: 100vh;
            display: flex;
            flex-direction: column;
            align-items: center;
            width: 100%;
        }

        h1 {
            font-size: 36px;
            margin: 0;
            text-align: left;
            color: royalblue;
            padding-top: 20px;
            padding-left: 20px;
            width: 95%;
            word-wrap: break-word;
        }

        input[type="text"], textarea {
            width: 95%;
            padding: 15px;
            font-size: 24px;
            background-color: white;
            outline: none;
            margin: 0;
            text-align: left;
            border: none;
            word-wrap: break-word;
            margin-bottom: 20px;
        }

        input[type="text"]:focus, textarea:focus {
            outline: none;
        }

        textarea {
            flex-grow: 1;
            font-size: 18px;
            line-height: 1.6;
            padding: 20px;
            resize: none;
            height: calc(100vh - 180px);
            overflow-y: auto;
        }

        form {
            display: flex;
            flex-direction: column;
            align-items: center;
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
            width: 95%;
            margin-top: 20px;
        }

        button:hover {
            background-color: #4169e1;
        }

        button:active {
            background-color: #27408b;
        }

        .back-arrow {
            position: absolute;
            top: 10px;
            left: 10px;
            width: 20px;
            height: 20px;
            background-color: rgba(0, 0, 0, 0.1);
            border-radius: 70%;
            display: flex;
            align-items: center;
            justify-content: center;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .back-arrow:hover {
            background-color: rgba(0, 0, 0, 0.2);
        }

        .back-arrow svg {
            width: 20px;
            height: 20px;
            fill: black;
        }

        .menu {
            position: absolute;
            top: 10px;
            right: 10px;
            display: inline-block;
        }

        .menu-trigger {
            display: flex;
            align-items: center;
            justify-content: center;
            width: 24px;
            height: 24px;
            background-color: rgba(0, 0, 0, 0.1);
            border-radius: 50%;
            cursor: pointer;
        }

        .menu-trigger:hover {
            background-color: rgba(0, 0, 0, 0.2);
        }

        .menu-trigger svg {
            width: 20px;
            height: 20px;
            fill: black;
        }

        .menu-content {
            display: none;
            position: absolute;
            top: 30px;
            right: 0;
            background-color: white;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            z-index: 1000;
        }

        .menu-content a {
            display: block;
            padding: 10px 20px;
            text-decoration: none;
            color: black;
            font-size: 14px;
            border-bottom: 1px solid #ddd;
        }

        .menu-content a:last-child {
            border-bottom: none;
        }

        .menu-content a:hover {
            background-color: #f5f5f5;
        }

        .menu:hover .menu-content {
            display: block;
        }

        .confirmation-box {
            display: none;
            position: fixed;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            background-color: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            text-align: center;
            max-width: 300px;
            width: 90%;
            z-index: 2000;
        }

        .confirmation-title {
            font-size: 20px;
            font-weight: bold;
            margin-bottom: 20px;
            color: royalblue;
        }

        .confirmation-buttons {
            display: flex;
            justify-content: space-between;
        }

        .confirmation-buttons button {
            padding: 10px 20px;
            font-size: 16px;
            font-weight: bold;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
            flex: 1;
            margin: 0 5px;
        }

        .confirmation-buttons button.yes {
            background-color: royalblue;
            color: white;
        }

        .confirmation-buttons button.yes:hover {
            background-color: #4169e1;
        }

        .confirmation-buttons button.no {
            background-color: #e0e0e0;
            color: black;
        }

        .confirmation-buttons button.no:hover {
            background-color: #c0c0c0;
        }
    </style>
</head>
<body>

    <div class="back-arrow" onclick="window.location.href='/notes'">
        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
            <path d="M15.41 16.59L10.83 12l4.58-4.59L14 6l-6 6 6 6z"/>
        </svg>
    </div>

    <div class="menu">
        <div class="menu-trigger">
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
                <circle cx="12" cy="5" r="2" />
                <circle cx="12" cy="12" r="2" />
                <circle cx="12" cy="19" r="2" />
            </svg>
        </div>
        <div class="menu-content">
            <a href="#" onclick="showConfirmation()">Delete...</a>
        </div>
    </div>

    <form action="/notes/${id}" method="post" accept-charset="UTF-8">
        <input type="text" name="title" placeholder="Note title" required value="${title}">
        <textarea name="content" placeholder="Write your note..." required>${content}</textarea>
        <button type="submit">Save Note</button>
    </form>

    <div class="confirmation-box" id="confirmationBox">
        <div class="confirmation-title">Are you sure?</div>
        <div class="confirmation-buttons">
            <button class="yes" onclick="confirmDelete()">Yes</button>
            <button class="no" onclick="hideConfirmation()">No</button>
        </div>
    </div>

    <script>
        function showConfirmation() {
            document.getElementById('confirmationBox').style.display = 'block';
        }

        function hideConfirmation() {
            document.getElementById('confirmationBox').style.display = 'none';
        }

        function confirmDelete() {
            window.location.href = "/notes/${id}/delete";
        }
    </script>

</body>
</html>

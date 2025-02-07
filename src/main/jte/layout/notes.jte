@import app.model.Note
@import java.util.List
@param String username
@param List<String> titles
@param List<Long> ids
@param List<java.time.LocalDate> updatedAt

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Your Notes</title>
    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            text-align: center;
        }

        .navbar {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 10px 20px;
            background-color: royalblue;
            color: white;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        .navbar .menu {
            display: flex;
            gap: 15px;
        }

        .navbar .menu a {
            text-decoration: none;
            color: white;
            font-weight: bold;
            font-size: 16px;
            padding: 8px 16px;
            border-radius: 5px;
            transition: background-color 0.3s;
        }

        .navbar .menu a:hover {
            background-color: #4169e1;
        }

        .navbar .datetime {
            font-size: 16px;
            font-weight: bold;
        }

        .container {
            max-width: 800px;
            width: 100%;
            margin: 20px auto;
            padding: 30px;
            background-color: #ffffff;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .welcome-title {
            font-size: 32px;
            font-weight: bold;
            color: royalblue;
            margin-bottom: 20px;
        }

        .notes-section {
            margin-top: 30px;
        }

        .note-card {
            background-color: #f9f9f9;
            border: 1px solid #ddd;
            border-radius: 8px;
            padding: 15px;
            margin-bottom: 15px;
            text-align: left;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .note-card a {
            text-decoration: none;
            color: royalblue;
            font-weight: bold;
            font-size: 18px;
            margin-right: 10px;
        }

        .note-card a:hover {
            text-decoration: underline;
        }

        .note-date {
            font-size: 14px;
            color: lightgray;
            white-space: nowrap;
        }

        .link {
            display: block;
            margin-top: 20px;
            font-size: 14px;
            text-decoration: none;
            color: royalblue;
        }

        .link:hover {
            text-decoration: underline;
        }

        .no-notes-message {
            margin-top: 30px;
            padding: 20px;
            background-color: #fff3cd;
            border: 1px solid #ffeeba;
            border-radius: 8px;
            color: #856404;
            font-size: 16px;
            text-align: center;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        .no-notes-message .icon {
            margin-right: 10px;
            font-size: 24px;
        }

        .add-note-button {
            position: relative;
            display: flex;
            align-items: center;
            justify-content: center;
            width: 160px;
            height: 50px;
            margin: 20px auto;
            font-size: 16px;
            font-weight: bold;
            color: white;
            background-color: royalblue;
            border: none;
            border-radius: 25px;
            cursor: pointer;
            overflow: hidden;
            transition: background-color 0.3s ease;
        }

        .add-note-button:hover {
            background-color: #4169e1;
        }

        .add-note-button span {
            position: absolute;
            display: flex;
            align-items: center;
            justify-content: center;
            width: 100%;
            height: 100%;
            transition: transform 0.5s ease-in-out;
        }

        .add-note-button span.text {
            z-index: 1;
            transform: translateX(0);
        }

        .add-note-button:hover span.text {
            transform: translateX(-200%);
        }

        .add-note-button span.icon {
            z-index: 2;
            transform: translateX(200%);
        }

        .add-note-button:hover span.icon {
            transform: translateX(0);
        }

        .add-note-button svg {
            width: 24px;
            height: 24px;
        }
    </style>
    <script>
        // Update the date and time dynamically
        function updateDateTime() {
            const dateTimeElement = document.getElementById('datetime');
            const now = new Date();
            const options = { year: 'numeric', month: 'long', day: 'numeric', hour: '2-digit', minute: '2-digit' };
            dateTimeElement.textContent =  now.getDate() + "." +
                (now.getMonth() + 1) + "." +
                now.getFullYear() + " " +
                now.getHours() + ":" +
                now.getMinutes();
        }

        // Update the time every minute
        setInterval(updateDateTime, 60000);
        window.onload = updateDateTime;
    </script>
</head>
<body>
<div class="navbar">
    <!-- Menu Links -->
    <div class="menu">
        <a href="/notes">Notes</a>
        <a href="/tasks">Tasks</a>
    </div>
    <!-- Date and Time -->
    <div class="datetime" id="datetime"></div>
</div>

<div class="container">
    <!-- Welcome message -->
    <div class="welcome-title">Welcome, ${username}!</div>

    <!-- Section displaying user notes -->
    @if (ids.isEmpty())
        <div class="no-notes-message">
            <span class="icon">📝</span>
            There are no notes you created yet.
        </div>
    @else
        <div class="notes-section">
            @for (int i = 0; i < ids.size(); i++)
                <div class="note-card">
                    <a href="/notes/${ids.get(i)}">${titles.get(i)}</a>
                    <span class="note-date">${updatedAt.get(i).toString()}</span>
                </div>
            @endfor
        </div>
    @endif

    <!-- Styled Button -->
    <button class="add-note-button" onclick="window.location.href='/notes/create'">
        <span class="text">Create Note</span>
        <span class="icon">
        <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
            <line x1="12" y1="5" x2="12" y2="19"/>
            <line x1="5" y1="12" x2="19" y2="12"/>
        </svg>
    </span>
    </button>

    <!-- Link to logout -->
    <a href="/logout" class="link">Log out</a>
</div>
</body>
</html>

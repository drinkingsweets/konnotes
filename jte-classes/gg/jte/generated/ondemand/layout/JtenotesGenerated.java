package gg.jte.generated.ondemand.layout;
import app.model.Note;
import java.util.List;
@SuppressWarnings("unchecked")
public final class JtenotesGenerated {
	public static final String JTE_NAME = "layout/notes.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,2,193,193,205,212,217,222,223,223,223,225,226,226,231,231,233,233,235,235,235,235,235,235,235,236,236,236,238,238,240,240,242,253,258,258,258,2,3,4,5,5,5,5};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, String username, List<String> titles, List<Long> ids, List<java.time.LocalDate> updatedAt) {
		jteOutput.writeContent("\n<!DOCTYPE html>\n<html lang=\"ru\">\n<head>\n    <meta charset=\"UTF-8\">\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n    <title>Your Notes</title>\n    <style>\n        body {\n            margin: 0;\n            font-family: Arial, sans-serif;\n            background-color: #f4f4f9;\n            text-align: center;\n        }\n\n        .navbar {\n            display: flex;\n            justify-content: space-between;\n            align-items: center;\n            padding: 10px 20px;\n            background-color: royalblue;\n            color: white;\n            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);\n        }\n\n        .navbar .menu {\n            display: flex;\n            gap: 15px;\n        }\n\n        .navbar .menu a {\n            text-decoration: none;\n            color: white;\n            font-weight: bold;\n            font-size: 16px;\n            padding: 8px 16px;\n            border-radius: 5px;\n            transition: background-color 0.3s;\n        }\n\n        .navbar .menu a:hover {\n            background-color: #4169e1;\n        }\n\n        .navbar .datetime {\n            font-size: 16px;\n            font-weight: bold;\n        }\n\n        .container {\n            max-width: 800px;\n            width: 100%;\n            margin: 20px auto;\n            padding: 30px;\n            background-color: #ffffff;\n            border-radius: 10px;\n            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);\n        }\n\n        .welcome-title {\n            font-size: 32px;\n            font-weight: bold;\n            color: royalblue;\n            margin-bottom: 20px;\n        }\n\n        .notes-section {\n            margin-top: 30px;\n        }\n\n        .note-card {\n            background-color: #f9f9f9;\n            border: 1px solid #ddd;\n            border-radius: 8px;\n            padding: 15px;\n            margin-bottom: 15px;\n            text-align: left;\n            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);\n            display: flex;\n            justify-content: space-between;\n            align-items: center;\n        }\n\n        .note-card a {\n            text-decoration: none;\n            color: royalblue;\n            font-weight: bold;\n            font-size: 18px;\n            margin-right: 10px;\n        }\n\n        .note-card a:hover {\n            text-decoration: underline;\n        }\n\n        .note-date {\n            font-size: 14px;\n            color: lightgray;\n            white-space: nowrap;\n        }\n\n        .link {\n            display: block;\n            margin-top: 20px;\n            font-size: 14px;\n            text-decoration: none;\n            color: royalblue;\n        }\n\n        .link:hover {\n            text-decoration: underline;\n        }\n\n        .no-notes-message {\n            margin-top: 30px;\n            padding: 20px;\n            background-color: #fff3cd;\n            border: 1px solid #ffeeba;\n            border-radius: 8px;\n            color: #856404;\n            font-size: 16px;\n            text-align: center;\n            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);\n        }\n\n        .no-notes-message .icon {\n            margin-right: 10px;\n            font-size: 24px;\n        }\n\n        .add-note-button {\n            position: relative;\n            display: flex;\n            align-items: center;\n            justify-content: center;\n            width: 160px;\n            height: 50px;\n            margin: 20px auto;\n            font-size: 16px;\n            font-weight: bold;\n            color: white;\n            background-color: royalblue;\n            border: none;\n            border-radius: 25px;\n            cursor: pointer;\n            overflow: hidden;\n            transition: background-color 0.3s ease;\n        }\n\n        .add-note-button:hover {\n            background-color: #4169e1;\n        }\n\n        .add-note-button span {\n            position: absolute;\n            display: flex;\n            align-items: center;\n            justify-content: center;\n            width: 100%;\n            height: 100%;\n            transition: transform 0.5s ease-in-out;\n        }\n\n        .add-note-button span.text {\n            z-index: 1;\n            transform: translateX(0);\n        }\n\n        .add-note-button:hover span.text {\n            transform: translateX(-200%);\n        }\n\n        .add-note-button span.icon {\n            z-index: 2;\n            transform: translateX(200%);\n        }\n\n        .add-note-button:hover span.icon {\n            transform: translateX(0);\n        }\n\n        .add-note-button svg {\n            width: 24px;\n            height: 24px;\n        }\n    </style>\n    <script>\n        ");
		jteOutput.writeContent("\n        function updateDateTime() {\n            const dateTimeElement = document.getElementById('datetime');\n            const now = new Date();\n            const options = { year: 'numeric', month: 'long', day: 'numeric', hour: '2-digit', minute: '2-digit' };\n            dateTimeElement.textContent =  now.getDate() + \".\" +\n                (now.getMonth() + 1) + \".\" +\n                now.getFullYear() + \" \" +\n                now.getHours() + \":\" +\n                now.getMinutes();\n        }\n\n        ");
		jteOutput.writeContent("\n        setInterval(updateDateTime, 60000);\n        window.onload = updateDateTime;\n    </script>\n</head>\n<body>\n<div class=\"navbar\">\n    ");
		jteOutput.writeContent("\n    <div class=\"menu\">\n        <a href=\"/notes\">Notes</a>\n        <a href=\"/tasks\">Tasks</a>\n    </div>\n    ");
		jteOutput.writeContent("\n    <div class=\"datetime\" id=\"datetime\"></div>\n</div>\n\n<div class=\"container\">\n    ");
		jteOutput.writeContent("\n    <div class=\"welcome-title\">Welcome, ");
		jteOutput.setContext("div", null);
		jteOutput.writeUserContent(username);
		jteOutput.writeContent("!</div>\n\n    ");
		jteOutput.writeContent("\n    ");
		if (ids.isEmpty()) {
			jteOutput.writeContent("\n        <div class=\"no-notes-message\">\n            <span class=\"icon\">📝</span>\n            There are no notes you created yet.\n        </div>\n    ");
		} else {
			jteOutput.writeContent("\n        <div class=\"notes-section\">\n            ");
			for (int i = 0; i < ids.size(); i++) {
				jteOutput.writeContent("\n                <div class=\"note-card\">\n                    <a href=\"/notes/");
				jteOutput.setContext("a", "href");
				jteOutput.writeUserContent(ids.get(i));
				jteOutput.setContext("a", null);
				jteOutput.writeContent("\">");
				jteOutput.setContext("a", null);
				jteOutput.writeUserContent(titles.get(i));
				jteOutput.writeContent("</a>\n                    <span class=\"note-date\">");
				jteOutput.setContext("span", null);
				jteOutput.writeUserContent(updatedAt.get(i).toString());
				jteOutput.writeContent("</span>\n                </div>\n            ");
			}
			jteOutput.writeContent("\n        </div>\n    ");
		}
		jteOutput.writeContent("\n\n    ");
		jteOutput.writeContent("\n    <button class=\"add-note-button\" onclick=\"window.location.href='/notes/create'\">\n        <span class=\"text\">Create Note</span>\n        <span class=\"icon\">\n        <svg xmlns=\"http://www.w3.org/2000/svg\" fill=\"none\" viewBox=\"0 0 24 24\" stroke=\"currentColor\" stroke-width=\"2\">\n            <line x1=\"12\" y1=\"5\" x2=\"12\" y2=\"19\"/>\n            <line x1=\"5\" y1=\"12\" x2=\"19\" y2=\"12\"/>\n        </svg>\n    </span>\n    </button>\n\n    ");
		jteOutput.writeContent("\n    <a href=\"/logout\" class=\"link\">Log out</a>\n</div>\n</body>\n</html>\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		String username = (String)params.get("username");
		List<String> titles = (List<String>)params.get("titles");
		List<Long> ids = (List<Long>)params.get("ids");
		List<java.time.LocalDate> updatedAt = (List<java.time.LocalDate>)params.get("updatedAt");
		render(jteOutput, jteHtmlInterceptor, username, titles, ids, updatedAt);
	}
}

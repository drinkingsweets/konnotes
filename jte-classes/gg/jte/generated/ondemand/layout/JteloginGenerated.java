package gg.jte.generated.ondemand.layout;
@SuppressWarnings("unchecked")
public final class JteloginGenerated {
	public static final String JTE_NAME = "layout/login.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,0,141,141,141,144,144,145,145,145,146,146,149,149,154,154,154,154,154,154,154,154,154,166,166,166,0,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, String username, java.util.List<String> errors) {
		jteOutput.writeContent("\n<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n    <meta charset=\"UTF-8\">\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n    <title>Sign In</title>\n    <style>\n        body {\n            display: flex;\n            justify-content: center;\n            align-items: center;\n            height: 100vh;\n            margin: 0;\n            font-family: Arial, sans-serif;\n            background-color: #f4f4f9;\n            text-align: center;\n        }\n\n        .container {\n            text-align: center;\n            max-width: 400px;\n            padding: 30px;\n            background-color: #ffffff;\n            border-radius: 10px;\n            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);\n        }\n\n        .title {\n            font-size: 36px;\n            font-weight: bold;\n            color: royalblue;\n            margin-bottom: 20px;\n            position: relative;\n            display: inline-flex;\n            align-items: center;\n            justify-content: center;\n        }\n\n        .title::before {\n            position: absolute;\n            content: \"\";\n            width: 18px;\n            height: 18px;\n            border-radius: 50%;\n            background-color: royalblue;\n            left: -30px;\n        }\n\n        .title::after {\n            position: absolute;\n            content: \"\";\n            width: 18px;\n            height: 18px;\n            border-radius: 50%;\n            background-color: royalblue;\n            left: -30px;\n            animation: pulse 1s infinite;\n        }\n\n        @keyframes pulse {\n            0% {\n                transform: scale(0.9);\n                opacity: 1;\n            }\n            100% {\n                transform: scale(1.8);\n                opacity: 0;\n            }\n        }\n\n        .error-messages {\n            margin-bottom: 20px;\n            padding: 10px;\n            background-color: #ffdddd;\n            border: 1px solid #ff5c5c;\n            border-radius: 5px;\n            color: #d8000c;\n            font-size: 14px;\n            text-align: left;\n        }\n\n        .form-group {\n            margin-bottom: 20px;\n        }\n\n        .form-group label {\n            display: block;\n            font-size: 16px;\n            margin-bottom: 5px;\n        }\n\n        .form-group input {\n            width: 100%;\n            padding: 10px;\n            font-size: 16px;\n            border: 1px solid #ccc;\n            border-radius: 5px;\n            box-sizing: border-box;\n        }\n\n        .button {\n            display: inline-block;\n            padding: 10px 20px;\n            font-size: 16px;\n            color: #fff;\n            background-color: royalblue;\n            border: none;\n            border-radius: 5px;\n            text-decoration: none;\n            cursor: pointer;\n            transition: background-color 0.3s ease;\n            width: 100%;\n            box-sizing: border-box;\n        }\n\n        .button:hover {\n            background-color: #4169e1;\n        }\n\n        .button:active {\n            background-color: #27408b;\n        }\n\n        .link {\n            display: block;\n            margin-top: 15px;\n            font-size: 14px;\n            text-decoration: none;\n            color: royalblue;\n        }\n\n        .link:hover {\n            text-decoration: underline;\n        }\n    </style>\n</head>\n<body>\n    <div class=\"container\">\n        ");
		if (errors != null && !errors.isEmpty()) {
			jteOutput.writeContent("\n            <div class=\"error-messages\">\n                <ul>\n                    ");
			for (String error : errors) {
				jteOutput.writeContent("\n                        <li>");
				jteOutput.setContext("li", null);
				jteOutput.writeUserContent(error);
				jteOutput.writeContent("</li>\n                    ");
			}
			jteOutput.writeContent("\n                </ul>\n            </div>\n        ");
		}
		jteOutput.writeContent("\n        <div class=\"title\">Sign In</div>\n        <form method=\"post\" action=\"/perform_login\">\n            <div class=\"form-group\">\n                <label for=\"username\">Username</label>\n                <input type=\"text\" id=\"username\" name=\"username\"");
		var __jte_html_attribute_0 = username;
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeContent(" value=\"");
			jteOutput.setContext("input", "value");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("input", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" required>\n            </div>\n            <div class=\"form-group\">\n                <label for=\"password\">Password</label>\n                <input type=\"password\" id=\"password\" name=\"password\" required>\n            </div>\n            <button type=\"submit\" class=\"button\">Sign In</button>\n        </form>\n        <a href=\"/register\" class=\"link\">Don't have an account? Sign up here</a>\n    </div>\n</body>\n</html>\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		String username = (String)params.get("username");
		java.util.List<String> errors = (java.util.List<String>)params.get("errors");
		render(jteOutput, jteHtmlInterceptor, username, errors);
	}
}

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class LoginServer {

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/login", new LoginHandler());
        server.setExecutor(null); // default executor
        System.out.println("Server started on port 8000...");
        server.start();
    }

    static class LoginHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if (!exchange.getRequestMethod().equalsIgnoreCase("POST")) {
                sendResponse(exchange, 405, "Only POST method is supported");
                return;
            }

            // Check content type
            String contentType = exchange.getRequestHeaders().getFirst("Content-Type");
            if (contentType == null || !contentType.equalsIgnoreCase("application/x-www-form-urlencoded")) {
                sendResponse(exchange, 400, "Bad Request: Unsupported Content-Type");
                return;
            }

            // Read request body
            InputStreamReader isr = new InputStreamReader(exchange.getRequestBody(), "utf-8");
            BufferedReader reader = new BufferedReader(isr);
            StringBuilder formData = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                formData.append(line);
            }

            Map<String, String> params = parseFormData(formData.toString());

            String username = params.get("username");
            String password = params.get("password");

            if ("admin".equals(username) && "admin".equals(password)) {
                sendResponse(exchange, 200, "Login successful");
            } else {
                sendResponse(exchange, 401, "Invalid credentials");
            }
        }

        private Map<String, String> parseFormData(String formData) throws UnsupportedEncodingException {
            Map<String, String> params = new HashMap<>();
            String[] pairs = formData.split("&");
            for (String pair : pairs) {
                String[] keyValue = pair.split("=");
                String key = URLDecoder.decode(keyValue[0], "UTF-8");
                String value = keyValue.length > 1 ? URLDecoder.decode(keyValue[1], "UTF-8") : "";
                params.put(key, value);
            }
            return params;
        }

        private void sendResponse(HttpExchange exchange, int statusCode, String message) throws IOException {
            exchange.getResponseHeaders().add("Content-Type", "text/plain");
            byte[] responseBytes = message.getBytes("UTF-8");
            exchange.sendResponseHeaders(statusCode, responseBytes.length);
            OutputStream os = exchange.getResponseBody();
            os.write(responseBytes);
            os.close();
        }
    }
}

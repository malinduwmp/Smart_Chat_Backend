/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controler;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
@WebServlet(name = "SignUp", urlPatterns = {"/SignUp"})
public class SignUp extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            
        Gson gson = new Gson();
        JsonObject requestJson = gson.fromJson(request.getReader(), JsonObject.class);
        System.out.println(requestJson.get("mobile").getAsString());
        System.out.println(requestJson.get("firstName").getAsString());
        System.out.println(requestJson.get("lastName").getAsString());
        System.out.println(requestJson.get("password").getAsString());
        
        String serverPath = request.getServletContext().getRealPath("");
        
        
        JsonObject responseJson = new JsonObject();
        responseJson.addProperty("message", "Server Hello");
        
        response.setContentType("application/json");
        response.getWriter().write(gson.toJson(responseJson));
                                   
    }
    
}
    
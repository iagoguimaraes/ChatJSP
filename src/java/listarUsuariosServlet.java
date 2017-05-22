/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class listarUsuariosServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        String usuariosJSON = listaUsuarioToJSON(ChatServlet.usuarios);
        response.getWriter().write(usuariosJSON);
    }

    private String listaUsuarioToJSON(ArrayList<Usuario> usuarios) {
        String json = "[";

        for (int i = 0; i < usuarios.size(); i++) {
            json += "{";
            json += "\"nickName\":\"";
            json += usuarios.get(i).getNickName();
            json += "\"";
            json += "}";
            if(i < usuarios.size()-1){
                json += ",";
            }
        }
        json += "]";
        return json;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}

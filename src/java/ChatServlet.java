/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author iago.guimaraes
 */
public class ChatServlet extends HttpServlet {

    private static ArrayList<String> conversa = new ArrayList<String>();

    protected void entrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nickname = (String)request.getParameter("nickname");       
        request.getSession().setAttribute("nickname", nickname);
        conversa.add(nickname + " entrou na conversa");
    }
    
    protected void receberMensagens(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().setAttribute("conversa", conversa);        
        request.getRequestDispatcher("WEB-INF/chat.jsp").forward(request, response);
    }

    protected void enviarMensagem(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nickname = (String)request.getSession().getAttribute("nickname");
        String mensagem = (String)request.getParameter("mensagem");
        conversa.add(nickname + ": " + mensagem);
        request.getRequestDispatcher("WEB-INF/chat.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        entrar(request,response);
        receberMensagens(request, response);     
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        enviarMensagem(request, response);
        receberMensagens(request, response);
    }
}

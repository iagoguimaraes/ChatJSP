/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author iago.guimaraes
 */
public class ChatServlet extends HttpServlet {

    private static ArrayList<Mensagem> conversa = new ArrayList<Mensagem>();
    public static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

    protected void entrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nickname = (String) request.getParameter("nickname");
        Usuario usuario = new Usuario(nickname);
        request.getSession().setAttribute("usuario", usuario);

        usuarios.add(usuario);
        
        Mensagem mensagem = new Mensagem(usuario, "entrou na conversa", new Date());
        conversa.add(mensagem);
    }

    protected void receberMensagens(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().setAttribute("conversa", conversa);
        request.getRequestDispatcher("WEB-INF/chat.jsp").forward(request, response);
    }

    protected void enviarMensagem(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        String texto = (String) request.getParameter("mensagem");

        Mensagem mensagem = new Mensagem(usuario, texto, new Date());
        conversa.add(mensagem);
        request.getRequestDispatcher("WEB-INF/chat.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getSession().getAttribute("usuario") == null) {
            entrar(request, response);
        }
        receberMensagens(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        enviarMensagem(request, response);
        receberMensagens(request, response);
    }
}

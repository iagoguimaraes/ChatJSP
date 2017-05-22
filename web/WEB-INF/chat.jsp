<%-- 
    Document   : chat
    Created on : 17/05/2017, 11:47:35
    Author     : iago.guimaraes
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chat JSP</title>
        <!-- <script>
             setInterval(function() {
                  window.location.href = 'Chat';
                }, 10000);
        </script> -->
        <script>
            fetch('/ChatJSP/listarUsuarios')
                .then(function(response){
                    response.json().then(function(data) {
                        console.log(data);
                    });
                });
        </script>
    </head>
    <body>
        <form method="POST" action="Chat">
            <input name="mensagem" type="text"/> 
            <button type="submit">Enviar</button>
            <a href="Chat">Atualizar</a>
        </form>
        <h3>Conversa:</h3>
        <div id="conversa">
            <c:forEach items="${conversa}" var="mensagem">
                <p>
                    <label>[${mensagem.data}] <b>${mensagem.usuario.nickName}:</b></label>
                    <span>${mensagem.mensagem}</span>
                </p>
            </c:forEach>
        </div>
    </body>
</html>

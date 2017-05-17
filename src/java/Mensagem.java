
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author iago.guimaraes
 */
public class Mensagem {

    private Usuario usuario;
    private String mensagem;
    private Date data;
    private SimpleDateFormat sdfDate;

    public Mensagem(Usuario usuario, String mensagem, Date data) {
        this.usuario = usuario;
        this.mensagem = mensagem;
        this.data = data;
        sdfDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getData() {  
        return sdfDate.format(this.data);
    }

    public void setData(Date data) {
        this.data = data;
    }

}

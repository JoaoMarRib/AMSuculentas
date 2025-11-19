package Suculentas;

import java.util.Date;

public class Artigo {

    private long id;
    private String titulo;
    private String conteudo;
    private String imagemUrl;
    private Date dataPublicacao;
    private String autor;

    public void publicar() {
        dataPublicacao = new Date();
    }

    public void editar(String novoConteudo) {
        this.conteudo = novoConteudo;
    }
}


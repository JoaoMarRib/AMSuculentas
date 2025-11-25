package Suculentas;

import java.util.Date;

public class Promocao {

    private static long contador = 1;
    private long id;
    private String titulo;
    private String descricao;
    private String imagemUrl;
    private Date dataInicio;
    private Date dataFim;
    private String linkDestino;

    public Promocao(String titulo, String descricao, String imagemUrl, Date inicio, Date fim, String linkDestino) {
        this.id = contador++;
        this.titulo = titulo;
        this.descricao = descricao;
        this.imagemUrl = imagemUrl;
        this.dataInicio = inicio;
        this.dataFim = fim;
        this.linkDestino = linkDestino;
    }

    public boolean isAtiva() {
        Date now = new Date();
        return now.after(dataInicio) && now.before(dataFim);
    }
}

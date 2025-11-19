package Suculentas;

import java.util.Date;

public class Promocao {

    private long id;
    private String titulo;
    private String descricao;
    private String imagemUrl;
    private Date dataInicio;
    private Date dataFim;
    private String linkDestino;
    private boolean isAtiva;

    public boolean isAtiva() {
        Date now = new Date();
        return now.after(dataInicio) && now.before(dataFim);
    }
}


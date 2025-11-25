package Suculentas;

import java.util.Date;

public class Depoimento {

    private static long contador = 1;
    private long id;
    private String nomeCliente;
    private String emailCliente;
    private String telefoneCliente;
    private String mensagem;
    private Date dataSubmissao = new Date();
    private StatusDepoimento status = StatusDepoimento.PENDENTE;

    public enum StatusDepoimento {
        PENDENTE, APROVADO, REPROVADO
    }

    public Depoimento(String nome, String email, String tel, String mensagem) {
        this.id = contador++;
        this.nomeCliente = nome;
        this.emailCliente = email;
        this.telefoneCliente = tel;
        this.mensagem = mensagem;
    }

    public boolean submeter() {
        System.out.println("Depoimento enviado para moderação.");
        return true;
    }

    public void aprovar() {
        status = StatusDepoimento.APROVADO;
    }

    public void reprovar() {
        status = StatusDepoimento.REPROVADO;
    }
}

package Suculentas;

import java.util.Date;

public class Orcamento {

    private long id;
    private String nomeCliente;
    private String emailCliente;
    private String telefoneCliente;
    private int quantidade;
    private String observacoes;
    private Date dataSolicitacao = new Date();
    private Produto produto;
    private StatusOrcamento status = StatusOrcamento.PENDENTE;

    private Notificador notificador;
    
    public enum StatusOrcamento {
        PENDENTE, RESPONDIDO, CANCELADO
    }

    public Orcamento(Notificador notificador) {
        this.notificador = notificador;
    }

    public boolean solicitar() {
        this.status = StatusOrcamento.PENDENTE;

        // Aqui simularia salvar no banco
        System.out.println("Orçamento salvo.");

        // Notificando administrador
        notificador.enviarMensagem(
            "Novo orçamento solicitado por " + nomeCliente,
            "ADMIN_WHATSAPP"
        );

        return true;
    }
}


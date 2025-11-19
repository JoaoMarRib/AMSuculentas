package Suculentas;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        // Serviço de notificação
        Notificador notificador = new ServicoWhatsApp();

        // Produto e categoria
        CategoriaProduto categoria = new CategoriaProduto();
        Produto produto = new Produto();

        // Orcamento
        Orcamento orcamento = new Orcamento(notificador);
        orcamento.solicitar();

        // Depoimento
        Depoimento depoimento = new Depoimento();
        depoimento.submeter();

        // Administrador
        Administrador admin = new Administrador();
        admin.revisarDepoimento(depoimento, StatusDepoimento.APROVADO);

        // Artigo
        Artigo artigo = new Artigo();
        artigo.publicar();

        // Promoção
        Promocao promo = new Promocao();
        System.out.println("Promoção ativa? " + promo.isAtiva());
    }
}


package Suculentas;

public class Orcamento {

    private static long contador = 1;
    private long id;
    private String nomeCliente;
    private String emailCliente;
    private String telefoneCliente;
    private int quantidade;
    private String observacoes;
    private Produto produto;
    private Notificador notificador;

    public Orcamento(String nome, String email, String tel, int quantidade, String obs, Produto produto, Notificador n) {
        this.id = contador++;
        this.nomeCliente = nome;
        this.emailCliente = email;
        this.telefoneCliente = tel;
        this.quantidade = quantidade;
        this.observacoes = obs;
        this.produto = produto;
        this.notificador = n;
    }

    public boolean solicitar() {
        double valor = produto.isDisponivel() ? produto.getDetalhes().contains("Preço: R$") ? produto.precoBase * quantidade : 0 : 0;

        System.out.println("Enviando orçamento...");
        System.out.println("Cliente: " + nomeCliente);
        System.out.println("Telefone: " + telefoneCliente);
        System.out.println("Produto: " + produto.getDetalhes());
        System.out.println("Quantidade: " + quantidade);
        System.out.println("Valor total: R$ " + (produto.precoBase * quantidade));

        notificador.enviarMensagem("Seu orçamento foi gerado!", telefoneCliente);

        return true;
    }
}

package Suculentas;

public class Produto {

    private static long contador = 1;
    private long id;
    private String nome;
    private String descricao;
    private String imagemUrl;
    private double precoBase;
    private boolean especieRara;
    private String tipoEmbalagem;
    private CategoriaProduto categoria;

    public Produto(String nome, String descricao, double precoBase, CategoriaProduto categoria) {
        this.id = contador++;
        this.nome = nome;
        this.descricao = descricao;
        this.precoBase = precoBase;
        this.categoria = categoria;
    }

    public boolean isDisponivel() {
        return true;
    }

    public String getDetalhes() {
        return nome + " - " + descricao + " | Preço: R$ " + precoBase;
    }
}

package Suculentas;

public class Produto {
    private long id;
    private String nome;
    private String descricao;
    private String imagemUrl;
    private double precoBase;
    private boolean especieRara;
    private String tipoEmbalagem;
    private CategoriaProduto categoria;

    public boolean isDisponivel() {
        return true;
    }

    public String getDetalhes() {
        return nome + " - " + descricao + " | Preço: R$" + precoBase;
    }
}


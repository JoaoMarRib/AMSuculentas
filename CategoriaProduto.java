package Suculentas;

public class CategoriaProduto {

    private static long contador = 1;
    private long id;
    private String nome;
    private String descricao;

    public CategoriaProduto(String nome, String descricao) {
        this.id = contador++;
        this.nome = nome;
        this.descricao = descricao;
    }
}

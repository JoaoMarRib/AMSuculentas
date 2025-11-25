package Suculentas;

import java.util.ArrayList;
import java.util.List;

public class Administrador {

    private long id;
    private String nome;
    private String email;
    private String hashSenha;

    private List<Produto> produtos = new ArrayList<>();

    public Administrador(long id, String nome, String email, String hashSenha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.hashSenha = hashSenha;
    }

    public boolean login(String email, String senha) {
        return this.email.equals(email) && this.hashSenha.equals(senha);
    }

    public void gerenciarProduto(Produto p) {
        if (p == null) {
            System.out.println("Produto inválido.");
            return;
        }
        produtos.add(p);
        System.out.println("Produto salvo: " + p.getDetalhes());
    }

    public void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        for (Produto p : produtos) {
            System.out.println(p.getDetalhes());
        }
    }


    public void revisarDepoimento(Depoimento d, Depoimento.StatusDepoimento status) {
        if (status == Depoimento.StatusDepoimento.APROVADO) d.aprovar();
        else d.reprovar();
    }

    public void gerenciarPromocao(Promocao p) {
        // lógica futura
    }
}

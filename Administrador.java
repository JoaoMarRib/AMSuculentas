package Suculentas;

public class Administrador {

    private long id;
    private String nome;
    private String email;
    private String hashSenha;
    private String whatsappNumero;

    public boolean login(String email, String senha) {
        return this.email.equals(email) && this.hashSenha.equals(senha);
    }

    public void gerenciarProduto(Produto p) {
    }

    public void gerenciarArtigo(Artigo a) {
    }

    public void revisarDepoimento(Depoimento d, StatusDepoimento status) {
        if (status == StatusDepoimento.APROVADO) d.aprovar();
        else d.reprovar();
    }

    public void responderOrcamento(Orcamento o) {
        o.solicitar();
    }

    public void gerenciarPromocao(Promocao p) {
    }
}


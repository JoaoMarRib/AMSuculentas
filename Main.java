package Suculentas;

public class Main {
    public static void main(String[] args) {

        CategoriaProduto categoria = new CategoriaProduto("Suculentas", "Plantas pequenas e resistentes");

        Produto produto = new Produto("Echeveria", "Suculenta verde linda", 15.50, categoria);

        ServicoWhatsApp whatsapp = new ServicoWhatsApp();

        Orcamento orc = new Orcamento(
            "Marcos",
            "email@email.com",
            "1199999999",
            3,
            "Entrega rápida se possível",
            produto,
            whatsapp
        );

        orc.solicitar();

        Depoimento d = new Depoimento("João", "j@x.com", "11999999", "Adorei minhas plantas!");
        d.submeter();

        Administrador adm = new Administrador(1, "Admin", "admin@mail.com", "123");
        adm.revisarDepoimento(d, Depoimento.StatusDepoimento.APROVADO);

        System.out.println("Sistema finalizado.");
    }
}

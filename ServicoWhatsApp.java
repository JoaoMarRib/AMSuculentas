package Suculentas;

public class ServicoWhatsApp implements Notificador {
    @Override
    public void enviarMensagem(String mensagem, String destinatario) {
        System.out.println("Enviando WhatsApp para " + destinatario + ": " + mensagem);
    }
}


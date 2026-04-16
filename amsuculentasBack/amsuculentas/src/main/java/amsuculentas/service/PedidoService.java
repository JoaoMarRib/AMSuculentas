package amsuculentas.service;

import amsuculentas.model.Pedido;
import amsuculentas.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository repo;

    public PedidoService(PedidoRepository repo) {
        this.repo = repo;
    }

    public List<Pedido> listar() {
        return repo.findAll();
    }

    public Pedido salvar(Pedido pedido) {

        if (pedido.getValorTotal() <= 0) {
            throw new RuntimeException("Pedido inválido");
        }

        return repo.save(pedido);
    }
}
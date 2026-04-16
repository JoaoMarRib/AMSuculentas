package amsuculentas.service;

import amsuculentas.model.Cliente;
import amsuculentas.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository repo;

    public ClienteService(ClienteRepository repo) {
        this.repo = repo;
    }

    public List<Cliente> listar() {
        return repo.findAll();
    }

    public Cliente salvar(Cliente cliente) {

        if (repo.existsByEmail(cliente.getEmail())) {
            throw new RuntimeException("Email já cadastrado");
        }

        return repo.save(cliente);
    }
}
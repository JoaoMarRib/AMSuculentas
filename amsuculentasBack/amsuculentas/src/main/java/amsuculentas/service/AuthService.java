package amsuculentas.service;

import amsuculentas.model.Admin;
import amsuculentas.repository.AdminRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AdminRepository repo;

    public AuthService(AdminRepository repo) {
        this.repo = repo;
    }

    public Admin login(String email, String senha) {

        Admin admin = repo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!admin.getSenha().equals(senha)) {
            throw new RuntimeException("Senha inválida");
        }

        return admin;
    }
}
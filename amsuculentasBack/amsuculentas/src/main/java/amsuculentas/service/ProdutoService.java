package amsuculentas.service;

import amsuculentas.model.Produto;
import amsuculentas.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.math.BigDecimal;

@Service
public class ProdutoService {

    private final ProdutoRepository repo;

    public ProdutoService(ProdutoRepository repo) {
        this.repo = repo;
    }

    public List<Produto> listar() {
        return repo.findAll();
    }

    public List<Produto> listarAtivos() {
        return repo.findByAtivoTrue();
    }

    public Produto salvar(Produto produto) {
        if (produto == null) {
            throw new RuntimeException("Produto não pode ser null");
        }

        if (produto.getPreco() == null || produto.getPreco().compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("Preço inválido");
        }

        return repo.save(produto);
    }

    // 🔵 PUT → substitui tudo
    public Produto atualizarCompleto(long id, Produto dados) {
        if (dados == null) {
            throw new RuntimeException("Dados não podem ser null");
        }

        Produto produto = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        produto.setNome(dados.getNome());
        produto.setDescricao(dados.getDescricao());
        produto.setPreco(dados.getPreco());
        produto.setEstoque(dados.getEstoque());
        produto.setPromocao(dados.getPromocao());
        produto.setAtivo(dados.getAtivo());
        produto.setImagem(dados.getImagem());
        produto.setCategoria(dados.getCategoria());

        return repo.save(produto);
    }

    public Produto atualizarParcial(long id, Produto dados) {
        if (dados == null) {
            throw new RuntimeException("Dados não podem ser null");
        }

       final Produto produto = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        if (dados.getNome() != null) produto.setNome(dados.getNome());
        if (dados.getDescricao() != null) produto.setDescricao(dados.getDescricao());
        if (dados.getPreco() != null) produto.setPreco(dados.getPreco());
        if (dados.getEstoque() != null) produto.setEstoque(dados.getEstoque());
        if (dados.getPromocao() != null) produto.setPromocao(dados.getPromocao());
        if (dados.getAtivo() != null) produto.setAtivo(dados.getAtivo());
        if (dados.getImagem() != null) produto.setImagem(dados.getImagem());
        if (dados.getCategoria() != null) produto.setCategoria(dados.getCategoria());

        return repo.save(produto);
    }

public void deletar(long id) {
    if (!repo.existsById(id)) {
        throw new RuntimeException("Produto não encontrado");
    }

    repo.deleteById(id);
}
}
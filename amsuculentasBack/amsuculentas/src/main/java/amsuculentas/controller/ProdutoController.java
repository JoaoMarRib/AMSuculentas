package amsuculentas.controller;

import amsuculentas.model.Produto;
import amsuculentas.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Produto> listar() {
        return service.listar();
    }

    @GetMapping("/ativos")
    public List<Produto> listarAtivos() {
        return service.listarAtivos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto criar(@RequestBody Produto produto) {
        return service.salvar(produto);
    }

    // PUT → atualização completa
    @PutMapping("/{id}")
    public Produto atualizarCompleto(@PathVariable Long id, @RequestBody Produto produto) {
        return service.atualizarCompleto(id, produto);
    }

    // PATCH → atualização parcial (aceita null nos campos)
    @PatchMapping("/{id}")
    public Produto atualizarParcial(@PathVariable Long id, @RequestBody Produto produto) {
        return service.atualizarParcial(id, produto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
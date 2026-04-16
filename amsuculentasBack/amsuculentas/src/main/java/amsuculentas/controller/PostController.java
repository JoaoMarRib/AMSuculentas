package amsuculentas.controller;

import amsuculentas.model.Post;
import amsuculentas.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping
    public List<Post> listar() {
        return service.listar();
    }

    @PostMapping
    public Post criar(@RequestBody Post post) {
        return service.salvar(post);
    }
}
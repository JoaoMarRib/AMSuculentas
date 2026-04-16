package amsuculentas.service;

import amsuculentas.model.Post;
import amsuculentas.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    
    private final PostRepository repo;

    public PostService(PostRepository repo) {
        this.repo = repo;
    }

    public List<Post> listar() {
        return repo.findAll();
    }

    public Post salvar(Post post) {
        return repo.save(post);
    }
}

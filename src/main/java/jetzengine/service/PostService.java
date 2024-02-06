package jetzengine.service;

import java.security.Principal;
import jetzengine.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    @GetMapping("/@{zname}/@{postId}")
    public String userBlog(@PathVariable String zname, @PathVariable Long postId,  Model model, Principal principal) {

    }
}

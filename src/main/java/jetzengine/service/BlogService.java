package jetzengine.service;

import jetzengine.entity.Blog;
import jetzengine.entity.Zuser;
import jetzengine.repository.BlogRepository;
import jetzengine.repository.ZuserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository blogRepository;
    private final ZuserRepository zuserRepository;

    public Blog create(String zname) {
        Zuser zuser = zuserRepository.findByZname(zname);

        String title = zname + "님의 블로그";
        String intro = zname + "님의 블로그입니다.";

        Blog blog = new Blog(zuser, title, intro, 0L);

        blogRepository.save(blog);

        return blog;
    }

    public Blog findBlog(String zname) {
        Zuser zuser = zuserRepository.findByZname(zname);

        Blog blog = blogRepository.findByZname(zuser);

        return blog;
    }
}

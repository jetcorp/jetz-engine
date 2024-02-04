package jetzengine.repository;

import jetzengine.entity.Blog;
import jetzengine.entity.Zuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Zuser> {
    Blog findByZname(Zuser zname);
}

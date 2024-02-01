package jetzengine.repository;

import java.util.Optional;
import jetzengine.entity.Zuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZuserRepository extends JpaRepository<Zuser, Long> {
    Optional<Zuser> findByEmail(String email);
}

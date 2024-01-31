package jetzengine.repository;

import jetzengine.entity.Zuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZuserRepository extends JpaRepository<Zuser, Long> {
}

package jetzengine.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
public class Zuser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(unique = true)
    String email;

    String password;

    @Column(unique = true)
    String zname;

    LocalDateTime regDateTime;

    public Zuser(String email, String password, String zname, LocalDateTime regDateTime) {
        this.email = email;
        this.password = password;
        this.zname = zname;
        this.regDateTime = regDateTime;
    }
}

package jetzengine.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Zuser {
    @Id
    private String zname;

    @Column(columnDefinition = "BIGINT(20) NOT NULL UNIQUE KEY auto_increment")
    private Long id;

    @Column(unique = true,
            nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private LocalDateTime regDateTime;

    public Zuser(String email, String password, String zname, LocalDateTime regDateTime) {
        this.email = email;
        this.password = password;
        this.zname = zname;
        this.regDateTime = regDateTime;
    }
}

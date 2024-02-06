package jetzengine.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import lombok.Getter;

@Entity
@Getter
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime regDateTime;

    private LocalDateTime modDateTime;

    @ManyToOne
    private Post post;
}

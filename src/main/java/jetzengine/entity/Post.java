package jetzengine.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;

@Entity
@Getter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Blog blog;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private LocalDateTime regDateTime;

    private LocalDateTime modDateTime;

    private Long likes;

    private Long hits;

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    private List<Reply> replyList;
}
package jetzengine.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Blog {
    @Id
    private String zname;

    @MapsId
    @OneToOne
    @JoinColumn(name = "zuser")
    private Zuser zuser;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String intro;

    private String profileImg;

    private String backgroundImg;

    private Long hits;

    @OneToMany(mappedBy = "blog", cascade = CascadeType.REMOVE)
    private List<Post> postList;

    public Blog(Zuser zuser, String title, String intro, Long hits) {
        this.zuser = zuser;
        this.title = title;
        this.intro = intro;
        this.hits = hits;
    }
}

package jetzengine.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
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

    private String title;

    private String intro;

    private String profileImg;

    private String backgroundImg;

    private Long hits;

    public Blog(Zuser zuser, String title, String intro, Long hits) {
        this.zuser = zuser;
        this.title = title;
        this.intro = intro;
        this.hits = hits;
    }
}

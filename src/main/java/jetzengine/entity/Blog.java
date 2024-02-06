package jetzengine.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;

@Entity
@Getter
@NoArgsConstructor
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "zname", referencedColumnName = "zname")
    Zuser zname;

    String title;

    String intro;

    String profileImg;

    String backgroundImg;

    Long hits;

    public Blog(Zuser zname, String title, String intro, Long hits) {
        this.zname = zname;
        this.title = title;
        this.intro = intro;
        this.hits = hits;
    }
}

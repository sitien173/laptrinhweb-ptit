package ptit.ltw.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Comment")
@Getter
@Setter
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id",foreignKey = @ForeignKey(name = "FK_comment_post"))
    private Post post;

    @Column(nullable = false)
    private LocalDateTime creatAt;

    @Column
    private Long parentId;

    @ManyToOne
    @JoinColumn(name = "appuser_id",foreignKey = @ForeignKey(name = "FK_comment_user"))
    private AppUser appUser;

    @Transient
    private List<Comment> child;

}

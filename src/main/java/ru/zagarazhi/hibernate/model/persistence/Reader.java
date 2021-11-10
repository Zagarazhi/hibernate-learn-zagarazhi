package ru.zagarazhi.hibernate.model.persistence;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "reader")
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "first_name", length = 63, nullable = false)
    @EqualsAndHashCode.Include
    private String firstName;

    @Column(name = "last_name", length = 63, nullable = false)
    @EqualsAndHashCode.Include
    private String lastName;

    @Column(name = "mail", length = 63)
    @EqualsAndHashCode.Include
    private String mail;

    @ManyToMany(mappedBy = "readers")
    @ToString.Exclude
    private List<Article> articles;
}

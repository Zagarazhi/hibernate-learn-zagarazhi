package ru.zagarazhi.hibernate.model.persistence;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "autor")
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Autor {
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

    @Column(name = "birthday", nullable = false)
    @EqualsAndHashCode.Include
    private LocalDate birthday;

    @OneToMany(mappedBy = "autor", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Article> articles;
}

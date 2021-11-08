package ru.zagarazhi.hibernate.model.persistence;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "article")
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "name", length = 63, nullable = false)
    @EqualsAndHashCode.Include
    private String name;

    @Column(name = "date")
    @EqualsAndHashCode.Include
    private LocalDate date;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Autor autor;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "article_readers",
        joinColumns = @JoinColumn(name = "article_id"),
        inverseJoinColumns = @JoinColumn(name = "reader_id")
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Reader> readers;
}

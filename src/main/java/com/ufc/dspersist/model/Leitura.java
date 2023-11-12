package com.ufc.dspersist.model;

import com.ufc.dspersist.enumeration.BookStatus;
import com.ufc.dspersist.enumeration.BookType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "leituras")
@Entity
public class Leitura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String title;
    private String authorname;

    @Column(name = "pages_qtd")
    private Integer pagesQtd;

    @Enumerated(EnumType.STRING)
    private BookType type;

    @Enumerated(EnumType.STRING)
    private BookStatus status;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Autor autor;

    @OneToMany(mappedBy = "leitura")
    private List<Anotacao> anotacoes;

    public Leitura(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Leitura{" + "id=" + id + ", title='" + title + ", authorName='" + authorname + ", pagesQtd=" + pagesQtd + ", type=" + type + ", status=" + status + '}';
    }
}
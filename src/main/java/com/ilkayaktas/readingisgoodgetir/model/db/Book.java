package com.ilkayaktas.readingisgoodgetir.model.db;

import lombok.*;

import javax.persistence.*;

/**
 * Created by ilkayaktas on 6.02.2022 at 01:04.
 */
@Entity
@Table(name = "book")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Book {
    private static final long serialVersionUID = 432154291451321L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "author")
    String author;

    @Column(name = "stockCount")
    Integer stockCount;

    @Column(name = "price")
    Double price;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((author == null) ? 0 : author.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((stockCount == null) ? 0 : stockCount.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        if (author == null) {
            if (other.author != null)
                return false;
        } else if (!author.equals(other.author))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (stockCount == null) {
            if (other.stockCount != null)
                return false;
        } else if (!stockCount.equals(other.stockCount))
            return false;
        return true;
    }
}

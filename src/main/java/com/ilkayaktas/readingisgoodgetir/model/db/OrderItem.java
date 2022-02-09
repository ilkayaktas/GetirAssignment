package com.ilkayaktas.readingisgoodgetir.model.db;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by ilkayaktas on 6.02.2022 at 01:04.
 */

@Entity
@Table(name = "orderitem")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "orderId")
    Long orderId;

    @NotNull
    @Column(name = "bookId")
    Long bookId;

    @NotNull
    @Column(name = "count")
    Integer count;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
        result = prime * result + ((count == null) ? 0 : count.hashCode());
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

        OrderItem other = (OrderItem) obj;

        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;

        if (count == null) {
            if (other.count != null)
                return false;
        } else if (!count.equals(other.count))
            return false;

        if (orderId == null) {
            if (other.orderId != null)
                return false;
        } else if (!orderId.equals(other.orderId))
            return false;

        if (bookId == null) {
            if (other.bookId != null)
                return false;
        } else if (!bookId.equals(other.bookId))
            return false;

        return true;
    }
}

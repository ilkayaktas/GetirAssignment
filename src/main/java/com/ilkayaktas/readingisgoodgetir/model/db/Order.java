package com.ilkayaktas.readingisgoodgetir.model.db;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;

/**
 * Created by ilkayaktas on 6.02.2022 at 01:04.
 */

@Entity
@Table(name = "order")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "order_time")
    Instant orderTime;

    @NotNull
    @Column(name = "status")
    Integer status;

    @OneToOne
    @NotNull
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    Customer customer;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((customer == null) ? 0 : customer.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((orderTime == null) ? 0 : orderTime.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
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

        Order other = (Order) obj;

        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;

        if (customer == null) {
            if (other.customer != null)
                return false;
        } else if (!customer.equals(other.customer))
            return false;

        if (orderTime == null) {
            if (other.orderTime != null)
                return false;
        } else if (!orderTime.equals(other.orderTime))
            return false;

        return true;
    }
}

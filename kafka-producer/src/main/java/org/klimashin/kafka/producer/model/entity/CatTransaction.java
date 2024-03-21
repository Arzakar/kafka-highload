package org.klimashin.kafka.producer.model.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "cat_transaction")

@Data
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CatTransaction {

    @Id
    @GeneratedValue
    @JdbcTypeCode(SqlTypes.UUID)
    @Column(name = "id")
    UUID id;

    @JdbcTypeCode(SqlTypes.UUID)
    @Column(name = "customer_id", nullable = false, updatable = false)
    UUID customerId;

    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    @Column(name = "direction", nullable = false, updatable = false)
    TransactionDirectionType direction;

    @JdbcTypeCode(SqlTypes.INTEGER)
    @Column(name = "cat_mass", nullable = false, updatable = false)
    Integer catMass;

    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(name = "cat_color", length = 7, nullable = false, updatable = false)
    String catColor;

    @CreationTimestamp
    @JdbcTypeCode(SqlTypes.TIMESTAMP_WITH_TIMEZONE)
    @Column(name = "created_at", nullable = false, updatable = false)
    OffsetDateTime createdAt;
}

package org.klimashin.kafka.producer.repository;

import org.klimashin.kafka.producer.model.entity.CatTransaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CatTransactionRepository extends JpaRepository<CatTransaction, UUID> {
}

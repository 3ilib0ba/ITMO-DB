package com.example.demo.balance.repository;

import com.example.demo.balance.model.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BalanceRepository extends JpaRepository<Balance, Long> {
    @Modifying
    @Transactional
    @Query(value = "update balance set value = ?2 where id = ?1", nativeQuery = true)
    void setNewBalanceById(long id, float newValue);
}

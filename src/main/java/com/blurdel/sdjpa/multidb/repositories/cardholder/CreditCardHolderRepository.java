package com.blurdel.sdjpa.multidb.repositories.cardholder;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blurdel.sdjpa.multidb.domain.cardholder.CreditCardHolder;

import java.util.Optional;


public interface CreditCardHolderRepository extends JpaRepository<CreditCardHolder, Long> {

    Optional<CreditCardHolder> findByCreditCardId(Long id);

}

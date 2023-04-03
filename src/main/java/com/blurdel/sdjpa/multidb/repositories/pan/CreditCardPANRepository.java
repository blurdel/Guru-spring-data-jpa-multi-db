package com.blurdel.sdjpa.multidb.repositories.pan;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blurdel.sdjpa.multidb.domain.pan.CreditCardPAN;

import java.util.Optional;


public interface CreditCardPANRepository extends JpaRepository<CreditCardPAN, Long> {

    Optional<CreditCardPAN> findByCreditCardId(Long id);

}

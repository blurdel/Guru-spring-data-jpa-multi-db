package com.blurdel.sdjpa.multidb.repositories.creditcard;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blurdel.sdjpa.multidb.domain.creditcard.CreditCard;


public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
}

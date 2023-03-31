package com.blurdel.sdjpa.multidb.repositories.cardholder;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blurdel.sdjpa.multidb.domain.cardholder.CreditCardHolder;


public interface CreditCardHolderRepository extends JpaRepository<CreditCardHolder, Long>{
}

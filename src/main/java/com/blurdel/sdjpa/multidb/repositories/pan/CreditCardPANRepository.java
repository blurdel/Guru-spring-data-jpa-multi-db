package com.blurdel.sdjpa.multidb.repositories.pan;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blurdel.sdjpa.multidb.domain.pan.CreditCardPAN;


public interface CreditCardPANRepository extends JpaRepository<CreditCardPAN, Long>{
}

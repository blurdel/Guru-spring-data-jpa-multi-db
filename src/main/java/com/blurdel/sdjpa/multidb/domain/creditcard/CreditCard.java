package com.blurdel.sdjpa.multidb.domain.creditcard;

import com.blurdel.sdjpa.multidb.domain.CreditCardConverter;

import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class CreditCard {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Convert(converter = CreditCardConverter.class)
    private String cvv;

    @Convert(converter = CreditCardConverter.class)
    private String expirationDate;
    
}

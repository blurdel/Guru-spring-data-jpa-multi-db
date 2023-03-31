package com.blurdel.sdjpa.multidb.domain.pan;

import com.blurdel.sdjpa.multidb.domain.CreditCardConverter;

import jakarta.persistence.Convert;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class CreditCardPAN {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Convert(converter = CreditCardConverter.class)
    private String creditCardNumber;
    
}

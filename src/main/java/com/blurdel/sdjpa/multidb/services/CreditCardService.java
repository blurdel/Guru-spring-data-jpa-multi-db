package com.blurdel.sdjpa.multidb.services;

import com.blurdel.sdjpa.multidb.domain.creditcard.CreditCard;

public interface CreditCardService {

    CreditCard getCreditCardById(Long id);

    CreditCard saveCreditCard(CreditCard cc);
}

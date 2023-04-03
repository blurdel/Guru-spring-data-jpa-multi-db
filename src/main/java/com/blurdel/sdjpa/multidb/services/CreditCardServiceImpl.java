package com.blurdel.sdjpa.multidb.services;

import com.blurdel.sdjpa.multidb.domain.cardholder.CreditCardHolder;
import com.blurdel.sdjpa.multidb.domain.pan.CreditCardPAN;
import com.blurdel.sdjpa.multidb.repositories.cardholder.CreditCardHolderRepository;
import com.blurdel.sdjpa.multidb.repositories.creditcard.CreditCardRepository;
import com.blurdel.sdjpa.multidb.repositories.pan.CreditCardPANRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.blurdel.sdjpa.multidb.domain.creditcard.CreditCard;

@Service
@RequiredArgsConstructor
public class CreditCardServiceImpl implements CreditCardService {

	private final CreditCardRepository creditCardRepo;
	private final CreditCardHolderRepository creditCardHolderRepo;
	private final CreditCardPANRepository creditCardPANRepo;


	@Override
	public CreditCard getCreditCardById(Long id) {
		// TODO Auto-generated method stub

		return null;
	}

	@Transactional
	@Override
	public CreditCard saveCreditCard(CreditCard cc) {
		CreditCard saved = creditCardRepo.save(cc);
		saved.setFirstName(cc.getFirstName());
		saved.setLastName(cc.getLastName());
		saved.setZipCode(cc.getZipCode());
		saved.setCreditCardNumber(cc.getCreditCardNumber());

		creditCardHolderRepo.save(CreditCardHolder.builder()
				.creditCardId(saved.getId())
				.firstName(saved.getFirstName())
				.lastName(saved.getLastName())
				.zipCode(saved.getZipCode())
				.build());

		creditCardPANRepo.save(CreditCardPAN.builder()
				.creditCardId(saved.getId())
				.creditCardNumber(saved.getCreditCardNumber())
				.build());

		return saved;
	}
}

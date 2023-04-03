package com.blurdel.sdjpa.multidb;

import com.blurdel.sdjpa.multidb.domain.creditcard.CreditCard;
import com.blurdel.sdjpa.multidb.services.CreditCardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class GuruSpringDataJpaMultiDbApplicationTests {

	@Autowired
	CreditCardService creditCardService;


	@Test
	void testSaveAndGetCreditCard() {
		CreditCard cc = CreditCard.builder()
				.firstName("John")
				.lastName("Thompson")
				.zipCode("12345")
				.creditCardNumber("1234556")
				.cvv("123")
				.expirationDate("12/26")
				.build();

		CreditCard saved = creditCardService.saveCreditCard(cc);

		assertThat(saved).isNotNull();
		assertThat(saved.getId()).isNotNull();
		assertThat(saved.getCreditCardNumber()).isNotNull();


		CreditCard fetched = creditCardService.getCreditCardById(saved.getId());

		assertThat(fetched).isNotNull();
		assertThat(fetched.getId()).isNotNull();
		assertThat(fetched.getCreditCardNumber()).isNotNull();
	}

	@Test
	void contextLoads() {
	}

}

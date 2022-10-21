package com.app;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.entity.Client;
import com.app.sevice.impl.ServiceClientImpl;

@SpringBootTest
class CarRentalApplicationTests {

	@Test
	void contextLoads() {
		
		Client client = new Client();
		
		client.setAdress("adress1");
		client.setAge(25);
		client.setCIN("J521847");
		client.setCantry("Morocco");
		client.setCity("Agadir");
		client.setEmail("email@gmail.com");
		client.setFirst_Name("khalil");
		client.setLast_Name("farouqi");
		client.setLicence("10/123456");
		client.setTel("0638153545");
		client.setVol_Numbre(1);
		client.setUserName("0638153545");
		client.setPassWord("0638153545");
		
		ServiceClientImpl adminController = new ServiceClientImpl();
		
		try {
			adminController.save(client);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		adminController.save(client);
		
		
	}

}

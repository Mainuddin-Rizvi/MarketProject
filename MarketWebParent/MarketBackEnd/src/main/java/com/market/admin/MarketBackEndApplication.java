package com.market.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.market.common.entity"})
public class MarketBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarketBackEndApplication.class, args);
	}

}

package com.garby.vault;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.bettercloud.vault.Vault;
import com.bettercloud.vault.VaultConfig;
import com.bettercloud.vault.VaultException;

@SpringBootApplication
public class VaultApplication {

	public static void main(String[] args) {
		SpringApplication.run(VaultApplication.class, args);
	}

	@Bean
	public Vault vault() throws VaultException {
		// Configure Vault
		VaultConfig config = new VaultConfig()
				.address("http://127.0.0.1:8200")
				.token("your_defined_token");       // Replace with your defined token

		// Initialize Vault instance
		return new Vault(config);
	}

}

package com.garby.vault;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
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
	public Vault vault(VaultProperties vaultProperties) throws VaultException {
		// Configure Vault using properties from application.yaml
		VaultConfig config = new VaultConfig()
				.address(vaultProperties.getAddress())
				.token(vaultProperties.getToken());

		// Initialize Vault instance
		return new Vault(config);
	}

	@ConfigurationProperties(prefix = "vault")
	class VaultProperties {
		private String address;
		private String token;

		// Getters and setters
		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}
	}

}

package com.garby.vault;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
//import org.springframework.util.ResourceUtils;
import org.yaml.snakeyaml.Yaml;
import com.bettercloud.vault.Vault;
import com.bettercloud.vault.VaultConfig;
import com.bettercloud.vault.VaultException;
import java.io.IOException;
import java.io.InputStream;

@SpringBootApplication
public class VaultApplication {

	public static void main(String[] args) {
		SpringApplication.run(VaultApplication.class, args);
	}

	@Bean
	public Vault vault() throws VaultException, IOException {
		// Load Vault configuration from vault.yaml file
		InputStream inputStream = new ClassPathResource("config/vault.yaml").getInputStream();
		Yaml yaml = new Yaml();
		VaultConfig vaultConfig;
		try (inputStream) {
			vaultConfig = yaml.loadAs(inputStream, VaultConfig.class);
		}

		// Initialize Vault instance
		return new Vault(vaultConfig);
	}

}

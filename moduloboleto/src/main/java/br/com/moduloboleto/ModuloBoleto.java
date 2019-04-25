package br.com.moduloboleto;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import br.com.moduloboleto.entities.Boleto;
import br.com.moduloboleto.entities.BoletoTracking;
import br.com.moduloboleto.repositories.BoletoRepository;
import br.com.moduloboleto.repositories.BoletoTrackingRepository;

@SpringBootApplication
public class ModuloBoleto extends SpringBootServletInitializer implements CommandLineRunner {

	@Autowired
	public BoletoRepository repoBoleto;

	@Autowired
	public BoletoTrackingRepository repoBoletoTracking;

	@Override
	public void run(String... args) throws Exception {
		Boleto boleto1 = new Boleto(null, LocalDate.of(2019, 1, 18), 100.00, LocalDate.of(2019, 3, 20));
		Boleto boleto2 = new Boleto(null, LocalDate.of(2019, 2, 18), 80.00, LocalDate.of(2019, 3, 20));
		Boleto boleto3 = new Boleto(null, LocalDate.of(2019, 2, 18), 10.00, LocalDate.of(2019, 3, 20));

		Boleto boleto4 = new Boleto(null, LocalDate.of(2019, 1, 10), 20.00, LocalDate.of(2019, 1, 15));
		Boleto boleto5 = new Boleto(null, LocalDate.of(2019, 2, 11), 50.00, LocalDate.of(2019, 2, 13));
		Boleto boleto6 = new Boleto(null, LocalDate.of(2019, 3, 20), 50.00, LocalDate.of(2019, 3, 25));

		BoletoTracking boletoTracking1 = new BoletoTracking(null, "Ativo", LocalDate.of(2019, 3, 20), boleto1);
		BoletoTracking boletoTracking2 = new BoletoTracking(null, "Ativo", LocalDate.of(2019, 3, 20), boleto2);
		BoletoTracking boletoTracking3 = new BoletoTracking(null, "Ativo", LocalDate.of(2019, 3, 20), boleto3);
		BoletoTracking boletoTracking4 = new BoletoTracking(null, "Ativo", LocalDate.of(2019, 3, 20), boleto4);
		BoletoTracking boletoTracking5 = new BoletoTracking(null, "Ativo", LocalDate.of(2019, 3, 20), boleto5);
		BoletoTracking boletoTracking6 = new BoletoTracking(null, "Ativo", LocalDate.of(2019, 3, 20), boleto6);
		BoletoTracking boletoTracking7 = new BoletoTracking(null, "Cancelado", LocalDate.of(2019, 2, 4), boleto5);
		BoletoTracking boletoTracking8 = new BoletoTracking(null, "Cancelado", LocalDate.of(2019, 3, 27), boleto6);

		repoBoleto.saveAll(Arrays.asList(boleto1, boleto2, boleto3, boleto4, boleto5, boleto6));
		repoBoletoTracking.saveAll(Arrays.asList(boletoTracking1, boletoTracking2, boletoTracking3,
				boletoTracking4, boletoTracking5, boletoTracking6, boletoTracking7, boletoTracking8));
		
	}

	public static void main(String[] args) {
		SpringApplication.run(ModuloBoleto.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ModuloBoleto.class);
	}

}

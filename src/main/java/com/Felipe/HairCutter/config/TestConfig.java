package com.Felipe.HairCutter.config;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.Felipe.HairCutter.entities.Barber;
import com.Felipe.HairCutter.entities.Category;
import com.Felipe.HairCutter.entities.Client;
import com.Felipe.HairCutter.entities.HairJob;
import com.Felipe.HairCutter.entities.HairJobOrder;
import com.Felipe.HairCutter.repositories.BarberRepository;
import com.Felipe.HairCutter.repositories.CategoryRepository;
import com.Felipe.HairCutter.repositories.ClientRepository;
import com.Felipe.HairCutter.repositories.HairJobOrderRepository;
import com.Felipe.HairCutter.repositories.HairJobRepository;

@Configuration
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private BarberRepository barberRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private HairJobRepository HJRepository;
	@Autowired
	private HairJobOrderRepository hJORepository;
	
	@Override
	public void run(String... args) throws Exception {
		Barber b1 = new Barber("Hyago");
		Barber b2 = new Barber("Vanderson");
		
		barberRepository.saveAll(Arrays.asList(b1, b2));
		
		Category ct1 = new Category("corte");
		Category ct2 = new Category("pintura");
		Category ct3 = new Category("tratamentos");
		
		categoryRepository.saveAll(Arrays.asList(ct1, ct2, ct3));
		
		Client c1 = new Client("felipe", "631 24 14 40", LocalDate.now());
		Client c2 = new Client("joâo", "+34 632 25 15 41", LocalDate.now());
	
		clientRepository.saveAll(Arrays.asList(c1,c2));
		
		HairJob hJ1 = new HairJob("Social", ct1, 7.00);
		HairJob hJ2 = new HairJob("Degradê", ct1, 7.00);
		HairJob hJ3 = new HairJob("pintura Sólida", ct2, 5.00);
		HairJob hJ4 = new HairJob("alisamento", ct3, 12.00);
		
		HJRepository.saveAll(Arrays.asList(hJ1, hJ2, hJ3, hJ4));
		
		HairJobOrder o1 = new HairJobOrder(b1, c1, Instant.now());
		HairJobOrder o2 = new HairJobOrder(b2, c2, Instant.now());
		o1.getJobs().addAll(Arrays.asList(hJ1, hJ3));
		o2.getJobs().addAll(Arrays.asList(hJ2, hJ3, hJ4));
		hJORepository.saveAll(Arrays.asList(o1, o2));
		
		
	}

}

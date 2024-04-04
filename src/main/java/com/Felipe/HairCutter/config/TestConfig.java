package com.Felipe.HairCutter.config;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.Felipe.HairCutter.entities.Barber;
import com.Felipe.HairCutter.entities.BarberDay;
import com.Felipe.HairCutter.entities.Category;
import com.Felipe.HairCutter.entities.Client;
import com.Felipe.HairCutter.entities.HairJob;
import com.Felipe.HairCutter.entities.HairJobOrder;
import com.Felipe.HairCutter.entities.Note;
import com.Felipe.HairCutter.entities.WeekDay;
import com.Felipe.HairCutter.enums.Availability;
import com.Felipe.HairCutter.enums.Day;
import com.Felipe.HairCutter.repositories.BarberDayRepository;
import com.Felipe.HairCutter.repositories.BarberRepository;
import com.Felipe.HairCutter.repositories.NoteRepository;
import com.Felipe.HairCutter.repositories.WeekDayRepository;
import com.Felipe.HairCutter.services.BarberService;
import com.Felipe.HairCutter.services.CategoryService;
import com.Felipe.HairCutter.services.ClientService;
import com.Felipe.HairCutter.services.HairJobOrderService;
import com.Felipe.HairCutter.services.HairJobService;

@Configuration
public class TestConfig implements CommandLineRunner {

	/*
	 * @Autowired private BarberRepository barberRepository;
	 * 
	 * @Autowired private ClientRepository clientRepository;
	 * 
	 * @Autowired private CategoryRepository categoryRepository;
	 * 
	 * @Autowired private HairJobRepository HJRepository;
	 * 
	 * @Autowired private HairJobOrderRepository hJORepository;
	 */

	@Autowired
	private BarberService barberService;
	@Autowired
	private BarberRepository barberRepository;
	@Autowired
	private BarberDayRepository barberDayRepository;
	@Autowired
	private ClientService clientService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private HairJobService HJService;
	@Autowired
	private HairJobOrderService hJOService;
	@Autowired
	private WeekDayRepository WDService;
	@Autowired
	private NoteRepository noteRepository;
	@Override
	public void run(String... args) throws Exception {
		for(int i = 0; i < 7; i++) {
			WDService.save(new WeekDay(Day.values()[i]));
		}
		
		// Database Seeding
		Barber b1 = new Barber("Hyago");
		Barber b2 = new Barber("Vanderson");
		// barber without services
		Barber b3 = new Barber("Vanderson");
		// barberRepository.saveAll(Arrays.asList(b1, b2));
		List<WeekDay> days = WDService.findAll();
		
		barberService.insert(b1);
		barberService.insert(b2);
		barberService.insert(b3);
		
		System.out.println(b1.getId() +" "+ b2.getId() +" "+ b3.getId());
		for(int i = 0; i < 7; i++) {
			barberDayRepository.save(new BarberDay( b1, days.get(i), Availability.trabalhando));
		}
		b1.getNotes().add(new Note("segunda feira arrumar estoque", LocalDate.now()));
		barberRepository.save(b1);
		
		
		Category ct1 = new Category("corte");
		Category ct2 = new Category("pintura");
		Category ct3 = new Category("tratamentos");

		// categoryRepository.saveAll(Arrays.asList(ct1, ct2, ct3));
		categoryService.insert(ct1);
		categoryService.insert(ct2);
		categoryService.insert(ct3);

		Client c1 = new Client("felipe", "631 24 14 40");
		Client c2 = new Client("joâo", "+34 632 25 15 41");
		// client without orders
		Client c3 = new Client("jonas", "+34 633 26 16 42");
		// clientRepository.saveAll(Arrays.asList(c1,c2));
		clientService.insert(c1);
		clientService.insert(c2);
		clientService.insert(c3);
		HairJob hJ1 = new HairJob("Social", "corte simples com maquina e tesoura.", ct1, 7.00);
		HairJob hJ2 = new HairJob("Degradê", "corte sofísticado com um degrade nas laterais.", ct1, 7.00);
		HairJob hJ3 = new HairJob("pintura Sólida", "pintura em todo o cabelo.", ct2, 5.00);
		HairJob hJ4 = new HairJob("alisamento", "processo de alisamento no cabelo", ct3, 12.00);

		// HJRepository.saveAll(Arrays.asList(hJ1, hJ2, hJ3, hJ4));
		HJService.insert(hJ1);
		HJService.insert(hJ2);
		HJService.insert(hJ3);
		HJService.insert(hJ4);

		HairJobOrder o1 = new HairJobOrder(b1, c1, Instant.now());
		HairJobOrder o2 = new HairJobOrder(b2, c2, Instant.now());

		o1.getJobs().addAll(Arrays.asList(hJ1, hJ3));
		o2.getJobs().addAll(Arrays.asList(hJ2, hJ3, hJ4));

		// hJORepository.saveAll(Arrays.asList(o1, o2));
		hJOService.insert(o1);
		hJOService.insert(o2);

		/*
		 * System.out.println(barberService.findById(b1.getId()));
		 * System.out.println(clientService.findById(c1.getId()));
		 * System.out.println(categoryService.findById(ct1.getId()));
		 * System.out.println(HJService.findById(hJ1.getId()));
		 * System.out.println(hJOService.findById(b1.getId()));
		 * System.out.println(hJOService.findById(o1.getId()));
		 */

		/*
		 * BarberDTO barber = BarberMapper.INSTANCE.barberToBarberDTO(b1);
		 * System.out.println(barber);
		 * System.out.println(BarberMapper.INSTANCE.barberDTOToBarber(barber));
		 * 
		 * CategoryDTO category = CategoryMapper.INSTANCE.categoryToCategoryDTO(ct1);
		 * System.out.println(category);
		 * System.out.println(CategoryMapper.INSTANCE.categoryDTOToCategory(category));
		 * 
		 * ClientDTO client = ClientMapper.INSTANCE.clientToClientDTO(c1);
		 * System.out.println(client);
		 * System.out.println(ClientMapper.INSTANCE.clientDTOToClient(client));
		 * 
		 * HairJobDTO HJ = HairJobMapper.INSTANCE.hairJobToHairJobDTO(hJ1);
		 * System.out.println(HJ);
		 * System.out.println(HairJobMapper.INSTANCE.hairJobDTOToHairJob(HJ));
		 * 
		 * HairJobOrderDTO hjo =
		 * HairJobOrderMapper.INSTANCE.hairJobOrderToHairJobOrderDTO(o1);
		 * System.out.println(hjo);
		 * System.out.println(HairJobOrderMapper.INSTANCE.hairJobOrderDTOToHairJobOrder(
		 * hjo));
		 */

		// this will update c2 and give to it a new updated history component.
		Client uc2 = c2;
		uc2.setPhone("+34 111 11 11 11");
		clientService.update(c2.getId(), uc2);

		// this will update b2 and give to it a new updated history component.
		Barber ub2 = b2;
		ub2.setName("wanderson");
		barberService.update(b2.getId(), ub2);

		// this one will be only disabled, because they have references by some orders.
		clientService.delete(c2.getId());
		barberService.delete(b2.getId());

		// this had to be completed removed from the database.
		clientService.delete(c3.getId());
		barberService.delete(b3.getId());
		
	}

}

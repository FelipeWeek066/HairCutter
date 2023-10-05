package com.Felipe.HairCutter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Felipe.HairCutter.services.BarberService;
import com.Felipe.HairCutter.services.CategoryService;
import com.Felipe.HairCutter.services.ClientService;
import com.Felipe.HairCutter.services.HairJobOrderService;
import com.Felipe.HairCutter.services.HairJobService;

@Controller
@RequestMapping(value="/admin")
public class HairCutterController {
	
	@Autowired
	private BarberService barberService;
	@Autowired
	private ClientService clientService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private HairJobService hairJobService;
	@Autowired
	private HairJobOrderService hairJobOrderService;

		@GetMapping(value = "/barbers")
		public ModelAndView getBarbers() {
			ModelAndView mv = new ModelAndView("tables");
			mv.addObject("barbers", barberService.findAll());
			return mv;
		}
		
		@GetMapping(value = "/clients")
		public ModelAndView getClients() {
			ModelAndView mv = new ModelAndView("tables");
			mv.addObject("clients", clientService.findAll());
			return mv;
		}
		
		@GetMapping(value = "/categories")
		public ModelAndView getCategories() {
			ModelAndView mv = new ModelAndView("tables");
			mv.addObject("categories", categoryService.findAll());
			return mv;
		}
		
		@GetMapping(value = "/jobs")
		public ModelAndView getJobs() {
			ModelAndView mv = new ModelAndView("tables");
			mv.addObject("jobs", hairJobService.findAll());
			return mv;
		}
		
		@GetMapping(value = "/orders")
		public ModelAndView getOrders() {
			ModelAndView mv = new ModelAndView("tables");
			mv.addObject("orders", hairJobOrderService.findAll());
			return mv;
		}
	
}

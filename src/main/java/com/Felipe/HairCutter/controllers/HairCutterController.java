package com.Felipe.HairCutter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Felipe.HairCutter.entities.Barber;
import com.Felipe.HairCutter.services.BarberService;
import com.Felipe.HairCutter.services.CategoryService;
import com.Felipe.HairCutter.services.ClientService;
import com.Felipe.HairCutter.services.HairJobOrderService;
import com.Felipe.HairCutter.services.HairJobService;

import jakarta.validation.Valid;


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

		@GetMapping(value = "/elements")
		public ModelAndView getBarbers() {
			ModelAndView mv = new ModelAndView("tables");
			mv.addObject("barbers", barberService.findAll());
			mv.addObject("clients", clientService.findAll());
			mv.addObject("categories", categoryService.findAll());
			mv.addObject("jobs", hairJobService.findAll());
			mv.addObject("orders", hairJobOrderService.findAll());
			return mv;
		}
		
		@PostMapping(value = "/elements/barbers")
		public String saveBarber(@Valid Barber barber, BindingResult result, RedirectAttributes attributes) {
			if(result.hasErrors()) {
				return "redirect:/admin/elements";
			}
			barberService.insert(barber);
			return "redirect:/admin/elements";
		}
	
}

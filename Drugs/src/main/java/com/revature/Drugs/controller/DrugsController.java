package com.revature.Drugs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.Drugs.model.Drugs;
import com.revature.Drugs.repository.DrugsDAO;

@RestController
@RequestMapping("/drugs")
public class DrugsController {
	
	@Autowired
	DrugsDAO dao;
	
//	@GetMapping("/{name}")
//	public Drugs getByName(@RequestParam(value="name") String name) {
//		return dao.findByName(name);
//	}
	
	@GetMapping("/{id}")
	public Drugs getById(@PathVariable("id") int id) {
		return dao.findById(id);
	}
	
	@PostMapping("/{name}/{description}")
	public Drugs newDrug(@PathVariable("name") String name, @PathVariable("description") String descr) {
		
		Drugs d = new Drugs();
		d.setName(name);
		d.setDescription(descr);
		d.setInventory(100);
		
		dao.save(d);
		
		return d;
	}
	

}

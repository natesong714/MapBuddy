package com.example.mapbuddybackend.business;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
class SearchParameterController {

	@Autowired
	private BusinessService businessService;

	@Autowired
	private BusinessList businessList;
	@Autowired
	private Environment env;

	@Autowired
	private SearchParameter sp;


	@CrossOrigin(origins="http://localhost:3000/")
	@RequestMapping(method=RequestMethod.POST, value="/search")
	public void getDataFromReact(@RequestBody SearchParameter sp) {
		sp.printAllBusinessNames();
		if (sp != null) {
			System.out.println(sp.getLocation());
		} else {
			System.out.println("failure");
		}
		businessList = businessService.getBusinessListWithCustomHeaders(sp.getLocation(), sp.getBusinessNames());

	}

	@CrossOrigin(origins="http://localhost:3000/")
	@RequestMapping("/return")
	public BusinessList getDataFromReact() {
		//businessList.printAllBusinesses();
		return businessList;
	}
}

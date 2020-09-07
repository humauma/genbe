package com.huma.genbe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

	@GetMapping("/biodata")
	public String style1()

	{
		return "dashboard/biodata";
	}

	@GetMapping("/getbio")
	public String style2()

	{
		return "dashboard/get";
	}

	@GetMapping("/pendidikan")
	public String style3()

	{
		return "dashboard/pendidikan";
	}

}

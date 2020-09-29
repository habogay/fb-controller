package com.fcs.controller;

import java.io.File;
import java.util.concurrent.ExecutionException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;



@Controller

public class HomeController {

	@GetMapping(value = "/")
	public String index(Model model) throws InterruptedException, ExecutionException {
		String rs="";
		ITesseract tess = new Tesseract();
		  try {
		    // Specify trained data folder
		    // tess.setDatapath("./tessdata");
		    // Specify detected language 
		    tess.setLanguage("eng");
		    File img = new File("/home/habogay/Desktop/lh.png");
		    rs = tess.doOCR(img);
		    model.addAttribute("rs", rs);
		    System.out.println(rs);
		  } catch (Exception e) {
		    System.out.println(e.getMessage());
		  }
		return "views/home/index";
	}
	
	@GetMapping(value = "/welcome")
	public String welcome() throws InterruptedException, ExecutionException {

		return "welcome";
	}

}

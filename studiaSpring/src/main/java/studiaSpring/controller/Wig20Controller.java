package studiaSpring.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import studiaSpring.download.Refresh;
import studiaSpring.entity.Wig20;
import studiaSpring.service.Wig20Service;


@Controller
@RequestMapping("/wig20s")
public class Wig20Controller {

private Wig20Service wig20Service;
	
	public Wig20Controller(Wig20Service wig20Service) {
		
		this.wig20Service = wig20Service; 
	}
	
	@GetMapping("/list")
	public String listUsers(Model theModel) {
		
		
		List<Wig20> theWig20 = wig20Service.findAll();
		
		int[] listOfid = new int[theWig20.size()];
		int[] listOfwolumen = new int[theWig20.size()];
		double[] listOfotwarcie = new double[theWig20.size()];
		double[] listOfnajwyzszy = new double[theWig20.size()];
		double[] listOfnajnizszy = new double[theWig20.size()];
		double[] listOfzamkniecie = new double[theWig20.size()];
		LocalDate[] listOfdata = new LocalDate[theWig20.size()];
		
		for(int i = 0; i < theWig20.size(); i++) {
			listOfid[i] = theWig20.get(i).getId().intValue();
			listOfwolumen[i] = theWig20.get(i).getWolumen();
			listOfotwarcie[i] = theWig20.get(i).getOtwarcie();
			listOfnajwyzszy[i] = theWig20.get(i).getNajwyzszy();
			listOfnajnizszy[i] = theWig20.get(i).getNajnizszy();
			listOfzamkniecie[i] = theWig20.get(i).getZamkniecie();
			listOfdata[i] = theWig20.get(i).getData();
		}
		
		theModel.addAttribute("id", listOfid);
		theModel.addAttribute("wolumen", listOfwolumen);
		theModel.addAttribute("otwarcie", listOfotwarcie);
		theModel.addAttribute("najwyzszy", listOfnajwyzszy);
		theModel.addAttribute("najnizszy", listOfnajnizszy);
		theModel.addAttribute("zamkniecie", listOfzamkniecie);
		theModel.addAttribute("data", listOfdata);
		theModel.addAttribute("wig20s", theWig20);
		
		return "wig20s/list-wig20s";
	}
	@GetMapping("/refresh")
	public String refresh() {
		try {
			new Refresh(wig20Service, "https://stooq.pl/q/d/l/?s=wig20&i=d").update();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return "redirect:/wig20s/list";
	}
}

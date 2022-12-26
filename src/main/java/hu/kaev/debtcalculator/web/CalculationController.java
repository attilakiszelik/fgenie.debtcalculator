package hu.kaev.debtcalculator.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hu.kaev.debtcalculator.model.Calculation;
import hu.kaev.debtcalculator.service.CalculationService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/debtcalculator")
@RequiredArgsConstructor
public class CalculationController {

	private final CalculationService calculationService;

	@GetMapping()
	public String home(Model model) {
		
		model.addAttribute("calculation", new Calculation());
		
		return "home";
		
	}
	
	@PostMapping("/calculate")
	public String getCalculation(@ModelAttribute Calculation calculation, Model model){
		
		System.out.println("hitel összege: " + calculation.getAmount());
		System.out.println("hónapok száma: " + calculation.getPeriods());
		System.out.println("éves kamat mértéke: " + calculation.getInterestRate());
		
		model.addAttribute("result", calculationService.getCalculation(calculation));
		
		return "result";
		
	}
}

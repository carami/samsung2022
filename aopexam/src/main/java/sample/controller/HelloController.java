package sample.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
//	@RequestMapping(value = "/hello" , method = RequestMethod.GET)
	@GetMapping("/hello")
	public String hello(Model model, @RequestParam(value="name", required = false )String name,
			@RequestParam(value="age") int age) {
		System.out.println("name::"+ name);
		
		model.addAttribute("greeting","안녕세요~~  "+name+"님");
		return "hello";
	}
	
	@GetMapping("/list")
	public String list() {
		return "list";
	}

}

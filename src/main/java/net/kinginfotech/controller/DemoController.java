package net.kinginfotech.controller;

import lombok.extern.slf4j.Slf4j;
import net.kinginfotech.service.DemoService;
import net.kinginfotech.service.DemoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class DemoController {
    //==fieds==
    public final DemoService demoService;
    @Autowired
    public DemoController(DemoService demoService){
        this.demoService = demoService;
    }
    //http://localhost:8080/todo-list/hello
    @ResponseBody
    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }

    //http://localhost:8080/todo-list/welcome
    //http://localhost:8080/todo-list/welcome?user=King
    @GetMapping("welcome")
    public String welcome(@RequestParam String user,@RequestParam int age, Model model){
        model.addAttribute("user",demoService.getHelloMessage(user));
        model.addAttribute("age",age);
        log.info("Model = {}", model);
        //prefix + name + suffix
        //WEB-INF/view/welcome.jsp
        return "welcome";
    }
   //==Model attribute==
    @ModelAttribute("welcomeMessage")
    public String welcomeMessage(){
        log.info("welcomeMessage()Called");
        //prefix + name + suffix
        //WEB-INF/view/welcome.jsp
        return demoService.getWelcomeMessage();
    }

}

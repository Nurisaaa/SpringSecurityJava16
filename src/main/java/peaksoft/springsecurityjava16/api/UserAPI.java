package peaksoft.springsecurityjava16.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserAPI {

    @GetMapping
    public String getMethod(){
        return "/home";
    }

    @GetMapping("/get")
    public String someMethod(){
        return "/somePage";
    }

    @GetMapping("/main")
    public String mainPage(){
        return "/main";
    }
}

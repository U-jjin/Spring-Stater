package starter.springbasic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello!!");
        return "hello";
    }

    //    2022-07-04 스프링-입문: MVC와 템플릿 엔진
    @GetMapping("hello-mvc")
    public String hellodMvc(@RequestParam(value="name",required = true) String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }

    //API
    //ResponseBody -> http의 body부를 직접 넣어 주겠다는 의미
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello"+name;  //"hello spring" 이라고 바로 내려감
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;
        //프로퍼티 접근방식
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}

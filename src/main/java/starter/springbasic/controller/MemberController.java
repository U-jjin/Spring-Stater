package starter.springbasic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import starter.springbasic.domain.Member;
import starter.springbasic.service.MemberService;

import java.util.List;

//Controller 어노테이션을 생성되면 멤버컨트롤러가 스프링 컨테이너에 생성하여 관리하게 됨.
@Controller
public class MemberController {
    //이렇게 객체를 생성하여 가져다가 쓰는 것이 아닌,
//스프링 컨테이너에 등록하고 컨테이너에서 받아서 쓰도록 해야함 -> 여러 컨트롤들이 가져다가 쓸 수 있도록
//private final MemberService memberService = new MemberService();
  private final MemberService memberService;

//Autowired : 스프링 컨테이너에 있는 Member service를 가져옴.
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    @GetMapping("members/new")
    public String createForm() {
        return "members/createMemberForm";
    }
    @PostMapping("members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());
        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("members")
    public String list(Model model){
        List<Member> members =memberService.findMembers();
        model.addAttribute("members",members);
        return "members/memberlist";
    }

}






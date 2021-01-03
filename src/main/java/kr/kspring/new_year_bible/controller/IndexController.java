package kr.kspring.new_year_bible.controller;

import kr.kspring.new_year_bible.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/")
public class IndexController {

  @GetMapping
  public String indexPage(Model model) {
    return "index";
  }
}

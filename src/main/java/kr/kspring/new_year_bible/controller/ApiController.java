package kr.kspring.new_year_bible.controller;

import kr.kspring.new_year_bible.dto.BibleData;
import kr.kspring.new_year_bible.dto.BibleData.Res;
import kr.kspring.new_year_bible.entity.Member;
import kr.kspring.new_year_bible.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ApiController {

  private final MemberService memberService;

  @PostMapping("/getBibleImage")
  public BibleData.Res getBibleImage(@RequestBody BibleData.Req req) throws Exception{

    if (req == null || req.getName() == null || req.getPassword() == null) {
      log.error("request null exception : {}", req);
      throw new RuntimeException("null");
    }

    log.info("user : {} / {}", req.getName(), req.getPassword());

    Member member = Member.builder()
        .name(req.getName())
        .password(req.getPassword())
        .build();
    String image = memberService.getImageOrNewImage(member);

    BibleData.Res res = new BibleData.Res(req.getName(), image);
    return res;
  }
}

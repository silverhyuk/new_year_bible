package kr.kspring.new_year_bible.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import javax.xml.bind.DatatypeConverter;
import kr.kspring.new_year_bible.entity.Member;
import kr.kspring.new_year_bible.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {
  private final MemberRepository memberRepository;

  public void save(Member member){
    member.setPassword(Base64Utils.encodeToString(member.getPassword().getBytes()));
    memberRepository.save(member);
  }

  public String getImageOrNewImage(Member member) throws Exception {

    String name = member.getName();
    String encodeToString = DatatypeConverter.printBase64Binary(member.getPassword().getBytes("UTF-8"));

    Optional<Member> byName = memberRepository.findMembersByName(name);
    if(byName.isPresent()) {
      Member existMember = byName.get();
      if (!encodeToString.equals(existMember.getPassword())) {
        throw new RuntimeException("password");
      }
      return existMember.getImage();
    } else {
      //이미지 새로 뽑기
      List<Member> membersByImageIsNotNull = memberRepository.findMembersByImageIsNotNull();
      List<String> images = membersByImageIsNotNull.stream().map(Member::getImage)
          .collect(Collectors.toList());

      String newImage = getImage(images);
      member.setImage(newImage);
      save(member);
      return newImage;
    }
  }

  public String getImage(List<String> images) throws IOException {
    PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
    Resource[] resources = resolver.getResources("classpath:static/assets/img/bible/*.png");
    List<String> list = Arrays.stream(resources).map(Resource::getFilename)
        .filter(filename -> !images.contains(filename))
        .collect(Collectors.toList());

    int size = list.size();

    double random = Math.random();
    int ran = (int)((random * size) - 1);
    return list.get(ran);

  }
}

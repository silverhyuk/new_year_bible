package kr.kspring.new_year_bible.repository;

import java.util.List;
import java.util.Optional;
import kr.kspring.new_year_bible.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
  Optional<Member> findMembersByName(String name);
  List<Member> findMembersByImageIsNotNull();
}

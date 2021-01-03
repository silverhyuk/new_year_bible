package kr.kspring.new_year_bible.entity;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.jadira.usertype.dateandtime.joda.PersistentDateTime;
import org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * 등록과 수정 시간을 서비스에서 자동으로 처리하도록 만든 엔티티 수퍼 클래스
 */
@MappedSuperclass
@EntityListeners(value = AuditingEntityListener.class)
@TypeDefs({
    @TypeDef(defaultForType = LocalDate.class, typeClass = PersistentDateTime.class),
    @TypeDef(defaultForType = LocalDateTime.class, typeClass = PersistentLocalDateTime.class),
    @TypeDef(defaultForType = DateTime.class, typeClass = PersistentDateTime.class)
})
@Data
@ToString(of = {"created", "updated"}, callSuper = true)
public class BaseEntity {
  /**
   * created on
   */
  @CreatedDate
  DateTime created;

  /**
   * updated on
   */
  @LastModifiedDate
  DateTime updated;
}

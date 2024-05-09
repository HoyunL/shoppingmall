package shop.shoppingmall.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.shoppingmall.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    boolean existsByUsername(String username);
}

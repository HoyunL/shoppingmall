package shop.shoppingmall.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import shop.shoppingmall.entity.MemberHistory;


@Repository
public interface MemberHistoryRepository extends MongoRepository<MemberHistory, String> {
}

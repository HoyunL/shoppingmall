package shop.shoppingmall.mongoRepository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;
import shop.shoppingmall.entity.MemberHistory;


@Repository
public interface MongoHistoryRepository extends MongoRepository<MemberHistory, String> {
}

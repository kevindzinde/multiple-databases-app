package zw.kevin.multipledatabasesapp.userdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zw.kevin.multipledatabasesapp.userdb.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

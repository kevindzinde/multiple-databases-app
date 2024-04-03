package zw.kevin.multipledatabasesapp.schooldb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zw.kevin.multipledatabasesapp.schooldb.entity.School;

@Repository
public interface SchoolRepository  extends JpaRepository<School,Long> {
}

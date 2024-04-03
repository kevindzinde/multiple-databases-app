package zw.kevin.multipledatabasesapp.schooldb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class School {
    @Id
    private Long id;
    private String name;
    private String location;

}

package zw.kevin.multipledatabasesapp.schooldb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import zw.kevin.multipledatabasesapp.schooldb.entity.School;
import zw.kevin.multipledatabasesapp.schooldb.repository.SchoolRepository;
import java.util.List;
@RestController
public class SchoolController {
    @Autowired
    SchoolRepository schoolRepository;
    @PostMapping("api/v1/school")
    public School saveSchool(@RequestBody School school){
        return schoolRepository.save(school);
    }
    @GetMapping("api/v1/schools")
    public List<School> getSchoolList(){
        return schoolRepository.findAll();

    }

}

package com.example.demo.services;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.sterrotype.Service;
import com.example.demo.entity.StudentEntity;
@Service
public class StudentService{
    private Map<Integer,StudentEntity>details=new HashMao<>();
    public StudentEntity saveData(StudentEntity st){
        details.put(st.getId(),st);
        return st;
    }
    public StudentEntity getById(int id){
        return details.get(id);
    }
    public Collection<StudentEntity>getAll(){
        return details.values();
    }
    public StudentEntity updateStudent(int id,StudentEntity st){
        if(details.containsKey(id)){
            st.setId(id);
            details.put(id,st);
            return st;
        }
        return null;
    }
}
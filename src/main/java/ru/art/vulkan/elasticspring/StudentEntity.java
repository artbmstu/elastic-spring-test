package ru.art.vulkan.elasticspring;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "student", type = "default")
public class StudentEntity {

    @Id
    int id;
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StudentEntity(int id, String name){
        super();
        this.id = id;
        this.name = name;
    }

    public StudentEntity(){}
}

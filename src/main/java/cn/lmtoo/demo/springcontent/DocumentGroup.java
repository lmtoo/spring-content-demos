package cn.lmtoo.demo.springcontent;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class DocumentGroup {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany
    private List<Document> entries = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Document> getEntries() {
        return entries;
    }

    public void setEntries(List<Document> entries) {
        this.entries = entries;
    }
}

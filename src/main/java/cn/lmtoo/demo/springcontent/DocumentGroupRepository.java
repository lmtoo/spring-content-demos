package cn.lmtoo.demo.springcontent;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "documentGroup")
public interface DocumentGroupRepository extends CrudRepository<DocumentGroup, Long> {

}

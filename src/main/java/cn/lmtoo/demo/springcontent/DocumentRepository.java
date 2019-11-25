package cn.lmtoo.demo.springcontent;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.versions.LockingAndVersioningRepository;

import java.util.Optional;

/**
 * 文档仓库
 *
 * @author lile
 * @since 2019-11-1 10:53:04
 */
@RepositoryRestResource(path = "documents", collectionResourceRel = "documents")
interface DocumentRepository extends CrudRepository<Document, Long>, LockingAndVersioningRepository<Document, Long> {

    //TODO: 查询所有的文档，默认禁用掉
    @Override
    @RestResource
    Iterable<Document> findAll();

    @Override
    @RestResource
    <S extends Document> S save(S entity);

    @Override
    @RestResource
    Optional<Document> findById(Long aLong);
}
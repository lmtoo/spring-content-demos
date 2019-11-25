package cn.lmtoo.demo.springcontent;

import org.springframework.content.commons.renditions.Renderable;
import org.springframework.content.commons.repository.AssociativeStore;
import org.springframework.content.commons.repository.ContentRepository;
import org.springframework.content.commons.repository.ContentStore;
import org.springframework.content.rest.StoreRestResource;

@StoreRestResource(path = "content")
public interface DocumentContentStore extends ContentStore<Document,Long>, AssociativeStore<Document, Long>, Renderable<Document> {
}

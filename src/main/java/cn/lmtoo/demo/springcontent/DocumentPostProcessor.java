package cn.lmtoo.demo.springcontent;

import org.springframework.core.io.Resource;

public interface DocumentPostProcessor {
    void postProcessAfterSetContent(Document document, Resource resource);
}

package cn.lmtoo.demo.springcontent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class TotalPageDocumentPostProcessor implements DocumentPostProcessor{

    @Autowired
    private DocumentRepository documentRepository;

    @Override
    @Transactional
    public void postProcessAfterSetContent(Document document, Resource resource) {

        Document d = documentRepository.getOne(document.getId());

        d.setTotalPages(100);

        documentRepository.saveAndFlush(d);

        System.out.println(d);

    }
}

package cn.lmtoo.demo.springcontent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Optional;

@Component
public class RenditionDocumentPostProcessor implements DocumentPostProcessor {

    @Autowired
    private DocumentRepository documentRepository;

    @Override
    @Transactional
    public void postProcessAfterSetContent(Document document, Resource resource) {
        Optional<Document> rendition = documentRepository.findByAncestorIdAndSourceAndMimeType(document.getId(), "rendition", MediaType.APPLICATION_PDF_VALUE);
        if (rendition.isPresent()) {
            return;
        }
        Document source = documentRepository.findById(document.getId()).orElseThrow(EntityNotFoundException::new);
        Document original = documentRepository.lock(source);
        try {
            Document newCopy = documentRepository.workingCopy(original);
            newCopy.setSource("rendition");
            newCopy.setMimeType(MediaType.APPLICATION_PDF_VALUE);
            newCopy.setContentId(null);
            documentRepository.unlock(newCopy);
        } finally {
            documentRepository.unlock(original);
        }
    }
}

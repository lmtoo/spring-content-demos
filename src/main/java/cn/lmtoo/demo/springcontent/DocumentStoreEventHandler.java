package cn.lmtoo.demo.springcontent;


import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.content.commons.annotations.HandleAfterSetContent;
import org.springframework.content.commons.annotations.StoreEventHandler;
import org.springframework.content.commons.repository.events.AfterSetContentEvent;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@StoreEventHandler
public class DocumentStoreEventHandler {

    @Autowired
    private DocumentContentStore contentStore;

    @Autowired
    private ObjectProvider<DocumentPostProcessor> documentPostProcessors;

    @HandleAfterSetContent
    public void afterSetContent(AfterSetContentEvent event) {
        TestingAuthenticationToken token = new TestingAuthenticationToken("user",null);
        token.setAuthenticated(true);
        SecurityContextHolder.getContext().setAuthentication(token);
        if (event.getSource() != null && event.getSource() instanceof Document) {
            Document document =(Document) event.getSource();
            documentPostProcessors.orderedStream().forEach(it-> it.postProcessAfterSetContent(document,contentStore.getResource(document)));
        }



    }
}

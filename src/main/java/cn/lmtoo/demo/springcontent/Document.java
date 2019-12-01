package cn.lmtoo.demo.springcontent;

import org.springframework.content.commons.annotations.ContentId;
import org.springframework.content.commons.annotations.ContentLength;
import org.springframework.content.commons.annotations.MimeType;
import org.springframework.content.commons.annotations.OriginalFileName;
import org.springframework.versions.*;

import javax.persistence.*;

@Entity
@Table(name = "documents")
public class Document {

    @Id
    @GeneratedValue
    private Long id;

    private String source;

    private String sourceId;

    @MimeType
    private String mimeType;


    @OriginalFileName
    private String originalFilename;

    @ContentId
    private String contentId;

    @ContentLength
    private long size;

    @Version
    private Long version;

    @LockOwner
    private String lockOwner;

    @VersionNumber
    private String versionNumber;

    @VersionLabel
    private String versionLabel;

    @AncestorRootId
    private String ancestralRootId;

    @AncestorId
    private String ancestorId;

    @SuccessorId
    private String successorId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOriginalFilename() {
        return originalFilename;
    }

    public void setOriginalFilename(String originalFilename) {
        this.originalFilename = originalFilename;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getLockOwner() {
        return lockOwner;
    }

    public void setLockOwner(String lockOwner) {
        this.lockOwner = lockOwner;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(String versionNumber) {
        this.versionNumber = versionNumber;
    }

    public String getVersionLabel() {
        return versionLabel;
    }

    public void setVersionLabel(String versionLabel) {
        this.versionLabel = versionLabel;
    }

    public String getAncestralRootId() {
        return ancestralRootId;
    }

    public void setAncestralRootId(String ancestralRootId) {
        this.ancestralRootId = ancestralRootId;
    }

    public String getAncestorId() {
        return ancestorId;
    }

    public void setAncestorId(String ancestorId) {
        this.ancestorId = ancestorId;
    }

    public String getSuccessorId() {
        return successorId;
    }

    public void setSuccessorId(String successorId) {
        this.successorId = successorId;
    }
}

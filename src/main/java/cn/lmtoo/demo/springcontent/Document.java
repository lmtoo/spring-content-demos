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

    public Document() {
    }

    public Document(Document original) {
        this.source = original.source;
        this.sourceId = original.sourceId;
        this.mimeType = original.mimeType;
        this.originalFilename = original.originalFilename;
        this.contentId = original.contentId;
        this.size = original.size;
        this.totalPages = original.totalPages;
    }

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

    private long totalPages;

    @Version
    private Long version;

    @LockOwner
    private String lockOwner;

    @VersionNumber
    private String versionNumber;

    @VersionLabel
    private String versionLabel;

    @AncestorRootId
    private Long ancestralRootId;

    @AncestorId
    private Long ancestorId;

    @SuccessorId
    private Long successorId;

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

    public long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(long totalPages) {
        this.totalPages = totalPages;
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

    public Long getAncestralRootId() {
        return ancestralRootId;
    }

    public void setAncestralRootId(Long ancestralRootId) {
        this.ancestralRootId = ancestralRootId;
    }

    public Long getAncestorId() {
        return ancestorId;
    }

    public void setAncestorId(Long ancestorId) {
        this.ancestorId = ancestorId;
    }

    public Long getSuccessorId() {
        return successorId;
    }

    public void setSuccessorId(Long successorId) {
        this.successorId = successorId;
    }
}

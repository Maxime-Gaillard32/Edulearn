package ch.heg.ig.sda.business;

import java.time.LocalDateTime;

public class Document {
    private int id;
    private String path;
    private LocalDateTime uploadDate;
    private DocumentType type;
    private DocumentExtension extension;
    private Student owner;

    public Document(int id, String path, LocalDateTime uploadDate, DocumentType documentType, DocumentExtension extension, Student owner) {
        this.setId(id);
        this.setPath(path);
        this.setUploadDate(uploadDate);
        this.setType(documentType);
        this.setExtension(extension);
        this.setOwner(owner);
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getPath() {
        return path;
    }

    /**
     *
     * @param path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     *
     * @return
     */
    public LocalDateTime getUploadDate() {
        return uploadDate;
    }

    /**
     *
     * @param uploadDate
     */
    public void setUploadDate(LocalDateTime uploadDate) {
        this.uploadDate = uploadDate;
    }

    /**
     *
     * @return
     */
    public DocumentType getType() {
        return type;
    }

    /**
     *
     * @param type
     */
    public void setType(DocumentType type) {
        this.type = type;
    }

    /**
     *
     * @return
     */
    public Student getOwner() {
        return owner;
    }

    /**
     *
     * @param owner
     */
    public void setOwner(Student owner) {
        this.owner = owner;
    }

    public DocumentExtension getExtension() {
        return extension;
    }

    public void setExtension(DocumentExtension extension) {
        this.extension = extension;
    }
}

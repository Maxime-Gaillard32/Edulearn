package ch.heg.ig.sda.business;

import java.time.LocalDateTime;

/**
 * Class Document, represent a document.
 */
public class Document {
    private int id;
    private String path;
    private LocalDateTime uploadDate;
    private DocumentType type;
    private DocumentExtension extension;
    private Student owner;

    /**
     * Document constructor.
     * @param id The document Id.
     * @param path The document path.
     * @param uploadDate The document upload date.
     * @param documentType The document type.
     * @param extension The document extension.
     * @param owner The document owner.
     */
    public Document(int id, String path, LocalDateTime uploadDate, DocumentType documentType, DocumentExtension extension, Student owner) {
        this.setId(id);
        this.setPath(path);
        this.setUploadDate(uploadDate);
        this.setType(documentType);
        this.setExtension(extension);
        this.setOwner(owner);
    }

    /**
     * Get the document Id.
     * @return document Id.
     */
    public int getId() {
        return id;
    }

    /**
     * Set the document Id.
     * @param id Id to set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the document path.
     * @return The document path.
     */
    public String getPath() {
        return path;
    }

    /**
     * Set the document path.
     * @param path Path to set.
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Get the document upload date.
     * @return The document upload date.
     */
    public LocalDateTime getUploadDate() {
        return uploadDate;
    }

    /**
     * Set the document upload date.
     * @param uploadDate The upload date.
     */
    public void setUploadDate(LocalDateTime uploadDate) {
        this.uploadDate = uploadDate;
    }

    /**
     * Get the document type.
     * @return The document type.
     */
    public DocumentType getType() {
        return type;
    }

    /**
     * Set the document type.
     * @param type The document type.
     */
    public void setType(DocumentType type) {
        this.type = type;
    }

    /**
     * Get the document owner.
     * @return The document owner.
     */
    public Student getOwner() {
        return owner;
    }

    /**
     * Set the document owner.
     * @param owner The document owner.
     */
    public void setOwner(Student owner) {
        this.owner = owner;
    }

    /**
     * Get the document extension.
     * @return The document extension.
     */
    public DocumentExtension getExtension() {
        return extension;
    }

    /**
     * Set the document extension.
     * @param extension The document extension.
     */
    public void setExtension(DocumentExtension extension) {
        this.extension = extension;
    }
}

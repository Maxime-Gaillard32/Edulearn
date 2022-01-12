package ch.heg.ig.sda.business;

/**
 * Document type enum.
 */
public enum DocumentType {
    SUMMARY("Summary"),
    SUPPORT("Support"),
    EXERCICE("Exercice");

    private final String label;

    /**
     * Document type constructor.
     * @param label The document type.
     */
    DocumentType(String label) {
        this.label = label;
    }

    /**
     * Get the document label.
     * @return The document label.
     */
    public String getLabel() {
        return label;
    }
}

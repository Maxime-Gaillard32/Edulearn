package ch.heg.ig.sda.business;

/**
 * Document extension enum.
 */
public enum  DocumentExtension {
    AUDIO("Audio"),
    TEXT("Text");

    private final String label;

    /**
     * Document extension constructor.
     * @param label the document extension label
     */
    DocumentExtension(String label) {
        this.label = label;
    }

    /**
     * Get the document extension label.
     * @return The document extension label.
     */
    public String getLabel() {
        return label;
    }
}

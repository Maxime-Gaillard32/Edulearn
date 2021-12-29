package ch.heg.ig.sda.business;

public enum  DocumentExtension {
    AUDIO("Audio"),
    TEXT("Text");

    private final String label;

    /**
     *
     * @param label
     */
    DocumentExtension(String label) {
        this.label = label;
    }

    /**
     *
     * @return
     */
    public String getLabel() {
        return label;
    }
}

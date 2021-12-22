package ch.heg.ig.sda.business;

public enum DocumentType {
    SUMMARY("Summary"),
    SUPPORT("Support"),
    EXERCICE("Exercice");

    private final String label;

    /**
     *
     * @param label
     */
    DocumentType(String label) {
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

package ch.heg.ig.sda.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *  Class Lesson, represent a lesson.
 */
public class Lesson {
    private int id;
    private String name;
    private String description;
    private long price;
    private List<Student> participants;
    private Student owner;
    private Student teacher;
    private List<Document> documents;

    /**
     * Lesson constructor, construct a new lesson.
     * @param id Id of the lesson.
     * @param name Name of the lesson.
     * @param description Description of the lesson.
     * @param price Price of to paid for the lesson.
     * @param owner Owner of the lesson.
     * @param teacher Teacher of the lesson.
     */
    public Lesson(int id, String name, String description, long price, Student owner, Student teacher) {
        this.setId(id);
        this.setName(name);
        this.setDescription(description);
        this.setPrice(price);
        this.setOwner(owner);
        this.setTeacher(teacher);
        participants = new ArrayList<>();
        documents = new ArrayList<>();
    }

    /**
     * Add a new participant in the list of participants.
     * @param participant The new participant to add in the list.
     * @return True if the participant is added else False.
     */
    public Boolean addParticipant(Student participant) {
        return this.getParticipants().add(participant);
    }

    /**
     * Remove a participant from the list of participants using the registration number.
     * @param registrationNumber The registration number of the student to remove from the list.
     * @return True if the participant is removed else False.
     */
    private Boolean removeParticipant(String registrationNumber) {
        return this.getParticipants().remove(this.getParticipant(registrationNumber));
    }

    /**
     * Remove a participant from the list of participants using the Id.
     * @param id The Id of the student to remove from the list.
     * @return True if the participant is removed else False.
     */
    private Boolean removeParticipant(int id) {
        return this.getParticipants().remove(this.getParticipant(id));
    }

    /**
     * Remove a participant from the list of participants using the student.
     * @param student The student to remove from the list.
     * @return True if the participant is removed else False.
     */
    private Boolean removeParticipant(Student student) {
        return this.removeParticipant(student.getRegistrationNumber());
    }

    /**
     * Get a participant from the list of participants using the student Id.
     * @param id The student Id to search.
     * @return The student object.
     */
    private Student getParticipant(int id) {
        for (Student currentStudent : this.getParticipants()) {
            if(currentStudent.getId() == id) return currentStudent;
        }

        return null;
    }

    /**
     * Get the registration number of a participant.
     * @param registrationNumber The registration number to search.
     * @return The student if it exists else false.
     */
    private Student getParticipant(String registrationNumber) {
        for (Student currentStudent : this.getParticipants()) {
            if(currentStudent.getRegistrationNumber().equals(registrationNumber)) {
                return currentStudent;
            }
        }

        return null;
    }

    /**
     * Add a document to the lesson.
     * @param document The document to add.
     * @return True if the document is added else False.
     */
    private Boolean addDocument(Document document) {
        return this.getDocuments().add(document);
    }

    /**
     * Remove a document from the document list.
     * @param document The document to delete.
     * @return True if the document is removed else False.
     */
    private Boolean removeDocument(Document document) {
        return this.getDocuments().remove(document);
    }

    /**
     * Remove a document from the document list using an Id.
     * @param id The Id of the document to remove.
     * @return True if the document is removed.
     */
    private Boolean removeDocument(int id) {
        return this.removeDocument(this.getDocument(id));
    }

    /**
     * Get a document from the document list.
     * @param document The document to get.
     * @return The document object if it exists else null.
     */
    private Document getDocument(Document document) {
        ArrayList<Document> documents = (ArrayList<Document>) this.getDocuments();

        for (Document currentDocument : documents) {
            if (currentDocument.equals(document))
                return currentDocument;
        }

        return null;
    }

    /**
     * Get a document from the list by an index.
     * @param index The document index.
     * @return The document object if it exists else Null.
     */
    private Document getDocument(int index) {
        return this.getDocuments().get(index);
    }

    /**
     * Get the lesson Id.
     * @return The lesson Id.
     */
    public int getId() {
        return id;
    }

    /**
     * Set the lesson Id.
     * @param id The document Id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the lesson name.
     * @return The lesson name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the lesson name.
     * @param name The lesson name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the lesson description.
     * @return The lesson description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the lesson description.
     * @param description The lesson description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the lesson price.
     * @return The lesson price.
     */
    public long getPrice() {
        return price;
    }

    /**
     * Set the lesson price.
     * @param price The lesson price.
     */
    public void setPrice(long price) {
        this.price = price;
    }

    /**
     * Get the participants of the lesson.
     * @return HashMap of participants.
     */
    public List<Student> getParticipants() {
        return participants;
    }

    /**
     * Get lesson owner.
     * @return The lesson owner.
     */
    public Student getOwner() {
        return owner;
    }

    /**
     * Set the lesson owner.
     * @param owner The lesson owner.
     */
    public void setOwner(Student owner) {
        this.owner = owner;
    }

    /**
     * Get the lesson teacher.
     * @return The lesson teacher.
     */
    public Student getTeacher() {
        return teacher;
    }

    /**
     * Set the lesson teacher.
     * @param teacher The lesson teacher.
     */
    public void setTeacher(Student teacher) {
        this.teacher = teacher;
    }

    /**
     * Get the lesson documents.
     * @return List of documents.
     */
    public List<Document> getDocuments() {
        return documents;
    }
}

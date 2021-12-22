package ch.heg.ig.sda.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class Lesson {
    private int id;
    private String name;
    private String description;
    private long price;
    private HashMap<String, Student> participants;
    private Student owner;
    private Student teacher;
    private List<Document> documents;

    /**
     *
     * @param id
     * @param name
     * @param description
     * @param price
     * @param owner
     * @param teacher
     */
    public Lesson(int id, String name, String description, long price, Student owner, Student teacher) {
        this.setId(id);
        this.setName(name);
        this.setDescription(description);
        this.setPrice(price);
        this.setOwner(owner);
        this.setTeacher(teacher);
        participants = new HashMap<>();
        documents = new ArrayList<>();
    }

    /**
     *
     * @param participant
     * @return
     */
    public Boolean addParticipant(Student participant) {
        return this.getParticipants().put(participant.getRegistrationNumber(), participant) != null;
    }

    /**
     *
     * @param registrationNumber
     * @return
     */
    private Boolean removeParticipant(String registrationNumber) {
        return this.getParticipants().remove(registrationNumber) != null;
    }

    /**
     *
     * @param student
     * @return
     */
    private Boolean removeParticipant(Student student) {
        return this.removeParticipant(student.getRegistrationNumber());
    }

    /**
     *
     * @param id
     * @return
     */
    private Student getParticipantById(int id) {
        for(Map.Entry<String, Student> participant : this.getParticipants().entrySet()) {
            Student student = participant.getValue();
            if(student.getId() == id)
                return student;
        }

        return null;
    }

    /**
     *
     * @param registrationNumber
     * @return
     */
    private Student getParticipantByRegiNum(String registrationNumber) {
        return this.getParticipants().get(registrationNumber);
    }

    /**
     *
     * @param document
     * @return
     */
    private Boolean addDocument(Document document) {
        return this.getDocuments().add(document);
    }

    /**
     *
     * @param document
     * @return
     */
    private Boolean removeDocument(Document document) {
        return this.getDocuments().remove(document);
    }

    /**
     *
     * @param id
     * @return
     */
    private Boolean removeDocument(int id) {
        return this.removeDocument(this.getDocumentById(id));
    }

    /**
     *
     * @param document
     * @return
     */
    private Document getDocument(Document document) {
        ArrayList<Document> documents = (ArrayList<Document>) this.getDocuments();

        for (Document currentDocument : documents) {
            if (currentDocument.equals(document))
                return currentDocument;
        }

        return null;
    }


    private Document getDocument(int index) {
        return this.getDocuments().get(index);
    }

    /**
     *
     * @param id
     * @return
     */
    private Document getDocumentById(int id) {
        ArrayList<Document> documents = (ArrayList<Document>) this.getDocuments();

        for (Document currentDocument : documents) {
            if (currentDocument.getId() == id)
                return currentDocument;
        }

        return null;
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
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     */
    public long getPrice() {
        return price;
    }

    /**
     *
     * @param price
     */
    public void setPrice(long price) {
        this.price = price;
    }

    /**
     *
     * @return
     */
    public HashMap<String, Student> getParticipants() {
        return participants;
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

    /**
     *
     * @return
     */
    public Student getTeacher() {
        return teacher;
    }

    /**
     *
     * @param teacher
     */
    public void setTeacher(Student teacher) {
        this.teacher = teacher;
    }

    /**
     *
     * @return
     */
    public List<Document> getDocuments() {
        return documents;
    }
}
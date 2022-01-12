package ch.heg.ig.sda.io;

import ch.heg.ig.sda.business.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Abstract Edulearn class.
 */
public abstract class AbstractEdulearn implements IEdulearn {
    private List<Student> studentList;
    private List<Document> documentList;
    private List<Lesson> lessonList;

    /**
     * Load student in list from data source.
     */
    public abstract void loadStudents();

    /**
     * Load documents in list from data source.
     */
    public abstract void loadDocuments();

    /**
     * Load lessons in list from data source.
     */
    public abstract void loadLessons();

    /**
     * Get all lessons from list.
     * @return The lesson list.
     */
    public List<Lesson> getAllLessons() {
        return this.getLessonList();
    }

    /**
     * Get the lesson by Id.
     * @param id The lesson Id.
     * @return The lesson if it exists else Null.
     */
    @Override
    public Lesson getLessonById(int id) {
        for (Lesson currentLesson : this.getLessonList()) {
            if(currentLesson.getId() == id)
                return currentLesson;
        }

        return null;
    }

    /**
     * Get lesson followed list of a student.
     * @param student The student on which get followed lessons.
     * @return The followed lesson list.
     */
    @Override
    public List<Lesson> getLessonsFollowed(Student student) {
        return student.getLessonsFollowed();
    }

    /**
     * Get participants list of a lesson.
     * @param lesson The lesson on which get participants.
     * @return The participant list.
     */
    @Override
    public Map<String, Student> getParticipants(Lesson lesson) {
        return lesson.getParticipants();
    }

    /**
     * Get the owner of the lesson.
     * @param lesson The lesson on which get the owner.
     * @return The lesson owner.
     */
    @Override
    public Student getOwner(Lesson lesson) {
        return lesson.getOwner();
    }

    /**
     * Get the teacher of the lesson.
     * @param lesson The lesson on which get the teacher.
     * @return The lesson teacher.
     */
    @Override
    public Student getTeacher(Lesson lesson) {
        return lesson.getTeacher();
    }

    /**
     * Get all student from list.
     * @return The student list.
     */
    @Override
    public List<Student> getAllStudent() {
        return this.getStudentList();
    }

    /**
     * Get a student by Id in list.
     * @param id The student Id.
     * @return The student if it exists else Null.
     */
    @Override
    public Student getStudentById(int id) {
        for (Student student : this.getStudentList()) {
            if(student.getId() == id)
                return student;
        }

        return null;
    }

    /**
     * Get a student by registration number in list.
     * @param registrationNumber The student Id.
     * @return The student if it exists else Null.
     */
    @Override
    public Student getStudentByRegiNumber(String registrationNumber) {
        for (Student student : this.getStudentList()) {
            if(student.getRegistrationNumber().equals(registrationNumber))
                return student;
        }

        return null;
    }

    /**
     * Get the document list of a lesson.
     * @param lesson The lesson on which get the documents.
     * @return The document list.
     */
    @Override
    public List<Document> getLessonsDocuments(Lesson lesson) {
        return lesson.getDocuments();
    }

    /**
     * Get the document list of a student.
     * @param student The student on which get the documents.
     * @return The document list.
     */
    @Override
    public List<Document> getStudentDocuments(Student student) {
        ArrayList<Document> documents = new ArrayList<>();
        for (Document currentDocument : this.getDocumentList()) {
            if(currentDocument.getOwner().equals(student))
                documents.add(currentDocument);
        }

        return documents;
    }

    /**
     * Get the document extension of a document.
     * @param document The document on which get the extension.
     * @return The document extension.
     */
    @Override
    public DocumentExtension getDocumentExtension(Document document) {
        return document.getExtension();
    }

    /**
     * Get the document type.
     * @param document The document on which get the type.
     * @return The document type.
     */
    @Override
    public DocumentType getDocumentType(Document document) {
        return document.getType();
    }

    /**
     * Get all students.
     * @return The student list.
     */
    private List<Student> getStudentList() {
        return studentList;
    }

    /**
     * Set the student list.
     * @param studentList The list to set.
     */
    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    /**
     * Get all documents.
     * @return The document list.
     */
    private List<Document> getDocumentList() {
        return documentList;
    }

    /**
     * ¨Set the document list.
     * @param documentList The document list.
     */
    public void setDocumentList(List<Document> documentList) {
        this.documentList = documentList;
    }

    /**
     * Get all lessons.
     * @return The lesson list.
     */
    private List<Lesson> getLessonList() {
        return lessonList;
    }

    /**
     * Set the lesson list.
     * @param lessonList The lesson list.
     */
    public void setLessonList(List<Lesson> lessonList) {
        this.lessonList = lessonList;
    }

}

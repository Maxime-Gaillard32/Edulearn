package ch.heg.ig.sda.io;

import ch.heg.ig.sda.business.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract  class AbstractEdulearn implements Edulearn {
    private List<Student> studentList;
    private List<Document> documentList;
    private List<Lesson> lessonList;

    public abstract void initializeStudentList();
    public abstract void initializeDocumentList();
    public abstract void initializeLessonList();

    public List<Lesson> getAllLessons() {
        return this.getLessonList();
    }

    @Override
    public Lesson getLessonById(int id) {
        for (Lesson currentLesson : this.getLessonList()) {
            if(currentLesson.getId() == id)
                return currentLesson;
        }

        return null;
    }

    @Override
    public List<Lesson> getLessonsFollowed(Student student) {
        return student.getLessonsFollowed();
    }

    @Override
    public Map<String, Student> getParticipants(Lesson lesson) {
        return lesson.getParticipants();
    }

    @Override
    public Student getOwner(Lesson lesson) {
        return lesson.getOwner();
    }

    @Override
    public Student getTeacher(Lesson lesson) {
        return lesson.getTeacher();
    }

    @Override
    public List<Student> getAllStudent() {
        return this.getStudentList();
    }

    @Override
    public Student getStudentById(int id) {
        for (Student student : this.getStudentList()) {
            if(student.getId() == id)
                return student;
        }

        return null;
    }

    @Override
    public Student getStudentByRegiNumber(String registrationNumber) {
        for (Student student : this.getStudentList()) {
            if(student.getRegistrationNumber().equals(registrationNumber))
                return student;
        }

        return null;
    }

    @Override
    public List<Document> getLessonsDocuments(Lesson lesson) {
        return lesson.getDocuments();
    }

    @Override
    public List<Document> getStudentDocuments(Student student) {
        ArrayList<Document> documents = new ArrayList<>();
        for (Document currentDocument : this.getDocumentList()) {
            if(currentDocument.getOwner().equals(student))
                documents.add(currentDocument);
        }

        return documents;
    }

    @Override
    public DocumentExtension getDocumentExtension(Document document) {
        return document.getExtension();
    }

    @Override
    public DocumentType getDocumentType(Document document) {
        return document.getType();
    }

    private List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    private List<Document> getDocumentList() {
        return documentList;
    }

    public void setDocumentList(List<Document> documentList) {
        this.documentList = documentList;
    }

    private List<Lesson> getLessonList() {
        return lessonList;
    }

    public void setLessonList(List<Lesson> lessonList) {
        this.lessonList = lessonList;
    }
}

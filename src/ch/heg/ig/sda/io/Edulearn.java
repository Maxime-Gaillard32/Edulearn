package ch.heg.ig.sda.io;

import ch.heg.ig.sda.business.*;
import java.util.List;
import java.util.Map;


public interface Edulearn {
    List<Lesson> getAllLessons();
    Lesson getLessonById(int id);
    List<Lesson> getLessonsFollowed(Student student);
    Map<String, Student> getParticipants(Lesson lesson);
    Student getOwner(Lesson lesson);
    Student getTeacher(Lesson lesson);
    List<Student> getAllStudent();
    Student getStudentById(int id);
    Student getStudentByRegiNumber(String registrationNumber);
    List<Document> getLessonsDocuments(Lesson lesson);
    List<Document> getStudentDocuments(Student student);
    DocumentExtension getDocumentExtension(Document document);
    DocumentType getDocumentType(Document document);
}

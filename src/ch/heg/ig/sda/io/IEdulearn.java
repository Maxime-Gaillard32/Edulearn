package ch.heg.ig.sda.io;

import ch.heg.ig.sda.business.*;
import java.util.List;
import java.util.Map;


public interface IEdulearn {
    void loadLessons();
    void loadStudents();
    Boolean addNewLesson(Lesson lesson);
    Boolean removeLesson(Lesson lesson);
    Lesson getLessonByName(String name);
    List<Document> getLessonsDocuments(Lesson lesson);
    Boolean addStudent(Student student);
    Boolean removeStudent(Student student);
    Student getStudentByRegiNumber(String registrationNumber);
    List<Lesson> getLessonsFollowed(Student student);
    List<Lesson> getAllOwnLessons(Student student);
    List<Student> getParticipants(Lesson lesson);
    List<Document> getStudentDocuments(Student student);
}

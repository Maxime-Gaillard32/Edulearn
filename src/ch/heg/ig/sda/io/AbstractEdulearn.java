package ch.heg.ig.sda.io;

import ch.heg.ig.sda.business.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Abstract Edulearn class.
 */
public abstract class AbstractEdulearn implements IEdulearn {
    private Map<String, Student> studentList = new HashMap<>();
    private Map<String, Lesson> lessonList = new HashMap<>();

    /**
     * Load student in list from data source.
     */
    public abstract void loadStudents();

    /**
     * Load lessons in list from data source.
     */
    public abstract void loadLessons();

    /**
     * Add a new lesson to the lessons list.
     * @param lesson The lesson to add.
     * @return True if it's added else False.
     */
    @Override
    public Boolean addNewLesson(Lesson lesson) {
        return this.getLessonList().putIfAbsent(lesson.getName(), lesson) != null;
    }

    /**
     * Remove a lesson from the list.
     * @return True if it's removed else False.
     */
    @Override
    public Boolean removeLesson(Lesson lesson) {
        return this.getLessonList().remove(lesson.getName()) != null;
    }

    /**
     * Get lesson by name in lessons list.
     * @param name The name of the lesson.
     * @return The lesson if it exists else Null.
     */
    @Override
    public Lesson getLessonByName(String name) {
        return this.getLessonList().get(name);
    }

    /**
     * Add a new student to the students list.
     * @return True if it's added else False.
     */
    @Override
    public Boolean addStudent(Student student) {
        return this.getStudentList().putIfAbsent(student.getRegistrationNumber(), student) != null;
    }

    /**
     * Remove a student from the students list.
     * @return True if it's removed else False.
     */
    @Override
    public Boolean removeStudent(Student student) {
        return this.getStudentList().remove(student.getRegistrationNumber()) != null;
    }

    /**
     * Get all lessons owned by student.
     * @param student The student.
     * @return A list of the student lessons.
     */
    @Override
    public List<Lesson> getAllOwnLessons(Student student) {
        ArrayList<Lesson> lessons = new ArrayList<>();
        for (var entry : this.getLessonList().entrySet()) {
            Lesson currentLesson = entry.getValue();
            if(currentLesson.getOwner().equals(student)) {
                lessons.add(currentLesson);
            }
        }
        return lessons;
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
    public List<Student> getParticipants(Lesson lesson) {
        return lesson.getParticipants();
    }

    /**
     * Get a student by registration number in list.
     * @param registrationNumber The student Id.
     * @return The student if it exists else Null.
     */
    @Override
    public Student getStudentByRegiNumber(String registrationNumber) {
        return this.getStudentList().get(registrationNumber);
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
        return student.getDocuments();
    }

    /**
     * Get all students.
     * @return The student list.
     */
    private Map<String, Student> getStudentList() {
        return studentList;
    }

    /**
     * Set the student list.
     * @param studentList The list to set.
     */
    public void setStudentList(Map<String, Student> studentList) {
        this.studentList = studentList;
    }

    /**
     * Get all lessons.
     * @return The lesson list.
     */
    private Map<String, Lesson> getLessonList() {
        return lessonList;
    }

    /**
     * Set the lesson list.
     * @param lessonList The lesson list.
     */
    public void setLessonList(Map<String, Lesson> lessonList) {
        this.lessonList = lessonList;
    }

    /**
     * Get all student from list.
     * @return The student list.
     */
    public Map<String, Student> getAllStudent() {
        return this.getStudentList();
    }

}

package ch.heg.ig.sda.business;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Student {
    private int id;
    private String lastname;
    private String firstname;
    private String email;
    private String registrationNumber;
    private List<Lesson> lessonsFollowed;

    /**
     *
     * @param id
     * @param lastname
     * @param firstname
     * @param email
     * @param registrationNumber
     */
    public Student(int id, String lastname, String firstname, String email, String registrationNumber) {
        this.setId(id);
        this.setLastname(lastname);
        this.setFirstname(firstname);
        this.setEmail(email);
        this.setRegistrationNumber(registrationNumber);
    }

    /**
     *
     * @param lesson
     * @return
     */
    private Boolean addLesson(Lesson lesson) {
        return this.getLessonsFollowed().add(lesson);
    }

    /**
     *
     * @param lesson
     * @return
     */
    private Boolean removeLesson(Lesson lesson) {
        return this.getLessonsFollowed().remove(lesson);
    }

    /**
     *
     * @param lesson
     * @return
     */
    private Boolean isFollowingLesson(Lesson lesson) {
        return this.getLessonsFollowed().contains(lesson);
    }

    /**
     *
     * @param index
     * @return
     */
    private Lesson getLesson(int index) {
        return this.getLessonsFollowed().get(index);
    }

    /**
     *
     * @param lesson
     * @return
     */
    private Lesson getLesson(Lesson lesson) {
        ArrayList<Lesson> lessons = (ArrayList<Lesson>) this.getLessonsFollowed();

        for (Lesson currentLesson : lessons) {
            if(currentLesson.equals(lesson))
                return currentLesson;
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
    public String getLastname() {
        return lastname;
    }

    /**
     *
     * @param lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     *
     * @return
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     *
     * @param firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    /**
     *
     * @param registrationNumber
     */
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    /**
     *
     * @return
     */
    public List<Lesson> getLessonsFollowed() {
        return lessonsFollowed;
    }
}

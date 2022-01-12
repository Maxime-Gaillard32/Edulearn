package ch.heg.ig.sda.business;

import java.util.ArrayList;
import java.util.List;
import com.opencsv.bean.CsvBindByName;

/**
 * Class Student, represent a student.
 */
public class Student {
    @CsvBindByName(column = "id")
    private int id;
    @CsvBindByName(column = "lastname")
    private String lastname;
    @CsvBindByName(column = "firstname")
    private String firstname;
    @CsvBindByName(column = "email")
    private String email;
    @CsvBindByName(column = "registrationnumber")
    private String registrationNumber;
    private List<Lesson> lessonsFollowed;

    /**
     * Student constructor, construct a new student.
     * @param id The student Id.
     * @param lastname The student lastname.
     * @param firstname The student firstname.
     * @param email The student email.
     * @param registrationNumber The student registration number.
     */
    public Student(int id, String lastname, String firstname, String email, String registrationNumber) {
        this.setId(id);
        this.setLastname(lastname);
        this.setFirstname(firstname);
        this.setEmail(email);
        this.setRegistrationNumber(registrationNumber);
    }

    /**
     * Add a lesson to the followed lesson of the student.
     * @param lesson The lesson to add in followed list.
     * @return True if the lesson is added else False.
     */
    private Boolean addLesson(Lesson lesson) {
        return this.getLessonsFollowed().add(lesson);
    }

    /**
     * Remove a lesson from the followed lesson list.
     * @param lesson The lesson to remove.
     * @return True if the lesson is removed else False.
     */
    private Boolean removeLesson(Lesson lesson) {
        return this.getLessonsFollowed().remove(lesson);
    }

    /**
     * Check if a lesson is already in the followed lesson list.
     * @param lesson The lesson to check.
     * @return True if the lesson is followed else False.
     */
    private Boolean isFollowingLesson(Lesson lesson) {
        return this.getLessonsFollowed().contains(lesson);
    }

    /**
     * Get a lesson from followed lesson list by index.
     * @param index The lesson index to search.
     * @return The lesson if it's followed else Null.
     */
    private Lesson getLesson(int index) {
        return this.getLessonsFollowed().get(index);
    }

    /**
     * Get a lesson from followed lesson list.
     * @param lesson The lesson to search.
     * @return The lesson if it's followed else Null.
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
     * Get the student Id.
     * @return The student Id.
     */
    public int getId() {
        return id;
    }

    /**
     * Set the student Id.
     * @param id The student Id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the student lastname.
     * @return The student lastname.
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Set the student last name.
     * @param lastname The student lastname.
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Get the student firstname.
     * @return The student firstname.
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Set the student firstname.
     * @param firstname The student firstname.
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Get the student email.
     * @return The student email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the student email.
     * @param email The student email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the student registration number.
     * @return The student registration number.
     */
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    /**
     * Set the student registration number.
     * @param registrationNumber The student registration number.
     */
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    /**
     * Get the student lessons followed list.
     * @return The followed lesson, can be empty if no lesson is followed.
     */
    public List<Lesson> getLessonsFollowed() {
        return lessonsFollowed;
    }
}

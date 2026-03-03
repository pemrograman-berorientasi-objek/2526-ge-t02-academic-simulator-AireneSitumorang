package academic.model;

/**
 * @author 12S24058 Airene Situmorang
 */

public class Course {

    private String code;
    private String name;
    private int credits;
    private char grade; // gunakan char untuk grade

    // Constructor
    public Course(String code, String name, int credits, char grade) {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.grade = grade;
    }

    // Getter
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public char getGrade() {
        return grade;
    }

    // Setter (optional, kalau dibutuhkan)
    public void setGrade(char grade) {
        this.grade = grade;
    }

    // Format output
    @Override
    public String toString() {
        return code + "|" + name + "|" + credits + "|" + grade;
    }
}
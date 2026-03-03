package academic.model;

/**
 * @author 12S24058 Airene Situmorang
 */

public class Course {
    private String code;
    private String name;
    private int sks;
    private String grade; // Ini mungkin grade default atau placeholder jika belum ada

    public Course(String code, String name, int sks, String grade) {
        this.code = code;
        this.name = name;
        this.sks = sks;
        this.grade = grade;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getSks() {
        return sks;
    }

    public String getGrade() {
        return grade;
    }

    // Metode toString ini berguna untuk memudahkan debugging atau format output
    // meskipun kita memformat output secara manual di driver
    @Override
    public String toString() {
        return code + "|" + name + "|" + sks + "|" + grade;
    }
}

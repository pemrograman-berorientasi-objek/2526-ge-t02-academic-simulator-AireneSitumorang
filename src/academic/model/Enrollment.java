package academic.model;

/**
 * @author 12S24058 Airene Situmorang
 * @author 12S24058 Airene Situmorang
 */

public class Enrollment {
    private String courseCode;
    private String studentNim;
    private String academicYear; // Contoh: 2021/2022
    private String semester;     // Contoh: even, odd, short
    private String grade;        // Defaultnya 'None'

    // Konstruktor utama saat pendaftaran dibuat tanpa grade awal
    public Enrollment(String courseCode, String studentNim, String academicYear, String semester) {
        this.courseCode = courseCode;
        this.studentNim = studentNim;
        this.academicYear = academicYear;
        this.semester = semester;
        this.grade = "None"; // Grade defaultnya 'None' saat pendaftaran baru
    }

    // Overload konstruktor untuk kasus jika grade sudah ada saat objek dibuat (opsional)
    public Enrollment(String courseCode, String studentNim, String academicYear, String semester, String grade) {
        this.courseCode = courseCode;
        this.studentNim = studentNim;
        this.academicYear = academicYear;
        this.semester = semester;
        this.grade = grade;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getStudentNim() {
        return studentNim;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public String getSemester() {
        return semester;
    }

    public String getGrade() {
        return grade;
    }

    // Metode setter untuk grade, karena grade bisa diubah atau diinput di kemudian hari
    public void setGrade(String grade) {
        this.grade = grade;
    }

    // Metode toString untuk representasi string dari objek Enrollment
    @Override
    public String toString() {
        return courseCode + "|" + studentNim + "|" + academicYear + "|" + semester + "|" + grade;
    }
}

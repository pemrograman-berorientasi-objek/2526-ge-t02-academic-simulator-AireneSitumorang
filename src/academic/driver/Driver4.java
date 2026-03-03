package academic.driver;

/**
 * @author 12S24058 Airene Situmorang
 * @author 12S24058 Airene Situmorang
 */


import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;
import java.util.Scanner;

public class Driver4 {
    // Array dan counter untuk Course
    private static final int MAX_COURSES = 100;
    private static Course[] courses = new Course[MAX_COURSES];
    private static int courseCount = 0;

    // Array dan counter untuk Student
    private static final int MAX_STUDENTS = 100;
    private static Student[] students = new Student[MAX_STUDENTS];
    private static int studentCount = 0;

    // Array dan counter untuk Enrollment
    private static final int MAX_ENROLLMENTS = 100;
    private static Enrollment[] enrollments = new Enrollment[MAX_ENROLLMENTS];
    private static int enrollmentCount = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line;

        System.out.println("Masukkan data (course-add#... / student-add#... / enrollment-add#...). Ketik --- untuk berhenti:");

        while (input.hasNextLine()) {
            line = input.nextLine();

            if (line.equals("---")) {
                break; // Berhenti jika user mengetik ---
            }

            // Memisahkan prefix dan data
            String[] rawParts = line.split("#", 2); // Split hanya pada '#' pertama
            if (rawParts.length < 2) {
                System.err.println("Peringatan: Format input tidak dikenal atau tidak lengkap: " + line);
                continue; // Lanjutkan ke baris berikutnya
            }

            String command = rawParts[0];
            String data = rawParts[1];

            switch (command) {
                case "course-add":
                    processCourseAdd(data);
                    break;
                case "student-add":
                    processStudentAdd(data);
                    break;
                case "enrollment-add":
                    processEnrollmentAdd(data);
                    break;
                default:
                    System.err.println("Peringatan: Perintah tidak dikenal: " + command + " di baris: " + line);
                    break;
            }
        }

        // Tampilkan semua data yang sudah disimpan secara berurutan
        System.out.println("\n--- Data Tersimpan ---");

        // Tampilkan Courses
        for (int i = 0; i < courseCount; i++) {
            System.out.println(courses[i].getCode() + "|" +
                               courses[i].getName() + "|" +
                               courses[i].getSks() + "|" +
                               courses[i].getGrade());
        }

        // Tampilkan Students
        for (int i = 0; i < studentCount; i++) {
            System.out.println(students[i].getNim() + "|" +
                               students[i].getName() + "|" +
                               students[i].getEntranceYear() + "|" +
                               students[i].getMajor());
        }

        // Tampilkan Enrollments
        for (int i = 0; i < enrollmentCount; i++) {
            System.out.println(enrollments[i].getCourseCode() + "|" +
                               enrollments[i].getStudentNim() + "|" +
                               enrollments[i].getAcademicYear() + "|" +
                               enrollments[i].getSemester() + "|" +
                               enrollments[i].getGrade());
        }

        input.close();
    }

    // Metode pembantu untuk memproses penambahan Course
    private static void processCourseAdd(String data) {
        String[] parts = data.split("#");
        if (parts.length == 4) {
            try {
                String code = parts[0];
                String name = parts[1];
                int sks = Integer.parseInt(parts[2]);
                String grade = parts[3];

                if (courseCount < MAX_COURSES) {
                    courses[courseCount] = new Course(code, name, sks, grade);
                    courseCount++;
                } else {
                    System.err.println("Peringatan: Array Course penuh, tidak dapat menambahkan: " + data);
                }
            } catch (NumberFormatException e) {
                System.err.println("Peringatan: Format SKS Course salah, input diabaikan: " + data);
            }
        } else {
            System.err.println("Peringatan: Format input Course salah (jumlah bagian tidak 4): " + data);
        }
    }

    // Metode pembantu untuk memproses penambahan Student
    private static void processStudentAdd(String data) {
        String[] parts = data.split("#");
        if (parts.length == 4) {
            try {
                String nim = parts[0];
                String name = parts[1];
                int entranceYear = Integer.parseInt(parts[2]);
                String major = parts[3];

                if (studentCount < MAX_STUDENTS) {
                    students[studentCount] = new Student(nim, name, entranceYear, major);
                    studentCount++;
                } else {
                    System.err.println("Peringatan: Array Student penuh, tidak dapat menambahkan: " + data);
                }
            } catch (NumberFormatException e) {
                System.err.println("Peringatan: Format Tahun Angkatan Student salah, input diabaikan: " + data);
            }
        } else {
            System.err.println("Peringatan: Format input Student salah (jumlah bagian tidak 4): " + data);
        }
    }

    // Metode pembantu untuk memproses penambahan Enrollment
    private static void processEnrollmentAdd(String data) {
        String[] parts = data.split("#");
        if (parts.length == 4) {
            String courseCode = parts[0];
            String studentNim = parts[1];
            String academicYear = parts[2];
            String semester = parts[3];

            if (enrollmentCount < MAX_ENROLLMENTS) {
                enrollments[enrollmentCount] = new Enrollment(courseCode, studentNim, academicYear, semester);
                enrollmentCount++;
            } else {
                System.err.println("Peringatan: Array Enrollment penuh, tidak dapat menambahkan: " + data);
            }
        } else {
            System.err.println("Peringatan: Format input Enrollment salah (jumlah bagian tidak 4): " + data);
        }
    }
}

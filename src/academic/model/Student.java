package academic.model;

public class Student {
    private String nim;
    private String name;
    private int entranceYear; // Tahun Angkatan
    private String major;     // Jurusan

    public Student(String nim, String name, int entranceYear, String major) {
        this.nim = nim;
        this.name = name;
        this.entranceYear = entranceYear;
        this.major = major;
    }

    public String getNim() {
        return nim;
    }

    public String getName() {
        return name;
    }

    public int getEntranceYear() {
        return entranceYear;
    }

    public String getMajor() {
        return major;
    }

    // Metode toString ini akan membantu dalam menampilkan data dengan format yang diinginkan
    @Override
    public String toString() {
        return nim + "|" + name + "|" + entranceYear + "|" + major;
    }
}

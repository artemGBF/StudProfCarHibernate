package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "professor")
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fio;
    private int age;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Driver driver;

    @ManyToMany(mappedBy = "professors",cascade = {CascadeType.PERSIST,
            CascadeType.MERGE})
    private List<Student> students = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "stud_prof",
            joinColumns = { @JoinColumn(name = "id_prof") },
            inverseJoinColumns = { @JoinColumn(name = "id_stud") }
    )
    private List<Student> students2 = new ArrayList<>();

    @ManyToMany(mappedBy = "professors",cascade = {CascadeType.PERSIST,
            CascadeType.MERGE})
    private List<Subject> subjects1 = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "prof_subject",
            joinColumns = { @JoinColumn(name = "id_prof") },
            inverseJoinColumns = { @JoinColumn(name = "id_subject") }
    )
    private List<Subject> subjects2 = new ArrayList<>();

    public Professor(String fio, int age, List<Student> students) {
        this.fio = fio;
        this.age = age;
        this.students2 = students;
    }

    public Professor(String fio, int age, List<Student> students, List<Subject> subjects) {
        this.fio = fio;
        this.age = age;
        this.students = this.students2 = students;
        this.subjects1 = subjects;
        this.subjects2=subjects;
    }

    public Professor() {
    }

    public static String[] getTags() {
        return new String[]{"id", "fio", "age"};
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", fio='" + fio + '\'' +
                ", age=" + age +
                ", driver=" + driver +
                '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Professor other = (Professor) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.fio, other.fio)) {
            return false;
        }
        if (this.age != other.age) {
            return false;
        }
        return true;
    }


}

package model;

import com.google.gson.Gson;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "driver")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_d;
    private Long id;
    private int type; // 1- stud, 2-prof
    private double experience;
    private String license;

    @OneToOne(mappedBy = "driver")
    private Professor professor;

    @OneToOne(mappedBy = "driver")
    private Student student;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "driver")
    private List<Car> cars = new ArrayList<>();

    public Driver() {
    }

    public Driver(Long id, int type, double experience, String license) {
        this.id = id;
        this.type = type;
        this.experience = experience;
        this.license = license;
    }

    public Driver(double experience, String license, Student student) {
        this.id = student.getId();
        this.type = 1;
        this.experience = experience;
        this.license = license;
    }

    public Driver(double experience, String license, Professor professor) {
        this.id = professor.getId();
        this.type = 0;
        this.experience = experience;
        this.license = license;
    }

    public static String[] getTags() {
        return new String[]{"id_d", "id", "type", "Experience", "License"};
    }

    public Long getId_d() {
        return id_d;
    }

    public void setId_d(Long id_d) {
        this.id_d = id_d;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getExperience() {
        return experience;
    }

    public void setExperience(double experience) {
        this.experience = experience;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}

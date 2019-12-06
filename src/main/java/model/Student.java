package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fio;
    private double point;
    @Column(name = "date_born")
    private Date dateBorn;
    @Column(name = "gr_name")
    private int groupName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Driver driver;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "stud_prof",
            joinColumns = { @JoinColumn(name = "id_stud") },
            inverseJoinColumns = { @JoinColumn(name = "id_prof") }
    )
    private List<Professor> professors = new ArrayList<>();

   /* @ManyToMany(mappedBy = "students2",cascade = {CascadeType.PERSIST,
            CascadeType.MERGE})
    private List<Professor> professors2 = new ArrayList<>();*/

    public Student(String fio, double point, Date dateBorn, int groupName, List<Professor> professors) {
        this.fio = fio;
        this.point = point;
        this.dateBorn = dateBorn;
        this.groupName = groupName;
        this.professors = professors;
    }

    public Student() {}


    public static String[] getTags(){
        return new String[]{"id", "FIO", "Point", "Date", "Group"};
    }

    public Object[] getValues(){
        return new Object[]{this.id, this.fio, this.point, this.dateBorn, this.groupName};
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

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public Date getDateBorn() {
        return dateBorn;
    }

    public void setDateBorn(Date dateBorn) {
        this.dateBorn = dateBorn;
    }

    public int getGroupName() {
        return groupName;
    }

    public void setGroupName(int groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", fio='" + fio + '\'' +
                ", point=" + point +
                ", dateBorn=" + dateBorn +
                ", groupName=" + groupName +
                '}';
    }
}

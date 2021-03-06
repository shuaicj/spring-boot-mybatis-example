package shuaicj.example.mybatis.relationship.entity;

import java.io.Serializable;

/**
 * A java bean representing an identity.
 *
 * @author shuaicj 2019/07/03
 */
@SuppressWarnings("serial")
public class Identity implements Serializable {

    private Long id;
    private String number;
    private Person person;

    public Identity() {
    }

    public Identity(String number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Identity{"
                + "id=" + id
                + ", number='" + number + '\''
                + '}';
    }
}

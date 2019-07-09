package shuaicj.example.mybatis.entity;

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

    @Override
    public String toString() {
        return "Identity{"
                + "id=" + id
                + ", number='" + number + '\''
                + '}';
    }
}

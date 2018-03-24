package org.hibernate.tutorial.hbm;

/**
 * <p>
 *
 * @author: hzy created on 2018/03/22
 */
public class Book {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

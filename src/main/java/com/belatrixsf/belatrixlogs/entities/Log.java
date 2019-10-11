package com.belatrixsf.belatrixlogs.entities;

import javax.persistence.*;

@Entity
@Table(name = "log")
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "message")
    private String message;

    @Column(name = "level")
    private Integer level;

    public Log(String message, Integer level) {
        this.message = message;
        this.level = level;
    }

    public Integer getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

}

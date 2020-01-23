package br.com.wexigor.wexigor.models;

import javax.persistence.Column;

public class UserMovie {

    @Column(name = "firstName")
    String user;
    String title;

    public UserMovie(String user, String title) {
        this.user = user;
        this.title = title;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

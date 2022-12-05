package app.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Users {

    private Long id;
    private String nick;
    private String login;
    private String password;
    private Timestamp insertTime;

    public Users() {
    }

    public Users(Long id, String nick, String login, String password, Timestamp insertTime) {
        this.id = id;
        this.nick = nick;
        this.login = login;
        this.password = password;
        this.insertTime = insertTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Timestamp insertTime) {
        this.insertTime = insertTime;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", nick='" + nick + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", insertTime=" + insertTime +
                '}';
    }
}

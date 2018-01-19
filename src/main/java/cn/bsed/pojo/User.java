package cn.bsed.pojo;

import java.util.Objects;

/**
 * @author SQM
 * @date 2018/1/17
 * @version: 1.0
 */
public class User {
    private int id;
    // @NotEmpty(message = "用户名不能为空")
    private String username;

    // @NotEmpty(message = "密码不能为空")
    // @Size(min = 6,max = 16,message = "密码长度为{min}-{max}位")
    private String password;
    private String nickname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        User user = (User) o;
        return id == user.id &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(nickname, user.nickname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, username, password, nickname);
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}

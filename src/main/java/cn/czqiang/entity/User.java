package cn.czqiang.entity;

/**
 * Created with IntelliJ IDEA.
 * User: 陈志强
 * Date: 13-10-16
 * Time: 下午1:47
 */
public class User {
    private String name;
    private String nikeName;
    private String password;
    private String email;

    public User() {
        super();
    }

    public User(String name, String nikeName, String password, String email) {
        super();
        this.name = name;
        this.nikeName = nikeName;
        this.password = password;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNikeName() {
        return nikeName;
    }

    public void setNikeName(String nikeName) {
        this.nikeName = nikeName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

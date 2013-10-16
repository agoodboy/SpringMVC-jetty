package cn.czqiang.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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

    @NotEmpty(message = "姓名不能为空！")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotEmpty(message = "昵称不能为空！")
    public String getNikeName() {
        return nikeName;
    }

    public void setNikeName(String nikeName) {
        this.nikeName = nikeName;
    }

    @NotEmpty(message = "密码不能为空！")
    @Size(min = 2, max = 10, message = "密码的长度必须大于3小于10！")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Pattern(regexp = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*", message = "邮箱格式不正确！")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

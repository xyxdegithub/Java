package entity;

/**
 * @author: xyx & yx282947664@163.com
 * @date 2023/7/31 031 11:30
 * @description: 系统管理员，只有系统管理员才能登录
 */
public class Admin {
    private String username;
    private String password;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

package 下练习.pratice.map;

public class zhanghao {
     private String username;
     private int password;
    public zhanghao() {
    }

    public zhanghao(String username, int password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "zhanghao{" +
                "username='" + username + '\'' +
                ", password=" + password +
                '}';
    }
}

package entity;

public class user {
    private int user_id;
    private String user_account;
    private String user_password;
    private String phone1;

    public user() {
    }

    public user(int user_id, String user_account, String user_password, String phone1) {
        super();
        this.user_id = user_id;
        this.user_account = user_account;
        this.user_password = user_password;
        this.phone1 = phone1;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_account() {
        return user_account;
    }

    public void setUser_account(String user_account) {
        this.user_account = user_account;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    @Override
    public String toString() {
        return "users{" +
                "user_id=" + user_id +
                ", user_account='" + user_account + '\'' +
                ", user_password='" + user_password + '\'' +
                ", phone1='" + phone1 + '\'' +
                '}';
    }
}

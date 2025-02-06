package Simple.E_Commerce.Simple.E_Commerce.SimpleE_CommerceEntities;

import jakarta.persistence.*;

@Entity
@Table(name = "authenticationUser")
public class AuthenticationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType. IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_Name")
    private String userName;
    @Column(name = "pass_Word")
    private String passWord;

    @Column(name = "phone_Number", unique = true, nullable = false )
    private int phoneNumber;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassWord() {
        return passWord;
    }
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    public int getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

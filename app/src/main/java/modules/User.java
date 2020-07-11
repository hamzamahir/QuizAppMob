package modules;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class User {

    private String nom;
    private String login_password;
    private DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

    public String getLogin_password() {
        return login_password;
    }

    public void setLogin_password(String login_password) {
        this.login_password = login_password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    private String email;
    private String login;
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "nom='" + nom + '\'' +
                ", login_password='" + login_password + '\'' +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void FBWrite(String id)
    {
        ref.child("users").child(id).setValue(this);
    }

    public User(String nom, String email, String login, String password,String login_password) {
        this.nom = nom;
        this.login_password = login_password;
        this.email = email;
        this.login = login;
        this.password = password;
    }
    public User() {

    }
}

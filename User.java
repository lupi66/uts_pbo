public class User {
    private String nama; 
    private String role; 
    private String password;

    public User(String nama, String role, String password) {
        this.nama = nama;
        this.role = role;
        this.password = password;
    }

    public boolean cekLogin(String inputRole, String inputPass) {
        return this.role.equals(inputRole) && this.password.equals(inputPass);
    }
    
    public String getNama() { return nama; }
}
package coreclosetsale.closet_sale.models;
import java.util.UUID;

import com.fasterxml.jackson.databind.deser.std.UUIDDeserializer;

import jakarta.persistence.*;

@Entity 
@Table(name = "users")
public class User {
 
    @Id 
    @Column(name="id", updatable = false, nullable = false,columnDefinition = "UNIQUEIDENTIFIER")
    private UUID id;
    
    private String firstName;

    private String lastName;

   @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    // Crucial para armar el link directo de WhatsApp
    @Column(nullable = false)
    private String whatsappNumber; 

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
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
    public String getFirstname() {
        return firstName;
    }
    public void setFirstname(String firstname) {
        this.firstName = firstname;
    }
    public String getLastname() {
        return lastName;
    }
    public void setLastname(String lastname) {
        this.lastName = lastname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getWhatsappNumber() {
        return whatsappNumber;
    }
    public void setWhatsappNumber(String whatsappNumber) {
        this.whatsappNumber = whatsappNumber;
    }
}

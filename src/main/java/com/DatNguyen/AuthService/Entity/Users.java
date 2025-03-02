package com.DatNguyen.AuthService.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "users")
public class Users implements UserDetails {
    @Id
    @Column(name = "user_id")
    private UUID userID;

    @Column(nullable = false, unique = true, name = "username")
    private String username;

    @Column(nullable = false, unique = true, name = "email")
    @Email
    private String email;

    @Column(name = "hashed_password", nullable = false)
    //@Size(min=8, max=15)
    private String hashedPassword;

    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    @Column(name = "last_login", nullable = false)
    private Timestamp lastLogin;

    @Column(name = "is_verified", nullable = false)
    private boolean isVerified;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    public Users() {}

    public Users(UUID userID, String username, String email, String hashedPassword, Timestamp createdAt, Timestamp lastLogin, boolean isVerified, Role role) {
        this.userID = userID;
        this.username = username;
        this.email = email;
        this.hashedPassword = hashedPassword;
        this.createdAt = createdAt;
        this.lastLogin = lastLogin;
        this.isVerified = isVerified;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return this.hashedPassword;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    @Override
    public String getUsername() {
        return this.email;
    }

    public UUID getUserID() {
        return userID;
    }

    public void setUserID(UUID userID) {
        this.userID = userID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

package org.academiadecodigo.charliesangels.models;

import org.academiadecodigo.charliesangels.utils.Security;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "user")
public class User extends AbstractModel{

    @NotNull(message = "username is mandatory")
    @NotBlank(message = "username is mandatory")
    @Size(min = 3, max = 36)
    @Column(unique=true)
    private String username;

    @Email
    private String email;

    @Size(min = 8)
    private String password;

    @OneToOne(mappedBy = "user", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private Poll poll;

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Poll getPoll() {
        return poll;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = Security.getHash(password);
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }

    /**
     *
     * @param poll
     */
    public void addPoll(Poll poll) {
        poll.setUser(this);
    }

    /**
     * Deletes the poll
     */
    public void deletePoll() {
        this.poll = null;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + username + '\'' +
                ", email='" + email + '\'' +
                ", poll=" + poll +
                '}';
    }
}

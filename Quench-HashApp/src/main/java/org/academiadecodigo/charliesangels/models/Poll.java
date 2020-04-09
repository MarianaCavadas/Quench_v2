package org.academiadecodigo.charliesangels.models;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "poll")
public class Poll extends AbstractModel{

    @Size(min = 5, max = 64)
    private String title;

    @Size(min = 10)
    private String message;
    private String photo;

    @Min(5)
    private int minimumVotes;
    private int yes;
    private int no;

    @OneToOne
    private User user;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getMinimumVotes() {
        return minimumVotes;
    }

    public void setMinimumVotes(int minimumVotes) {
        this.minimumVotes = minimumVotes;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getYes() {
        return yes;
    }

    public void setYes(int yes) {
        this.yes = yes;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void incrementYes() {
        yes++;
    }

    public void incrementNo() {
        no++;
    }

    @Override
    public String toString() {
        return "Poll{" +
                "title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", minimumVotes=" + minimumVotes +
                ", yes=" + yes +
                ", no=" + no +
                ", user=" + user +
                '}';
    }
}

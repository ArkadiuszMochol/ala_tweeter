package model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "app_user")

public class AppUser {
    //obiekt pojo
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String login;
    private String name;

    @Column(name = "last_name")
    private String lastName;
    private String password;
    private String email;
    @Column(name = "date_of_registration")
    @CreationTimestamp
    private Date dateOfRegistration;

    @ManyToMany(mappedBy = "followedByUser")
    private Set<AppUser> followers = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "follower_followed",
            joinColumns = {@JoinColumn(name = "follower_id")},
            inverseJoinColumns = {@JoinColumn(name = "followedByUser_id")})
    private Set<AppUser> followedByUser = new HashSet<>();

    public AppUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(Date dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public Set<AppUser> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<AppUser> followers) {
        this.followers = followers;
    }

    public Set<AppUser> getFollowedByUser() {
        return followedByUser;
    }

    public void setFollowedByUser(Set<AppUser> followedByUser) {
        this.followedByUser = followedByUser;
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", dateOfRegistration=" + dateOfRegistration +

                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppUser appUser = (AppUser) o;

        return id.equals(appUser.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    public static class UserBuilder {
        private String name;
        private String lastName;
        private String login;
        private String password;
        private String mail;
        private Date dateOfRegistration;

        public static UserBuilder getBuilder() {
            return new UserBuilder();
        }

        public UserBuilder login(String login) {
            this.login = login;
            return this;
        }

        public UserBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder mail(String mail) {
            this.mail = mail;
            return this;
        }

        public UserBuilder dateOfRegistration(Date dateOfRegistration) {
            this.dateOfRegistration = dateOfRegistration;
            return this;
        }

        public AppUser build() {
            AppUser user = new AppUser();
            user.setLogin(this.login);
            user.setName(this.name);
            user.setLastName(this.lastName);
            user.setPassword(this.password);
            user.setEmail(this.mail);
            user.setDateOfRegistration(this.dateOfRegistration);
            return user;
        }


    }

}
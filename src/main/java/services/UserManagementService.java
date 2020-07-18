package services;

import model.AppUser;

import java.util.Set;

public interface UserManagementService {
    //zależności trzymamy w interfejsach

    void saveUser(AppUser appUser);

    void deleteUser(AppUser appUser);

    void follow(String currentUserLogin, String userLoginToFollow);

    void stopFollwing(String currentUserLogin, String userLoginToUnFollow);

    Set<AppUser> getFollowedUser(String currentUserLogin);

    Set<AppUser> getNotFollowedUser(String currentUserLogin);

    boolean isUserValid(String login, String password);

    boolean isUserLoginAvailable(String login);

    boolean isUserMailAvailable(String mail);


}

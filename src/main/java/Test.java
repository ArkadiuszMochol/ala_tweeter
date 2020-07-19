import dao_dataAccessObject.UserDao;
import dao_dataAccessObject.impl.AppUserDao;
import model.AppUser;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {

    public static void main(String[] args) {
        UserDao userDao = new AppUserDao();

        AppUser user1 = new AppUser();

        user1.setName("Erni");
        user1.setLogin("erni");
        user1.setEmail("erni@o2.p");
        user1.setPassword("erni");
        user1.setDateOfRegistration(new Date());
        userDao.saveUser(user1);

        AppUser user2 = new AppUser();
        user2.setName("Jan");
        user2.setLogin("jan");
        user2.setEmail("jan@o2.pl");
        user2.setPassword("jan");
        user2.setDateOfRegistration(new Date());
        userDao.saveUser(user2);

        AppUser user3 = new AppUser();
        user3.setName("Ola");
        user3.setLogin("ola");
        user3.setEmail("ola@o2.pl");
        user3.setPassword("ola");
        user3.setDateOfRegistration(new Date());
        userDao.saveUser(user3);

        userDao.follow("Jan", "Erni");
        AppUser erni = userDao.getUserByLogin("Erni");
        Set<AppUser> followers = erni.getFollowers();
        AppUser erni1 = userDao.getUserByLogin("Erni");
        HashSet<AppUser> followers1 = userDao.getFollowers(erni1.getLogin());

        System.out.println(followers.size());
        userDao.saveUser(erni1);
    }
    public static void returnTest(){
        if(true){
            System.out.println("In if");
            return;
        }
        System.out.println("outside");
    }
}

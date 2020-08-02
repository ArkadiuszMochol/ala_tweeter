package services.impl;

import dao_dataAccessObject.TweetDAO;
import dao_dataAccessObject.UserDao;
import dao_dataAccessObject.impl.AppUserDao;
import dao_dataAccessObject.impl.TweetDAOImpl;
import model.AppUser;
import model.Tweet;
import services.TweetManagementService;

import java.util.HashSet;
import java.util.Set;

public class TweetManagementServiceImpl implements TweetManagementService {
    private UserDao userDAO;
    private TweetDAO tweetDAO;

    public TweetManagementServiceImpl() {
        this.userDAO = new AppUserDao();
        this.tweetDAO = new TweetDAOImpl();
    }

    @Override
    public void addTweet(String userLogin, String message) {
        AppUser user = userDAO.getUserByLogin(userLogin);
        tweetDAO.addTweet(user, message);
    }

    @Override
    public void updateTweet(Long tweetId, String message) {
        tweetDAO.updateTweet(tweetId, message);
    }

    @Override
    public void deleteTweet(Long id) {
        tweetDAO.deleteTweet(id);
    }

    @Override
    public Set<Tweet> getFollowedTweets(String userLogin) {
        Set<Tweet> followedTweets = new HashSet<>();
        Set<AppUser> followedUsers = userDAO.getFollowedUsers(userLogin);
        followedTweets.addAll(tweetDAO.getUserTweets(userLogin));
        followedUsers.stream().forEach(p -> followedTweets.addAll(tweetDAO.getUserTweets(p.getLogin())));
        return followedTweets;
    }


}

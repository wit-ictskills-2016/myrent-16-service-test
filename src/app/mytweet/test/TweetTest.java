package app.mytweet.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import app.mytweet.main.MyTweetServiceAPI;
import app.mytweet.models.Tweet;
import app.mytweet.models.Tweeter;


public class TweetTest
{
  private static MyTweetServiceAPI service = new MyTweetServiceAPI();

  @Test
  public void test() throws Exception
  {

    Tweet tweet = new Tweet("tweet-5", "5", "November 16th 10.00 hours");
    Tweet returnedTweet = service.createTweet(tweet.id, tweet);
    assertEquals(tweet, returnedTweet);
    
    Tweeter tweeter = new Tweeter("John", "Doe", "john@doe.com", "secret");
    Tweeter returnedTweeter = service.createTweeter(tweeter);
    assertEquals(tweeter, returnedTweeter);
    
    Tweeter tweeter2 = new Tweeter("John", "Doe", "john@doe.com", "secret");
    Tweeter returnedTweeter2 = service.createTweeter(tweeter2);
    assertEquals(tweeter2, returnedTweeter2);
    
    List<Tweet> tweets = service.getAllTweets();
    System.out.println("Number tweets " + tweets.size());
    
    List<Tweeter> tweeters = service.getAllTweeters();
    System.out.println("Number tweeters " + tweeters.size());
  }

}

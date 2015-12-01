package app.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import app.main.TweetServiceAPI;
import app.models.Tweet;
import app.models.Tweeter;


/**
List of api methods to test
# Tweeter (the user)
GET     /api/tweeters                              TweetersAPI.getAllTweeters     [ok]
GET     /api/tweeters/{id}                         TweetersAPI.getTweeter         [ok]
POST    /api/tweeters                              TweetersAPI.createTweeter      [ok]
DELETE  /api/tweeters/{id}                         TweetersAPI.deleteTweeter      [ok]
DELETE  /api/tweeters                              TweetersAPI.deleteAllTweeters  [ok]

# Tweet
GET     /api/tweets                                TweetsAPI.getAllTweets         [ok]
DELETE  /api/tweets                                TweetsAPI.deleteAllTweets      [ok]
GET     /api/tweeters/{id}/tweets                  TweetsAPI.getTweets            [0k]
GET     /api/tweeters/{id}/tweets/{tweetId}        TweetsAPI.getTweet             [0k]
POST    /api/tweeters/{id}/tweets                  TweetsAPI.createTweet          [ok]
DELETE  /api/tweeters/{id}/tweets/{tweetId}        TweetsAPI.deleteTweet          [ok]
*/
public class TweetTest
{
  private static TweetServiceAPI service = new TweetServiceAPI();
  
  private int NUMBER_TWEETS   = 8;
  private int NUMBER_TWEETERS = 4;
  
  static Tweeter tweeters[] =
  {
    new Tweeter("Homer", "Simpson", "homer@simpson.com", "secret"),
    new Tweeter("Marge", "Simpson", "marge@simpson.com", "secret"),
    new Tweeter("Bart", "Simpson", "bart@simpson.com", "secret"),
    new Tweeter("Lisa", "Simpson", "lisa@simpson.com", "secret")

  };
  
  static Tweet tweets[] = 
  {
    new Tweet("tweet 0"),
    new Tweet("tweet 1"),
    new Tweet("tweet 2"),
    new Tweet("tweet 3"),
    new Tweet("tweet 4"),
    new Tweet("tweet 5"),
    new Tweet("tweet 6"),
    new Tweet("tweet 7"),

  };
  
  @Before
  public void setup() throws Exception
  {
    for (Tweeter tweeter : tweeters)
    {
      service.createTweeter(tweeter);
    }
 
    service.createTweet(tweeters[0].id, tweets[0]); 
    service.createTweet(tweeters[0].id, tweets[1]); 
 
    service.createTweet(tweeters[1].id, tweets[2]); 
    service.createTweet(tweeters[1].id, tweets[3]); 

    service.createTweet(tweeters[2].id, tweets[4]); 
    service.createTweet(tweeters[2].id, tweets[5]); 
    
    service.createTweet(tweeters[3].id, tweets[6]); 
    service.createTweet(tweeters[3].id, tweets[7]); 
  }
 
  @After
  public void teardown() throws Exception
  {
    service.deleteAllTweeters();
    service.deleteAllTweets();
  }
  
@Test
  public void getAllTweeters() throws Exception
  {    
    List<Tweeter> tweeters = service.getAllTweeters();
    assertEquals(tweeters.size(), NUMBER_TWEETERS);
  }
 
@Test
 public void getAllTweets() throws Exception
 {
   List<Tweet> tweets = service.getAllTweets();
   assertEquals(tweets.size(), NUMBER_TWEETS); 
 }
 
 /**
  * DELETE  /api/tweeters/{id}    TweetersAPI.deleteTweeter
  * 
  * service.createTweet(tweeters[0].id, tweets[0]); 
  */
  @Test
  public void deleteTweet() throws Exception
  {
    String tweetId = tweets[0].id;
    String tweeterId = tweeters[0].id;
    int rval = service.deleteTweet(tweeterId, tweetId);
    assertEquals(rval, 200);
  }
  
  @Test
  public void deleteTweeter() throws Exception
  {
    int rval = service.deleteTweeter(tweeters[0].id);
    assertEquals(rval, 200)
;  }
  
  @Test
  public void getTweeter() throws Exception
  {
    Tweeter tweeter = service.getTweeter(tweeters[0].id);
    assertEquals(tweeter, tweeters[0]);
  }
  
  // GET     /api/tweeters/{id}/tweets   TweetsAPI.getTweets
  @Test
  public void getTweets() throws Exception
  {
    String tweeterId = tweeters[1].id;
    List<Tweet> tweets = service.getTweets(tweeterId);
    assertEquals(tweets.size(), 2);
  }
  
  // service.createTweet(tweeters[2].id, tweets[4]); 
  // service.createTweet(tweeters[2].id, tweets[5]); 
  // GET     /api/tweeters/{id}/tweets/{tweetId}        TweetsAPI.getTweet
  @Test
  public void getTweet() throws Exception
  {
    String tweeterId = tweeters[2].id;
    String tweetId = tweets[5].id;
    Tweet tweet = service.getTweet(tweeterId, tweetId);
    assertEquals(tweets[5], tweet);
  }

}

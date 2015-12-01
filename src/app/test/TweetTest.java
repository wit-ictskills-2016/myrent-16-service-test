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
Complete list api methods tested
# Tweeter (the user)
GET     /api/tweeters                              TweetersAPI.getAllTweeters     
GET     /api/tweeters/{id}                         TweetersAPI.getTweeter         
POST    /api/tweeters                              TweetersAPI.createTweeter      
DELETE  /api/tweeters/{id}                         TweetersAPI.deleteTweeter      
DELETE  /api/tweeters                              TweetersAPI.deleteAllTweeters  

# Tweet
GET     /api/tweets                                TweetsAPI.getAllTweets         
DELETE  /api/tweets                                TweetsAPI.deleteAllTweets      
GET     /api/tweeters/{id}/tweets                  TweetsAPI.getTweets            
GET     /api/tweeters/{id}/tweets/{tweetId}        TweetsAPI.getTweet             
POST    /api/tweeters/{id}/tweets                  TweetsAPI.createTweet          
DELETE  /api/tweeters/{id}/tweets/{tweetId}        TweetsAPI.deleteTweet          
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
  
  /**
   * POST /api/tweeters TweetersAPI.createTweeter POST /api/tweets
   * TweetersAPI.createTweet
   */
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

  /**
   * DELETE /api/tweets TweetsAPI.deleteAllTweets DELETE /api/tweeters
   * TweetsAPI.deleteAllTweeterss
   */
  @After
  public void teardown() throws Exception
  {
    service.deleteAllTweeters();
    service.deleteAllTweets();
  }

  /**
   * GET /api/tweeters TweetersAPI.getAllTweeters
   */
  @Test
  public void getAllTweeters() throws Exception
  {
    List<Tweeter> tweeters = service.getAllTweeters();
    assertEquals(tweeters.size(), NUMBER_TWEETERS);
  }

  /**
   * GET /api/tweets TweetsAPI.getAllTweets
   */
  @Test
  public void getAllTweets() throws Exception
  {
    List<Tweet> tweets = service.getAllTweets();
    assertEquals(tweets.size(), NUMBER_TWEETS);
  }

  /**
   * DELETE /api/tweeters/{id} TweetersAPI.deleteTweeter
   */
  @Test
  public void deleteTweet() throws Exception
  {
    String tweetId = tweets[0].id;
    String tweeterId = tweeters[0].id;
    int rval = service.deleteTweet(tweeterId, tweetId);
    assertEquals(rval, 200);
  }

  /**
   * DELETE /api/tweeters/{id} TweetersAPI.deleteTweeter
   */
  @Test
  public void deleteTweeter() throws Exception
  {
    int rval = service.deleteTweeter(tweeters[0].id);
    assertEquals(rval, 200);
  }

  /**
   * GET /api/tweeters/{id} TweetersAPI.getTweeter
   */
  @Test
  public void getTweeter() throws Exception
  {
    Tweeter tweeter = service.getTweeter(tweeters[0].id);
    assertEquals(tweeter, tweeters[0]);
  }

  /**
   * GET /api/tweeters/{id}/tweets TweetsAPI.getTweets
   */
  @Test
  public void getTweets() throws Exception
  {
    String tweeterId = tweeters[1].id;
    List<Tweet> tweets = service.getTweets(tweeterId);
    assertEquals(tweets.size(), 2);
  }

  /**
   * GET /api/tweeters/{id}/tweets/{tweetId} TweetsAPI.getTweet
   */
  @Test
  public void getTweet() throws Exception
  {
    String tweeterId = tweeters[2].id;
    String tweetId = tweets[5].id;
    Tweet tweet = service.getTweet(tweeterId, tweetId);
    assertEquals(tweets[5], tweet);
  }

}

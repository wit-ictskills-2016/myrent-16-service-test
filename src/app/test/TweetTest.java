package app.test;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Test;

import app.main.TweetServiceAPI;
import app.models.Tweet;
import app.models.Tweeter;


public class TweetTest
{
  private static TweetServiceAPI service = new TweetServiceAPI();

  @Test
  public void test() throws Exception
  {

    Tweeter tweeter = new Tweeter("Barney", "Gumble", "barney@gumble.com", "secret");
    Tweeter returnedTweeter = service.createTweeter(tweeter);
    assertEquals(tweeter, returnedTweeter);
 
    Tweeter tweeter2 = new Tweeter("Homer", "Simpson", "homer@simpson.com", "secret");
    Tweeter returnedTweeter2 = service.createTweeter(tweeter2);
    assertEquals(tweeter2, returnedTweeter2);
    
    //List<Tweeter> tweeters = service.getAllTweeters();
    //System.out.println("Number tweeters " + tweeters.size());
    
//    int result = service.deleteAllTweets();
//    assertEquals(result, 200);
//    System.out.println("deleteAllTweets result: " + result);
    
//    List<Tweet> tweetsDeleted = service.getAllTweets();
//    assertEquals(tweetsDeleted.size(), 0);
//    System.out.println("Number tweeters " + tweetsDeleted.size());
    
//    System.out.println(tweet.datestamp);
//
//    Tweeter tweeter = new Tweeter("John", "Doe", "john@doe.com", "secret");
//    Tweeter returnedTweeter = service.createTweeter(tweeter);
//    assertEquals(tweeter, returnedTweeter);
//       
//    Tweeter tweeter2 = new Tweeter("John", "Doe", "john@doe.com", "secret");
//    Tweeter returnedTweeter2 = service.createTweeter(tweeter2);
//    assertEquals(tweeter2, returnedTweeter2);
//    
//    List<Tweet> tweets = service.getAllTweets();
//    System.out.println("Number tweets " + tweets.size());
//    
//    List<Tweeter> tweeters = service.getAllTweeters();
//    System.out.println("Number tweeters " + tweeters.size());
    
    // <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    // @GET("/api/tweeters/{id}/tweets/{tweetId}")
    // Call<Tweet> getTweet(@Path("id") String id, @Path("id") String tweetId);
    // <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

//    String tweeterId = "A";
//    String tweetId = "B";
//    Tweet tweetImage = service.getTweet(tweeterId, tweetId);
//    assertEquals(tweetImage, tweet);
   
  }

}

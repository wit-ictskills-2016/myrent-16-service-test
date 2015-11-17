package app.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import app.main.TweetServiceAPI;
import app.models.Tweet;
import app.models.Tweeter;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;


public class TweetTest
{
  private static TweetServiceAPI service = new TweetServiceAPI();

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

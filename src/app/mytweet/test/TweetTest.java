package app.mytweet.test;

import static org.junit.Assert.*;

import org.junit.Test;

import app.mytweet.main.MyTweetServiceAPI;
import app.mytweet.models.Tweet;


public class TweetTest
{
  private static MyTweetServiceAPI service = new MyTweetServiceAPI();

  @Test
  public void test() throws Exception
  {

    Tweet tweet = new Tweet("tweet-3", "3", "November 14th 14.52 hours");
    Tweet returnedTweet = service.createTweet(tweet);
    assertEquals(tweet, returnedTweet);
  }

}

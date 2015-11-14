package app.mytweet.main;


import app.mytweet.models.Tweet;
import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.POST;

public interface MyTweetServiceProxy
{
  @POST("/api/tweets")
  Call<Tweet> createTweet(@Body Tweet tweet);
}

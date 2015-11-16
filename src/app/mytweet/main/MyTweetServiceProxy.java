//package app.mytweet.main;
//
//
//import app.mytweet.models.Tweet;
//import retrofit.Call;
//import retrofit.http.Body;
//import retrofit.http.POST;
//
//public interface MyTweetServiceProxy
//{
//  @POST("/api/tweets")
//  Call<Tweet> createTweet(@Body Tweet tweet);
//}


package app.mytweet.main;

import java.util.List;

import app.mytweet.models.Tweet;
import app.mytweet.models.Tweeter;
import retrofit.Call;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

public interface MyTweetServiceProxy
{
//  @POST("/api/tweets")
//  Call<Tweet> createTweet(@Body Tweet tweet);
//
//  @POST("/api/tweeter")
//  Call<Tweeter> createTweeter(@Body Tweeter tweeter);
//
//  @POST("/api/tweeter/login")
//  Call<Tweeter> login (@Body Tweeter tweeter);

  @GET("/api/tweeters")
  Call<List<Tweeter>> getAllTweeters();

  @GET("/api/tweeters/{id}")
  Call<Tweeter> getTweeter(@Path("id") String id);

  @POST("/api/tweeters")
  Call<Tweeter> createTweeter(@Body Tweeter tweeter);

  @DELETE("/api/tweeters/{id}")
  Call<Tweeter> deleteTweeter(@Path("id") String id);

  @DELETE("/api/tweeters")
  Call<String> deleteAllTweeters();

  @GET("/api/tweets")
  Call<List<Tweet>> getAllTweets();

  @DELETE("/api/tweets")
  Call<String> deleteAllTweets();

  @GET("/api/tweeters/{id}/tweets")
  Call<List<Tweet>> getTweets(@Path("id") String id);

  @GET("/api/tweeters/{id}/tweets/{tweetId}")
  Call<Tweet> getTweet(@Path("id") String id, @Path("id") String tweetId);

  @POST("/api/tweeters/{id}/tweets")
  Call<Tweet> createTweet(@Path("id") String id, @Body Tweet tweet);

  @DELETE("/api/tweeters/{id}/tweets/{tweetId}")
  Call<Tweet> deleteTweet(@Path("id") String id, @Path("id") String tweetId);
}

package app.main;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import app.models.Tweet;
import app.models.Tweeter;
import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class TweetServiceAPI
{
  private String service_url = "http://localhost:9000";
  private TweetServiceProxy service;

  public TweetServiceAPI()
  {
    Gson gson = new GsonBuilder().create();

    Retrofit retrofit = new Retrofit.Builder().baseUrl(service_url)
                             .addConverterFactory(GsonConverterFactory
                             .create(gson))
                             .build();
    service = retrofit.create(TweetServiceProxy.class);
  }

  public List<Tweeter> getAllTweeters() throws Exception
  {
    Call<List<Tweeter>> call = (Call<List<Tweeter>>) service.getAllTweeters();
    Response<List<Tweeter>> tweeters = call.execute();
    return tweeters.body();
  }

  public Tweeter getTweeter(String id) throws Exception
  {
    Call<Tweeter> call = (Call<Tweeter>) service.getTweeter(id);
    Response<Tweeter> tweeters = call.execute();
    return tweeters.body();
  }

  public int deleteTweeter(String id) throws Exception
  {
    Call<Tweeter> call = service.deleteTweeter(id);
    Response<Tweeter> val = call.execute();
    return val.code();
  }

  public int deleteAllTweeters() throws Exception
  {
    Call<String> call = service.deleteAllTweeters();
    Response<String> val = call.execute();
    return val.code();
  }

  public Tweeter createTweeter(Tweeter newTweeter) throws Exception
  {
    Call<Tweeter> call = (Call<Tweeter>) service.createTweeter(newTweeter);
    Response<Tweeter> returnedTweeter = call.execute();
    return returnedTweeter.body();
  }

  public List<Tweet> getAllTweets() throws Exception
  {
    Call<List<Tweet>> call = (Call<List<Tweet>>) service.getAllTweets();
    Response<List<Tweet>> donations = call.execute();
    return donations.body();
  }

  public Tweet getTweet(String tweeterId, String tweetId) throws Exception
  {
    Call<Tweet> call = (Call<Tweet>) service.getTweet(tweeterId, tweetId);
    Response<Tweet> tweet = call.execute();
    return tweet.body(); 
    
  }
  public List<Tweet> getTweets(String id) throws Exception
  {
    Call<List<Tweet>> call = (Call<List<Tweet>>) service.getTweets(id);
    Response<List<Tweet>> donations = call.execute();
    return donations.body();
  }
  
  public Tweet createTweet(String id, Tweet newTweet) throws Exception
  {
    Call<Tweet> call = (Call<Tweet>) service.createTweet(id, newTweet);
    Response<Tweet> returnedTweet = call.execute();
    return returnedTweet.body();
  }

  public int deleteTweet(String id, String donationId) throws Exception
  {
    Call<Tweet> call = service.deleteTweet(id, donationId);
    Response<Tweet> val = call.execute();
    return val.code();
  }

  public int deleteAllTweets() throws Exception
  {
    Call<String> call = service.deleteAllTweets();
    Response<String> val = call.execute();
    return val.code();
  }
}
package app.mytweet.main;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import app.mytweet.models.Tweet;
import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MyTweetServiceAPI
{
  private String service_url = "http://localhost:9000";
  private MyTweetServiceProxy service;

  public MyTweetServiceAPI()
  {
    Gson gson = new GsonBuilder().create();

    Retrofit retrofit = new Retrofit.Builder().baseUrl(service_url)
                             .addConverterFactory(GsonConverterFactory
                             .create(gson))
                             .build();
    service = retrofit.create(MyTweetServiceProxy.class);
  }
  
  public Tweet createTweet(Tweet newTweet) throws Exception
  {
    Call<Tweet> call = (Call<Tweet>) service.createTweet(newTweet);
    Response<Tweet> returnedTweet = call.execute();
    return returnedTweet.body();
  }
}


/*import java.util.List;

import app.model.Tweet;

public class MyTweetServiceAPI
{ 
  public static List<Tweet> getTweets() throws Exception
  {
    String response =  Rest.get("/api/tweets");
    List<Tweet> tweetList = JsonParsers.json2Tweets(response);
    return tweetList;
  }

  public static Tweet getTweet(Long id) throws Exception
  {
    String response =  Rest.get("/api/tweets/" + id);
    Tweet tweet = JsonParsers.json2Tweet(response);
    return tweet;
  }

  public static Tweet createTweet(Tweet tweet) throws Exception
  {
    String response = Rest.post ("/api/tweets", JsonParsers.tweet2Json(tweet));
    return JsonParsers.json2Tweet(response);
  }

  public static void deleteTweet(Long id) throws Exception
  {
    Rest.delete ("/api/tweets/" + id);
  }  
  
  public static void deleteAllTweets() throws Exception
  {
    Rest.delete ("/api/tweets");
  } 
}*/
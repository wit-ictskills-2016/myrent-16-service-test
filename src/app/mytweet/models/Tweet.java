package app.mytweet.models;
import java.util.UUID;

import com.google.common.base.Objects;

import static com.google.common.base.Objects.toStringHelper;

public class Tweet
{

  public String   id;
  public String   tweetText;
  public String   tweetCount;
  public String   tweetDate;
  
  public User   user;
  
  public Tweet(){}
  
  public Tweet(String tweetText, String tweetCount, String tweetDate)
  {
    this.id         = UUID.randomUUID().toString();
    this.tweetText  = tweetText;
    this.tweetCount = tweetCount;
    this.tweetDate  = tweetDate;
  }
  
  @Override
  public boolean equals(final Object obj)
  {
    if (obj instanceof Tweet)
    {
      final Tweet other = (Tweet) obj;        
      return     Objects.equal(id,         other.id)
              && Objects.equal(tweetText,  other.tweetText)
              && Objects.equal(tweetCount, other.tweetCount)
              && Objects.equal(tweetDate,  other.tweetDate) ;                  
    }
    else
    {
      return false;
    }
  }  
}

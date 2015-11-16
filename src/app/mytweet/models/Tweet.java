package app.mytweet.models;

import java.util.UUID;

import com.google.common.base.Objects;

import static com.google.common.base.Objects.toStringHelper;

public class Tweet
{

  public String id;
  public String message;
  public String count;
  public String datestamp;


  public Tweet()
  {
  }

  public Tweet(String message, String count, String datestamp)
  {
    this.id = UUID.randomUUID().toString();
    this.message = message;
    this.count = count;
    this.datestamp = datestamp;
  }

  @Override
  public boolean equals(final Object obj)
  {
    if (obj instanceof Tweet)
    {
      final Tweet other = (Tweet) obj;
      return Objects.equal(id, other.id) 
          && Objects.equal(message, other.message) 
          && Objects.equal(count, other.count)
          && Objects.equal(datestamp, other.datestamp);
    }
    else
    {
      return false;
    }
  }
}

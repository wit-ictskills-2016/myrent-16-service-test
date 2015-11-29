package app.models;

import java.util.Date;
import java.util.UUID;

import com.google.common.base.Objects;

public class Tweet
{

  public String id;
  public String message;
  public String count;
  public Long   datestamp;
  

  public Tweet()
  {
    this.id = UUID.randomUUID().toString();
  }

  public Tweet(String message, String count)
  {
    this.id = UUID.randomUUID().toString();
    this.message = message;
    this.count = count;
    this.datestamp = new Date().getTime();
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

package app.models;

import java.util.UUID;

import com.google.common.base.Objects;

public class Tweeter 
{
  public String id;
  public String firstName;
  public String lastName;
  public String email;
  public String password;
  public String geolocation;
  public Double zoom;
 
  public Tweeter()
  {
    this.id = UUID.randomUUID().toString();
  }
  
  public Tweeter(String firstName, String lastName, String email, String password)
  {
    this.id        = UUID.randomUUID().toString();
    this.firstName = firstName;
    this.lastName  = lastName;
    this.email     = email;
    this.password  = password;
    geolocation    = "52.253456,-7.187162";
    zoom           = 16.0;
  } 
  
  @Override
  public boolean equals(final Object obj)
  {
    if (obj instanceof Tweeter)
    {
      final Tweeter other = (Tweeter) obj;
      return Objects.equal(id,         other.id)
          && Objects.equal(firstName,  other.firstName) 
          && Objects.equal(lastName,   other.lastName)
          && Objects.equal(email,      other.email)
          && Objects.equal(password,   other.password)
          && Objects.equal(geolocation,other.geolocation)
          && Objects.equal(zoom,       other.zoom);                               
    }
    else
    {
      return false;
    }
  }  

}
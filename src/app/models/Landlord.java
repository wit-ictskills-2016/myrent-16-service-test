package app.models;

import java.util.UUID;

import com.google.common.base.Objects;

public class Landlord 
{
  public String id;
  public String firstName;
  public String lastName;

 
  public Landlord()
  {
    this.id = UUID.randomUUID().toString();
  }
  
  public Landlord(String firstName, String lastName)
  {
    this.id = UUID.randomUUID().toString();
    this.firstName = firstName;
    this.lastName = lastName;
  } 
  
  @Override
  public boolean equals(final Object obj)
  {
    if (obj instanceof Landlord)
    {
      final Landlord other = (Landlord) obj;
      return Objects.equal(id, other.id)
          && Objects.equal(firstName, other.firstName) 
          && Objects.equal(lastName, other.lastName);                           
    }
    else
    {
      return false;
    }
  }  

}
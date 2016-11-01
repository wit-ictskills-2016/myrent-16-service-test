package app.models;

import java.util.Date;
import java.util.Random;

import com.google.common.base.Objects;

public class Residence
{

  public Long id;
  public String geolocation;
  public Long date;
  public boolean rented;
  public String tenant;
  public double zoom;
  public String photo;


  public Residence()
  {
    id = unsignedLong();
    date = new Date().getTime();
    geolocation = "";
    date = 0L;
    rented = false;
    zoom = 0;
    photo = "";
  }

  /**
   * Generate a long greater than zero
   * 
   * @return Unsigned Long value greater than zero
   */
  private Long unsignedLong() {
    long rndVal = 0;
    do {
      rndVal = new Random().nextLong();
    } while (rndVal <= 0);
    return rndVal;
  }
  @Override
  public boolean equals(final Object obj)  {
    if (obj instanceof Residence)  {
      final Residence other = (Residence) obj;
      return Objects.equal(id, other.id) 
          && Objects.equal(geolocation, other.geolocation)
          && Objects.equal(date, other.date)
          && Objects.equal(rented, other.rented)
          && Objects.equal(tenant, other.tenant)
          && Objects.equal(zoom, other.zoom)
          && Objects.equal(photo, other.photo);
    }
    return false;
  }
}

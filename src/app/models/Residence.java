  package app.models;

import java.util.Date;
import java.util.UUID;

import com.google.common.base.Objects;

public class Residence
{

	public String uuid;
	public String geolocation;
	public Long date;
	public boolean rented;
	public String tenant;
	public double zoom;
	public String photo;
  

  public Residence()
  {
    uuid = UUID.randomUUID().toString();
    date = new Date().getTime();
    geolocation = "";
    date = 0L;
    rented = false;
    zoom = 0;
    photo = "";
  }

  public Residence(Residence other)
  {
	this.uuid = other.uuid;
    this.date = other.date;
	this.geolocation = other.geolocation;
	this.date = other.date;
	this.rented = other.rented;
	this.tenant = other.tenant;
	this.zoom = other.zoom;
	this.photo = other.photo;
  }

  @Override
  public boolean equals(final Object obj)
  {
    if (obj instanceof Residence)
    {
      final Residence other = (Residence) obj;
      return Objects.equal(uuid, other.uuid) 
          && Objects.equal(date, other.date)
          && Objects.equal(geolocation,  other.geolocation)
          && Objects.equal(rented,  other.rented)
          && Objects.equal(tenant,  other.tenant)
          && Objects.equal(zoom, other.zoom)
          && Objects.equal(photo,  other.photo);
    }
    else
    {
      return false;
    }
  }
}

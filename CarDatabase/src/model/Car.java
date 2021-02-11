package model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table (name="inventory")
public class Car {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="NAME")
	private String name;
	@Column(name="YEAR")
	private String year;
	public Car()
	{
		super();
	}
	public Car(int id)
	{
		super();
		this.id = id;
	}
	public Car(String name, String year)
	{
		super();
		this.name = name;
		this.year = year;
	}
	public int getId()
	{
		return id;
	}
	public String getName()
	{
		return name;
	}
	public String getYear()
	{
		return year;
	}
	public String returnFullDetails()
	{
		return "ID:" + id + " Name and year: " + name + ": " + year;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void setYear(String year)
	{
		this.year = year;
	}
	
}

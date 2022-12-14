package model;

public class Flight {
	private int id;
	private String departure_city;
	private String arrival_city;
	private int discount;
	private int cost;
	private int lessCost;
	private String start_time;
	private String end_time;
	private String departure_time;
	private String arrival_time;
	
	
	public Flight() {}
	
	
	
	public Flight(String departure_city, String arrival_city, int discount, int cost, String start_time, String end_time,
			String departure_time, String arrival_time) {
		super();
		this.departure_city = departure_city;
		this.arrival_city = arrival_city;
		this.discount = discount;
		this.cost = cost;
		this.lessCost = cost - ((discount*cost)/100);
		this.start_time = start_time;
		this.end_time = end_time;
		this.departure_time = departure_time;
		this.arrival_time = arrival_time;
	}



	public Flight(int id, String departure_city, String arrival_city, int discount, int cost, String start_time, String end_time,
			String departure_time, String arrival_time) {
		super();
		this.id = id;
		this.departure_city = departure_city;
		this.arrival_city = arrival_city;
		this.discount = discount;
		this.cost = cost;
		this.lessCost = cost - ((discount*cost)/100);
		this.start_time = start_time;
		this.end_time = end_time;
		this.departure_time = departure_time;
		this.arrival_time = arrival_time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDeparture_city() {
		return departure_city;
	}
	public void setDeparture_city(String departure_city) {
		this.departure_city = departure_city;
	}
	public String getArrival_city() {
		return arrival_city;
	}
	public void setArrival_city(String arrival_city) {
		this.arrival_city = arrival_city;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}	
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getlessCost() {
		return lessCost;
	}
	
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String getDeparture_time() {
		return departure_time;
	}
	public void setDeparture_time(String departure_time) {
		this.departure_time = departure_time;
	}
	public String getArrival_time() {
		return arrival_time;
	}
	public void setArrival_time(String arrival_time) {
		this.arrival_time = arrival_time;
	}
	
	
	

}

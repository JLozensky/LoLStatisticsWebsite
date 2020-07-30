package lol.model;

public class Users {
	
	private String summonerName;
	private String firstName;
	private String lastName;
	
	
	public Users(String summonerName, String firstName, String lastName) {
		this.summonerName = summonerName;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	

	public Users(String summonerName) {
		this.summonerName = summonerName;
	}



	public String getSummonerName() {
		return summonerName;
	}


	public void setSummonerName(String summonerName) {
		this.summonerName = summonerName;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	
	

}

package javaproject;

public class DTO {
	private long seatTime;
	private String ID;
	public DTO() {
		
	}
	public DTO(String ID, long seatTime) {
		this.ID=ID;
		this.seatTime=seatTime;
	}
	public void setTime(long time) {
		this.seatTime=time; 
	}
	public void LogingID(String logID) {
		this.ID=logID;
	}
	public long getSeatTime() {
		return seatTime;
	}
	public String getID() {
		return ID;
	}
	public String toString() {
		return "DTO [seatTime= " + seatTime +"ID"+ID+"]";
	}
}


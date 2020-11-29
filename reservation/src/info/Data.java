package info;

public class Data {
	String id;
	String password;
	String name;
	String phonenum;
	String email;
	String birth;
	String seattime;

	public Data() {
	}
    
	public Data(String id, String password, String name, String phonenum, String email, String birth, String seattime) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.phonenum = phonenum;
		this.email = email;
		this.birth = birth;
		this.seattime = seattime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassWord() {
		return password;
	}

	public void setPassWord(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getSeattime() {
		return seattime;
	}

	public void setSeattime(String seattime) {
		this.seattime = seattime;
	}
	
}

package Join;

public class MemberDTO {
	
	private String id;
	private String password;
	private String name;
	private String phone;
	private String mail;
	private String birth;
	
	public MemberDTO() {
		
	}
	
	public MemberDTO(String id, String password, String name, String phone, 
			String mail, String birth) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.mail = mail;
		this.birth = birth;
	}
	
	public String getID() {
		return id;
	}
	
	public void setID(String id) {
		this.id = id;
	}
	
	public String getPWD() {
		return password;
	}
	
	public void setPWD(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getBirth() {
		return birth;
	}
	
	public void setBirth(String birth) {
		this.birth = birth;
	}
	
	public String toString() {
		return "MemberDTO [id= " + id + ", password =" + password + ", name =" + name + "+, phone" + phone +
				", mail" + mail + ", birth" + birth +"]";
	}
	}



package entity;

public class Student {
	private int id;
	private String name;
	private String clas;
	private String addr;
	public Student(){
		
	}
	public Student(int id, String name, String clas, String addr) {
		super();
		this.id = id;
		this.name = name;
		this.clas = clas;
		this.addr = addr;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClas() {
		return clas;
	}
	public void setClas(String clas) {
		this.clas = clas;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
}

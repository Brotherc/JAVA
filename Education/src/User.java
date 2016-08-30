
public class User {
	
	protected int uid;//±àºÅ
	protected String uname;//µÇÂ¼Ãû
	protected String upwd;//µÇÂ¼ÃÜÂë
	protected int upower;//µÇÂ¼È¨ÏÞ
	
	public User() {}
	
	public User(int uid, String uname, String upwd, int upower) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upwd = upwd;
		this.upower = upower;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public int getUpower() {
		return upower;
	}
	public void setUpower(int upower) {
		this.upower = upower;
	}
	
	@Override
	public String toString() {
		return "µÇÂ¼Ãû:"+uname+" µÇÂ¼ÃÜÂë:"+upwd;
	}

	public void loginSystem(String name,String upwd){
		if(this.uname==name&&this.upwd==upwd)
			System.out.println("µÇÂ¼³É¹¦");
		else System.out.println("µÇÂ¼Ê§°Ü");
	}
	
}


public class User {
	
	protected int uid;//���
	protected String uname;//��¼��
	protected String upwd;//��¼����
	protected int upower;//��¼Ȩ��
	
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
		return "��¼��:"+uname+" ��¼����:"+upwd;
	}

	public void loginSystem(String name,String upwd){
		if(this.uname==name&&this.upwd==upwd)
			System.out.println("��¼�ɹ�");
		else System.out.println("��¼ʧ��");
	}
	
}

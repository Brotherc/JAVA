
public class Student extends User{

	private int sid;//编号
	private String sno;//学号
	private String sname;//姓名
	private String sex;//性别
	private String sdate;//出生日期
	private String stel;//电话
	private String sadd;//地址
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public String getStel() {
		return stel;
	}
	public void setStel(String stel) {
		this.stel = stel;
	}
	public String getSadd() {
		return sadd;
	}
	public void setSadd(String sadd) {
		this.sadd = sadd;
	}
	
	public Student(int sid, String sno, String sname, String sex, String sdate, String stel, String sadd){
		this.sid = sid;
		this.sno = sno;
		this.sname = sname;
		this.sex = sex;
		this.sdate = sdate;
		this.stel = stel;
		this.sadd = sadd;
	}
	
	public Student(int sid, String sno, String sname, String sex, String sdate, String stel, String sadd,int uid, String uname, String upwd, int upower) {
		super(uid, uname, upwd,upower);
		this.sid = sid;
		this.sno = sno;
		this.sname = sname;
		this.sex = sex;
		this.sdate = sdate;
		this.stel = stel;
		this.sadd = sadd;
	}
	public Student() {}
	public void introduction(){
		System.out.println("编号:"+sid+" 学号:"+sno+" 姓名:"+sname+" 性别:"+sex+" 出生日期:"+sdate+" 电话:"+stel+" 地址:"+sadd);
	}
	
	@Override
	public String toString() {
		return "编号:"+sid+" 学号:"+sno+" 姓名:"+sname+" 性别:"+sex+" 出生日期:"+sdate+" 电话:"+stel+" 地址:"+sadd;
	}
}

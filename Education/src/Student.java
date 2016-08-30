
public class Student extends User{

	private int sid;//���
	private String sno;//ѧ��
	private String sname;//����
	private String sex;//�Ա�
	private String sdate;//��������
	private String stel;//�绰
	private String sadd;//��ַ
	
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
		System.out.println("���:"+sid+" ѧ��:"+sno+" ����:"+sname+" �Ա�:"+sex+" ��������:"+sdate+" �绰:"+stel+" ��ַ:"+sadd);
	}
	
	@Override
	public String toString() {
		return "���:"+sid+" ѧ��:"+sno+" ����:"+sname+" �Ա�:"+sex+" ��������:"+sdate+" �绰:"+stel+" ��ַ:"+sadd;
	}
}

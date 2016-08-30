import java.util.Scanner;
public class StudentMenu {
	
	private IStudentDao studentdao;
	private Scanner sc;

	public StudentMenu() {}

	public StudentMenu(IStudentDao studentdao) {
		this.studentdao = studentdao;
		sc=new Scanner(System.in);
	}

	public IStudentDao getStudentdao() {
		return studentdao;
	}

	public void setStudentdao(IStudentDao studentdao) {
		this.studentdao = studentdao;
	}
	
	public void mainMenu(){
		System.out.println("===========================");
		System.out.println("1.����ѧ��");
		System.out.println("2.ɾ��ѧ��");
		System.out.println("3.�޸�ѧ��");
		System.out.println("4.��ѯѧ��");
		System.out.println("5.��ʾȫ��");
		System.out.println("6.��¼");
		System.out.println("7.�˳�");
		System.out.println("===========================");
		System.out.println("��ѡ��(0-7)");
		int choic=chickInt();
		switch(choic){
		case 1:
			insert();
			break;
		case 2:
			delete();
			break;
		case 3:
			update();
			break;
		case 4:
			search();
			break;
		case 5:
			showAll();
			break;
		case 6:
			login();
			break;
		case 7:
			System.out.println("====>���Ѿ��˳�!лл~");
			System.exit(0);
		default:	
			System.out.println("====>��������ϵͳ��ֹ");
			System.exit(-1);
		}
	}
	
	public void insert(){
		System.out.println("====>����ѧ��");
		System.out.println("��������");
		int sid=sc.nextInt();
		System.out.println("������ѧ��");
		String sno=sc.next();
		System.out.println("����������");
		String sname=sc.next();
		System.out.println("�������Ա�");
		String sex=sc.next();
		System.out.println("�������������****-**-**");
		String sdate=sc.next();
		System.out.println("������绰");
		String stel=sc.next();
		System.out.println("�������ַ");
		String sadd=sc.next();
		Student stu=new Student(sid,sno,sname,sex,sdate,stel,sadd);
		if(studentdao.insert(stu)){
			System.out.println("====>�����ɹ�");
		}else{
			System.out.println("====>����ʧ��");
		}
		returnMain();
	}
	public void delete(){
		System.out.println("====>ɾ��ѧ��");
		System.out.println("��������");
		int sid=sc.nextInt();
		if(studentdao.delete(sid)){
			System.out.println("====>ɾ���ɹ�");
		}else{
			System.out.println("====>ɾ��ʧ��");
		}
		returnMain();
	}
	public void update(){
		System.out.println("====>�޸�ѧ��");
		System.out.println("��������Ҫ�޸ĵ�ѧ�����");
		int sid=sc.nextInt();
		System.out.println("�������µ�ѧ��");
		String sno=sc.next();
		System.out.println("�������µ�����");
		String sname=sc.next();
		System.out.println("�������µ��Ա�");
		String sex=sc.next();
		System.out.println("�������µĳ�������****-**-**");
		String sdate=sc.next();
		System.out.println("�������µĵ绰");
		String stel=sc.next();
		System.out.println("�������µĵ�ַ");
		String sadd=sc.next();
		Student s=new Student(sid, sno, sname, sex, sdate, stel, sadd);
		if(studentdao.updata(s)){
			System.out.println("====>�޸ĳɹ�");
		}else{
			System.out.println("====>�޸�ʧ��");
		}
		returnMain();
	}
	public void search(){
		System.out.println("====>��ѯѧ��");
		System.out.println("��������");
		int sid=sc.nextInt();
		Student s=studentdao.search(sid);
		if(s!=null){
			System.out.println("====>��ѯ�ɹ� "+s.toString());
		}else{
			System.out.println("====>��ѯʧ��");
		}
		returnMain();
	}
	public void showAll(){
		studentdao.showAll();
		returnMain();
	}
	
	public void login(){
		System.out.println("====>��¼ϵͳ");
		Tools tools=new Tools();
		String code=tools.getCode();
		System.out.println("��֤��:"+code);
		System.out.println("�������¼��");
		String sname=sc.next();
		System.out.println("�������¼����");
		String spwd=sc.next();
		System.out.println("��������֤��");
		String scode=sc.next();
		Student student=studentdao.login(sname, spwd);
		if(student!=null&&scode.equals(code)){
			System.out.println("====>��½�ɹ�");
		}else {
			System.out.println("====>��¼ʧ��");
		}
		mainMenu();
	}
	
	public void returnMain(){
		System.out.println("����0����");
		int n=sc.nextInt();
		while(n!=0){
			System.out.println("");
			n=sc.nextInt();
		}
		mainMenu();
	}
	private int chickInt(){
		int n=0;
		while(true){
			String s=sc.next();
			if(s.matches("[1234567]")){
				n=Integer.parseInt(s);break;
			}else{
				System.out.println("��������������0-7���ڵ�����");
			}
		}
		return n;
	}
}

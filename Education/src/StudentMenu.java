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
		System.out.println("1.新增学生");
		System.out.println("2.删除学生");
		System.out.println("3.修改学生");
		System.out.println("4.查询学生");
		System.out.println("5.显示全部");
		System.out.println("6.登录");
		System.out.println("7.退出");
		System.out.println("===========================");
		System.out.println("请选择(0-7)");
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
			System.out.println("====>您已经退出!谢谢~");
			System.exit(0);
		default:	
			System.out.println("====>输入有误，系统终止");
			System.exit(-1);
		}
	}
	
	public void insert(){
		System.out.println("====>新增学生");
		System.out.println("请输入编号");
		int sid=sc.nextInt();
		System.out.println("请输入学号");
		String sno=sc.next();
		System.out.println("请输入姓名");
		String sname=sc.next();
		System.out.println("请输入性别");
		String sex=sc.next();
		System.out.println("请输入出生日期****-**-**");
		String sdate=sc.next();
		System.out.println("请输入电话");
		String stel=sc.next();
		System.out.println("请输入地址");
		String sadd=sc.next();
		Student stu=new Student(sid,sno,sname,sex,sdate,stel,sadd);
		if(studentdao.insert(stu)){
			System.out.println("====>新增成功");
		}else{
			System.out.println("====>新增失败");
		}
		returnMain();
	}
	public void delete(){
		System.out.println("====>删除学生");
		System.out.println("请输入编号");
		int sid=sc.nextInt();
		if(studentdao.delete(sid)){
			System.out.println("====>删除成功");
		}else{
			System.out.println("====>删除失败");
		}
		returnMain();
	}
	public void update(){
		System.out.println("====>修改学生");
		System.out.println("请输入需要修改的学生编号");
		int sid=sc.nextInt();
		System.out.println("请输入新的学号");
		String sno=sc.next();
		System.out.println("请输入新的姓名");
		String sname=sc.next();
		System.out.println("请输入新的性别");
		String sex=sc.next();
		System.out.println("请输入新的出生日期****-**-**");
		String sdate=sc.next();
		System.out.println("请输入新的电话");
		String stel=sc.next();
		System.out.println("请输入新的地址");
		String sadd=sc.next();
		Student s=new Student(sid, sno, sname, sex, sdate, stel, sadd);
		if(studentdao.updata(s)){
			System.out.println("====>修改成功");
		}else{
			System.out.println("====>修改失败");
		}
		returnMain();
	}
	public void search(){
		System.out.println("====>查询学生");
		System.out.println("请输入编号");
		int sid=sc.nextInt();
		Student s=studentdao.search(sid);
		if(s!=null){
			System.out.println("====>查询成功 "+s.toString());
		}else{
			System.out.println("====>查询失败");
		}
		returnMain();
	}
	public void showAll(){
		studentdao.showAll();
		returnMain();
	}
	
	public void login(){
		System.out.println("====>登录系统");
		Tools tools=new Tools();
		String code=tools.getCode();
		System.out.println("验证码:"+code);
		System.out.println("请输入登录名");
		String sname=sc.next();
		System.out.println("请输入登录密码");
		String spwd=sc.next();
		System.out.println("请输入验证码");
		String scode=sc.next();
		Student student=studentdao.login(sname, spwd);
		if(student!=null&&scode.equals(code)){
			System.out.println("====>登陆成功");
		}else {
			System.out.println("====>登录失败");
		}
		mainMenu();
	}
	
	public void returnMain(){
		System.out.println("输入0返回");
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
				System.out.println("输入有误，请输入0-7以内的整数");
			}
		}
		return n;
	}
}

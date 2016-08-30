
public class Test {

	public static void main(String[] args) {
		Student stu1=new Student(01, "1", "a", "boy", "1", "1", "1", 01, "a", "a", 1);
		Student stu2=new Student(02, "2", "b", "boy", "2", "2", "2", 02, "b", "b", 2);
		Student stu3=new Student(03, "3", "c", "boy", "3", "3", "3", 03, "c", "c", 3);
		StudentDao studentDao=new StudentDao();
		studentDao.insert(stu1);
		studentDao.insert(stu2);
		studentDao.insert(stu3);
		StudentMenu studentMenu=new StudentMenu(studentDao);
		studentMenu.login();
	}

}

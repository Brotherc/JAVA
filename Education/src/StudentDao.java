import java.util.ArrayList;
import java.util.List;

public class StudentDao implements IStudentDao {
	private List<Student> stuList;

	public StudentDao() {
		stuList=new ArrayList<Student>();
	}

	public StudentDao(List<Student> stuList) {
		super();
		this.stuList = stuList;
	}

	public List<Student> getStuList() {
		return stuList;
	}

	public void setStuList(List<Student> stuList) {
		this.stuList = stuList;
	}
	
	@Override
	public boolean insert(Student s) {
		return stuList.add(s);
	}
	

	@Override
	public boolean delete(int sid) {
		for(Student s:stuList){
			if(s.getSid()==sid){
				System.out.println(s.toString());
				return stuList.remove(s);
			}
		}
		return false;
	}

	@Override
	public boolean updata(Student s) {
		for(int i=0;i<stuList.size();i++){
			if(s.getSid()==stuList.get(i).getSid()){
				stuList.add(i, s);
				return true;
			}
		}
		return false;
	}

	@Override
	public Student search(int sid) {
		for(Student s:stuList){
			if(s.getSid()==sid){
				return s;
			}
		}
		return null;
	}

	@Override
	public void showAll() {
		for(Student s:stuList){
			System.out.println(s.toString());
		}
	}

	@Override
	public Student login(String pname, String pwad) {
		Student stu=null;
		for(Student s:stuList){
			if(s.getUname().equals(pname)&&s.getUpwd().equals(pwad)){
				stu=s;
				break;
			}
		}
		return stu;
	}
	
}

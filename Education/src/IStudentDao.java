
public interface IStudentDao {
	public boolean insert(Student s);
	public boolean delete(int sid);
	public boolean updata(Student s);
	public Student search(int sid);
	public void showAll();
	public Student login(String pname,String pwad);
}

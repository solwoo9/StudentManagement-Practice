import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {
   
	
	// 메모리 저장
	private final List<Student> students = new ArrayList<>();
	private int nextId = 1;
	
	public StudentRepositoryImpl() {
		System.out.println("StudentRepository 생성");
	}
	
	
	
	
	@Override
    public List<Student> findAll() {
        return new ArrayList<>(students);
    }

    @Override
    public Student findById(int id) {
    	for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
    	}
        return null;
    }

    @Override
    public void save(Student student) {
    	student = new Student(nextId++,student.getName(),student.getMajor());
    	students.add(student);
    }

    @Override
    public Student update(int id, Student updatedStudent) {
        for (Student student : students) {
            if (student.getId() == id) {
                student.setName(updatedStudent.getName());
                student.setMajor(updatedStudent.getMajor());
                return student;
            }
        }
        return null;
    }
    @Override
    public boolean delete(int id) {
        return students.removeIf(student -> student.getId() == id);
    }
}

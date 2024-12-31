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
//        return students 로해도 되나 원본을 지키기 위해 사용하지않는다
    }

    @Override
    public Student findById(int id) {
    	for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
    	}
    	
//    	for(int i = 0 ; i < students.size() ; i++) {
//    		if (students.get(i).getId() == id) {
//    			return students.get(i);
//    		}
//    	}
    	
    	// 람다표현식 기본 문법
    	// (매개변수) -> {본문}
//    	Student result = null;
//    	students.forEach((student) -> {
//    		if(student.getId() == id) {
//    			result = student;
//    		}
//    	});
        return null;
    }

    	
    
    
    @Override
    public void save(Student student) {
    	student = new Student(nextId++,student.getName(),student.getMajor());
    	students.add(student);
    }

    @Override
    public Student update(int id, Student updatedStudent) {
//        for (Student student : students) {
//            if (student.getId() == id) {
//                student.setName(updatedStudent.getName());
//                student.setMajor(updatedStudent.getMajor());
//                return student;
//            }
//        }
        
        Student student = findById(id);
        if(student != null) {
        	student.setName(updatedStudent.getName());
        	student.setMajor(updatedStudent.getMajor());
        }
        return null;
    }
    @Override
    public void delete(int id) {
//        return students.removeIf(student -> student.getId() == id);      
        for(int i = 0 ; i < students.size() ; i++) {
    		if (students.get(i).getId() == id) {
    			students.remove(i);
    			break;
    		}
    		}
        
    }
}

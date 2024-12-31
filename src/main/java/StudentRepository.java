import java.util.List;

interface StudentRepository {
    // 모든 학생정보 조회
    List<Student> findAll();
    // 학생 ID로 학생정보 조회
    Student findById(int id);
    // 학생정보 저장
    void save(Student student);
    // 학생정보 수정
    Student update(int id, Student updatedStudent);
    // 학생정보 삭제
    boolean delete(int id);
}

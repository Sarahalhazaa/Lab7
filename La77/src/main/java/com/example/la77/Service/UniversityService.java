package com.example.la77.Service;

import com.example.la77.Model.Course;
import com.example.la77.Model.Student;
import com.example.la77.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class UniversityService {

    ArrayList<Student> students = new ArrayList<>();
    ArrayList<Teacher> teachers = new ArrayList<>();
    ArrayList<Course> course = new ArrayList<>();

    public ArrayList<Course> getCourse() {
        return course;
    }

    public void addCourse(Course course) {
        this.course.add(course);
    }

    public boolean updateCourse(String id, Course course) {

        for (int i = 0; i < this.course.size(); i++) {
            if (this.course.get(i).getId().equalsIgnoreCase(id)) {
                this.course.set(i, course);
                return true;
            }
        }
        return false;
    }

    public boolean deleteCourse(String id) {
        for (int i = 0; i < this.course.size(); i++) {
            if (this.course.get(i).getId().equalsIgnoreCase(id)) {
                this.course.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Student> getStudent() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public boolean updateStudent(String id, Student student) {

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equalsIgnoreCase(id)) {
                students.set(i, student);
                return true;
            }
        }
        return false;
    }

    public boolean deleteStudent(String id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equalsIgnoreCase(id)) {
                students.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public boolean updateTeacher(String id, Teacher teacher) {

        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId().equalsIgnoreCase(id)) {
                teachers.set(i, teacher);
                return true;
            }
        }
        return false;
    }

    public boolean deleteTeacher(String id) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId().equalsIgnoreCase(id)) {
                teachers.remove(i);
                return true;
            }
        }
        return false;
    }

//-------------------------------------end CRUD -------------------------------------

//-------------------------------------    الطالب     -----------------------------------


    //-------الطالب يضيف كورس الي جدولة الدراسي بشرط لا تزيد عدد الساعات المسجله له عن 15 ساعه------
    public boolean addCourseToStudentSchedule(String id, String Id) {
        int total = 0;
        int h = 0;
        for (int i = 0; i < this.course.size(); i++) {
            if (this.course.get(i).getId().equalsIgnoreCase(Id)) {
                Course course1 = course.get(i);
                h = course.get(i).getHours();
                for (int j = 0; j < students.size(); j++) {
                    if (students.get(j).getId().equalsIgnoreCase(id)) {
                        for (int u = 0; u < students.get(j).getSchedule().size(); u++) {
                            total += students.get(j).getSchedule().get(u).getHours();
                        }
                        if (total + h <= 15)
                            students.get(j).getSchedule().add(course1);
                        return true;
                    }
                }
            }

        }
        return false;
    }

    //-----------------الطالب يعرض جدولة الدراسي كامل -----------------
    public ArrayList<Course> StudentSchedule(String id) {
        for (int j = 0; j < students.size(); j++) {
            if (students.get(j).getId().equalsIgnoreCase(id)) {
                return students.get(j).getSchedule();
            }
        }
        return null;

    }

    //-----الطالب يعرض جدول يوم واحد فقط من ايام الاسبوع ------
    public ArrayList<Course> StudentScheduleForOneDay(String id, String day) {
        ArrayList<Course> courses = new ArrayList<>();
        for (int j = 0; j < students.size(); j++) {
            if (students.get(j).getId().equalsIgnoreCase(id)) {
                for (int u = 0; u < students.get(j).getSchedule().size(); u++) {
                    if (students.get(j).getSchedule().get(u).getDay().equalsIgnoreCase(day))
                        courses.add(students.get(j).getSchedule().get(u));
                }

            }
        }
        return courses;
    }

    // ----الطالب يحذف كورس من جدوله الدراسي------
    public boolean deleteCourseFromStudentSchedule(String id, String Id) {

        for (int j = 0; j < students.size(); j++) {
            if (students.get(j).getId().equalsIgnoreCase(id)) {
                for (int u = 0; u < students.get(j).getSchedule().size(); u++) {
                    if (students.get(j).getSchedule().get(u).getId().equalsIgnoreCase(Id)) {
                        students.get(j).getSchedule().remove(u);
                        return true;
                    }
                }
            }
        }
        return false;
    }


    //-------------------------------------     المعلم     -------------------------------------


    //--------------------- المعلم يضيف كورس الي جدولة -----------------
    public boolean addCourseToTeacherSchedule(String id, String Id) {
        for (int i = 0; i < this.course.size(); i++) {
            if (this.course.get(i).getId().equalsIgnoreCase(Id)) {
                Course course1 = course.get(i);
                for (int j = 0; j < teachers.size(); j++) {
                    if (teachers.get(j).getId().equalsIgnoreCase(id)) {
                        teachers.get(j).getSchedule().add(course1);
                        return true;
                    }
                }
            }

        }
        return false;
    }

    //------المعلم يعديل درجه طالب في صفه ------
    public boolean UpdateGrade(String id, String Id, String ID, int grade) {
        for (int j = 0; j < teachers.size(); j++) {
            if (teachers.get(j).getId().equalsIgnoreCase(ID)) {
                for (int u = 0; u < teachers.get(j).getSchedule().size(); u++) {
                    if (teachers.get(j).getSchedule().get(u).getId().equalsIgnoreCase(Id)) {
                        for (int i = 0; i < students.size(); j++) {
                            if (students.get(i).getId().equalsIgnoreCase(id)) {
                                for (int q = 0; u < students.get(i).getSchedule().size(); q++) {
                                    if (students.get(i).getSchedule().get(q).getId().equalsIgnoreCase(Id)) {
                                        students.get(i).getSchedule().get(q).setGrade(grade);
                                        return true;
                                    }}}}}}}}
        return false;
}

//----المعلم يعرض اسماء الطلاب المسجلين في صفه ------

    public ArrayList<Student> nameStudentOfCourse(String id, String Id) {

        ArrayList<Student> students1 = new ArrayList<>();
        for (int j = 0; j < teachers.size(); j++) {
            if (teachers.get(j).getId().equalsIgnoreCase(id)) {
                for (int u = 0; u < teachers.get(j).getSchedule().size(); u++) {
                    if (teachers.get(j).getSchedule().get(u).getId().equalsIgnoreCase(Id)) {
                        for (int i = 0; i < students.size(); j++) {
                            for (int q = 0; q < students.get(i).getSchedule().size(); q++) {
                                if (students.get(i).getSchedule().get(q).getId().equalsIgnoreCase(Id)) {
                                    students1.add(students.get(i));
                                }
                            }
                        }
                    }
                }
            }
        }
        return students1;
    }


    //------المعلم يعرض متوسط درجات الطلاب في كورس معين  -------

    public double AverageGradesOfStudents(String id, String Id) {

        double AverageGrades=0;
        int count=0;
        double total=0;
        for (int j = 0; j < teachers.size(); j++) {
            if (teachers.get(j).getId().equalsIgnoreCase(id)) {
                for (int u = 0; u < teachers.get(j).getSchedule().size(); u++) {
                    if (teachers.get(j).getSchedule().get(u).getId().equalsIgnoreCase(Id)) {
                        for (int i = 0; i < students.size(); j++) {
                            for (int q = 0; u < students.get(i).getSchedule().size(); q++) {
                                if (students.get(i).getSchedule().get(q).getId().equalsIgnoreCase(Id)) {
                                   total+=students.get(i).getSchedule().get(q).getGrade();
                                   count++;
                                }
                            }
                        }
                    }
                }
            }
        }
        if(count!=0)
        return AverageGrades=total/count;
        return 0;
    }


    //--------------------------------------   الكورس   --------------------------------------


    //------عرض رقم كلاس لكورس معين ( موقعه) ووقته ويومه -------

        public String informationOfCourse(String id) {
            for (int j = 0; j < course.size(); j++) {
                if (course.get(j).getId().equalsIgnoreCase(id)) {
                    return "name: "+course.get(j).getNameCourse() +"Day: " +course.get(j).getDay() +" Time: "+course.get(j).getTime();
                }}
            return null;
        }

    //-----------   عرض اسماء الاساتذه لكورس معين ----------
    public ArrayList<Teacher> TeacherOfCourse(String name) {

 ArrayList<Teacher> teachers1 = new ArrayList<>();
        for (int j = 0; j < course.size(); j++) {
            if (course.get(j).getNameCourse().equalsIgnoreCase(name)) {
                for (int i = 0; i < teachers.size(); i++) {
                        for (int u = 0; u < teachers.get(i).getSchedule().size(); u++) {
                            if (teachers.get(i).getSchedule().get(u).getNameCourse().equalsIgnoreCase(name)) {
                                teachers1.add(teachers.get(i));
                            }}}}}
                return teachers1;
    }
  // ------- تحديث رقم الكلاس لكورس معين ----------
    public boolean updateClassNumber(String id , String ClassNumber){
        for (int j = 0; j < course.size(); j++) {
            if (course.get(j).getId().equalsIgnoreCase(id)) {
                course.get(j).setNumberClass(ClassNumber);
                return true;
            }

    }
        return false;
    }

 //--------- عرض كورسات يوم معين -----------

    public ArrayList<Course> coursesOfDay(String day){
        ArrayList<Course> course1= new ArrayList<>();
        for (int j = 0; j < course.size(); j++) {
            if (course.get(j).getDay().equalsIgnoreCase(day)) {
                course1.add(course.get(j));

            }

        }
        return course1;
    }



}

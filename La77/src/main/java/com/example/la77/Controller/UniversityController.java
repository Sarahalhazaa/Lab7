package com.example.la77.Controller;

import com.example.la77.Api.ApiResponse;
import com.example.la77.Model.Course;
import com.example.la77.Model.Student;
import com.example.la77.Model.Teacher;
import com.example.la77.Service.UniversityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/vi/University")
@RequiredArgsConstructor
public class UniversityController {
    private final UniversityService universityService;

    @GetMapping("/getCourse")
    public ResponseEntity getCourse(){
        ArrayList<Course> course = universityService.getCourse();
        return ResponseEntity.status(200).body(course);

    }

    @PostMapping("/addCourse")
    public ResponseEntity addCourse(@RequestBody @Valid Course course , Errors errors){

        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        universityService.addCourse(course);
        return ResponseEntity.status(200).body(new ApiResponse("Course added"));

    }
    @PutMapping("/updateCourse/{id}")
    public ResponseEntity updateCourse(@PathVariable String id, @RequestBody @Valid Course course , Errors errors){

        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated= universityService.updateCourse(id,course);
        if(isUpdated){
            return ResponseEntity.status(200).body(new ApiResponse("Course updated"));}
        return ResponseEntity.status(400).body(new ApiResponse("Course not updated"));

    }
    @DeleteMapping("/deleteCourse/{id}")
    public ResponseEntity deleteCourse(@PathVariable String id){

        boolean isdeleted= universityService.deleteCourse(id);
        if(isdeleted){
            return ResponseEntity.status(200).body(new ApiResponse("Course deleted"));}
        return ResponseEntity.status(400).body(new ApiResponse("Course not deleted"));

    }



    @GetMapping("/getStudent")
    public ResponseEntity getStudent(){
        ArrayList<Student> students = universityService.getStudent();
        return ResponseEntity.status(200).body(students);

    }

    @PostMapping("/addStudent")
    public ResponseEntity addStudent(@RequestBody @Valid Student student , Errors errors){

        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        universityService.addStudent(student);
        return ResponseEntity.status(200).body(new ApiResponse("Student added"));

    }
    @PutMapping("/updateStudent/{id}")
    public ResponseEntity updateStudent(@PathVariable String id, @RequestBody @Valid Student student , Errors errors){

        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated= universityService.updateStudent(id,student);
        if(isUpdated){
            return ResponseEntity.status(200).body(new ApiResponse("Student updated"));}
        return ResponseEntity.status(400).body(new ApiResponse("Student not updated"));

    }
    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity deleteStudent(@PathVariable String id){

        boolean isdeleted= universityService.deleteStudent(id);
        if(isdeleted){
            return ResponseEntity.status(200).body(new ApiResponse("Student deleted"));}
        return ResponseEntity.status(400).body(new ApiResponse("Student not deleted"));

    }

    @GetMapping("/getTeacher")
    public ResponseEntity getTeacher(){
        ArrayList<Teacher> teachers = universityService.getTeachers();
        return ResponseEntity.status(200).body(teachers);

    }
    @PostMapping("addTeacher")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher, Errors errors){

        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        universityService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher added"));

    }
    @PutMapping("/updateTeacher/{id}")
    public ResponseEntity updateTeacher(@PathVariable String id, @RequestBody @Valid Teacher teacher , Errors errors){

        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated= universityService.updateTeacher(id, teacher);
        if(isUpdated){
            return ResponseEntity.status(200).body(new ApiResponse("Teacher updated"));}
        return ResponseEntity.status(400).body(new ApiResponse("Teacher not updated"));

    }
    @DeleteMapping("/deleteTeacher/{id}")
    public ResponseEntity deleteTeacher(@PathVariable String id){

        boolean isdeleted= universityService.deleteTeacher(id);
        if(isdeleted){
            return ResponseEntity.status(200).body(new ApiResponse("Teacher deleted"));}
        return ResponseEntity.status(400).body(new ApiResponse("Teacher not deleted"));

    }

//------------------------------------------------end CRUD-----------------------------------

// ---------------------------------     الطالب      -------------------------------

    @PostMapping("addCourseToStudent/{id}/{ID}")
    public ResponseEntity addCourseToStudentSchedule(@PathVariable String id,@PathVariable String ID){

        boolean isAdded=  universityService.addCourseToStudentSchedule(id,ID);
        if (isAdded){
        return ResponseEntity.status(200).body(new ApiResponse(" Course Added"));}
        return ResponseEntity.status(400).body(new ApiResponse("Course not Added"));


    }
@GetMapping("/StudentSchedule/{id}")
    public ResponseEntity StudentSchedule(@PathVariable String id){
        ArrayList<Course> course1 = universityService.StudentSchedule(id);
        return ResponseEntity.status(200).body(course1);

    }

    @GetMapping("/StudentScheduleForOneDay/{id}/{day}")
    public ResponseEntity StudentScheduleForOneDay(@PathVariable String id,@PathVariable String day){
        ArrayList<Course> course1 = universityService.StudentScheduleForOneDay(id,day);
        return ResponseEntity.status(200).body(course1);

    }

    @DeleteMapping("/deleteCourseFromStudentSchedule/{id}/{ID}")
    public ResponseEntity deleteCourseFromStudentSchedule(@PathVariable String id,@PathVariable String ID){

        boolean isdeleted= universityService.deleteCourseFromStudentSchedule(id,ID);
        if(isdeleted){
            return ResponseEntity.status(200).body(new ApiResponse("Course deleted"));}
        return ResponseEntity.status(400).body(new ApiResponse("Course not deleted"));

    }

//-----------------------------    المعلم    -------------------------------
@PostMapping("addCourseToTeacherSchedule/{id}/{ID}")
public ResponseEntity addCourseToTeacherSchedule(@PathVariable String id,@PathVariable String ID){

    boolean isAdded=  universityService.addCourseToTeacherSchedule(id,ID);
    if (isAdded){
        return ResponseEntity.status(200).body(new ApiResponse(" Course Added"));}
    return ResponseEntity.status(400).body(new ApiResponse("Course not Added"));


}

    @PutMapping("/UpdateGrade/{id}/{Id}/{ID}/{grade}")
    public ResponseEntity  UpdateGrade(@PathVariable String id, @PathVariable String Id , @PathVariable String ID, @PathVariable int grade ){

        boolean isUpdated= universityService.UpdateGrade(id,Id,ID,grade);
        if(isUpdated){
            return ResponseEntity.status(200).body(new ApiResponse("grade updated"));}
        return ResponseEntity.status(400).body(new ApiResponse("grade not updated"));

    }


    @GetMapping("/nameStudentOfCourse/{id}/{Id}")
    public ResponseEntity nameStudentOfCourse(@PathVariable String id, @PathVariable String Id){
        ArrayList<Student> students = universityService.nameStudentOfCourse(id,Id);
        return ResponseEntity.status(200).body(students);

    }

    @GetMapping("/AverageGradesOfStudents/{id}/{Id}")
    public ResponseEntity AverageGradesOfStudents(@PathVariable String id, @PathVariable String Id){
        double AverageGrades = universityService.AverageGradesOfStudents(id,Id);
        return ResponseEntity.status(200).body(AverageGrades);

    }

    //------------------------------     الكورس      -----------------------------------

    @GetMapping("/informationOfCourse/{id}")
    public ResponseEntity informationOfCourse(@PathVariable String id) {
       String course = universityService.informationOfCourse(id);
        if (course == null) {
            return ResponseEntity.status(400).body(new ApiResponse("Course not found"));
        }
        return ResponseEntity.status(200).body(new ApiResponse("Course found: "+course));
    }


    @GetMapping("/TeacherOfCourse/{name}")
    public ResponseEntity  TeacherOfCourse(@PathVariable String name){
        ArrayList<Teacher> teachers = universityService.TeacherOfCourse(name);
        return ResponseEntity.status(200).body(teachers);

    }

    @PutMapping("/updateClassNumber/{id}/{ClassNumber}")
    public ResponseEntity updateClassNumber(@PathVariable String id, @PathVariable String ClassNumber){
        boolean isUpdated= universityService.updateClassNumber(id,ClassNumber);
        if(isUpdated){
            return ResponseEntity.status(200).body(new ApiResponse("ClassNumber updated"));}
        return ResponseEntity.status(400).body(new ApiResponse("ClassNumber not updated"));

    }

    @GetMapping("/coursesOfDay/{day}")
    public ResponseEntity coursesOfDay(@PathVariable String day){
        ArrayList<Course> course1 = universityService.coursesOfDay(day);
        return ResponseEntity.status(200).body(course1);

    }
}

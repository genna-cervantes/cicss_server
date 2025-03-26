package ust.com.cicss.controllers;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import ust.com.cicss.dao.CourseOfferingsRepository;
import ust.com.cicss.dao.CourseRepository;
import ust.com.cicss.models.Course;
import ust.com.cicss.models.CourseDTO;

@RestController
@RequestMapping("/courseofferings")
public class CourseOfferingsController {

    @Autowired
    private CourseOfferingsRepository COrepo;

    @Autowired
    private CourseRepository Crepo;

    @PreAuthorize("hasAuthority('ROLE_Department_Chair')")
    @GetMapping("/{year}/{semester}/{department}")
    public List<CourseDTO> getCourseOfferings(@PathVariable(name = "year") int year, @PathVariable(name = "semester") int semester, @PathVariable(name = "department") String department) {
        // SELECT c.course_id, c.name, c.subject_code, c.total_units, c.type
        // FROM courses c
        // JOIN curriculum cur ON c.course_id = ANY(cur.courses)
        // WHERE cur.year = $1 AND cur.semester = $2 AND cur.department = $3;

        return COrepo.getCourseOfferings(year, semester, department); //returns a list of courses based on year, semester, and department
    }

    @PreAuthorize("hasAuthority('ROLE_Department_Chair')")
    @PostMapping("/{year}/{semester}/{department}")
    public void addCourseToCourseOfferings(@RequestBody Course course, @PathVariable int year, @PathVariable int semester, @PathVariable String department) {
        // 2 ung queries na need gawin nito
        // generate course id CR + random string of length 8 so 'CRRwSJc1Ec'
        String randomString = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
        String courseId = "CR" + randomString;
        course.setCourseId(courseId);

        if (course.getTotalUnits() == 3) {
            course.setUnitsPerClass(1.5f);
        } else {
            course.setUnitsPerClass(course.getTotalUnits());
        }

        // INSERT INTO courses (course_id, subject_code, units_per_class, type, category, restrictions, total_units, specific_room_assignment) VALUES (...ung values) -- nasa req body toh dapat lahat
        Crepo.save(course);
        // UPDATE curriculum
        // SET courses = ARRAY_APPEND(courses, $4)
        // WHERE year = $1 AND semester = $2 AND department = $3;
        COrepo.updateCourseOfferings(year, semester, department, course.getSubjectCode());
    }

    @PreAuthorize("hasAuthority('ROLE_Department_Chair')")
    @PutMapping("/{year}/{semester}/{department}")
    public void updateCourseOfferings(@RequestBody Map<String, Object> updates, @PathVariable double year, @PathVariable double semester, @PathVariable String department) {

        if (updates.get("courseCodeKey") == null) {
            throw new IllegalArgumentException("Missing courseCode for update");
        }

        // UPDATE teaching_academic_staff updatecolumn = updatedcolvalue WHERE tas_id = tas_id
        String courseCode = String.valueOf(updates.get("courseCodeKey"));
        ObjectMapper mapper = new ObjectMapper();
        String column = "";
        Object value = null;

        for (Map.Entry<String, Object> entry : updates.entrySet()) {

            if (entry.getKey().equals("courseCodeKey")) {
                continue;
            }

            column = entry.getKey(); // Next key as column
            value = entry.getValue(); // Next value
            System.out.println("course code: " + courseCode + ", column: " + column + ", value: " + value);

            switch (column) {
                case "name":
                    COrepo.updateName(courseCode, value.toString());
                    break;
                case "courseCode":
                    if (value instanceof Map) {
                        Map<String, Object> valueMap = (Map<String, Object>) value;
                        String previous = valueMap.get("previous").toString();
                        String newCode = valueMap.get("new").toString();

                        COrepo.updateCourseCodeCoursesTable(previous, newCode);
                        COrepo.updateCourseCodeCurriculumTable(department, year, semester, previous, newCode); // ndi gumana
                    } else {
                        throw new IllegalArgumentException("Invalid value for courseCode: Expected a map with 'previous' and 'new'.");
                    }
                    break;
                case "totalUnits":
                    // check if icchange to 3 para machange ung units per class
                    COrepo.updateTotalUnits(courseCode, ((Integer) value).doubleValue());
                    break;
                case "courseType":
                    COrepo.updateCourseType(courseCode, value.toString());
                    break;
                case "courseCategory":
                    COrepo.updateCourseCategory(courseCode, value.toString());
                    break;
                default:
                    throw new IllegalArgumentException("Invalid column name: " + column);
            }

        }

    }

    @PreAuthorize("hasAuthority('ROLE_Department_Chair')")
    @DeleteMapping("/{year}/{semester}/{department}")
    public void deleteCourseOffering(@RequestBody Map<String, Object> courseDetails, @PathVariable int year, @PathVariable int semester, @PathVariable String department) {
        
        System.out.println(courseDetails);
        String courseCode = courseDetails.get("courseCode").toString();

        if (courseCode == null){
            throw new IllegalArgumentException("Missing course code");
        }

        Crepo.deleteCourseFromCourseCode(courseCode);

        // UPDATE curriculum
        COrepo.deleteCourseFromCurriculum(department, year, semester, courseCode);
    }
}

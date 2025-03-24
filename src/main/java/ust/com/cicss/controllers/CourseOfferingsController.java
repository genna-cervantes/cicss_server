package ust.com.cicss.controllers;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/{year}/{semester}/{department}")
    public List<CourseDTO> getCourseOfferings(@PathVariable(name = "year") int year, @PathVariable(name = "semester") int semester, @PathVariable(name = "department") String department) {
        // SELECT c.course_id, c.name, c.subject_code, c.total_units, c.type
        // FROM courses c
        // JOIN curriculum cur ON c.course_id = ANY(cur.courses)
        // WHERE cur.year = $1 AND cur.semester = $2 AND cur.department = $3;

        return COrepo.getCourseOfferings(year, semester, department); //returns a list of courses based on year, semester, and department
    }

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

    @PutMapping
    public void updateCourseOfferings(@RequestBody Map<String, Object> updates) {

        if (updates.get("courseId") == null) {
            throw new IllegalArgumentException("Missing courseId for update");
        }

        // UPDATE teaching_academic_staff updatecolumn = updatedcolvalue WHERE tas_id = tas_id
        String course_id = String.valueOf(updates.get("courseId"));
        ObjectMapper mapper = new ObjectMapper();
        String column = "";
        Object value = null;

        for (Map.Entry<String, Object> entry : updates.entrySet()) {

            if (entry.getKey().equals("courseId")) {
                continue;
            }

            column = entry.getKey(); // Next key as column
            value = entry.getValue(); // Next value
            System.out.println("tas_id: " + course_id + ", column: " + column + ", value: " + value);

            switch (column) {
                case "name":
                    COrepo.updateName(course_id, value.toString());
                    break;
                case "courseCode":
                    if (value instanceof Map) {
                        Map<String, Object> valueMap = (Map<String, Object>) value;
                        String previous = valueMap.get("previous").toString();
                        String newCode = valueMap.get("new").toString();

                        COrepo.updateCourseCodeCoursesTable(course_id, newCode);
                        COrepo.updateCourseCodeCurriculumTable(course_id, previous, newCode);
                    } else {
                        throw new IllegalArgumentException("Invalid value for courseCode: Expected a map with 'previous' and 'new'.");
                    }
                    break;
                case "totalUnits":
                    COrepo.updateTotalUnits(course_id, (double) value);
                    break;
                case "courseType":
                    COrepo.updateCourseType(course_id, value.toString());
                    break;
                case "courseCategory":
                    COrepo.updateCourseCategory(course_id, value.toString());
                    break;
                default:
                    throw new IllegalArgumentException("Invalid column name: " + column);
            }

        }

    }
}

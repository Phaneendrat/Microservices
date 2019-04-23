package demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentServiceController {
 
    private static Map<String, List<Student>> schooDB = new HashMap<String, List<Student>>();
    
    Logger log = LoggerFactory.getLogger(StudentServiceController.class);
 
    static {
        schooDB = new HashMap<String, List<Student>>();
 
        List<Student> lst = new ArrayList<Student>();
        Student std = new Student("Sajal", "Class IV");
        lst.add(std);
        std = new Student("Lokesh", "Class V");
        lst.add(std);
 
        schooDB.put("abcschool", lst);
 
        lst = new ArrayList<Student>();
        std = new Student("Kajal", "Class III");
        lst.add(std);
        std = new Student("Sukesh", "Class VI");
        lst.add(std);
 
        schooDB.put("xyzschool", lst);
 
    }
 
    @RequestMapping(value = "/getStudentDetailsForSchool/{schoolname}", method = RequestMethod.GET)
    public List<Student> getStudents(@PathVariable String schoolname,HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Getting Student details for " + schoolname+ " from port:"+request.getServerPort());
        
        log.info("Getting Student details for " + schoolname+ " from port:"+request.getServerPort());
 
        List<Student> studentList = schooDB.get(schoolname);
        if (studentList == null) {
            studentList = new ArrayList<Student>();
            Student std = new Student("Not Found", "N/A");
            studentList.add(std);
        }
        return studentList;
    }
    
    @GetMapping(value="/getStudentResponseEntity",produces=MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity getStudentResponseEntity() {
    	System.out.println("---inside get response entity method----");
    	HttpHeaders header= new HttpHeaders();
    	header.add("Content-Type", "application/xml");
    	
    	return ResponseEntity.ok()
    			.headers(header)
    			.body(new Student("Surjeet","Comps"));
    	
    }
    
    @GetMapping(name="/getGreeting")
    public String getGreeting(HttpServletRequest request) {
    	return "Hello from Student Service running on port:"+request.getServerPort();
    }
}

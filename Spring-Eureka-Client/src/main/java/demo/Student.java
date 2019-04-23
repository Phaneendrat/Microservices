package demo;

import java.io.Serializable;

import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName="student")
public class Student implements Serializable
{

	private static final long serialVersionUID = -1142399587811312005L;

	@JacksonXmlProperty
	@Transient
    private transient static String name;
	
	@JacksonXmlProperty
    private String className;
     
    public Student(String name, String className) {
        super();
        this.name = name;
        this.className = className;
    }
     
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getClassName() {
        return className;
    }
 
    public void setClassName(String className) {
        this.className = className;
    }
}

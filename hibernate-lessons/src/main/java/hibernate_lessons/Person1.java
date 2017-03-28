package hibernate_lessons;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
public class Person1 implements Serializable {
	   static final long serialVersionUID = -7593775012501239451L;

	    private Long id;
	    private String name;

	    public Person1() {
	    }

	    @Id  @GeneratedValue(strategy = GenerationType.AUTO)
	    public Long getMyId() {
	        return id;
	    }

	    public void setMyId(Long id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    @Column()
	    public void setName(String name) {
	        this.name = name.toUpperCase();
	    }
}
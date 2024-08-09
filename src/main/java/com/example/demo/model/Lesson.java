package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
    private String title;
    
    @NotBlank
    @Size(max = 500)
    private String description;

//    @ManyToOne
//    @JoinColumn(name = "course_id", nullable = false)
    
    @ManyToOne
    @JoinColumn(name = "course_id")
    @JsonBackReference
    @NotNull
    private Course course;

    // Constructors
    public Lesson() {}

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

	public Lesson(Long id, String title, String description, Course course) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.course = course;
	}

	 @Override
	    public String toString() {
	        return "Lesson{" +
	                "id=" + id +
	                ", title='" + title + '\'' +
	                ", description='" + description + '\'' +
	                '}';
	    }
    
}

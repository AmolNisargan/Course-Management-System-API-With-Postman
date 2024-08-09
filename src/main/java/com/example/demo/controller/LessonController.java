package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Lesson;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.LessonRepository;

@RestController
@RequestMapping("/api/lessons")
public class LessonController {

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private CourseRepository courseRepository;

    // Get all lessons
    @GetMapping
    public List<Lesson> getAllLessons() {
    		System.out.println(lessonRepository.findAll());
    	
    		
    		return lessonRepository.findAll();
    }

    // Get a specific lesson by ID
    @GetMapping("/{id}")
    public ResponseEntity<Lesson> getLessonById(@Valid @PathVariable Long id) {
        Optional<Lesson> lesson = lessonRepository.findById(id);
        if (lesson.isPresent()) {
            return ResponseEntity.ok(lesson.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Create a new lesson
    @PostMapping
    public ResponseEntity<Lesson> createLesson(@Valid @RequestBody Lesson lesson) {
        if (courseRepository.existsById(lesson.getCourse().getId())) {
            Lesson savedLesson = lessonRepository.save(lesson);
            return ResponseEntity.ok(savedLesson);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Update a lesson
    @PutMapping("/{id}")
    public ResponseEntity<Lesson> updateLesson(@Valid @PathVariable Long id, @RequestBody Lesson lessonDetails) {
        Optional<Lesson> lesson = lessonRepository.findById(id);
        if (lesson.isPresent()) {
            Lesson existingLesson = lesson.get();
            existingLesson.setTitle(lessonDetails.getTitle());
            existingLesson.setDescription(lessonDetails.getDescription());
            existingLesson.setCourse(lessonDetails.getCourse());
            Lesson updatedLesson = lessonRepository.save(existingLesson);
            return ResponseEntity.ok(updatedLesson);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a lesson
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLesson(@Valid @PathVariable Long id) {
        if (lessonRepository.existsById(id)) {
            lessonRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

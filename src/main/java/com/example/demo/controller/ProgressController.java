package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Progress;
import com.example.demo.repository.ProgressRepository;

@RestController
@RequestMapping("/api/users")
public class ProgressController {

    @Autowired
    private ProgressRepository progressRepository;

    @GetMapping("/{id}/progress")
    public ResponseEntity<List<Progress>> getProgressByUserId(@PathVariable Long id) {
        List<Progress> progressList = progressRepository.findByUserId(id);
        if (progressList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(progressList);
    }

    @PostMapping("/{id}/progress")
    public ResponseEntity<Progress> updateProgress(@PathVariable Long id, @RequestBody Progress progressDetails) {
        Progress progress = new Progress();
        progress.setUserId(id);
        progress.setCourseId(progressDetails.getCourseId());
        progress.setProgress(progressDetails.getProgress());
        Progress updatedProgress = progressRepository.save(progress);
        return ResponseEntity.status(201).body(updatedProgress);
    }
}


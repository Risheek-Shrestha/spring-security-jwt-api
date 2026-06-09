package com.example.secureapi;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @GetMapping
    public ResponseEntity<List<String>> getBooks() {
        return ResponseEntity.ok(
                List.of("Clean Code", "Atomic Habits", "The Pragmatic Programmer")
        );
    }
}

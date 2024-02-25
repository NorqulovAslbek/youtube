package com.example.controller;

import com.example.dto.CreateCommentDTO;
import com.example.dto.UpdateCommentDTO;
import com.example.enums.AppLanguage;
import com.example.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
@Tag(name = "Comment Api list", description = "Api list for Comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping()
    @Operation(summary = "Api for comment create", description = "this api  create comment")
    public ResponseEntity<?> create(@Valid @RequestBody CreateCommentDTO dto,
                                    @RequestHeader(value = "Accept-Language", defaultValue = "UZ")
                                    AppLanguage language) {
        return ResponseEntity.ok(commentService.create(dto, language));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Api for comment update", description = "this api  update comment")
    public ResponseEntity<?> update(@PathVariable("id") Integer commentId,
                                    @RequestBody UpdateCommentDTO dto,
                                    @RequestHeader(value = "Accept-Language", defaultValue = "UZ")
                                     AppLanguage language){
        return ResponseEntity.ok(commentService.update(commentId,dto,language));
    }

}

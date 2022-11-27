package com.wdyj.boilerplate.bbs.controllers;

import com.wdyj.boilerplate.bbs.dto.PostRequest;
import com.wdyj.boilerplate.bbs.dto.PostResponse;
import com.wdyj.boilerplate.bbs.models.Post;
import com.wdyj.boilerplate.bbs.services.PostService;
import com.wdyj.boilerplate.response.model.EntityIdResponse;
import com.wdyj.boilerplate.response.model.PageResponse;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/api/bbs")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public ResponseEntity<PageResponse<PostResponse>> getPosts(@PathParam("page") int page, @PathParam("size") int size) {
        Pageable pageable = PageRequest.of(page, size);

        return ResponseEntity.ok(new PageResponse<>(postService.getPosts(pageable)));
    }

    @PostMapping("/posts")
    public ResponseEntity<EntityIdResponse<Long>> insertPost(@RequestBody PostRequest postRequest) {
        Long insertedId = postService.insertPost(postRequest);
        return new ResponseEntity<>(new EntityIdResponse<>(insertedId), HttpStatus.CREATED);
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<EntityIdResponse<Long>> updatePost(@PathVariable Long id, @RequestBody PostRequest postRequest) {
        Long updatedId = postService.updatePost(id, postRequest);

        return new ResponseEntity<>(new EntityIdResponse<>(updatedId), HttpStatus.OK);
    }

    @DeleteMapping("/posts/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }
}

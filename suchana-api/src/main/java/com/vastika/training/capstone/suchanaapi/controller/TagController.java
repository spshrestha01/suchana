package com.vastika.training.capstone.suchanaapi.controller;

import com.vastika.training.capstone.suchanaapi.models.Tag;
import com.vastika.training.capstone.suchanaapi.services.TagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class TagController {

    @Autowired
    private TagService tagService;

    @RequestMapping("/tags")
    public ResponseEntity<List<Tag>> getTags(){
        List<Tag> tags = this.tagService.findAll();
        return new ResponseEntity<>(tags, HttpStatus.OK);
    }

    @RequestMapping("/tags/{id}")
    public ResponseEntity<Tag> getTag(@PathVariable("id") int id){
        Tag tag = this.tagService.findById(id);
        log.info("Tag found with id: {}, {}", id, tag);
        return new ResponseEntity<>(tag, HttpStatus.OK);
    }

    @RequestMapping(value = "/tags", method = RequestMethod.POST)
    public ResponseEntity<Tag> createTag(@RequestBody Tag tag){
        log.info("createTag() -> {}", tag);
        Tag saved = this.tagService.createTag(tag);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/tags/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deleteTag(@PathVariable("id") int id){
        log.info("deleteTag() -> {}", id);
        this.tagService.deleteTag(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/tags/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Tag> updateTag(@RequestBody Tag tag, @PathVariable("id") int id){
        log.info("updateTag() -> {}", id);
        tag.setId(id);
        Tag updated = this.tagService.updateTag(tag);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }


}

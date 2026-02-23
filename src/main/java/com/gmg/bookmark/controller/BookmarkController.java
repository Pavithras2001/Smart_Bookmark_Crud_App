package com.gmg.bookmark.controller;

import com.gmg.bookmark.entity.Bookmark;
import com.gmg.bookmark.service.BookmarkService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookmarks")
@CrossOrigin
public class BookmarkController {

    private final BookmarkService service;

    public BookmarkController(BookmarkService service) {
        this.service = service;
    }

    @PostMapping
    public Bookmark add(@RequestBody Bookmark bookmark) {
        return service.addBookmark(bookmark);
    }

    @GetMapping
    public List<Bookmark> getAll() {
        return service.getAllBookmarks();
    }

    @PutMapping("/{id}")
    public Bookmark update(@PathVariable Long id, @RequestBody Bookmark bookmark) {
        return service.updateBookmark(id, bookmark);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteBookmark(id);
    }
}

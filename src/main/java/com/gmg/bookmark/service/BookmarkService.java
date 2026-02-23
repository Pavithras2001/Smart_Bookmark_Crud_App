package com.gmg.bookmark.service;

import com.gmg.bookmark.entity.Bookmark;
import com.gmg.bookmark.repository.BookmarkRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookmarkService {

    private final BookmarkRepository repository;

    public BookmarkService(BookmarkRepository repository) {
        this.repository = repository;
    }

    public Bookmark addBookmark(Bookmark bookmark) {
        return repository.save(bookmark);
    }

    public List<Bookmark> getAllBookmarks() {
        return repository.findAll();
    }

    public Bookmark updateBookmark(Long id, Bookmark updated) {
        Bookmark bookmark = repository.findById(id).orElseThrow();
        bookmark.setTitle(updated.getTitle());
        bookmark.setUrl(updated.getUrl());
        return repository.save(bookmark);
    }

    public void deleteBookmark(Long id) {
        repository.deleteById(id);
    }
}

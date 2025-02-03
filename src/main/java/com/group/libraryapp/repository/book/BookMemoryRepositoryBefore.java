package com.group.libraryapp.repository.book;

import org.springframework.stereotype.Repository;

@Repository
public class BookMemoryRepositoryBefore implements BookRepositoryBefore {

    public void saveBook() {
        System.out.println("MemoryRepository");
    }
}

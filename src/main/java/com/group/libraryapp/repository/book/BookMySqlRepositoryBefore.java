package com.group.libraryapp.repository.book;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public class BookMySqlRepositoryBefore implements BookRepositoryBefore {

    public void saveBook() {
        System.out.println("MySqlRepository");
    }
}

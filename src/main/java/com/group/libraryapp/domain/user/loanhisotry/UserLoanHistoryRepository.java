package com.group.libraryapp.domain.user.loanhisotry;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserLoanHistoryRepository extends JpaRepository<UserLoanHistory, Long> {
    boolean existsByBookNameAndIsReturn(String name, boolean isReturn);

    //비즈니스 로직으로 사용하지 않게 됨. 삭제해도 됨.
    Optional<UserLoanHistory> findByUserIdAndBookName(Long id, String bookName);
}

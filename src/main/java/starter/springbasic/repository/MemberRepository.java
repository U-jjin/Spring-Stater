package starter.springbasic.repository;

import org.springframework.stereotype.Repository;
import starter.springbasic.domain.Member;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member) throws SQLException;
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();


}


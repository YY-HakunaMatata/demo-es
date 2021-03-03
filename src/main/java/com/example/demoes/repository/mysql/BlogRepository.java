package com.example.demoes.repository.mysql;

import com.example.demoes.entity.mysql.BlogDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Mr.PengYY
 * @date 2021-03-02 16:44
 * @description:
 */
public interface BlogRepository extends JpaRepository<BlogDB, Integer> {

    @Query("select b from BlogDB b where b.title like concat('%', :keyword, '%') " +
            "or b.content like concat('%', :keyword, '%')")
    List<BlogDB> queryBlogDBs(@Param("keyword") String keyword);
}

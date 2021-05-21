package com.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springproject.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}

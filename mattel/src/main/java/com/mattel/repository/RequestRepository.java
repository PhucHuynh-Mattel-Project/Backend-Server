package com.mattel.repository;

import com.mattel.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Integer> {

    public List<Request> findAllByStatus(String status);
}

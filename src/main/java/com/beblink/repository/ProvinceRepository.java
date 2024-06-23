package com.beblink.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.beblink.model.Province;

/**
 * The interface Province repository.
 */
public interface ProvinceRepository extends JpaRepository<Province, String> {
}

package com.starhub.sites.repository;

import com.starhub.sites.domain.BaseDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository<T extends BaseDomain> extends JpaRepository<T,Long>, JpaSpecificationExecutor<T> {
}
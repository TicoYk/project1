package com.springguru.project1.repositories;

import com.springguru.project1.domain.Address;

import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long>{
    
}

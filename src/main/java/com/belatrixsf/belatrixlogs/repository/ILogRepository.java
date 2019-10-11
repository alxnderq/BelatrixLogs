package com.belatrixsf.belatrixlogs.repository;

import com.belatrixsf.belatrixlogs.entities.Log;
import org.springframework.data.repository.CrudRepository;

public interface ILogRepository extends CrudRepository<Log, Integer> {
}

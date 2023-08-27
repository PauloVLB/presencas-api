package com.ufrn.presencasapi.repository;

import com.ufrn.presencasapi.model.Monitoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonitoriaRepository extends JpaRepository<Monitoria, Long> {
}

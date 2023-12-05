package ru.ryabson.Processing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ryabson.Processing.entity.LoginAudit;

public interface LoginAuditRepository extends JpaRepository<LoginAudit, Long> {

}

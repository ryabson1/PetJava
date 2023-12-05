package ru.ryabson.Processing.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ryabson.Processing.entity.LoginAudit;
import ru.ryabson.Processing.repository.LoginAuditRepository;

@Service
@AllArgsConstructor
public class LoginAuditService {

    private final LoginAuditRepository loginAuditRepository;

    public void createAudit(LoginAudit loginAudit){
        loginAuditRepository.save(loginAudit);
    }

}

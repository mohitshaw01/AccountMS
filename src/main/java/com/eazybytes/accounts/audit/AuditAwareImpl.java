package com.eazybytes.accounts.audit;

import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("AuditAwareImpl")
public class AuditAwareImpl implements AuditorAware<String> {

    /**
     * This method help get the current User and set it as an Auditor
     * and help get the value to the DTO of updatedBy and createdBy
     *
     * @return
     */
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Accounts_MS");
    }
}

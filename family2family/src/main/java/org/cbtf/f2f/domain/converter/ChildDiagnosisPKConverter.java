package org.cbtf.f2f.domain.converter;

import org.cbtf.f2f.domain.entity.*;
import org.cbtf.f2f.domain.repository.ChildRepository;
import org.cbtf.f2f.domain.repository.DiagnosisRepository;
import org.cbtf.f2f.domain.repository.SubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.spi.BackendIdConverter;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.regex.Pattern;

@Component
public class ChildDiagnosisPKConverter implements BackendIdConverter {

    private static final Pattern DELIMITER = Pattern.compile("\\|");

    @Autowired
    private ChildRepository childRepository;

    @Autowired
    private DiagnosisRepository diagnosisRepository;

    @Override
    public Serializable fromRequestId(String id, Class<?> entityType) {
        String[] keyParts = DELIMITER.split(id);
        Integer childId = Integer.valueOf(keyParts[0]);
        Integer diagnosisId = Integer.valueOf(keyParts[1]);
        Child child = childRepository.findOne(childId);
        Diagnosis diagnosis = diagnosisRepository.findOne(diagnosisId);
        return new ChildDiagnosis.PK(diagnosis, child);
    }

    @Override
    public String toRequestId(Serializable id, Class<?> entityType) {
        ChildDiagnosis.PK childDiagnosisPk = (ChildDiagnosis.PK) id;
        return childDiagnosisPk.getChild().getChildId() + "|" + childDiagnosisPk.getDiagnosis().getId();
    }

    @Override
    public boolean supports(Class<?> delimiter) {
        return ChildDiagnosis.class.equals(delimiter);
    }
}

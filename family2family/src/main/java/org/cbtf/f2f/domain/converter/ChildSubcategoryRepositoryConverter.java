package org.cbtf.f2f.domain.converter;

import org.cbtf.f2f.domain.entity.Child;
import org.cbtf.f2f.domain.entity.ChildSubcategory;
import org.cbtf.f2f.domain.entity.Subcategory;
import org.cbtf.f2f.domain.repository.ChildRepository;
import org.cbtf.f2f.domain.repository.SubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.spi.BackendIdConverter;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.regex.Pattern;

@Component
public class ChildSubcategoryRepositoryConverter implements BackendIdConverter {

    private static final Pattern DELIMITER = Pattern.compile("\\|");

    @Autowired
    private ChildRepository childRepository;

    @Autowired
    private SubcategoryRepository subcategoryRepository;

    @Override
    public Serializable fromRequestId(String id, Class<?> entityType) {
        String[] keyParts = DELIMITER.split(id);
        Integer childId = Integer.valueOf(keyParts[0]);
        Integer subcategoryId = Integer.valueOf(keyParts[1]);
        Child child = childRepository.findOne(childId);
        Subcategory subcategory = subcategoryRepository.findOne(subcategoryId);
        return new ChildSubcategory.PK(subcategory, child);
    }

    @Override
    public String toRequestId(Serializable id, Class<?> entityType) {
        return id.toString();
    }

    @Override
    public boolean supports(Class<?> delimiter) {
        return ChildSubcategory.class.equals(delimiter);
    }
}

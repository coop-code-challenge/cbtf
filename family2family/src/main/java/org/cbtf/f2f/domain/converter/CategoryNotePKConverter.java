package org.cbtf.f2f.domain.converter;

import org.cbtf.f2f.domain.entity.*;
import org.cbtf.f2f.domain.repository.CategoryRepository;
import org.cbtf.f2f.domain.repository.ChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.spi.BackendIdConverter;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.regex.Pattern;

/**
 * Responsible for converting the CategoryNotePK to and from a string.
 */
@Component
public class CategoryNotePKConverter implements BackendIdConverter {

    private static final Pattern DELIMITER = Pattern.compile("\\|");

    @Autowired
    private ChildRepository childRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Serializable fromRequestId(String id, Class<?> entityType) {
        String[] keyParts = DELIMITER.split(id);
        Integer childId = Integer.valueOf(keyParts[0]);
        Integer categoryId = Integer.valueOf(keyParts[1]);
        Child child = childRepository.findOne(childId);
        Category category = categoryRepository.findOne(categoryId);
        return new CategoryNote.PK(category, child);
    }

    @Override
    public String toRequestId(Serializable id, Class<?> entityType) {
        CategoryNote.PK categoryNotePk = (CategoryNote.PK) id;
        return categoryNotePk.getChild().getChildId() + "|" + categoryNotePk.getCategory().getCategoryId();
    }

    @Override
    public boolean supports(Class<?> delimiter) {
        return CategoryNote.class.equals(delimiter);
    }
}

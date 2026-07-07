package com.cwa.lms.ls.mapper;

import com.cwa.lms.ls.dto.DocumentResponse;
import com.cwa.lms.ls.entity.Document;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DocumentMapper {

    Document toEntity(Document document);

    DocumentResponse toResponse(Document document);
}

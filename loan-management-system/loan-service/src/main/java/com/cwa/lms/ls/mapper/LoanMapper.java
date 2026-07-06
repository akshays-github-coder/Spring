package com.cwa.lms.ls.mapper;

import com.cwa.lms.ls.dto.LoanResponse;
import com.cwa.lms.ls.entity.Loan;
import org.mapstruct.Mapper;

// The componentModel = "spring" tells MapStruct to generate a Spring bean
// so you can inject it with @Autowired or constructor injection.
@Mapper(componentModel = "spring")
public interface LoanMapper {

    Loan toEntity(Loan loan);

    LoanResponse toResponse(Loan loan);
}

package com.devstack.ecom.feanix.dto.paginate;

import com.devstack.ecom.feanix.dto.response.ResponseProductDto;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ResponseProductPaginateDto {
    private long count;
    private List<ResponseProductDto> dataList;
}

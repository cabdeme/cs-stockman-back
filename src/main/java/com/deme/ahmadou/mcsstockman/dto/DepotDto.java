package com.deme.ahmadou.mcsstockman.dto;

import com.deme.ahmadou.mcsstockman.model.Depot;
import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class DepotDto {
    private Long id;

    private String name;

    public static DepotDto fromEntity(Depot depot){
        if(depot == null){
            return null;
        }else{
            return DepotDto.builder()

                    .build();
        }
    }

}

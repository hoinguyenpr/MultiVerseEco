package com.common.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role {
    private Integer id;
    private String name;
    private String description;
}

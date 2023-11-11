package kz.halykbank.halykbank.dto;

import jakarta.persistence.*;
import kz.halykbank.halykbank.model.Organization;
import lombok.Data;

@Data
public class ItemDTO {

    private Long id;

    private String name;

    private Integer price;

    private Organization organization;
}
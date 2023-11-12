package kz.halykbank.halykbank.dto;

import jakarta.persistence.ManyToOne;
import kz.halykbank.halykbank.model.Item;
import kz.halykbank.halykbank.model.Organization;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ReceiptDTO {

    private Long id;

    private LocalDate creationDate = LocalDate.now();

    private Integer totalPrice;

    private String phoneNumber;

    private EmployeeDTO employeeDTO;

    private OrganizationDTO organizationDTOs;

    private List<ItemDTO> itemsDTOs;
}

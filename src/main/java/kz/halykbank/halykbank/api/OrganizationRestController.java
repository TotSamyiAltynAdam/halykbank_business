package kz.halykbank.halykbank.api;

import kz.halykbank.halykbank.dto.OrganizationDTO;
import kz.halykbank.halykbank.service.OrganizationService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/organization")
@RequiredArgsConstructor
public class OrganizationRestController {

    private final OrganizationService organizationService;

    @GetMapping
    public List<OrganizationDTO> getList() {
        return organizationService.getListByUserId();
    }


}

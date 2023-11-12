package kz.halykbank.halykbank.service;

import kz.halykbank.halykbank.dto.OrganizationDTO;
import kz.halykbank.halykbank.mapper.OrganizationMapper;
import kz.halykbank.halykbank.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationService {

    private final OrganizationRepository organizationRepository;
    private final OrganizationMapper organizationMapper;

    public List<OrganizationDTO> getList() {
        return organizationMapper.toDTOList(organizationRepository.findAll());
    }


    public List<OrganizationDTO> getListByUserId() {
        return organizationMapper.toDTOList(organizationRepository.findAllByUserId(1L));


    }
}

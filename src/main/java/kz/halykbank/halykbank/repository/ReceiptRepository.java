package kz.halykbank.halykbank.repository;


import kz.halykbank.halykbank.model.Organization;
import kz.halykbank.halykbank.model.Receipt;
import kz.halykbank.halykbank.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
    @Query("SELECT u FROM Receipt u WHERE u.employee = :id")
    List<Receipt> getReceiptsByEmployee(Long id);
    List<Receipt> findAllByOrganizationAndCreationDate(Organization organization, LocalDate localDate);
}

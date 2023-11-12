package kz.halykbank.halykbank.service;

import kz.halykbank.halykbank.dto.ReceiptDTO;
import kz.halykbank.halykbank.mapper.ReceiptMapper;
import kz.halykbank.halykbank.model.Item;
import kz.halykbank.halykbank.model.Organization;
import kz.halykbank.halykbank.model.Receipt;
import kz.halykbank.halykbank.repository.OrganizationRepository;
import kz.halykbank.halykbank.repository.ReceiptRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReceiptService {
    private final ReceiptRepository receiptRepository;
    private final ReceiptMapper receiptMapper;
    private final OrganizationRepository organizationRepository;
    public Map<String, int[]> totalPriceWithCount(Long org_id) {
        LocalDate now = LocalDate.now();
        Organization organization = organizationRepository.findById(org_id).get();

        List<Receipt> allByOrganizationAndCreationDate = receiptRepository.findAllByOrganizationAndCreationDate(organization, now);

        Map<String, int[]> ans = new HashMap<>();
        for (Receipt receipt : allByOrganizationAndCreationDate) {
            List<Item> items = receipt.getItems();
            for (Item item : items) {
                int[] put = ans.put(item.getName(), ans.getOrDefault(item.getName(), new int[]{0,0}));
                //put[0] -> totalPrice
                //put[1] -> count
                put[0] += item.getPrice();
                put[1]++;
            }
        }
        return ans;
    }
    public List<ReceiptDTO> getList() {
        return receiptMapper.toDTOList(receiptRepository.findAll());
    }
    public List<ReceiptDTO> getListByUserId() {return receiptMapper.toDTOList(receiptRepository.getReceiptsByEmployee(1L));}
}

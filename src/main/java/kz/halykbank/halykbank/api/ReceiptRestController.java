package kz.halykbank.halykbank.api;

import kz.halykbank.halykbank.dto.ReceiptDTO;
import kz.halykbank.halykbank.service.ReceiptService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/receipt")
@RequiredArgsConstructor
public class ReceiptRestController {

    private final ReceiptService receiptService;

    @GetMapping
    public List<ReceiptDTO> getListByUserId() { return receiptService.getListByUserId();}

    @GetMapping("/{org_id}")
    public Map<String, int[]> getTodayResult(@PathVariable("org_id") Long org_id){
        return receiptService.totalPriceWithCount(org_id);
    }

}

package com.solcorp.inventoryservice.service;

import com.solcorp.inventoryservice.model.Inventory;
import com.solcorp.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public boolean isInStock (String skuCode) {
        List<Inventory> inventories = inventoryRepository.findBySkuCode(skuCode).orElse(Collections.emptyList());
         return inventories.size() > 0;
    }
}

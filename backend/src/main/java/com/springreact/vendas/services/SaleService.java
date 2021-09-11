package com.springreact.vendas.services;

import com.springreact.vendas.dto.SaleDTO;
import com.springreact.vendas.dto.SaleSuccessDTO;
import com.springreact.vendas.dto.SaleSumDTO;
import com.springreact.vendas.entities.Sale;
import com.springreact.vendas.repositories.SaleRepository;
import com.springreact.vendas.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;
    @Autowired
    private SellerRepository sellerRepository;

    @Transactional(readOnly = true)
    public Page<SaleDTO> findAll(Pageable pageable) {
        sellerRepository.findAll();
        Page<Sale> result = repository.findAll(pageable);

//        return result.map(x -> new SaleDTO(x));
        return result.map(SaleDTO::new);
    }

    @Transactional(readOnly = true)
    public List<SaleSumDTO> amountGroupedBySeller() {
        sellerRepository.findAll();

        return repository.amountGroupedBySeller();
    }

    @Transactional(readOnly = true)
    public List<SaleSuccessDTO> successGroupedBySeller() {
        sellerRepository.findAll();

        return repository.successGroupedBySeller();
    }
}

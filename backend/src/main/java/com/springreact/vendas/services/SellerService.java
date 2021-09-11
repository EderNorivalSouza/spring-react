package com.springreact.vendas.services;

import com.springreact.vendas.dto.SellerDTO;
import com.springreact.vendas.entities.Seller;
import com.springreact.vendas.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SellerService {

    @Autowired
    private SellerRepository repository;

    public List<SellerDTO> findAll() {
        List<Seller> result = repository.findAll();

//        return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
        return result.stream().map(SellerDTO::new).collect(Collectors.toList());
    }
}

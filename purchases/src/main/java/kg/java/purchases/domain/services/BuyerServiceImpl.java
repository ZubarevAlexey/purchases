package kg.java.purchases.domain.services;

import jakarta.transaction.Transactional;
import kg.java.purchases.core.exceptions.EntityNotFoundException;
import kg.java.purchases.core.contracts.services.BuyerService;
import kg.java.purchases.core.exceptions.EntityDuplicateException;
import kg.java.purchases.core.mappers.BuyerMapper;
import kg.java.purchases.core.models.dtos.buyer.*;
import kg.java.purchases.data.BuyerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BuyerServiceImpl implements BuyerService {
    private final BuyerRepository buyerRepository;

    public BuyerServiceImpl(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }

    @Override
    public BuyerDto register(CreateBuyerDto model) throws EntityDuplicateException {
        var buyer = buyerRepository.findByName(model.getName());
        if (buyer.isPresent()) throw new EntityDuplicateException();
        var entity = BuyerMapper.BUYER_MAPPER.fromDomain(model);
        buyerRepository.save(entity);
        return BuyerMapper.BUYER_MAPPER.toDomain(entity);
    }

    @Override
    public BuyerDto update(UpdateBuyerDto model) throws EntityNotFoundException {
        var buyer = buyerRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        var entity = buyer.builder()
                .id(model.getId())
                .name(model.getName())
                .email(model.getEmail())
                .build();
        buyerRepository.save(entity);
        return BuyerMapper.BUYER_MAPPER.toDomain(entity);
    }

    @Override
    public HttpStatus delete(DeleteBuyerDto model) throws EntityNotFoundException {
        var buyer = buyerRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        buyerRepository.delete(buyer);
        return HttpStatus.OK;
    }

    @Override
    public BuyerDto findById(FindByIdBuyerDto model) throws EntityNotFoundException {
        var buyer = buyerRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        return BuyerMapper.BUYER_MAPPER.toDomain(buyer);
    }

    @Override
    public List<BuyerDto> findByName(FindBuyersByNameDto model) {
        var buyers = buyerRepository.findBuyerEntitiesByNameContainsIgnoreCase(model.getName());
        return buyers.stream().map(BuyerMapper.BUYER_MAPPER::toDomain).collect(Collectors.toList());
    }

}

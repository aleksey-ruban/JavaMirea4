package com.example.unit20.service;

import com.example.unit20.model.Item;
import com.example.unit20.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }


    @Override
    public void create(Item item) {
        log.info("Create item");
        itemRepository.save(item);
    }

    @Override
    public List<Item> readAll() {
        log.info("Read all items");
        return itemRepository.findAll();
    }

    @Override
    public Item read(int id) {
        log.info("Read item " + id);
        return itemRepository.getReferenceById(id);
    }

    @Override
    public boolean update(Item item, int id) {
        log.info("Update item " + id);
        if (itemRepository.existsById(id)) {
            item.setId(id);
            itemRepository.save(item);
            return  true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        log.info("Delete item " + id);
        if (itemRepository.existsById(id)) {
            itemRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

package com.pavel.SoulCollect.repos;

import com.pavel.SoulCollect.models.Item;
import com.pavel.SoulCollect.models.Tag;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TagRepo extends CrudRepository<Tag, Long> {
    List<Tag> findAllByTagName(String tagName);
    Tag findByTagName(String tagName);
    List<Tag> findAllByItemsContains(Item item);
}

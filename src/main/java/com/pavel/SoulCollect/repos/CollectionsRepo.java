package com.pavel.SoulCollect.repos;

import com.pavel.SoulCollect.models.Collection;
import com.pavel.SoulCollect.models.User;
import org.springframework.data.repository.CrudRepository;

public interface CollectionsRepo extends CrudRepository<Collection, Long> {
    Collection findCollectionByName(String name);
    Iterable<Collection> findAllByOwner(User user);

}

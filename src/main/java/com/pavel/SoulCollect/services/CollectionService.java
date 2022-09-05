package com.pavel.SoulCollect.services;

import com.pavel.SoulCollect.models.Collection;
import com.pavel.SoulCollect.models.Item;
import com.pavel.SoulCollect.models.User;
import com.pavel.SoulCollect.repos.CollectionsRepo;
import com.pavel.SoulCollect.repos.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollectionService {
    @Autowired
    private CollectionsRepo collectionsRepo;
    @Autowired
    private ItemRepo itemRepo;

    public Iterable<Item> getItems(Collection col) {
        return itemRepo.findAllByCollection(col);
    }

    public void editCollection(Collection collection, Collection newCollection) {
        collection.setName(newCollection.getName());
        collection.setDescription(newCollection.getDescription());
        collectionsRepo.save(collection);
    }

    public Iterable<Collection> getCollections(User user) {
        return collectionsRepo.findAllByOwner(user);
    }

    public void deleteCollection(Collection collection) {
        collectionsRepo.delete(collection);
    }

    public Iterable<Collection> getAllCollections() {
        return collectionsRepo.findAll();
    }

    public Collection getMaxSizeCollection() {
        Iterable<Collection> collections = getAllCollections();
        Collection maxSize = collections.iterator().next();
        for (Collection col : collections) {
            if (col.getItems().size() > maxSize.getItems().size())
                maxSize = col;
        }
        return maxSize;
    }

    public void saveCollection(Collection collection) {
        collectionsRepo.save(collection);
    }
}

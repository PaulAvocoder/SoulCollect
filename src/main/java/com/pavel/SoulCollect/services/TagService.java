package com.pavel.SoulCollect.services;

import com.pavel.SoulCollect.models.Tag;
import com.pavel.SoulCollect.repos.ItemRepo;
import com.pavel.SoulCollect.repos.TagRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagService {
    @Autowired
    ItemRepo itemRepo;
    @Autowired
    TagRepo tagRepo;

    public Iterable<Tag> getAllTags() {
        return tagRepo.findAll();
    }
}

package com.pavel.SoulCollect.controllers;

import com.pavel.SoulCollect.services.CollectionService;
import com.pavel.SoulCollect.services.ItemService;
import com.pavel.SoulCollect.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {
    @Autowired
    private CollectionService collectionService;
    @Autowired
    private TagService tagService;
    @Autowired
    private ItemService itemService;

    @GetMapping("/")
    public String mainPage(Model model){
        model.addAttribute("maxSizeCollection", collectionService.getMaxSizeCollection());
        model.addAttribute("tags", tagService.getAllTags());
        model.addAttribute("lastAddedItems", itemService.getLastAddedItems());
        return "";
    }

}

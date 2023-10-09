package org.launchcode.artgallery.controllers;

import org.launchcode.artgallery.data.ArtworksData;
import org.launchcode.artgallery.models.Artwork;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/artworks")
public class ArtworkController {

    // Corresponds to http://localhost:8080/artworks
    @GetMapping("")
    public String renderArtworksPage(Model model) {
        model.addAttribute("artworkList", ArtworksData.getAll());
        return "artworks/index";
    }

    // TODO: Pass an empty artwork object to the template for binding with th:field and th:errors
    // TODO: Pass a list of styles to the template once the enum exists
    // Corresponds to http://localhost:8080/artworks/add
    @GetMapping("/add")
    public String renderAddArtForm() {
        return "artworks/add";
    }

    // TODO: Enable validation and handle validation errors
    // TODO: For style select with enums, pass list of styles if sending user back to form
    // Corresponds to http://localhost:8080/artworks/add?title=SomeTitle&artist=SomeArtist
    @PostMapping("/add")
    public String processAddArtForm(@ModelAttribute Artwork artwork) {
        ArtworksData.add(artwork);
        return "redirect:/artworks";
    }

    // Corresponds to http://localhost:8080/artworks/delete
    @GetMapping("/delete")
    public String renderDeleteArtForm(Model model) {
        model.addAttribute("artworkList", ArtworksData.getAll());
        return "artworks/delete";
    }

    // Corresponds to http://localhost:8080/artworks/delete?artworkIds=1&artworkIds=2 (etc)
    @PostMapping("/delete")
    public String processDeleteArtForm(@RequestParam(required = false) int[] artworkIds) {
        for (int id : artworkIds) {
            ArtworksData.remove(id);
        }
        return "redirect:/artworks";
    }

}

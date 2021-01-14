package tacos.web.api;

import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tacos.Ingredient;
import tacos.data.IngredientRepository;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(path = "/ingredients", produces = "application/json")
@CrossOrigin("*")
@RequiredArgsConstructor
public class IngredientController {

    private final IngredientRepository ingredientRepository;

    @GetMapping
    public CollectionModel<IngredientResource> allIngredients() {
        Iterable<Ingredient> ingredients = ingredientRepository.findAll();
        CollectionModel<IngredientResource> ingredientResources = new IngredientResourceAssembler().toCollectionModel(ingredients);
        ingredientResources.add(linkTo(methodOn(this.getClass()).allIngredients()).withRel("recents"));
        return ingredientResources;
    }
}

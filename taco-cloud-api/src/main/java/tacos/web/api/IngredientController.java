package tacos.web.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tacos.Ingredient;
import tacos.data.IngredientRepository;

import java.net.URI;
import java.util.Optional;

@Slf4j
@RestController
//@RequestMapping(path = "/ingredients", produces = "application/json")
@RequestMapping(path="/ingredientsx", produces="application/json")
@CrossOrigin("*")
@RequiredArgsConstructor
public class IngredientController {

    private final IngredientRepository ingredientRepository;

    @GetMapping
    public Iterable<Ingredient> allIngredients() {
        return ingredientRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Ingredient> byId(@PathVariable String id) {
        return ingredientRepository.findById(id);
    }

    @PutMapping("/{id}")
    public void updateIngredient(@PathVariable String id, @RequestBody Ingredient ingredient) {
        if (!ingredient.getId().equals(id)) {
            throw new IllegalStateException("Given ingredient's ID doesn't match the ID in the path.");
        }
        ingredientRepository.save(ingredient);
    }

    @PostMapping
    public ResponseEntity<Ingredient> postIngredient(@RequestBody Ingredient ingredient) {
        Ingredient saved = ingredientRepository.save(ingredient);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("http://localhost:8080/ingredients/" + ingredient.getId()));
        log.info("saved ingredient : {} : ", saved);
        return new ResponseEntity<>(saved, headers, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteIngredient(@PathVariable String id) {
        ingredientRepository.deleteById(id);
    }
}

package tacos.web.api;

import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import tacos.Ingredient;

import static tacos.Ingredient.*;

@Getter
public class IngredientResource extends RepresentationModel<IngredientResource> {
    private final String name;
    private final Type type;

    public IngredientResource(Ingredient ingredient) {
        this.name = ingredient.getName();
        this.type = ingredient.getType();
    }
}

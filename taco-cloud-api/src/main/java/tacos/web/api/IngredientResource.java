package tacos.web.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import tacos.Ingredient;

import static tacos.Ingredient.*;

@Getter
public class IngredientResource extends RepresentationModel<IngredientResource> {

    @JsonIgnore(false)
    private final String id;
    private final String name;
    private final Type type;

    public IngredientResource(Ingredient ingredient) {
        this.id = ingredient.getId();
        this.name = ingredient.getName();
        this.type = ingredient.getType();
    }
}

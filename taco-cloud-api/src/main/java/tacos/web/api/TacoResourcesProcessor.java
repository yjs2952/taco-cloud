package tacos.web.api;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import tacos.Taco;

@Component
public class TacoResourcesProcessor implements RepresentationModelProcessor<PagedModel<EntityModel<Taco>>> {

  private final EntityLinks entityLinks;
  
  public TacoResourcesProcessor(EntityLinks entityLinks) {
    this.entityLinks = entityLinks;
  }
  
  @Override
  public PagedModel<EntityModel<Taco>> process(PagedModel<EntityModel<Taco>> resources) {
    resources
      .add(entityLinks
          .linkFor(Taco.class)
          .slash("recent")
          .withRel("recents"));
    
    return resources;
  }

}

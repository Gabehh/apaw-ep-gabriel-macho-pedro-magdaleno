package es.upm.miw.apaw_gabriel_pedro.chef_resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(ChefResource.CHEFS)
public class ChefResource {

    public static final String CHEFS = "/chefs";

    private ChefBusinessController chefBusinessController;

    @Autowired
    public ChefResource(ChefBusinessController chefBusinessController) {
        this.chefBusinessController = chefBusinessController;
    }

    @PatchMapping()
    public void patch (@RequestParam String oldName, @RequestParam String newName ){
        this.chefBusinessController.patch(oldName, newName);
    }

    @PostMapping
    public ChefDto create(@RequestBody ChefDto chefDto){
        chefDto.validate();
        return this.chefBusinessController.create(chefDto);
    }

}

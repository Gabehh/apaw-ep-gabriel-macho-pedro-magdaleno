package es.upm.miw.apaw_gabriel_pedro.waiter_resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(WaiterResource.WAITERS)
public class WaiterResource {

    public static final String WAITERS = "/waiters";
    public static final String ID_ID = "/{id}";

    private WaiterBusinessController waiterBusinessController;

    @Autowired
    public WaiterResource(WaiterBusinessController waiterBusinessController){this.waiterBusinessController = waiterBusinessController;}

    @PostMapping
    public WaiterDto create(@RequestBody WaiterDto waiterDto){
        waiterDto.validate();
        return this.waiterBusinessController.create(waiterDto);
    }

    @DeleteMapping(value = ID_ID)
    public void delete (@PathVariable String id) {
        this.waiterBusinessController.delete(id);
    }

}

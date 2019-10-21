package es.upm.miw.apaw_gabriel_pedro.waiter_resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(WaiterResource.WAITERS)
public class WaiterResource {

    public static final String WAITERS = "/waiters";
    private WaiterBusinessController waiterBusinessController;

    @Autowired
    public WaiterResource(WaiterBusinessController waiterBusinessController){this.waiterBusinessController = waiterBusinessController;}

    @PostMapping
    public WaiterDto create(@RequestBody WaiterDto waiterDto){
        waiterDto.validate();
        return this.waiterBusinessController.create(waiterDto);
    }
}

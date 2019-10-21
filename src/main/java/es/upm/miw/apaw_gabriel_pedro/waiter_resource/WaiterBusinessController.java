package es.upm.miw.apaw_gabriel_pedro.waiter_resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class WaiterBusinessController {

    private WaiterDao waiterDao;

    @Autowired
    public WaiterBusinessController(WaiterDao waiterDao){this.waiterDao = waiterDao;}

    public WaiterDto create(WaiterDto waiterDto){
        Waiter waiter = new Waiter(waiterDto.getName(), waiterDto.getStarDate(), waiterDto.getBirthDate());
        this.waiterDao.save(waiter);
        return new WaiterDto(waiter);
    }
}

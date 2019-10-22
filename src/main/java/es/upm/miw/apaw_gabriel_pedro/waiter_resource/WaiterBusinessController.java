package es.upm.miw.apaw_gabriel_pedro.waiter_resource;

import es.upm.miw.apaw_gabriel_pedro.exceptions.NotFoundException;
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

    public void delete(String id){
        Waiter waiter = this.waiterDao.findById(id)
                .orElseThrow(()-> new NotFoundException("Waiter id: "+ id));
        this.waiterDao.delete(waiter);
    }
}

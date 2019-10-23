package es.upm.miw.apaw_gabriel_pedro.chef_resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ChefBusinessController {

    private ChefDao chefDao;

    @Autowired
    public ChefBusinessController(ChefDao chefDao) {
        this.chefDao = chefDao;
    }

    public void patch(String oldName, String newName) {
        List<Chef> chefList = this.chefDao.findAll();

        for (int i = 0; i < chefList.size(); i++) {
            if (chefList.get(i).getName().equals(oldName)) {
                chefList.get(i).setName(newName);
                this.chefDao.save(chefList.get(i));
            }
        }

    }

    public ChefDto create(ChefDto chefDto){
        Chef chef = new Chef(chefDto.getName(), chefDto.getStarDate(), chefDto.getBirthDate());
        this.chefDao.save(chef);
        return new ChefDto(chef);
    }

}

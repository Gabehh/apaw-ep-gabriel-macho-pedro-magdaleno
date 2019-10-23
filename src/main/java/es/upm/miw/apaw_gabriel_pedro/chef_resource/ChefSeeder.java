package es.upm.miw.apaw_gabriel_pedro.chef_resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

@Service
public class ChefSeeder {

    private ChefDao chefDao;

    @Autowired
    public ChefSeeder(ChefDao chefDao) {
        this.chefDao = chefDao;
        this.seedChefs();
    }

    public void seedChefs() {

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1995);
        cal.set(Calendar.MONTH, Calendar.FEBRUARY);
        cal.set(Calendar.DAY_OF_MONTH, 2);
        Date starDate = cal.getTime();
        cal.set(Calendar.YEAR, 2019);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 4);
        Date birthDate = cal.getTime();

        this.chefDao.saveAll(Arrays.asList(
                new Chef("Pedro", starDate, birthDate),
                new Chef("Francisco", starDate, birthDate),
                new Chef("Gabriel", starDate, birthDate)
        ));

    }

}
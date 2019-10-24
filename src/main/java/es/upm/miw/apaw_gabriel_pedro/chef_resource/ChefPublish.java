package es.upm.miw.apaw_gabriel_pedro.chef_resource;

import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;

import java.util.Date;

public class ChefPublish {

    private String name;

    private Date starDate;

    private Date birthDate;

    public EmitterProcessor<String> emitter;

    public ChefPublish() {
        this.emitter = EmitterProcessor.create();
    }

    public void create(String name, Date starDate, Date birthDate) {
        this.name = name;
        this.starDate = starDate;
        this.birthDate = birthDate;
        this.emitter.onNext("name: " + name + " " + "starDate: "+ starDate + " " + "birthDate: "+ birthDate);
    }

    public Flux<String> publisher() {
        return this.emitter;
    }

}

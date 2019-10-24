package es.upm.miw.apaw_gabriel_pedro.supplier_resource;

import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;

public class SupplierPublish {

    private Boolean isLocal;

    private String telephone;

    private String direction;

    public EmitterProcessor<String> emitter;

    public SupplierPublish() {
        this.emitter = EmitterProcessor.create();
    }

    public void create(Boolean isLocal, String direction, String telephone){
        this.telephone = telephone;
        this.direction = direction;
        this.isLocal= isLocal;
        this.emitter.onNext("direction: " + direction + " " + "Telephone: "+ telephone);
    }

    public Flux<String> publisher() {
        return this.emitter;
    }

}

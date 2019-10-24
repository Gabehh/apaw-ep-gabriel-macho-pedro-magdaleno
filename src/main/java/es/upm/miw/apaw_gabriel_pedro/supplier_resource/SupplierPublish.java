package es.upm.miw.apaw_gabriel_pedro.supplier_resource;

import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;

public class SupplierPublish {

    public Boolean isLocal;

    public String telephone;

    public String direction;

    public EmitterProcessor<String> emitter;

    public SupplierPublish() {
        this.emitter = EmitterProcessor.create();
    }

    public void setIsLocal(Boolean isLocal){
        this.isLocal = isLocal;
        this.emitter.onNext("is Local?: " + isLocal );
    }

    public void setDirection(String direction){
        this.direction = direction;
        this.emitter.onNext("Direction: " + direction);
    }

    public void setTelephone(String telephone){
        this.telephone = telephone;
        this.emitter.onNext("Telephone: "+ telephone);
    }

    public Flux<String> publisher() {
        return this.emitter;
    }

}

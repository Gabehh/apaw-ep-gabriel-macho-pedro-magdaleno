package es.upm.miw.apaw_gabriel_pedro.chef_resource;

import java.util.Date;

public interface TreeChefs {

    String id();

    String name();

    Date starDate();

    Date birthDate();

    boolean isComposite();

    void add(TreeChefs treeChefs);

    void remove(TreeChefs treeChefs);

}

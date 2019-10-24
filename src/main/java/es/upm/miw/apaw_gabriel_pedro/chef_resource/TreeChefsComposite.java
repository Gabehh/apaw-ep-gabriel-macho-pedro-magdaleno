package es.upm.miw.apaw_gabriel_pedro.chef_resource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TreeChefsComposite implements TreeChefs {

    private String id;

    private String name;

    private Date starDate;

    private Date birthDate;

    private List<TreeChefs> treeChefsList;

    public TreeChefsComposite(String id, String name, Date starDate, Date birthDate) {
        this.id = id;
        this.name = name;
        this.starDate = starDate;
        this.birthDate = birthDate;
        this.treeChefsList = new ArrayList<>();
    }

    @Override
    public String id() {
        return this.id;
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public Date starDate() {
        return this.starDate;
    }

    @Override
    public Date birthDate() {
        return this.birthDate;
    }

    @Override
    public boolean isComposite() {
        return true;
    }

    @Override
    public void add(TreeChefs treeChefs) {
        treeChefsList.add(treeChefs);
    }

    @Override
    public void remove(TreeChefs treeChefs) {
        treeChefsList.remove(treeChefs);
    }

}

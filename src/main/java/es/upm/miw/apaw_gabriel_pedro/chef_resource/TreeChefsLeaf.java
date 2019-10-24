package es.upm.miw.apaw_gabriel_pedro.chef_resource;

import java.util.Date;

public class TreeChefsLeaf implements TreeChefs {

    private Chef chef;

    public TreeChefsLeaf(Chef chef) {
        this.chef = chef;
    }

    @Override
    public String id() {
        return this.chef.getId();
    }

    @Override
    public String name() {
        return this.chef.getName();
    }

    @Override
    public Date starDate() {
        return this.chef.getStarDate();
    }

    @Override
    public Date birthDate() {
        return this.chef.getBirthDate();
    }

    @Override
    public boolean isComposite() {
        return false;
    }

    @Override
    public void add(TreeChefs treeChefs) {
        // Do nothing because is leaf
    }

    @Override
    public void remove(TreeChefs treeChefs) {
        // Do nothing because is leaf
    }

}

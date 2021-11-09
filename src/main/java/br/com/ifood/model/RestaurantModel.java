package br.com.ifood.model;

public class RestaurantModel extends HasTimestamps {
    private int id;
    private String name;
    private String cnpj;
    private String cnae;

    public int getId() {
        return id;
    }

    public String getCnae() {
        return cnae;
    }

    public void setCnae(String cnae) {
        this.cnae = cnae;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RestaurantModel() {
    }
}
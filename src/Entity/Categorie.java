/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Alex
 */
public class Categorie {
    private int numeroCategorie;
    private String nomCategorie;
    
    public Categorie(int unNumero, String unNom)
    {
        this.numeroCategorie = unNumero;
        this.nomCategorie = unNom;
    }

    /**
     * @return the numeroCategorie
     */
    public int getNumeroCategorie() {
        return numeroCategorie;
    }

    /**
     * @param numeroCategorie the numeroCategorie to set
     */
    public void setNumeroCategorie(int numeroCategorie) {
        this.numeroCategorie = numeroCategorie;
    }

    /**
     * @return the nomCategorie
     */
    public String getNomCategorie() {
        return nomCategorie;
    }

    /**
     * @param nomCategorie the nomCategorie to set
     */
    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }
    
    
}

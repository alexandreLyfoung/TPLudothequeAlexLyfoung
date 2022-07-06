/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Alex
 */
public class Jeux {
    private int numeroJeux;
    private String nomJeux;
    
    public Jeux(int unNumero, String unNom)
    {
        this.numeroJeux = unNumero;
        this.nomJeux = unNom;
    }

    /**
     * @return the numeroJeux
     */
    public int getNumeroJeux() {
        return numeroJeux;
    }

    /**
     * @param numeroJeux the numeroJeux to set
     */
    public void setNumeroJeux(int numeroJeux) {
        this.numeroJeux = numeroJeux;
    }

    /**
     * @return the nomJeux
     */
    public String getNomJeux() {
        return nomJeux;
    }

    /**
     * @param nomJeux the nomJeux to set
     */
    public void setNomJeux(String nomJeux) {
        this.nomJeux = nomJeux;
    }
    
    
}

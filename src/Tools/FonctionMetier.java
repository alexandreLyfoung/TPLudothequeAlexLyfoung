/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tools;

import Entity.Categorie;
import Entity.Jeux;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Alex
 */
public class FonctionMetier {
    //Cet obj va servir à nous connecter à notre bdd
    private Connection maCnx;
    //Cet objt va servir a ecrire les requetes sql
    private PreparedStatement ps;
    //Cet obj va servir à recuperer les donnees  provenant de nos requettes
    //Toutes les requettes SELECT (JEUX d'ENREGISTREMENTS)
    private ResultSet rsl; 
    
    public FonctionMetier()
    {
        this.maCnx = ConnexionBDD.getCnx();
    }
    
    public ArrayList<Categorie> GetAllCategories()
    {
        ArrayList <Categorie> mesCategories = new ArrayList<>();
        try {
                       
            ps = maCnx.prepareStatement("SELECT categorie.idCateg, categorie.nomCateg FROM categorie;");
            rsl = ps.executeQuery();
            
            while (rsl.next())
            {
                Categorie maCategorie = new Categorie(rsl.getInt(1),rsl.getString(2));
                //Categorie maCategorie = new Categorie(rsl.getInt("idCateg"),rsl.getString("nomCateg"));
                mesCategories.add(maCategorie);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mesCategories;
    }
    
    public int GetLastNumJeux()
    {
        int dernierNumero = 0;        
        try {
                       
            ps = maCnx.prepareStatement("SELECT MAX(jeux.idJeux) FROM jeux;");
            rsl = ps.executeQuery();
            rsl.next();
            dernierNumero = rsl.getInt(1) + 1;
            
        } catch (SQLException ex) {
            Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dernierNumero;
    }
    
    public ArrayList<Jeux> GetAllJeuxByIdCategories(int idCateg)
    {
        ArrayList<Jeux> mesJeux = new ArrayList<>();
        try {
                       
            ps = maCnx.prepareStatement("SELECT jeux.idJeux, jeux.nomJeux FROM jeux WHERE jeux.numCateg=" + idCateg);
            rsl = ps.executeQuery();
            while(rsl.next())
            {
                Jeux monJeux = new Jeux(rsl.getInt(1), rsl.getString(2));
                mesJeux.add(monJeux);
            }
                        
        } catch (SQLException ex) {
            Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
        return mesJeux;
    }
    
    public void AjouterUnJeux(String nomCategorie, String nomJeux, int idJeux)
    {
        try {
            int numCateg = 0;
            switch (nomCategorie)
            {
                case "Ambiance":
                    numCateg = 1;
                    break;
                case "Hasard":
                    numCateg = 2;
                    break;
                case "Rapidité":
                    numCateg = 3;
                    break;
                case "Mémoire":
                    numCateg = 4;
                    break;
                default:
                    break;
            }
            ps = maCnx.prepareStatement("INSERT INTO jeux (jeux.idJeux, jeux.nomJeux, jeux.imageJeux, jeux.numCateg) VALUES("+idJeux+", '"+nomJeux+"', 'Image', "+ numCateg+")");
            ps.executeUpdate();
                        
        } catch (SQLException ex) {
            Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

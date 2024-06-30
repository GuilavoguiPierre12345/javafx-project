/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package g5projetjavafx;

import g5.DAO.vente.ClientDAO;
import g5.DAO.vente.CommandeDAO;
import g5.DAO.vente.DetailCommandeDAO;
import g5.DAO.vente.FournisseurDAO;
import g5.DAO.vente.MaterielDAO;
import g5.DAO.vente.UtilisateurDAO;
import g5.entity.vente.Client;
import g5.entity.vente.Commande;
import g5.entity.vente.DetailCommande;
import g5.entity.vente.Fournisseur;
import g5.entity.vente.Materiel;
import g5.entity.vente.Utilisateur;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.control.TableColumn;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXMLLoader;
import javafx.print.PageLayout;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 * FXML Controller class
 *
 * @author kallo
 */
public class JavaFXtestController implements Initializable { 
    
    
    Boolean state = true;
      @FXML
    private BorderPane dashboard;

    @FXML
    private Button home;

    @FXML
    private Button logout;
    
    @FXML
    private Button valide_commande;
    
  
    @FXML
    private Pane navigation_section;

    @FXML
    private Pane page_approvisionnement;

    @FXML
    private Pane page_vente;

    @FXML
    private Button provide;

    @FXML
    private Button settings;

    @FXML
    private Button shop;

    @FXML
    private Button user_manager;
    
    @FXML
    private Pane page_gestion_users;

    @FXML
    private Pane page_home;
    
    @FXML
    private TextField fournisseur_adresse;

    @FXML
    private TextField fournisseur_materiel;

    @FXML
    private TextField fournisseur_nom;
    
     @FXML
    private TextField materiel_description;

    @FXML
    private TextField materiel_designation;

    @FXML
    private TextField materiel_prix_unitaire;

    @FXML
    private TextField materiel_stock;
    
    @FXML
    private Button btn_ajout_materiel_fournisseur;
    
    @FXML
    private TableView<Materiel> table_liste_materiel;
    
    @FXML
    private TableColumn<?, ?> colDesignation;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colIdFournisseur;

    @FXML
    private TableColumn<?, ?> colPrixUnitaire;

    @FXML
    private TableColumn<?, ?> colStock;
    
    @FXML
    private TableColumn<?, ?> Adresse;

    @FXML
    private TableColumn<?, ?> MaterielFourni;
    
    @FXML
    private TableColumn<?, ?> idFournisseur1;
    
    @FXML
    private TableColumn<?, ?> nomComplet;
    
    @FXML
    private TableView<Fournisseur> tableListeFournisseur;
    
    @FXML
    private TableView<Materiel> tableListCommandeMateriel;
    
    @FXML
    private TableColumn<?, ?> colDesignation1;
    
    @FXML
    private TableColumn<?, ?> colPrixU;
    
    @FXML
    private TableColumn<?, ?> quantite;
    
    @FXML
    private ListView<String> contenuPanier;

    @FXML
    private Button btnAjoutPanier;
    
    @FXML
    private TableColumn<?, ?> colIdUser;

    @FXML
    private TableColumn<?, ?> colNomUtilisateur;
    
    @FXML
    private TableColumn<?, ?> colEmailUtilisateur;
    
    @FXML
    private TableColumn<?, ?> colRoleUtilisateur;
    
    @FXML
    private TableView<Utilisateur> tableListeUtilisateur;
    
    @FXML
    private PasswordField motDePasseUtilisateurt;
    
   @FXML
    private TextField nomUtilisateurt;
   
   @FXML
    private ComboBox<String> roleUtilisateurt;
   
   @FXML
    private TextField emailUtilisateurt;
   
   
    @FXML
    private TextField rechercherMateriel;
    
    @FXML
    private TextField filtrerEtRechercher;
    
    @FXML
    private TextField materiel_idMateriel;
    
    @FXML
    private TextField materiel_idFournisseurs;
    
    @FXML
    private TextField rechercherFournisseur;
    
    @FXML
    private TextField fournisseur_idFournisseur;
    
    @FXML
    private Button btnModifFourniseur;
    
    @FXML
    private Label adminName;
    
    @FXML
    private Button btnModifMateriel;
    
       @FXML
    private TextField clientAd;

    @FXML
    private TextField clientGenre;

    @FXML
    private TextField clientNom;

    @FXML
    private TextField clientTel;
    
    @FXML
    private TextField quantiteChoisi;
     
    @FXML
    private TextField rechercheMateriels;

    @FXML
    private Label nbrClient;

    @FXML
    private Label nbrFournisseur;

    @FXML
    private Label nbrMateriel;
    
    @FXML
    private Label venteTotale;
    
    @FXML
    private TableView<Client> table_liste_clients;

    @FXML
    private TableView<Commande> table_liste_commande;

    @FXML
    private TableView<DetailCommande> table_liste_detailCommande;
    
    @FXML
    private TableColumn<?, ?> colIdcommande;
    
    @FXML
    private TableColumn<?, ?> coldateCommande;
    
    @FXML
    private TableColumn<?, ?> colmontant;
    
    @FXML
    private TableColumn<?, ?> colnumeroClient;
    
    @FXML
    private TableColumn<?, ?> colIddetailcommande;

    @FXML
    private TableColumn<?, ?> colIdmaterieldetail;
    
    @FXML
    private TableColumn<?, ?> coldatedetail;
    
    @FXML
    private TableColumn<?, ?> colprixdetail;
    
    @FXML
    private TableColumn<?, ?> colquantitedetail;
    
    @FXML
    private TableColumn<?, ?> colclientadresse;

    @FXML
    private TableColumn<?, ?> colclientgenre;

    @FXML
    private TableColumn<?, ?> colclientnom;

    @FXML
    private TableColumn<?, ?> colclienttelephone;
    
    @FXML
    private TableColumn<?, ?> colidclient;
    
    @FXML
    private TextField rechercherClient;
    
    @FXML
    private TextField rechercherCommande;
    
    @FXML
    private TextField rechercherDetail;
    
    @FXML
    private Pane pageGestionnaire;
    
    @FXML
    private PieChart statiqueDateCommande;
    
    @FXML
    private BarChart<String, Integer> clientParGenre;
    /**
     * Initializes the controller class.
     * @param event
     */
   
    
    //basculer sur la page vente
    public void switchToPageVente(ActionEvent event) {
        
        //listMateriels();
        if(event.getSource() == shop) {
            page_approvisionnement.setVisible(false);
            page_gestion_users.setVisible(false);
            page_home.setVisible(false);
            pageGestionnaire.setVisible(false);
            page_vente.setVisible(true);
            filtrerEtRechercher();
            populateTableView();
            tableListeMaterielCommande();
            remplirTableViewCommande();
            tableListeUtilisateur();
            remplirTableViewDetailCommande();
            remplirTableViewClient();
            homeWidget();
            alimenterBarChart();
            alimenterPieChart();
            //updateMateriel();
        }
    }
    // basculer sur la page approvisionnement
    public void switchToPageApprovisionnement(ActionEvent event) {
        if(event.getSource() == provide) {
            page_gestion_users.setVisible(false);
            page_home.setVisible(false);
            page_vente.setVisible(false);
            pageGestionnaire.setVisible(false);
            page_approvisionnement.setVisible(true);
            populateTableView();
            tableListeMaterielCommande();
            remplirTableViewCommande();
            tableListeUtilisateur();
            remplirTableViewDetailCommande();
            remplirTableViewClient();
            homeWidget();
            alimenterBarChart();
            alimenterPieChart();
        }
    }
    //basculer sur la page d'accueil
    public void switchToPageHome(ActionEvent event) {
        if(event.getSource() == home) {
            page_gestion_users.setVisible(false);
            page_vente.setVisible(false);
            page_approvisionnement.setVisible(false);
            pageGestionnaire.setVisible(false);
            page_home.setVisible(true);
            populateTableView();
            tableListeMaterielCommande();
            remplirTableViewCommande();
            tableListeUtilisateur();
            remplirTableViewDetailCommande();
            remplirTableViewClient();
            homeWidget();
            alimenterBarChart();
            alimenterPieChart();
        }
    }
    //basculer sur la page gestion users
    public void switchToPageGestionUsers(ActionEvent event) {
        if(event.getSource() == user_manager) {
            page_vente.setVisible(false);
            page_approvisionnement.setVisible(false);
            page_home.setVisible(false);
            pageGestionnaire.setVisible(false);
            page_gestion_users.setVisible(true);
            populateTableView();
            tableListeMaterielCommande();
            remplirTableViewCommande();
            tableListeUtilisateur();
            remplirTableViewDetailCommande();
            remplirTableViewClient();
            homeWidget();
            alimenterBarChart();
            alimenterPieChart();
        }
    }
    public void switchToPageGestionnaire(ActionEvent event) {
        if(event.getSource() == settings) {
            page_vente.setVisible(false);
            page_approvisionnement.setVisible(false);
            page_home.setVisible(false);
            page_gestion_users.setVisible(false);
            pageGestionnaire.setVisible(true);
            populateTableView();
            tableListeMaterielCommande();
            remplirTableViewCommande();
            tableListeUtilisateur();
            remplirTableViewDetailCommande();
            remplirTableViewClient();
            homeWidget();
            alimenterBarChart();
            alimenterPieChart();
        }
    }
    
    //control des champs de saisies (materiels & fournisseurs)
    public Boolean controlInputsField() {
        state = true;
        Map<String,TextField> materiel_fournisseur = new HashMap<>();
        materiel_fournisseur.put("designation", materiel_designation);
        materiel_fournisseur.put("description", materiel_description);
        materiel_fournisseur.put("stock", materiel_stock);
        materiel_fournisseur.put("prix_unitaire", materiel_prix_unitaire);
        materiel_fournisseur.put("nom_complet", fournisseur_nom);
        materiel_fournisseur.put("adresse", fournisseur_adresse);
        materiel_fournisseur.put("materiel_fournit", fournisseur_materiel);

        materiel_fournisseur.forEach((key, value) -> {
            if (value.getText().isEmpty()) {
                value.setPromptText(key + " obligatoire !");
                value.setStyle("-fx-prompt-text-fill: red; -fx-font-size: 16px; -fx-border-color:red; -fx-border-width:1.5px;");
                state = false;
            } else {
                value.setStyle("-fx-border-color:none;-fx-border-width:0px;-fx-font-size: 16px;");
            }
        });

        return state;
    }
    // control champ fournisseur pour la modification
    public Boolean controlInputsFieldFournisseur() {
        state = true;
        Map<String,TextField> materiel_fournisseur = new HashMap<>();
        materiel_fournisseur.put("nom_complet", fournisseur_nom);
        materiel_fournisseur.put("adresse", fournisseur_adresse);
        materiel_fournisseur.put("materiel_fournit", fournisseur_materiel);

        materiel_fournisseur.forEach((key, value) -> {
            if (value.getText().isEmpty()) {
                value.setPromptText(key + " obligatoire !");
                value.setStyle("-fx-prompt-text-fill: red; -fx-font-size: 16px; -fx-border-color:red; -fx-border-width:1.5px;");
                state = false;
            } else {
                value.setStyle("-fx-border-color:none;-fx-border-width:0px;-fx-font-size: 16px;");
            }
        });

        return state;
    }
    // control champ materiel pour la modification
    public Boolean controlInputsFieldMateriel() {
        state = true;
        Map<String,TextField> materiel_fournisseur = new HashMap<>();
        materiel_fournisseur.put("designation", materiel_designation);
        materiel_fournisseur.put("description", materiel_description);
        materiel_fournisseur.put("stock", materiel_stock);
        materiel_fournisseur.put("prix_unitaire", materiel_prix_unitaire);
        materiel_fournisseur.forEach((key, value) -> {
            if (value.getText().isEmpty()) {
                value.setPromptText(key + " obligatoire !");
                value.setStyle("-fx-prompt-text-fill: red; -fx-font-size: 16px; -fx-border-color:red; -fx-border-width:1.5px;");
                state = false;
            } else {
                value.setStyle("-fx-border-color:none;-fx-border-width:0px;-fx-font-size: 16px;");
            }
        });

        return state;
    }
    
// debut Page des approvisionnements
    
    //ajout matériels et fournisseurs dans la base
    public void addProvidersAndMaterials(){
        
        System.out.println(controlInputsField());
        if(controlInputsField()) {
           //les informations du fournisseur
           Fournisseur fournisseur = new Fournisseur();
           fournisseur.setNomComplet(fournisseur_nom.getText());
           fournisseur.setAdresse(fournisseur_adresse.getText());
           fournisseur.setMateriel(fournisseur_materiel.getText());
           FournisseurDAO f_dao = new FournisseurDAO();
           f_dao.create(fournisseur); //envoi des données dans la table

           //les informations du matériel
           Materiel materiel = new Materiel();
           materiel.setNomMateriel(materiel_designation.getText());
           materiel.setDescription(materiel_description.getText());
           materiel.setPrix(Integer.parseInt(materiel_prix_unitaire.getText()));
           materiel.setStock(Integer.parseInt(materiel_stock.getText()));
           materiel.setIdFournisseur(fournisseur.getIdFournisseur());
           MaterielDAO m_dao = new MaterielDAO();
           m_dao.create(materiel);
           showConfirmationDialog();
           populateTableView();  
           tableListeMaterielCommande();
           homeWidget();
        }
    }
    
    public void showConfirmationDialog() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Enregistrement effectué avec succès");
        alert.getButtonTypes().remove(ButtonType.CANCEL);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            // Code à exécuter lorsque l'utilisateur clique sur le bouton OK
            // Réinitialisez les champs ici
            clearFields();
        }
    }
    //confirmation
    public void showConfirmationCommande() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Commande effectué avec succès");
        alert.getButtonTypes().remove(ButtonType.CANCEL);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            // Code à exécuter lorsque l'utilisateur clique sur le bouton OK
            // Réinitialisez les champs ici
            clearFields();
        }
    }
    //modification effectué avec succès
    public void showConfirmationModif() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Modification effectué avec succès");
        alert.getButtonTypes().remove(ButtonType.CANCEL);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            // Code à exécuter lorsque l'utilisateur clique sur le bouton OK
            // Réinitialisez les champs ici
            clearFields();
        }
    }
    
    public void clearFields() {
        // Code pour réinitialiser les champs à leur valeur par défaut
        fournisseur_nom.clear();
        fournisseur_adresse.clear();
        fournisseur_materiel.clear();
        materiel_designation.clear();
        materiel_description.clear();
        materiel_prix_unitaire.clear();
        materiel_stock.clear();
        fournisseur_nom.setStyle("-fx-border-color:none;-fx-border-width:0px;-fx-font-size: 16px;");
        fournisseur_materiel.setStyle("-fx-border-color:none;-fx-border-width:0px;-fx-font-size: 16px;");
        fournisseur_adresse.setStyle("-fx-border-color:none;-fx-border-width:0px;-fx-font-size: 16px;");
        materiel_description.setStyle("-fx-border-color:none;-fx-border-width:0px;-fx-font-size: 16px;");
        materiel_designation.setStyle("-fx-border-color:none;-fx-border-width:0px;-fx-font-size: 16px;");
        materiel_prix_unitaire.setStyle("-fx-border-color:none;-fx-border-width:0px;-fx-font-size: 16px;");
        materiel_stock.setStyle("-fx-border-color:none;-fx-border-width:0px;-fx-font-size: 16px;");
        btn_ajout_materiel_fournisseur.setVisible(true);
        populateTableView();
        tableListeMaterielCommande();
    }
    
// mise à jour 
public void updateMateriel(){
        System.out.println(controlInputsFieldMateriel());
        if(controlInputsFieldMateriel()) {
           //les informations du materiel
           Materiel materiel = new Materiel();
           materiel.setIdMatriel(Integer.parseInt(materiel_idMateriel.getText()));
           materiel.setNomMateriel(materiel_designation.getText());
           materiel.setDescription(materiel_description.getText());
           materiel.setStock(Integer.parseInt(materiel_stock.getText()));
           materiel.setPrix(Double.parseDouble(materiel_prix_unitaire.getText()));
           materiel.setIdFournisseur(Integer.parseInt(materiel_idFournisseurs.getText()));
           MaterielDAO materiel_dao = new MaterielDAO();
           materiel_dao.update(materiel); //envoi des données dans la table
           
           clearFields();
           showConfirmationModif();  
           populateTableView();
           homeWidget();
           btnModifMateriel.setVisible(false);
           btn_ajout_materiel_fournisseur.setVisible(true);
                      
        }
}

// recherche materiel
    
public void filtrerEtRechercher() {  
       FilteredList<Materiel> filter = new FilteredList<>(table_liste_materiel.getItems(), e -> true);  
       rechercherMateriel.textProperty().addListener ((observable, oldValue, newValue) -> {
           filter.setPredicate(predicateMateriel ->{
               
               if(newValue == null || newValue.isEmpty()){
                   return true;               
               }
               String searchKey = newValue.toLowerCase();
               String idMatriel = String.valueOf(predicateMateriel.getIdMatriel());
               if(idMatriel.contains(searchKey)){
                   return true;               
               }
               else if(predicateMateriel.getNomMateriel().toLowerCase().contains(searchKey)){
                  return true;
               }
               else if (String.valueOf(predicateMateriel.getStock()).toLowerCase().contains(searchKey)) {
                  return true;
               } 
               else if (String.valueOf(predicateMateriel.getPrix()).toLowerCase().contains(searchKey)) {
                  return true;
               } 
               else if (String.valueOf(predicateMateriel.getIdFournisseur()).toLowerCase().contains(searchKey)) {
                  return true;
               }
               return false;
           });
           
        // Charger les informations dans les TextField avec les données de la première ligne correspondante
        if (!filter.isEmpty()) {
            Materiel premierEnregistrement = filter.get(0);
            materiel_idMateriel.setText(String.valueOf(premierEnregistrement.getIdMatriel()));
            materiel_designation.setText(premierEnregistrement.getNomMateriel());
            materiel_description.setText(String.valueOf(premierEnregistrement.getDescription()));
            materiel_stock.setText(String.valueOf(premierEnregistrement.getStock()));
            materiel_prix_unitaire.setText(String.valueOf(premierEnregistrement.getPrix()));
            materiel_idFournisseurs.setText(String.valueOf(premierEnregistrement.getIdFournisseur()));
            btn_ajout_materiel_fournisseur.setVisible(false);
            // Mettre à jour d'autres TextField si nécessaire
        } else {
            btn_ajout_materiel_fournisseur.setVisible(true);
            // Réinitialiser les TextField si aucun enregistrement correspondant n'est trouvé

            // Réinitialiser d'autres TextField si nécessaire
        }
//            materiel_designation.clear();
//            materiel_description.clear();
//            materiel_prix_unitaire.clear();
//            materiel_stock.clear();
       });

       SortedList<Materiel> sortList = new SortedList<>(filter); 
       sortList.comparatorProperty().bind(table_liste_materiel.comparatorProperty());
       table_liste_materiel.setItems(sortList);
}
// mise à jour fournisseur
public void updateFournisseur(){
        System.out.println(controlInputsFieldFournisseur());
        if(controlInputsFieldFournisseur()) {
           //les informations du materiel
           Fournisseur fournisseur = new Fournisseur();
           fournisseur.setIdFournisseur(Integer.parseInt(fournisseur_idFournisseur.getText()));
           fournisseur.setNomComplet(fournisseur_nom.getText());
           fournisseur.setAdresse(fournisseur_adresse.getText());
           fournisseur.setMateriel(fournisseur_materiel.getText());

           FournisseurDAO fournisseur_dao = new FournisseurDAO();
           fournisseur_dao.update(fournisseur); //envoi des données dans la table
           
           clearFields();
           showConfirmationModif();  
           populateTableView();
           homeWidget();
           btn_ajout_materiel_fournisseur.setVisible(true);
           
        }
}
// recherche fournisseur
public void filtrerEtRechercherFournisseur() {  
       FilteredList<Fournisseur> filter = new FilteredList<>(tableListeFournisseur.getItems(), e -> true);  
       rechercherFournisseur.textProperty().addListener ((observable, oldValue, newValue) -> {
           filter.setPredicate(predicateFournisseur ->{
               
               if(newValue == null || newValue.isEmpty()){
                   return true;               
               }
               String searchKey = newValue.toLowerCase();
               String idFournisseur = String.valueOf(predicateFournisseur.getIdFournisseur());
               if(idFournisseur.contains(searchKey)){
                   return true;               
               }
               else if(predicateFournisseur.getNomComplet().toLowerCase().contains(searchKey)){
                  return true;
               }
               else if(predicateFournisseur.getAdresse().toLowerCase().contains(searchKey)){
                  return true;
               }
               else if(predicateFournisseur.getMateriel().toLowerCase().contains(searchKey)){
                  return true;
               }
               
               return false;
           });
           
        // Charger les informations dans les TextField avec les données de la première ligne correspondante
        if (!filter.isEmpty()) {
            Fournisseur premierEnregistrement = filter.get(0);
            fournisseur_idFournisseur.setText(String.valueOf(premierEnregistrement.getIdFournisseur()));
            fournisseur_nom.setText(premierEnregistrement.getNomComplet());
            fournisseur_adresse.setText(premierEnregistrement.getAdresse());
            fournisseur_materiel.setText(premierEnregistrement.getMateriel());
            
            // Mettre à jour d'autres TextField si nécessaire
        } else {
            // Réinitialiser les TextField si aucun enregistrement correspondant n'est trouvé

            // Réinitialiser d'autres TextField si nécessaire
        }
//            materiel_designation.clear();
//            materiel_description.clear();
//            materiel_prix_unitaire.clear();
//            materiel_stock.clear();
       });

       SortedList<Fournisseur> sortList = new SortedList<>(filter); 
       sortList.comparatorProperty().bind(tableListeFournisseur.comparatorProperty());
       tableListeFournisseur.setItems(sortList);
}
    
public void populateTableView() {
        // Définir comment les colonnes accèdent aux valeurs des objets Materiel
        colId.setCellValueFactory(new PropertyValueFactory<>("idMatriel"));
        colDesignation.setCellValueFactory(new PropertyValueFactory<>("nomMateriel"));
        colStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        colPrixUnitaire.setCellValueFactory(new PropertyValueFactory<>("prix"));
        colIdFournisseur.setCellValueFactory(new PropertyValueFactory<>("idFournisseur"));
        
        // Définir comment les colonnes accèdent aux valeurs des objets Fournisseur
        idFournisseur1.setCellValueFactory(new PropertyValueFactory<>("idFournisseur"));
        nomComplet.setCellValueFactory(new PropertyValueFactory<>("nomComplet"));
        Adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        MaterielFourni.setCellValueFactory(new PropertyValueFactory<>("materiel"));

        // Créer l'ObservableList pour stocker les données des enregistrements de votre table materiel
        ObservableList<Materiel> materielList = FXCollections.observableArrayList();
        // Créer l'ObservableList pour stocker les données des enregistrements de votre table fournisseur
        ObservableList<Fournisseur> fournisseurList = FXCollections.observableArrayList();

        // Récupérer les enregistrements de la table "materiel" depuis la base de données
        MaterielDAO m_dao = new MaterielDAO();
        List<Materiel> materielFromDB = m_dao.listMateriel();
        // Récupérer les enregistrements de la table "fournisseur" depuis la base de données
        FournisseurDAO f_dao = new FournisseurDAO();
        List<Fournisseur> fournisseurFromDB = f_dao.listFournisseur();

        // Ajouter les objets Materiel à l'ObservableList
        materielList.addAll(materielFromDB);
        // Ajouter les objets Fournisseur à l'ObservableList
        fournisseurList.addAll(fournisseurFromDB);

        // Définir la source de données de votre TableView pour la liste materiel
        table_liste_materiel.setItems(materielList);
        // Définir la source de données de votre TableView pour la liste fournisseur
        tableListeFournisseur.setItems(fournisseurList);
    }


// supprimer un materiel 


public void supprimerMateriel() {
    table_liste_materiel.setRowFactory(tv -> {
        TableRow<Materiel> row = new TableRow<>();
        row.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2 && !row.isEmpty()) {
                Materiel materiel = row.getItem();
                
                // Supprimer l'objet Materiel de la base de données
                MaterielDAO mao = new MaterielDAO();
                mao.delete(materiel.getIdMatriel()); // Utiliser l'identifiant de la ligne
                
                // Mettre à jour la liste des éléments de la table
                table_liste_materiel.getItems().remove(materiel);
            }
        });
        return row;
    });
}
public void supprimerDetail() {
    table_liste_detailCommande.setRowFactory(tv -> {
        TableRow<DetailCommande> row = new TableRow<>();
        row.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2 && !row.isEmpty()) {
                DetailCommande detail = row.getItem();
                
                // Supprimer l'objet Materiel de la base de données
                DetailCommandeDAO mao = new DetailCommandeDAO();
                mao.delete(detail.getIdDetail()); // Utiliser l'identifiant de la ligne
                
                // Mettre à jour la liste des éléments de la table
                table_liste_detailCommande.getItems().remove(detail);
            }
        });
        return row;
    });
}
public void supprimerCommande() {
    table_liste_commande.setRowFactory(tv -> {
        TableRow<Commande> row = new TableRow<>();
        row.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2 && !row.isEmpty()) {
                Commande commande = row.getItem();
                
                // Supprimer l'objet Materiel de la base de données
                CommandeDAO mao = new CommandeDAO();
                mao.delete(commande.getIdCommande()); // Utiliser l'identifiant de la ligne
                
                // Mettre à jour la liste des éléments de la table
                table_liste_commande.getItems().remove(commande);
            }
        });
        return row;
    });
}

public void supprimerClient() {
    table_liste_clients.setRowFactory(tv -> {
        TableRow<Client> row = new TableRow<>();
        row.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2 && !row.isEmpty()) {
                Client client = row.getItem();
                
                // Supprimer l'objet Materiel de la base de données
                ClientDAO cao = new ClientDAO();
                cao.delete(client.getIdClient()); // Utiliser l'identifiant de la ligne
                
                // Mettre à jour la liste des éléments de la table
                table_liste_clients.getItems().remove(client);
            }
        });
        return row;
    });
}


public void supprimerFournisseur() {
    tableListeFournisseur.setRowFactory(tv -> {
        TableRow<Fournisseur> row = new TableRow<>();
        row.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2 && !row.isEmpty()) {
                Fournisseur four = row.getItem();
                
                // Supprimer l'objet Materiel de la base de données
                FournisseurDAO fao = new FournisseurDAO();
                fao.delete(four.getIdFournisseur()); // Utiliser l'identifiant de la ligne
                
                // Mettre à jour la liste des éléments de la table
                tableListeFournisseur.getItems().remove(four);
            }
        });
        return row;
    });
}





// control des champs client
public Boolean controlInputsClient() {
        state = true;
        Map<String,TextField> client = new HashMap<>();
        client.put("nom", clientNom);
        client.put("adresse", clientAd);
        client.put("tel", clientTel);
        client.put("genre", clientGenre);

        client.forEach((key, value) -> {
            if (value.getText().isEmpty()) {
                value.setPromptText(key + " obligatoire !");
                value.setStyle("-fx-prompt-text-fill: red; -fx-font-size: 16px; -fx-border-color:red; -fx-border-width:1.5px;");
                state = false;
            } else {
                value.setStyle("-fx-border-color:none;-fx-border-width:0px;-fx-font-size: 16px;");
            }
        });
      // Contrôle de la TableView
    if (contenuPanier.getItems().isEmpty()) {
        contenuPanier.setStyle("-fx-border-color: red; -fx-border-width: 1.5px;");
        state = false;
    } else {
        contenuPanier.setStyle("-fx-border-color: none; -fx-border-width: 0px;");
    }
        return state;
 }

// recherche materiel pour commande
public void filtrerEtRechercherMaterielCommande() {
    FilteredList<Materiel> filteredList = new FilteredList<>(tableListCommandeMateriel.getItems(), e -> true);
    
    rechercheMateriels.textProperty().addListener((observable, oldValue, newValue) -> {
        filteredList.setPredicate(predicateMateriel -> {
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }
            
            String searchKey = newValue.toLowerCase();
            String idMateriel = String.valueOf(predicateMateriel.getIdMatriel());
            
            if (idMateriel.contains(searchKey)) {
                return true;
            } else if (predicateMateriel.getNomMateriel().toLowerCase().contains(searchKey)) {
                return true;
            }
            
            return false;
        });
    });
    
    SortedList<Materiel> sortedList = new SortedList<>(filteredList);
    sortedList.comparatorProperty().bind(tableListCommandeMateriel.comparatorProperty());
    tableListCommandeMateriel.setItems(sortedList);
}
public void filtrerEtRechercherCommande() {
    FilteredList<Commande> filteredList = new FilteredList<>(table_liste_commande.getItems(), e -> true);
    
    rechercherCommande.textProperty().addListener((observable, oldValue, newValue) -> {
        filteredList.setPredicate(predicateCommande -> {
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }
            
            String searchKey = newValue.toLowerCase();
            String idCommande= String.valueOf(predicateCommande.getIdCommande());
            
            if (idCommande.contains(searchKey)) {
                return true;
            } else if (predicateCommande.getDateCommande().toLowerCase().contains(searchKey)) {
                return true;
            }            
            return false;
        });
    });
    
    SortedList<Commande> sortedList = new SortedList<>(filteredList);
    sortedList.comparatorProperty().bind(table_liste_commande.comparatorProperty());
    table_liste_commande.setItems(sortedList);
}
public void filtrerEtRechercherdetail() {
    FilteredList<DetailCommande> filteredList = new FilteredList<>(table_liste_detailCommande.getItems(), e -> true);
    
    rechercherDetail.textProperty().addListener((observable, oldValue, newValue) -> {
        filteredList.setPredicate(predicateCommande -> {
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }
            
            String searchKey = newValue.toLowerCase();
            String idCommande= String.valueOf(predicateCommande.getIdDetail());
            
            if (idCommande.contains(searchKey)) {
                return true;
            }   
            return false;
        });
    });
    
    SortedList<DetailCommande> sortedList = new SortedList<>(filteredList);
    sortedList.comparatorProperty().bind(table_liste_detailCommande.comparatorProperty());
    table_liste_detailCommande.setItems(sortedList);
}
public void filtrerEtRechercherClient() {
    FilteredList<Client> filteredList = new FilteredList<>(table_liste_clients.getItems(), e -> true);
    
    rechercherClient.textProperty().addListener((observable, oldValue, newValue) -> {
        filteredList.setPredicate(predicateClient -> {
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }
            
            String searchKey = newValue.toLowerCase();
            String idClient = String.valueOf(predicateClient.getIdClient());
            
            if (idClient.contains(searchKey)) {
                return true;
            } else if (predicateClient.getNumeroClient().toLowerCase().contains(searchKey)) {
                return true;
            }
            else if (predicateClient.getAdresseClient().toLowerCase().contains(searchKey)) {
                return true;
            }
            else if (predicateClient.getGenre().toLowerCase().contains(searchKey)) {
                return true;
            }
            else if (predicateClient.getNomComplet().toLowerCase().contains(searchKey)) {
                return true;
            }
            
            return false;
        });
    });
    
    SortedList<Client> sortedList = new SortedList<>(filteredList);
    sortedList.comparatorProperty().bind(table_liste_clients.comparatorProperty());
    table_liste_clients.setItems(sortedList);
}


// methode pour annuler la vente
public void clearFieldsclient() {
        // Code pour réinitialiser les champs à leur valeur par défaut
        clientAd.clear();
        clientGenre.clear();
        clientNom.clear();
        clientTel.clear();
        clientAd.setStyle("-fx-border-color:none;-fx-border-width:0px;-fx-font-size: 16px;");
        clientGenre.setStyle("-fx-border-color:none;-fx-border-width:0px;-fx-font-size: 16px;");
        clientTel.setStyle("-fx-border-color:none;-fx-border-width:0px;-fx-font-size: 16px;");
        clientNom.setStyle("-fx-border-color:none;-fx-border-width:0px;-fx-font-size: 16px;");
        contenuPanier.setStyle("-fx-border-color: none; -fx-border-width: 0px;");
        quantiteChoisi.clear();
        clearTableView(contenuPanier);
 }
//vider la table View
public void clearTableView(ListView<String> tableView) {
    tableView.getItems().clear();
}


//ajout des produits dans le panier
ObservableList<String> items = FXCollections.observableArrayList();
public Double montant = 0.0;
//public int quantit = 0;
public int idMat;
//public int prixU;
//les listes de récupération des informations détaillée de la commande
List<Double> liste_qte = new ArrayList<>();
List<Integer> liste_id_materiel = new ArrayList<>();
List<Double> liste_pu = new ArrayList<>();

public void addToPanier() {
    Materiel materiel = tableListCommandeMateriel.getSelectionModel().getSelectedItem();
    int num = tableListCommandeMateriel.getSelectionModel().getSelectedIndex();
    if (num < 0) {
        tableListCommandeMateriel.setStyle("-fx-border-color:red; -fx-border-width:1.5px;");
        return;
    }
    tableListCommandeMateriel.setStyle("-fx-border-color:none; -fx-border-width:0;");
    
    int val = Integer.parseInt(quantiteChoisi.getText());
    if(val !=0 || val > 0  || !quantiteChoisi.getText().equals("")){
         items.add("Des: " + materiel.getNomMateriel()+"  |  Prix :"+materiel.getPrix()+"  |  Qte: "+quantiteChoisi.getText());
         idMat = materiel.getIdMatriel();
         Double prix = materiel.getPrix();
         Double qte = Double.valueOf(quantiteChoisi.getText());
         montant += prix * qte ;
         
         liste_id_materiel.add(materiel.getIdMatriel());
         liste_qte.add(qte);
         liste_pu.add(prix);
         
//         quantit = Integer.parseInt(quantiteChoisi.getText());
//         prixU = prix;
//         idMat = Imateriel.getIdMatriel();
        // quantiteChoisi.setStyle("-fx-prompt-text-fill: none; -fx-font-size: 0; -fx-border-color:none; -fx-border-width:0;");
    //la listeView 
        contenuPanier.setItems(items);
    }else {
         quantiteChoisi.setPromptText("Entrer un entier positif");
         quantiteChoisi.setStyle("-fx-prompt-text-fill: red; -fx-font-size: 16px; -fx-border-color:red; -fx-border-width:2px;");
         return;
    }
       
}
    
//envoi des informations dans la table commande
public void addCommande(){
    
    try {
        if(controlInputsClient()){
        //client
        Client client = new Client();
        ClientDAO client_dao = new ClientDAO();
        client.setNomComplet(clientNom.getText());
        client.setAdresseClient(clientAd.getText());
        client.setGenre(clientGenre.getText());
        client.setNumeroClient(clientTel.getText());
        client_dao.create(client);
        //commande
        Commande cmd = new Commande();
        CommandeDAO cmd_dao = new CommandeDAO();
    
        LocalDate date = LocalDate.now();
        cmd.setIdClient(client);
        cmd.setMontant(montant);
        cmd.setDateCommande(date.toString());
        cmd_dao.create(cmd);
        
//      detail commande        
        DetailCommande d_commande= new DetailCommande();
        DetailCommandeDAO dao_commande= new DetailCommandeDAO();
        
        for(int i=0;i<liste_id_materiel.size();i++) {
             d_commande.setIdCommande(cmd);
             d_commande.setQuantite(liste_qte.get(i));
             Materiel mat = new Materiel();
             mat.setIdMatriel(liste_id_materiel.get(i));
             d_commande.setIdMateriel(mat);
             d_commande.setPrixUnitaire(liste_pu.get(i));
             
             dao_commande.create(d_commande);
        }
        
        valide_commande.setStyle("-fx-border-color:red; -fx-border-width:1.5px;");
        showConfirmationCommande();
        clearFieldsclient();
        homeWidget();
      }
    
    }catch(Exception e){
        System.out.println("Erreur d'exécution !");
    }
    
}     

public void tableListeMaterielCommande(){
        // Définir comment les colonnes accèdent aux valeurs des objets Materiel
        colDesignation1.setCellValueFactory(new PropertyValueFactory<>("nomMateriel"));
        quantite.setCellValueFactory(new PropertyValueFactory<>("stock"));
        colPrixU.setCellValueFactory(new PropertyValueFactory<>("prix"));
        // Créer l'ObservableList pour stocker les données des enregistrements de votre table materiel
        ObservableList<Materiel> materielList = FXCollections.observableArrayList();
        // Récupérer les enregistrements de la table "materiel" depuis la base de données
        MaterielDAO m_dao = new MaterielDAO();
        List<Materiel> materielFromDB = m_dao.listMateriel();
        // Ajouter les objets Materiel à l'ObservableList
        materielList.addAll(materielFromDB);
        // Définir la source de données de votre TableView pour la liste materiel
        tableListCommandeMateriel.setItems(materielList);
        
    }
     
public void remplirTableViewDetailCommande() {
    DetailCommandeDAO d_commande=new DetailCommandeDAO();
    // Appeler la méthode listDetailsCommande() pour obtenir les détails de commande
    List<DetailCommande> detailsCommande = d_commande.listDetailsCommande();
    // Créer une liste observable pour les détails de commande
    ObservableList<DetailCommande> observableList = FXCollections.observableArrayList();
    // Configurer les cellules des colonnes pour afficher les propriétés appropriées de DetailCommande
    colIddetailcommande.setCellValueFactory(new PropertyValueFactory<>("idDetail"));

    colquantitedetail.setCellValueFactory(new PropertyValueFactory<>("quantite"));
    
    colprixdetail.setCellValueFactory(new PropertyValueFactory<>("prixUnitaire"));

    coldatedetail.setCellValueFactory(new PropertyValueFactory<>("idCommande"));

    colIdmaterieldetail.setCellValueFactory(new PropertyValueFactory<>("idMateriel"));    
    observableList.addAll(detailsCommande);
    // Ajouter les colonnes à la tableView
    table_liste_detailCommande.setItems(observableList);
}
public void remplirTableViewClient() {

    // Configurer les cellules des colonnes pour afficher les propriétés appropriées de DetailCommande
    colidclient.setCellValueFactory(new PropertyValueFactory<>("idClient"));
    colclientnom.setCellValueFactory(new PropertyValueFactory<>("nomComplet"));    
    colclienttelephone.setCellValueFactory(new PropertyValueFactory<>("numeroClient"));
    colclientadresse.setCellValueFactory(new PropertyValueFactory<>("adresseClient"));   
    colclientgenre.setCellValueFactory(new PropertyValueFactory<>("genre"));

    ObservableList<Materiel> materielList = FXCollections.observableArrayList();
    // Créer une liste observable pour les détails de commande
    ObservableList<Client> observableList = FXCollections.observableArrayList();
    ClientDAO d_client=new ClientDAO();
    // Appeler la méthode listDetailsCommande() pour obtenir les détails de commande
    List<Client> client = d_client.listClient();
    // Associer la liste observable à la tableView
    observableList.addAll(client);
    // Ajouter les colonnes à la tableView
    table_liste_clients.setItems(observableList);
}
public void remplirTableViewCommande() {
    // Configurer les cellules des colonnes pour afficher les propriétés appropriées de DetailCommande
    colIdcommande.setCellValueFactory(new PropertyValueFactory<>("idCommande"));
    colnumeroClient.setCellValueFactory(new PropertyValueFactory<>("idClient"));    
    coldateCommande.setCellValueFactory(new PropertyValueFactory<>("dateCommande"));
    colmontant.setCellValueFactory(new PropertyValueFactory<>("montant"));   

    // Créer une liste observable pour les détails de commande
    ObservableList<Commande> observableList = FXCollections.observableArrayList();
    CommandeDAO d_commande=new CommandeDAO();
    // Appeler la méthode listDetailsCommande() pour obtenir les détails de commande
    List<Commande> commande = d_commande.listCommande();
    observableList.addAll(commande);
    // Ajouter les colonnes à la tableView
    table_liste_commande.setItems(observableList);
}

//control des champs de saisies (Utilisateur)
public Boolean controlInputsUtilisateur() {
    state = true;
    Map<String, Control> utilisateur = new HashMap<>();  // Utiliser la classe Control pour stocker les champs

    // Ajouter les champs de texte
    utilisateur.put("nomUtilisateur", nomUtilisateurt);
    utilisateur.put("email", emailUtilisateurt);
    utilisateur.put("motDePasse", motDePasseUtilisateurt);

    // Ajouter le champ de sélection (ComboBox)
    utilisateur.put("role", roleUtilisateurt);  // Remplacer roleUtilisateurt par roleComboBox (ou le nom approprié de votre ComboBox)

    utilisateur.forEach((key, value) -> {
        if (value instanceof TextField) {  // Vérifier si le contrôle est un TextField
            TextField textField = (TextField) value;  // Effectuer un cast vers TextField
            if (textField.getText().isEmpty()) {
                textField.setPromptText(key + " obligatoire !");
                textField.setStyle("-fx-prompt-text-fill: red; -fx-font-size: 16px; -fx-border-color:red; -fx-border-width:1.5px;");
                state = false;
            } else {
                textField.setStyle("-fx-border-color:none;-fx-border-width:0px;-fx-font-size: 16px;");
            }
        } else if (value instanceof ComboBox) {  // Vérifier si le contrôle est un ComboBox
            ComboBox comboBox = (ComboBox) value;  // Effectuer un cast vers ComboBox
            if (comboBox.getValue() == null) {
                comboBox.setPromptText(key + " obligatoire !");
                comboBox.setStyle("-fx-prompt-text-fill: red; -fx-font-size: 16px; -fx-border-color:red; -fx-border-width:1.5px;");
                state = false;
            } else {
                comboBox.setStyle("-fx-border-color:none;-fx-border-width:0px;-fx-font-size: 16px;");
            }
        }
    });

    return state;
}

public void addUtilisateur(){
        System.out.println(controlInputsUtilisateur());
        if(controlInputsUtilisateur()) {
           //les informations du fournisseur
           Utilisateur utilisateur = new Utilisateur();
           utilisateur.setEmail(emailUtilisateurt.getText());
           utilisateur.setNom(nomUtilisateurt.getText());
           utilisateur.setMotDepasse(motDePasseUtilisateurt.getText());
           utilisateur.setRole(roleUtilisateurt.getValue());
           utilisateur.setQuestion("je sui un developpeur");

           UtilisateurDAO u_dao = new UtilisateurDAO();
           u_dao.create(utilisateur); //envoi des données dans la table
           
           clearUtilisateur();
           showConfirmationDialog();  
           tableListeUtilisateur();
           
        }
}
public void updateUtilisateur(){
        System.out.println(controlInputsUtilisateur());
        if(controlInputsUtilisateur()) {
           //les informations du fournisseur
           Utilisateur utilisateur = new Utilisateur();
           utilisateur.setIdUtilisateur(2);
           utilisateur.setEmail(emailUtilisateurt.getText());
           utilisateur.setNom(nomUtilisateurt.getText());
           utilisateur.setMotDepasse(motDePasseUtilisateurt.getText());
           utilisateur.setRole(roleUtilisateurt.getValue());
           utilisateur.setQuestion("je sui un developpeur");
           UtilisateurDAO u_dao = new UtilisateurDAO();
           u_dao.updateUser(utilisateur); //envoi des données dans la table
           
           clearUtilisateur();
           showConfirmationDialog();  
           tableListeUtilisateur();
           
        }
}
    
public void clearUtilisateur() {
        // Code pour réinitialiser les champs à leur valeur par défaut
        nomUtilisateurt.clear();
        emailUtilisateurt.clear();
        roleUtilisateurt.getItems().clear();
        motDePasseUtilisateurt.clear();
        nomUtilisateurt.setStyle("-fx-border-color:none;-fx-border-width:0px;-fx-font-size: 16px;");
        emailUtilisateurt.setStyle("-fx-border-color:none;-fx-border-width:0px;-fx-font-size: 16px;");
        roleUtilisateurt.setStyle("-fx-border-color:none;-fx-border-width:0px;-fx-font-size: 16px;");
        motDePasseUtilisateurt.setStyle("-fx-border-color:none;-fx-border-width:0px;-fx-font-size: 16px;");
        tableListeUtilisateur();
        utilisateurRole();
    }
    
    
public void tableListeUtilisateur(){
        // Définir comment les colonnes accèdent aux valeurs des objets utilisateur
        colIdUser.setCellValueFactory(new PropertyValueFactory<>("idUtilisateur"));
        colNomUtilisateur.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colEmailUtilisateur.setCellValueFactory(new PropertyValueFactory<>("email"));
        colRoleUtilisateur.setCellValueFactory(new PropertyValueFactory<>("role"));
        // Créer l'ObservableList pour stocker les données des enregistrements de votre table utilisateur
        ObservableList<Utilisateur> utilisateurList = FXCollections.observableArrayList();
        // Récupérer les enregistrements de la table "utilisateur" depuis la base de données
        UtilisateurDAO u_dao = new UtilisateurDAO();
        List<Utilisateur> utilisateurFromDB = u_dao.listUtilisateur();
        // Ajouter les objets utilisateur à l'ObservableList
        utilisateurList.addAll(utilisateurFromDB);
        // Définir la source de données de votre TableView pour la liste utilisateur
        tableListeUtilisateur.setItems(utilisateurList);
    }
    
public void chargertableListeUtilisateur() {
    Utilisateur utilisateur = tableListeUtilisateur.getSelectionModel().getSelectedItem();
    int num = tableListeUtilisateur.getSelectionModel().getSelectedIndex();
    if (num < 0) {
        return;
    }

    nomUtilisateurt.setText(utilisateur.getNom());
    emailUtilisateurt.setText(utilisateur.getEmail());
    motDePasseUtilisateurt.setText(utilisateur.getMotDepasse());
    utilisateurRole();
    //roleUtilisateurt.setValue(utilisateur.getRole());
}

public void logOut(Stage stage) throws Exception {
       
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));                    
            Scene scene = new Scene(root);
            //insertion de la feuille de style
            scene.getStylesheets().add("/CSS/login_and_register_stylesheet.css");
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();  
            
    }
public void deconnexion() throws Exception{
   
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Voulez-vous vous deconnecté ?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
             
            Stage stage = new Stage();
            logOut(stage); //la méthode qui permet de passer sur le dashboard
            logout.getScene().getWindow().hide();
        }
}

public void homeWidget() {
    CommandeDAO cmd_dao = new CommandeDAO();
    ClientDAO client_dao = new ClientDAO();
    FournisseurDAO f_dao = new FournisseurDAO();
    MaterielDAO m_dao = new MaterielDAO();
    nbrClient.setText(""+client_dao.listClient().size());
    nbrFournisseur.setText(""+f_dao.listFournisseur().size());
    nbrMateriel.setText(""+m_dao.listMateriel().size());
    
    Double montant = 0.;
    List<Commande> liste_cmd = cmd_dao.listCommande();
    for(int i=0;i<liste_cmd.size();i++){
        montant += liste_cmd.get(i).getMontant();
    }
    venteTotale.setText(""+montant);
    
}

// page gestionnaire


// Déclarer et initialiser les colonnes de la table


public void alimenterPieChart() {
    CommandeDAO cmd = new CommandeDAO();
    List<Commande> commandes = cmd.listCommande();
    Map<String, Double> montantsParDate = new HashMap<>();

    // Calcul du montant total par date
    for (Commande commande : commandes) {
        String dateCommande = commande.getDateCommande();
        double montant = commande.getMontant();

        // Vérifier si la date est déjà présente dans la map
        if (montantsParDate.containsKey(dateCommande)) {
            // Ajouter le montant à la valeur existante
            double montantTotal = montantsParDate.get(dateCommande) + montant;
            montantsParDate.put(dateCommande, montantTotal);
        } else {
            // Ajouter une nouvelle entrée pour la date avec le montant
            montantsParDate.put(dateCommande, montant);
        }
    }

    // Création des données du PieChart
    ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
    for (Map.Entry<String, Double> entry : montantsParDate.entrySet()) {
        String dateCommande = entry.getKey();
        double montantTotal = entry.getValue();
        data.add(new PieChart.Data(dateCommande, montantTotal));
    }

    // Ajout des données au PieChart
    statiqueDateCommande.setData(data);
}


public void alimenterBarChart() {
    ClientDAO c = new ClientDAO();
    List<Client> clients = c.listClient();
    Map<String, Integer> clientsParGenre = new HashMap<>();

    // Compter le nombre de clients par genre
    for (Client client : clients) {
        String genre = client.getGenre();

        // Vérifier si le genre est déjà présent dans la map
        if (clientsParGenre.containsKey(genre)) {
            // Incrémenter le compteur du genre existant
            int count = clientsParGenre.get(genre);
            clientsParGenre.put(genre, count + 1);
        } else {
            // Ajouter un nouveau genre avec un compteur initial de 1
            clientsParGenre.put(genre, 1);
        }
    }

    // Création des séries de données pour le BarChart
    XYChart.Series<String, Integer> series = new XYChart.Series<>();
    for (Map.Entry<String, Integer> entry : clientsParGenre.entrySet()) {
        String genre = entry.getKey();
        int count = entry.getValue();
        series.getData().add(new XYChart.Data<>(genre, count));
    }

    // Effacer les données existantes du BarChart
    clientParGenre.getData().clear();

    // Ajouter la série de données au BarChart
    clientParGenre.getData().add(series);
}


public void printAllClients() {
    TableView<Client> tableView = table_liste_clients; // Utilisez le nom correct de votre TableView

    Printer printer = Printer.getDefaultPrinter();
    PrinterJob printerJob = PrinterJob.createPrinterJob(printer);

    if (printerJob != null) {
        // Configurez les paramètres d'impression (média, orientation, marges, etc.)
        PageLayout pageLayout = printerJob.getPrinter().getDefaultPageLayout();
        printerJob.getJobSettings().setPageLayout(pageLayout);

        // Obtenez le contenu visuel de la TableView en tant qu'objet Node
        Node content = tableView;

        // Créez une nouvelle VBox pour inclure l'entête et le contenu de la TableView
        VBox printContent = new VBox();
        printContent.setSpacing(10); // Espacement entre l'entête et le contenu
        printContent.getChildren().addAll(new Text("LISTE DES CLIENTS"), content);

        // Imprimez le contenu visuel
        boolean printed = printerJob.printPage(printContent);
        if (printed) {
            // Terminez le travail d'impression
            printerJob.endJob();
        } else {
            // Annulez le travail d'impression si une erreur s'est produite
            printerJob.cancelJob();
        }
    }
}



// fin gestionnaire

// fin Page des utilisateurs
public void utilisateurRole(){
    ObservableList<String> list = FXCollections.observableArrayList("Administrateur","User simple");
    roleUtilisateurt.setItems(list); 
}
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        alimenterBarChart();
        alimenterPieChart();
        supprimerFournisseur();
        supprimerMateriel();
        supprimerClient();
        supprimerCommande();
        supprimerDetail();
        homeWidget();
        utilisateurRole();
        populateTableView();
        tableListeMaterielCommande();
        remplirTableViewCommande();
        tableListeUtilisateur();
        remplirTableViewDetailCommande();
        remplirTableViewClient();
        rechercherMateriel.textProperty().addListener((observable, oldValue, newValue) -> {
        //filtrerEtRechercher(Integer.parseInt(newValue));
   });
        
    }  

    private void showErrorMessage(String matériel_introuvable) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

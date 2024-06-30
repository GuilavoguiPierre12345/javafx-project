/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package g5projetjavafx;

import g5.DAO.vente.UtilisateurDAO;
import g5.entity.vente.Utilisateur;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 *
 * @author kallo
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private AnchorPane aside_login_form;
    
    @FXML
    private AnchorPane aside_login_form1;

    @FXML
    private Button aside_login_form_button;

    @FXML
    private Button aside_login_form_button11;

    @FXML
    private Button error_login;

    @FXML
    private Label label_error;

    @FXML
    private AnchorPane login_form;

    @FXML
    private Button login_form_button;

    @FXML
    private Button login_form_forgot_password;

    @FXML
    private TextField login_form_login;

    @FXML
    private PasswordField login_form_password;

    @FXML
    private Button register_button;

    @FXML
    private PasswordField register_confirmation;

    @FXML
    private TextField register_email;

    @FXML
    private AnchorPane register_form;

    @FXML
    private TextField register_login;

    @FXML
    private PasswordField register_password;

    @FXML
    private ComboBox<String> register_role;

    @FXML
    private StackPane stack_login_register;

    @FXML
    private AnchorPane user_login_form;

    @FXML
    private AnchorPane window_register;
    
    @FXML
    private TextField register_question;
    

      
    Utilisateur user = new Utilisateur();
    UtilisateurDAO user_dao = new UtilisateurDAO();
    
    public void swicthForm(ActionEvent event) {
        TranslateTransition slider = new TranslateTransition();
        TranslateTransition slider1 = new TranslateTransition();
        
        if(event.getSource() == aside_login_form_button) {
            List<Utilisateur> userList = user_dao.listUtilisateur();
            if(!userList.isEmpty()) {
                aside_login_form_button.setVisible(false);
                return;
            }
            
            slider.setNode(aside_login_form);
            slider.setToX(407);
            
            slider.setDuration(Duration.seconds(.5));
            slider.setOnFinished((ActionEvent e)->{      
                user_login_form.setVisible(false);
                window_register.setVisible(true);
            });
            
            slider.play();
            
            
        }else if(event.getSource() == aside_login_form_button11) {
            slider1.setNode(aside_login_form1);
            slider1.setToX(-407);
            
            slider.setNode(aside_login_form);
            slider.setByX(-407);
            
            slider1.setDuration(Duration.seconds(.5));
            slider1.setOnFinished((ActionEvent e)->{      
                user_login_form.setVisible(true);
                window_register.setVisible(false);
            });
            
            slider1.play();
            slider.play();
        }
    }
    
    Boolean state = true;
    String pass = "";
    String conf = "";
    public Boolean controlRegisterValue() {
        state = true;
        Map<String,TextField> admin = new HashMap<>();
            admin.put("login", register_login);
            admin.put("email", register_email);
            admin.put("password", register_password);
            admin.put("confirmation", register_confirmation);
            admin.put("question", register_question);
           // admin.put("role", register_role.getValue);

            admin.forEach((key,value)->{
            if (value.getText().length() == 0){
               
               value.setPromptText(key+" obligatoire !");
               value.setStyle("-fx-prompt-text-fill: red; -fx-font-size: 16px; -fx-border-color:red; -fx-border-width:1.5px;");
               state = false;
           }else{
                
               if(key.equals("password")){
                   pass = value.getText();
               }
               if(key.equals("confirmation")){
                   conf = value.getText();
               }
               value.setStyle("-fx-border-color:none;-fx-border-width:0px;-fx-font-size: 16px;");
           } 
           } 
            );
            if(register_role.getValue()==null){
                //register_role.setStyle(pass);
                register_role.setStyle("-fx-prompt-text-fill: red; -fx-font-size: 16px; -fx-border-color:red; -fx-border-width:1.5px;");
                state = false;
            }
                if((pass.length()!=0) && (conf.length()!=0)){
                    if(!(pass.equals(conf))){
                        label_error.setText("Mot de passe non identique !");
                        state = false;
                    }
                }
            
         return state;
    }
    public void EventExample(ActionEvent event) {
        if(event.getSource()== register_button) {
            //controle des champs
            //System.out.println(controlRegisterValue());
            
            if(controlRegisterValue()){
                //connexion au backend
                user.setNom(register_login.getText());
                user.setEmail(register_email.getText());
                user.setMotDepasse(register_password.getText());
                user.setRole(register_role.getValue());
                user.setQuestion(register_question.getText());
                
                user_dao.create(user);
                label_error.setText("Utilisateur ajouter avec succès.");
            }
        }
    }
    
    public void gotoDashboard(Stage stage) throws Exception {
       
        Parent root = FXMLLoader.load(getClass().getResource("javaFXtest.fxml"));                    
            Scene scene = new Scene(root);
            //insertion de la feuille de style
            scene.getStylesheets().add("/CSS/javafxtest.css");
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();  
            
    }
    
    public void connectionControl(ActionEvent event) throws Exception {
        if(event.getSource() == login_form_button) {
                    
            List<Utilisateur> userList = user_dao.listUtilisateur();
            
            for(int i=0;i<userList.size();i++){
                if (
                        (userList.get(i).getNom().equals(login_form_login.getText()))
                        && 
                        (userList.get(i).getMotDepasse().equals(login_form_password.getText()))
                        
                    )
                {   
                    Stage stage = new Stage();
                    gotoDashboard(stage); //la méthode qui permet de passer sur le dashboard
                    login_form_button.getScene().getWindow().hide();
                    break;
                }else{
                    error_login.setText("Informations incorrect !");
                }
                //System.out.println(userList.get(i).getNom() + " "+userList.get(i).getMotDePasse());
            }
           
        } 
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> list = FXCollections.observableArrayList("Administrateur","User simple");
        register_role.setItems(list); 
    }    
    
}

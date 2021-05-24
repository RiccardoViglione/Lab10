/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.rivers;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.rivers.model.Measurements;
import it.polito.tdp.rivers.model.Model;
import it.polito.tdp.rivers.model.River;
import it.polito.tdp.rivers.model.Simulator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	private Model model;
	private Simulator sim;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="boxRiver"
    private ComboBox<River> boxRiver; // Value injected by FXMLLoader

    @FXML // fx:id="txtStartDate"
    private TextField txtStartDate; // Value injected by FXMLLoader

    @FXML // fx:id="txtEndDate"
    private TextField txtEndDate; // Value injected by FXMLLoader

    @FXML // fx:id="txtNumMeasurements"
    private TextField txtNumMeasurements; // Value injected by FXMLLoader

    @FXML // fx:id="txtFMed"
    private TextField txtFMed; // Value injected by FXMLLoader

    @FXML // fx:id="txtK"
    private TextField txtK; // Value injected by FXMLLoader

    @FXML // fx:id="btnSimula"
    private Button btnSimula; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader
@FXML
    void rimepi(ActionEvent event) {
this.txtResult.clear();
this.txtK.clear();
this.txtFMed.clear();
this.txtEndDate.clear();
this.txtStartDate.clear();
txtNumMeasurements.clear();
River r=(River) this.boxRiver.getValue();   
if(r != null) {
	Measurements m = this.model.getMeasurementsInfo(r);
	txtStartDate.setText(m.getStartDate().toString());
	txtEndDate.setText(m.getEndDate().toString());
	txtNumMeasurements.setText(""+m.getNumMeasurements());
	txtFMed.setText(""+m.getfMed()); 
}
else {
	txtResult.setText("Scegliere un fiume");
	return;
}
}


    @FXML
    void doSimula(ActionEvent event) {
this.txtResult.clear();
String ks=txtK.getText() ;
float k;
try {
	k=Float.parseFloat(ks);
	}
    catch(NumberFormatException nfe) {
    	this.txtResult.setText("Inserire un numero");
    	return;
    }

  this.sim.setK(k);
this.sim.setfMed(Float.parseFloat(txtFMed.getText()));
this.sim.setR(boxRiver.getValue());
this.sim.run();
this.txtResult.appendText("Giorni di disserviizio: " +this.sim.giorni() +"\n\n" );
txtResult.appendText("Cmed: " + this.sim.cMed());
}
        @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert boxRiver != null : "fx:id=\"boxRiver\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtStartDate != null : "fx:id=\"txtStartDate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtEndDate != null : "fx:id=\"txtEndDate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNumMeasurements != null : "fx:id=\"txtNumMeasurements\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtFMed != null : "fx:id=\"txtFMed\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtK != null : "fx:id=\"txtK\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnSimula != null : "fx:id=\"btnSimula\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }public void setModel(Model model) {
    	this.model=model;
    	this.sim=new Simulator();
    	this.boxRiver.getItems().addAll(this.model.getAllRivers());    }
}



/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */
/*
package it.polito.tdp.rivers;

import java.net.URL;

import java.util.ResourceBundle;

import it.polito.tdp.rivers.model.Measurements;
import it.polito.tdp.rivers.model.Model;
import it.polito.tdp.rivers.model.River;
import it.polito.tdp.rivers.model.Simulator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model;
	private Simulator sim;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="boxRiver"
    private ComboBox<River> boxRiver; // Value injected by FXMLLoader

    @FXML // fx:id="txtStartDate"
    private TextField txtStartDate; // Value injected by FXMLLoader

    @FXML // fx:id="txtEndDate"
    private TextField txtEndDate; // Value injected by FXMLLoader

    @FXML // fx:id="txtNumMeasurements"
    private TextField txtNumMeasurements; // Value injected by FXMLLoader

    @FXML // fx:id="txtFMed"
    private TextField txtFMed; // Value injected by FXMLLoader

    @FXML // fx:id="txtK"
    private TextField txtK; // Value injected by FXMLLoader

    @FXML // fx:id="btnSimula"
    private Button btnSimula; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader
    
    @FXML
    void rimepi(ActionEvent event) {
    	txtResult.clear();
    	txtK.clear();
		txtFMed.clear();
		txtNumMeasurements.clear();
		txtStartDate.clear();
		txtEndDate.clear();
		
    	River r = this.boxRiver.getValue();
    	if(r != null) {
    		Measurements m = this.model.getMeasurementsInfo(r);
    		txtStartDate.setText(m.getStartDate().toString());
    		txtEndDate.setText(m.getEndDate().toString());
    		txtNumMeasurements.setText(""+m.getNumMeasurements());
    		txtFMed.setText(""+m.getfMed()); 
    	}
    	else {
    		txtResult.setText("Scegliere un fiume");
    		return;
    	}
    }

    @FXML
    void doSimula(ActionEvent event) {
    	txtResult.clear();
    	String ks = txtK.getText();
    	float k;
    	try {
    		k = Float.parseFloat(ks);
    	}
    	catch(NumberFormatException nfe) {
    		txtResult.setText("Inserire un numero");
    		return;
    	}
    	this.sim.setK(k);
    	this.sim.setfMed(Float.parseFloat(txtFMed.getText()));
    	this.sim.setR(boxRiver.getValue());
    	
    	this.sim.run();
    	
    	txtResult.appendText("Giorni di disservizio: " + this.sim.giorni() + "\n\n");
    	txtResult.appendText("Cmed: " + this.sim.cMed());
    }
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert boxRiver != null : "fx:id=\"boxRiver\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtStartDate != null : "fx:id=\"txtStartDate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtEndDate != null : "fx:id=\"txtEndDate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNumMeasurements != null : "fx:id=\"txtNumMeasurements\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtFMed != null : "fx:id=\"txtFMed\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtK != null : "fx:id=\"txtK\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnSimula != null : "fx:id=\"btnSimula\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
    }
    
    public void setModel(Model model) {
    	this.model = model;
    	this.sim = new Simulator();
    	this.boxRiver.getItems().addAll(this.model.getAllRivers());
    }
}
*/







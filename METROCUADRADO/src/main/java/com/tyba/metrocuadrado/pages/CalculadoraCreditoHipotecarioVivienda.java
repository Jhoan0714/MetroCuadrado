/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tyba.metrocuadrado.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author Jhoan Lopez
 */
public class CalculadoraCreditoHipotecarioVivienda {

    private WebDriver driver;

    @FindBy(id = "ingresosMensuales")
    private WebElement ingresosMensuales;
    
    @FindBy(xpath = "//*[@id=\"tabcordion-body-1\"]/div[1]/form/div[2]/select")
    private WebElement plazo;
    
    @FindBy(xpath = "//*[@id=\"tabcordion-body-1\"]/div[1]/form/button")
    private WebElement calcular;
    
    public CalculadoraCreditoHipotecarioVivienda(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
    
    public void calcularCredito(String ingresosMensuales, int indice){
        this.ingresosMensuales.sendKeys(ingresosMensuales);
        seleccionarPlazo(indice);
        calcular.click();
    }
    
    private void seleccionarPlazo(int indice){
        Select select = new Select(plazo);
        select.selectByIndex(indice); 
    }

}

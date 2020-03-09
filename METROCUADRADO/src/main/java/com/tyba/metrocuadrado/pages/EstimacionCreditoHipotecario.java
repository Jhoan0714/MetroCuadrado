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

/**
 *
 * @author Jhoan Lopez
 */
public class EstimacionCreditoHipotecario {

    private WebDriver driver;

    @FindBy(xpath = "/html/body/div[3]/div[2]/div/div/div[1]/div[3]/div[1]/dl[1]/dd")
    private WebElement ingresosMensual;

    @FindBy(xpath = "/html/body/div[3]/div[2]/div/div/div[1]/div[3]/div[1]/dl[2]/dd")
    private WebElement bancoPrestaHasta;

    @FindBy(xpath = "/html/body/div[3]/div[2]/div/div/div[1]/div[3]/div[1]/dl[3]/dd")
    private WebElement cuotaInicial;
    
    @FindBy(xpath = "/html/body/div[3]/div[2]/div/div/div[1]/div[3]/div[1]/dl[3]/dd")
    private WebElement compraInmuebleValor;
    
    public EstimacionCreditoHipotecario(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
    
    public String[] verificarEstimacionCredito(){
        String[] datos = new String[]{ingresosMensual.getText().replaceAll("\\$|,", ""),bancoPrestaHasta.getText().replaceAll("\\$|,", ""),cuotaInicial.getText().replaceAll("\\$|,", ""),compraInmuebleValor.getText().replaceAll("\\$|,", "")};
        return datos;
    }
}

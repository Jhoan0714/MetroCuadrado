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
public class CalcularValorCuotas {

    private WebDriver driver;

    @FindBy(className = "vercuotas")
    private WebElement verCoutas;

    @FindBy(name = "loadAmount")
    private WebElement valorCredito;

    @FindBy(xpath = "//*[@id=\"tabcordion-body-2\"]/div/div[1]/form/div[2]/select")
    private WebElement plazo;

    @FindBy(xpath = "//*[@id=\"tabcordion-body-2\"]/div/div[1]/form/button")
    private WebElement calcular;

    public CalcularValorCuotas(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void calcularCuotas(String plazo, int indice) throws InterruptedException {
        verCoutas.click();
        this.valorCredito.sendKeys(plazo);
        Thread.sleep(5000);
        seleccionarPlazo(indice);
        calcular.click();
        Thread.sleep(5000);
    }

    private void seleccionarPlazo(int indice) {
        Select select = new Select(plazo);
        select.selectByIndex(indice);
    }

}

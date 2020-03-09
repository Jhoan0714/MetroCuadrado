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
public class EstimacionValorCuotas {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"tabcordion-body-2\"]/div/div[3]/div[1]/dl[1]/dd")
    private WebElement montoCredito;

    @FindBy(xpath = "//*[@id=\"tabcordion-body-2\"]/div/div[3]/div[1]/dl[2]/dd")
    private WebElement ingresosMensuales;

    @FindBy(xpath = "//*[@id=\"tabcordion-body-2\"]/div/div[3]/div[1]/dl[3]/dd")
    private WebElement cuotaInicial;

    @FindBy(xpath = "//*[@id=\"tabcordion-body-2\"]/div/div[3]/div[1]/dl[4]/dd")
    private WebElement compraInmuebleValor;

    public EstimacionValorCuotas(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public String[] verificarEstimacionCuotas() {
        return new String[]{montoCredito.getText().replaceAll("\\$|,", ""), ingresosMensuales.getText().replaceAll("\\$|,", ""), cuotaInicial.getText().replaceAll("\\$|,", ""), compraInmuebleValor.getText().replaceAll("\\$|,", "")};
    }
}

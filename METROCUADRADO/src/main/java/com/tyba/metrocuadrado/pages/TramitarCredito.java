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
public class TramitarCredito {

    private WebDriver driver;

    @FindBy(name = "userNameLQN")
    private WebElement usuario;

    @FindBy(name = "userIdLQN")
    private WebElement identificacion;

    @FindBy(name = "userEmailLQN")
    private WebElement email;

    @FindBy(name = "userPhoneNumberLQN")
    private WebElement telefono;
    
    @FindBy(name = "userCityLQN")
    private WebElement ciudad;
    
    @FindBy(name = "loadAmountLQN")
    private WebElement valorInmueble;
    
    @FindBy(name = "creditAmountLQN")
    private WebElement valorCredito;
    
    @FindBy(id = "select-termInYearsLQN")
    private WebElement plazo;

    public TramitarCredito(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void calcularCuotas(String userName, String identificacion,String email,String telefono,int ciudadIndice,String valorInmueble,String valorCredito, int plazoIndice){
        this.usuario.sendKeys(userName);
        this.identificacion.sendKeys(userName);
        this.email.sendKeys(email);
        this.telefono.sendKeys(telefono);
        seleccionarOpcionar(ciudadIndice,ciudad);
        this.valorInmueble.sendKeys(valorInmueble);
        this.valorCredito.sendKeys(valorCredito);
        seleccionarOpcionar(plazoIndice,plazo);
    }

    private void seleccionarOpcionar(int indice,WebElement element) {
        Select select = new Select(element);
        select.selectByIndex(indice);
    }
}

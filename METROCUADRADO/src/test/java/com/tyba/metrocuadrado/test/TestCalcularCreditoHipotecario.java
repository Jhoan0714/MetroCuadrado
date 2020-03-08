/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tyba.metrocuadrado.test;

import com.tyba.metrocuadrado.pages.CalculadoraCreditoHipotecarioVivienda;
import com.tyba.metrocuadrado.pages.EstimacionCreditoHipotecario;
import com.tyba.metrocuadrado.utils.report.ReportManager;
import com.tyba.metrocuadrado.utils.report.ReportTestManager;
import java.lang.reflect.Method;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author Jhoan Lopez
 */
public class TestCalcularCreditoHipotecario extends MetroCuadrado {

    @BeforeTest
    public void test() {
        ReportManager.name = "Calcular Credito.html";
    }

    @Test(priority = 0, description = "Calcular Credito Hipotecario Vivienda")
    public void calcularCreditoVivienda(Method method) throws InterruptedException {
        ReportTestManager.startTest(method.getName(), "Calcular Credito Hipotecario Vivienda");
        CalculadoraCreditoHipotecarioVivienda cchv = new CalculadoraCreditoHipotecarioVivienda(driver);
        cchv.calcularCredito("2500000", 0);
    }

    @Test(priority = 1, description = "Verificar Estimacion Credito")
    public void verificareEstimacionCredito(Method method) {
        ReportTestManager.startTest(method.getName(), "Verificar estimacion del credito - Teniendo en cuenta los siguientes valores(Cuanto puede prestar el banco,¿Cuota inicia minima de?, ¿Puede comprar un inmueble de?");
        EstimacionCreditoHipotecario ech = new EstimacionCreditoHipotecario(driver);
        String[] values = ech.verificarEstimacionCredito();
        System.out.println("Valores " + values[0]);
        Assert.assertEquals("2500000",values[0]);
    }

}

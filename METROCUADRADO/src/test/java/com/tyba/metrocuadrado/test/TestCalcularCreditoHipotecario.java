/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tyba.metrocuadrado.test;

import com.tyba.metrocuadrado.pages.CalculadoraCreditoHipotecarioVivienda;
import com.tyba.metrocuadrado.pages.EstimacionCreditoHipotecario;
import com.tyba.metrocuadrado.pages.TramitarCredito;
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
        ReportManager.name = "Calcular Credito Hipotecario.html";
    }

    @Test(priority = 0, description = "Calcular Credito Hipotecario Vivienda")
    public void calcularCreditoVivienda(Method method){
        ReportTestManager.startTest(method.getName(), "Calcular Credito Hipotecario Vivienda");
        CalculadoraCreditoHipotecarioVivienda cchv = new CalculadoraCreditoHipotecarioVivienda(driver);
        cchv.calcularCredito("2500000", 0);
    }

    @Test(priority = 1, description = "Verificar Estimacion Credito")
    public void verificarEstimacionCredito(Method method) {
        ReportTestManager.startTest(method.getName(), "Verificar estimacion del credito, teniendo en cuenta las siguientes variables<p> - Cuanto puede prestar el banco<p> - Cuota inicia minima de?<p> - Puede comprar un inmueble de?");
        EstimacionCreditoHipotecario ech = new EstimacionCreditoHipotecario(driver);
        String[] values = ech.verificarEstimacionCredito();
        assert "2500000".equals(values[0].trim()) : "El ingreso mensual no corresponde al ingresado en la calculadora";
        assert Integer.parseInt(values[1].trim()) > 0 : "El monto que el banco prestara no es correcto";
        assert Integer.parseInt(values[2].trim()) >= 0 : "El valor de la cuota inicial no es correcto";
        assert Integer.parseInt(values[3].trim()) > 0 : "El valor compra maximo de inmueble no es correcto";
    }

    @Test(priority = 2, description = "Tramitar Credito")
    public void tramitarCredito(Method method) throws InterruptedException {
        ReportTestManager.startTest(method.getName(), "Ingresa la informacion del usuario para iniciar con el tramite del credito");
        TramitarCredito tc = new TramitarCredito(driver);
        tc.calcularCuotas("Jose Lopez", "123456789", "abcd@gmail.com", "7456789", 1, "150000000", "45000000", 1);
    }

}

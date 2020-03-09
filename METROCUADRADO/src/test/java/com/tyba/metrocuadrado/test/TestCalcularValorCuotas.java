/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tyba.metrocuadrado.test;

import com.tyba.metrocuadrado.pages.CalculadoraCreditoHipotecarioVivienda;
import com.tyba.metrocuadrado.pages.CalcularValorCuotas;
import com.tyba.metrocuadrado.pages.EstimacionCreditoHipotecario;
import com.tyba.metrocuadrado.pages.EstimacionValorCuotas;
import com.tyba.metrocuadrado.utils.report.ReportManager;
import com.tyba.metrocuadrado.utils.report.ReportTestManager;
import java.lang.reflect.Method;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author Jhoan Lopez
 */
public class TestCalcularValorCuotas extends MetroCuadrado {

    @BeforeTest
    public void test() {
        ReportManager.name = "Calcular Valor Cuotas.html";
    }

    @Test(priority = 0, description = "Calcular Valor Cuotas")
    public void calcularValorCuotas(Method method) throws InterruptedException {
        ReportTestManager.startTest(method.getName(), "Calcular el Valor de las Cuotas de Acuerdo a un Monto Solicitado");
        CalcularValorCuotas cvc = new CalcularValorCuotas(driver);
        cvc.calcularCuotas("35000000", 1);
    }

    @Test(priority = 1, description = "Verificar Estimacion Cuotas")
    public void verificarEstimacionCredito(Method method) {
        ReportTestManager.startTest(method.getName(), "Verificar estimacion de las cuotas");
        EstimacionValorCuotas ecv = new EstimacionValorCuotas(driver);
        String[] values = ecv.verificarEstimacionCuotas();
        assert "35000000".equals(values[0].trim()) : "El valor del credito no corresponde al ingresado en la calculadora";
        assert Integer.parseInt(values[1].trim()) > 0 : "Los ingresos mensuales no son validos";
        assert Integer.parseInt(values[2].trim()) >= 0 : "El valor de la cuota inicial no es correcto";
        assert Integer.parseInt(values[3].trim()) > 0 : "El valor compra maximo de inmueble no es correcto";
    }
}

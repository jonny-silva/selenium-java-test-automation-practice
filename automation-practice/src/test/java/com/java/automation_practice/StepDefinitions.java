package com.java.automation_practice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;

import hooks.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pages.CheckoutPage;
import pages.Home;
import pages.ProductItemPage;

public class StepDefinitions {

	private Home home;

	private ProductItemPage productItemPage;

	private CheckoutPage checkoutPage;
	
	private String productName;

	@Dado("que eu selecionei um produto")
	public void que_eu_selecionei_um_produto() {
		home = new Home();

		productName = home.getProductName();

		home.addRandomProductToCart();

		productItemPage = new ProductItemPage();

		assertEquals(productName, productItemPage.getProductName());

	}

	@Dado("defini a quantidade para {int}")
	public void defini_a_quantidade_para(Integer quantidade) {
		productItemPage.setQuantity(quantidade.toString());
	}

	@Dado("adicionei o produto ao carrinho")
	public void adicionei_o_produto_ao_carrinho() {
		productItemPage.addToCart();
	}

	@Quando("Eu clicar em proceder para o checkout")
	public void eu_clicar_em_proceder_para_o_checkout() {
		assertTrue(productItemPage.isModalReady(20));
		productItemPage.clickProceedToCheckout();
	}

	@Entao("o produto selecionado deve estar presente no carrinho")
	public void o_produto_selecionado_deve_estar_presente_no_carrinho() {
		checkoutPage =  new CheckoutPage();
		
		checkoutPage.refreshPage();
		assertEquals(productName, checkoutPage.getProductName());
		
	}

	@Entao("a quantidade deve ser {int}")
	public void a_quantidade_deve_ser(Integer quantidade) {
		assertEquals(quantidade.toString(), checkoutPage.getQuantity());
	}

	@Before
	public static void setUp() {
		try {
			TestBase.setUp();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@After
	public static void tearDown() {
		TestBase.tearDown();
	}
}

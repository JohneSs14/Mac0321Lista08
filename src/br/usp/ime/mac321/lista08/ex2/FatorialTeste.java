package br.usp.ime.mac321.lista08.ex2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.usp.ime.mac321.lista08.ex1.FatorialController;
import br.usp.ime.mac321.lista08.ex1.FatorialView;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;

public class FatorialTeste {

	@Test
	public void testCalcularFatorial() {
		BigInteger result = FatorialController.calcularFatorial(5);
		assertEquals(BigInteger.valueOf(120), result);
	}

	@Test
	public void testCalcularFatorialWithNegativeNumber() {
		try {
			FatorialController.calcularFatorial(-1);
			assertEquals(true, false);
		} catch (IllegalArgumentException e) {
			assertEquals("O número deve ser não-negativo.", e.getMessage());
		}
	}

	@Test
	public void testFatorialView() throws InvocationTargetException, InterruptedException {
		FatorialView.start();

		SwingUtilities.invokeAndWait(() -> {
			FatorialView.textField.setText("5");
			FatorialView.button.doClick();
			assertEquals("Resultado: 120", FatorialView.resultLabel.getText());
		});
	}
}

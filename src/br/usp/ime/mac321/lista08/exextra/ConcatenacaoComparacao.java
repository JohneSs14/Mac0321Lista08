package br.usp.ime.mac321.lista08.exextra;

public class ConcatenacaoComparacao {
	public static void main(String[] args) {
		int repeticoes = 100000;

		// Concatenação com String
		long startTime = System.currentTimeMillis();
		String str = "";
		for (int i = 0; i < repeticoes; i++) {
			str += "Hello, World! ";
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Tempo de concatenação com String: " + (endTime - startTime) + " ms");

		// Concatenação com StringBuffer
		startTime = System.currentTimeMillis();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < repeticoes; i++) {
			sb.append("Hello, World! ");
		}
		endTime = System.currentTimeMillis();
		System.out.println("Tempo de concatenação com StringBuffer: " + (endTime - startTime) + " ms");

	}
}

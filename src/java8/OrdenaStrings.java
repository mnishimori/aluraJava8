package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStrings {

	public static void main(String[] args) {
		
		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("casa do código");
		palavras.add("caelum");
		System.out.println("\nList original " + palavras);
		
		
		Comparator<String> comp = new OrdenacaoPorTamanho();
		palavras.sort(comp);
		System.out.println("\nList ordenado pelo tamanho da string " + palavras);
		
		
		Consumer<String> consumidor = new ImprimeNaLinha();
		System.out.println("\nImprime list na linha ");
		palavras.forEach(consumidor);
		
		
		System.out.println("\nImprime list na linha com consumer ");
		Consumer<String> consumidor2 = new Consumer<String>() {

			@Override
			public void accept(String s) {
				System.out.println(s);
			}
		};
		palavras.forEach(consumidor2);
		
		
		System.out.println("\nImprime list na linha com classe anônima ");
		palavras.forEach(new Consumer<String>() {
			@Override
			public void accept(String s) {
				System.out.println(s);
			}
		});
		
		
		System.out.println("\nImprime list na linha lâmbda ");
		palavras.forEach(p -> System.out.println(p));
		
		
		System.out.println("\nComparator com classe anônima ");
		palavras.sort(new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() < o2.length()) return -1;
				if (o1.length() > o2.length()) return 1;
				return 0;
			}
		});
		System.out.println(palavras);

	
		System.out.println("\nComparator com inferface funcional ");
		palavras.sort((o1, o2) -> {
			if (o1.length() < o2.length()) return -1;
			if (o1.length() > o2.length()) return 1;
			return 0;
		});
		System.out.println(palavras);
		
		
		System.out.println("\nComparator com lâmbda ");
		palavras.sort((o1, o2) -> Integer.compare(o1.length(), o2.length()));
		System.out.println(palavras);
		
		
		System.out.println("\nOrdenação sem o método compare, com lâmbda");
		palavras.sort((o1, o2) -> o1.length() - o2.length());
		System.out.println(palavras);
		
		
		// new Thread(() -> System.out.println("Executando um Runnable")).start();
	}

}

class OrdenacaoPorTamanho implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		if (o1.length() < o2.length()) return -1;
		if (o1.length() > o2.length()) return 1;
		return 0;
	}
	
}

class ImprimeNaLinha implements Consumer<String>{

	@Override
	public void accept(String s) {
		System.out.println(s);
	}
	
}

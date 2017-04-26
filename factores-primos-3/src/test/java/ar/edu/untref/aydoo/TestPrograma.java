package ar.edu.untref.aydoo;

import java.io.IOException;

import org.junit.Test;

public class TestPrograma {

	@Test
	public void test() throws IOException {
		Programa programa = new Programa();
		String[] entrada = {"360", "--format=quiet", "--sort=desc"};
		Programa.main(entrada);
	}

}

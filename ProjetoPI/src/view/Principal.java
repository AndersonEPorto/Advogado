package view;

import java.util.ArrayList;

import controller.AdvogadoDao;
import model.Advogado;

public class Principal {

	public static void main(String[] args) {

		AdvogadoDao dao = new AdvogadoDao();
		Advogado advogado = new Advogado();
		
		
		
		ArrayList lista = dao.listaAdvogados();
		
		for (Object object : lista) {
			System.out.println(object);
		}
		
		
	}

}

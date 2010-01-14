package br.com.qualiti.java.avancado.modulo02.parte3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestFixedThreadPool {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Cria��o de um Executor do tipo Fixed Thread Pool
		ExecutorService fixedPool= Executors.newFixedThreadPool(3);
		
		fixedPool.execute( new MessageRunnable("A") );
		fixedPool.execute( new MessageRunnable("B") );
		fixedPool.execute( new MessageRunnable("C") );
		fixedPool.execute( new MessageRunnable("Thread que n�o cabe no pool. Esperou at� uma das j� agendadas terminar.") );
		
		fixedPool.shutdown(); //Libera as instancias de thread do pool (Quando terminarem a execu��o)
	}

}

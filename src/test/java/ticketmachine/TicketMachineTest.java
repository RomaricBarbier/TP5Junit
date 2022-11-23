package ticketmachine;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class TicketMachineTest {
	private static final int PRICE = 50; // Une constante

	private TicketMachine machine; // l'objet à tester

	@BeforeEach
	public void setUp() {
		machine = new TicketMachine(PRICE); // On initialise l'objet à tester
	}

	@Test
	// On vérifie que le prix affiché correspond au paramètre passé lors de l'initialisation
	// S1 : le prix affiché correspond à l’initialisation.
	public void priceIsCorrectlyInitialized() {
		// Paramètres : valeur attendue, valeur effective, message si erreur
		assertEquals(PRICE, machine.getPrice(), "Initialisation incorrecte du prix");
	}

	@Test
	// S2 : la balance change quand on insère de l’argent
	public void insertMoneyChangesBalance() {
		machine.insertMoney(10);
		machine.insertMoney(20);
                // Les montants ont été correctement additionnés  
		assertEquals(10 + 20, machine.getBalance(), "La balance n'est pas correctement mise à jour");              
	}

	@Test
	//S3
	public void nePasImprimerSiPasAssezInserer(){
		machine.insertMoney(PRICE-1);
		assertFalse(machine.printTicket(),"Pas assez d'argent inséré, le billet ne doit pas s'imprimer");
	}

	@Test
	//S4
	public void imprimeSiMontantInsereSuffisant(){
		machine.insertMoney(PRICE);
		assertTrue(machine.printTicket(),"Argent inséré suffisant, le billet doit s'imprimer");
	}

	@Test
	//S5
	public void decrementTicketPrix(){
		machine.insertMoney(PRICE);
		machine.printTicket();
		assertEquals(machine.getPrice()-PRICE,machine.getBalance());
	}

	@Test
	//S6
	public void montantCollecterMitAJour(){
		machine.insertMoney(PRICE);
		assertEquals(PRICE,machine.getBalance());
	}

	@Test
	//S7
	public void rendCorrectementLaMonnaie(){
		machine.insertMoney(PRICE);
		assertEquals(PRICE, machine.refund());
	}

	@Test
	//S8
	public void remetLaBalanceAZero(){
		machine.insertMoney(PRICE);
		machine.refund();
		assertEquals(0,machine.getBalance());
	}
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class FTLDriver extends JPanel{
	private static Random generator = new Random();
	
	//Windows components
	private JFrame window = new JFrame("FLT");

	private JLabel lblCredits = new JLabel("");
	private JLabel lblXP = new JLabel("");
	private JLabel lblTurns = new JLabel("Turns: ");
	private JLabel lblHull = new JLabel("Hull:");
	private JLabel lblArmor = new JLabel("Armor:");
	private JLabel lblShields = new JLabel("Sheilds:");
	private JProgressBar pbHull = new JProgressBar();
	private JProgressBar pbArmor = new JProgressBar();
	private JProgressBar pbShields = new JProgressBar();

	//Main Screen Components
	private JButton btnTravel = new JButton("Travel");
	private JButton btnUpgrade = new JButton("Upgrade");
	private JButton btnInventory = new JButton("Inventory");
	private JButton btnHelp = new JButton("Help");

	//Misc Components
	private JButton btnBack = new JButton("Back");

	//Upgrade Screen Components
	private JLabel lblCostU = new JLabel("XP Cost:");
	private JLabel lblHullU = new JLabel("Hull");
	private JLabel lblArmorU = new JLabel("Armor");
	private JLabel lblShieldsU = new JLabel("Shields");
	private JLabel lblDriveU = new JLabel("FTL Drive");
	private JLabel lblPowerU = new JLabel("Power");
	private JTextField txtHull = new JTextField();
	private JTextField txtArmor = new JTextField(); 
	private JTextField txtShields = new JTextField();
	private JTextField txtDrive = new JTextField();
	private JTextField txtPower = new JTextField();
	private JProgressBar pbHullU = new JProgressBar();
	private JProgressBar pbArmorU = new JProgressBar();
	private JProgressBar pbShieldsU = new JProgressBar();
	private JProgressBar pbDriveU = new JProgressBar();
	private JProgressBar pbPowerU = new JProgressBar();
	private JButton btnHullU = new JButton("Upgrade");
	private JButton btnArmorU = new JButton("Upgrade");
	private JButton btnShieldsU = new JButton("Upgrade");
	private JButton btnDriveU = new JButton("Upgrade");
	private JButton btnPowerU = new JButton("Upgrade");
	
	//Inventory Screen
	private JLabel lblDesc = new JLabel("");
	private JLabel lblIWeap1 = new JLabel("Weapon 1:");
	private JLabel lblIWeap2 = new JLabel("Weapon 2:");
	private JLabel lblIWeap3 = new JLabel("Weapon 3:");
	private JLabel lblIWeap4 = new JLabel("Weapon 4:");
	private JLabel lblIWeap5 = new JLabel("Weapon 5:");
	private JButton btnIWeap1 = new JButton("View");
	private JButton btnIWeap2 = new JButton("View");
	private JButton btnIWeap3 = new JButton("View");
	private JButton btnIWeap4 = new JButton("View");
	private JButton btnIWeap5 = new JButton("View");

	//Travel Screen
	private JLabel lblLoc1 = new JLabel("");
	private JLabel lblLoc2 = new JLabel("");
	private JLabel lblLoc3 = new JLabel("");
	private JLabel lblLoc4 = new JLabel("");
	private JButton btnLoc1 = new JButton("Travel Here:");
	private JButton btnLoc2 = new JButton("Travel Here:");
	private JButton btnLoc3 = new JButton("Travel Here:");
	private JButton btnLoc4 = new JButton("Travel Here:");

	//Encounter Screen part 1
	private JLabel lblEncDesc = new JLabel("");
	private JButton btnExplore = new JButton("Explore");
	
	//Encounter Screen part 2
	private JButton btnAttack = new JButton("Attack");
	private JButton btnConfirm = new JButton("Confirm");

	//Encounter Screen shop
	private JLabel lblStoreDesc = new JLabel("");
	private JLabel lblStore = new JLabel("Store:");
	private JLabel lblSPlayer = new JLabel("Your Inventory:");

	//Player
	private JLabel lblSWeap1 = new JLabel("Weapon 1:");
	private JLabel lblSWeap2 = new JLabel("Weapon 2:");
	private JLabel lblSWeap3 = new JLabel("Weapon 3:");
	private JLabel lblSWeap4 = new JLabel("Weapon 4:");
	private JLabel lblSWeap5 = new JLabel("Weapon 5:");
	private JButton btnSVWeap1 = new JButton("View");
	private JButton btnSVWeap2 = new JButton("View");
	private JButton btnSVWeap3 = new JButton("View");
	private JButton btnSVWeap4 = new JButton("View");
	private JButton btnSVWeap5 = new JButton("View");
	private JButton btnSBWeap1 = new JButton("Sell");
	private JButton btnSBWeap2 = new JButton("Sell");
	private JButton btnSBWeap3 = new JButton("Sell");
	private JButton btnSBWeap4 = new JButton("Sell");
	private JButton btnSBWeap5 = new JButton("Sell");

	//Store
	private JLabel lblStore1 = new JLabel("Item 1:");
	private JLabel lblStore2 = new JLabel("Item 2:");
	private JLabel lblStore3 = new JLabel("Item 3:");
	private JButton btnStoreView1 = new JButton("View");
	private JButton btnStoreBuy1 = new JButton("Buy");
	private JButton btnStoreView2 = new JButton("View");
	private JButton btnStoreBuy2 = new JButton("Buy");
	private JButton btnStoreView3 = new JButton("View");
	private JButton btnStoreBuy3 = new JButton("Buy");

	private JButton btnStoreConfirm = new JButton("Confirm");
	private JLabel lblTransaction = new JLabel("Transaction: ");
	
	//Store varibles
	private int transaction;
	private int inventorySize;
	private boolean buy1 = false;
	private boolean buy2 = false;
	private boolean buy3 = false;
	private boolean sell1 = false;
	private boolean sell2 = false;
	private boolean sell3 = false;
	private boolean sell4 = false;
	private boolean sell5 = false;

	//Repair
	private JLabel lblRepairHull = new JLabel("Cost: ");
	private JLabel lblRepairArmor = new JLabel("Cost: ");
	private JButton btnRepairHull = new JButton("Repair Hull");
	private JButton btnRepairArmor = new JButton("Repair Armor");
	
	//Encoutner Event
	private JLabel lblEventEnd = new JLabel("");
	private JLabel lblEventReward = new JLabel("");
	private JButton btnEventAccept = new JButton("Accept Weapon");
	private JButton btnEventEnd = new JButton("Countinue"); 
	
	//Factions
	private ArrayList<Faction> factionList = new ArrayList<Faction>();
	private int currentFaction;
	private String shipStance;
	
	//Encounter Ship
	//Ship trade
	private int tradeType;
	private JLabel lblTrade = new JLabel ("Their terms:");
	private JLabel lblTradeFor = new JLabel (" for: ");
	private JLabel lblTradeCost = new JLabel ("$");
	private JLabel lblTradeTerm = new JLabel ("");
	private JButton btnTradeAccept = new JButton("Accept");
	private JButton btnTradeDecline = new JButton("Decline");
	private int tradeCost;
	private int tradeXP;
	private Weapon tradeWeapon;
	
	//Combat
	private StarShip npcShip = new StarShip(1);
	private Player npc = new Player(1);
	private int shieldPower = 0;
	private int NpcShieldPower = 0;
	private int creditsCReward;
	private int xpCReward;
	private int scoreCReward;
	private String roundResults;
   private boolean combatEnd = false;

	private int retreatCount = 0;
	private boolean comRetreat = false;
	private int NpcRetreatCount = 0;
	private boolean NpcRetreat = false;
	private ArrayList<Weapon> attackQueue = new ArrayList<Weapon>();
	private ArrayList<Weapon> npcAttackQueue = new ArrayList<Weapon>();
	ArrayList<Integer> speedList = new ArrayList<Integer>();
	ArrayList<Integer> npcSpeedList = new ArrayList<Integer>();

	private boolean fire1 = false;
	private boolean fire2 = false;
	private boolean fire3 = false;
	private boolean fire4 = false;
	private boolean fire5 = false;

	
	private JLabel lblCWeap1 = new JLabel("Weapon 1:");
	private JLabel lblCWeap2 = new JLabel("Weapon 2:");
	private JLabel lblCWeap3 = new JLabel("Weapon 3:");
	private JLabel lblCWeap4 = new JLabel("Weapon 4:");
	private JLabel lblCWeap5 = new JLabel("Weapon 5:");
	private JButton btnCWeap1 = new JButton("Fire");
	private JButton btnCWeap2 = new JButton("Fire");
	private JButton btnCWeap3 = new JButton("Fire");
	private JButton btnCWeap4 = new JButton("Fire");
	private JButton btnCWeap5 = new JButton("Fire");
	private JCheckBox cbWeap1 = new JCheckBox();
	private JCheckBox cbWeap2 = new JCheckBox();
	private JCheckBox cbWeap3 = new JCheckBox();
	private JCheckBox cbWeap4 = new JCheckBox();
	private JCheckBox cbWeap5 = new JCheckBox();
	private JButton btnCombatConfirm = new JButton("Confirm");
	private JLabel lblPowerC = new JLabel("Power");
	private JProgressBar pbPowerC = new JProgressBar();
	private JLabel lblShieldsC = new JLabel("Shield Regen");
	private JButton btnShieldsC = new JButton("Cycle Power");
	private JCheckBox cbShield1 = new JCheckBox();
	private JCheckBox cbShield2 = new JCheckBox();
	private JCheckBox cbShield3 = new JCheckBox();
	private JButton btnRetreat = new JButton("Retreat");
	
	private JLabel lblNpcHp = new JLabel("NPC:");
	private JProgressBar pbNpcHull = new JProgressBar();
	private JProgressBar pbNpcShields = new JProgressBar();
	private JProgressBar pbNpcArmor = new JProgressBar();
	
	private JLabel lblCResults = new JLabel("");
	private JButton btnCombatEnd = new JButton("Continue");
	
	//Combat Success
	private JLabel lblSuccess = new JLabel("<HTML><H1>Success</H1></HTML>");
	private JLabel lblSCredits = new JLabel("Credits: ");
	private JLabel lblSXP = new JLabel("XP: ");
	private JButton btnSuccess = new JButton("Continue");

	//Fail components
	private JLabel lblFailure = new JLabel("<HTML><H1>Failure</H1><br><i>Your ship parished</i></HTML>");
	private JLabel lblFinalScore = new JLabel("Final score: ");
	private JLabel lblTotalCredits = new JLabel("Total credits earned: ");
	private JLabel lblTotalXP = new JLabel("Total XP earned: ");
	
	//Player components
	private Player player = new Player();
	private StarShip playerShip = new StarShip();
	Shop shop = new Shop(1);
	Encounter event = new Encounter(1);

	//UI switches
	private boolean main;
	private boolean upgr;
	private boolean inve;
	private boolean misc;
	private boolean trav;
	private boolean enc1;
	private boolean enc2;
	private boolean stor;
	private boolean even;
	private boolean trad;
	private boolean comb;
	private boolean succ;
	private boolean fail;

	//Other varibles
	private int turns = 0;
	private int difficulty = 0;
	private int currentLocation;
	private int [][] locations = new int[4][2]; //[Locations][Risk,Local]
	private String [] locals = {"Blue Star", "Yellow Star", "Red Star", "White Star", "Brown Star", 
	"Violet Nebula", "Blue Nebula", "Green Nebula", "Red Nebula"};
	private int encounter = 0;
	


	public FTLDriver(){
		//Primary Progress Bar
		pbHull.setMinimum(0);
		pbHull.setMaximum(playerShip.getMaxHull());
		pbHull.setValue(playerShip.getHull());
		pbHull.setStringPainted(true);
		pbHull.setForeground(new Color(120,40,40));
		pbHull.setString("" + (int)(100 * playerShip.getHullPercent()) + "%");
		
		pbArmor.setMinimum(0);
		pbArmor.setMaximum(playerShip.getMaxArmor());
		pbArmor.setValue(playerShip.getArmor());
		pbArmor.setStringPainted(true);
		pbArmor.setForeground(new Color(40,120,40));
		pbArmor.setString("" + (int)(100 * playerShip.getArmorPercent()) + "%");
		
		pbShields.setMinimum(0);
		pbShields.setMaximum(playerShip.getMaxShields());
		pbShields.setValue(playerShip.getShields());
		pbShields.setStringPainted(true);
		pbShields.setForeground(new Color(40,40,120));
		pbShields.setString("" + (int)(100 * playerShip.getShieldsPercent()) + "%");
		
		//Upgrade Setup
		pbHullU.setMinimum(0);
		pbHullU.setMaximum(10);
		pbHullU.setValue(player.getHullLevel());
		pbHullU.setStringPainted(true);
		pbHullU.setForeground(new Color(120,80,80));
		pbHullU.setString("");
		pbHullU.setOrientation(1);
		
		pbArmorU.setMinimum(0);
		pbArmorU.setMaximum(10);
		pbArmorU.setValue(player.getArmorLevel());
		pbArmorU.setStringPainted(true);
		pbArmorU.setForeground(new Color(80,120,80));
		pbArmorU.setString("");
		pbArmorU.setOrientation(1);
		
		pbShieldsU.setMinimum(0);
		pbShieldsU.setMaximum(10);
		pbShieldsU.setValue(player.getShieldsLevel());
		pbShieldsU.setStringPainted(true);
		pbShieldsU.setForeground(new Color(80,80,120));
		pbShieldsU.setString("");
		pbShieldsU.setOrientation(1);
		
		pbDriveU.setMinimum(0);
		pbDriveU.setMaximum(5);
		pbDriveU.setValue(player.getDriveLevel());
		pbDriveU.setStringPainted(true);
		pbDriveU.setForeground(new Color(120,80,150));
		pbDriveU.setString("");
		pbDriveU.setOrientation(1);
		
		pbPowerU.setMinimum(0);
		pbPowerU.setMaximum(10);
		pbPowerU.setValue(player.getDriveLevel());
		pbPowerU.setStringPainted(true);
		pbPowerU.setForeground(new Color(250,220,180));
		pbPowerU.setString("");
		pbPowerU.setOrientation(1);
		
		txtHull.setEnabled(false);
		txtArmor.setEnabled(false);
		txtShields.setEnabled(false);
		txtDrive.setEnabled(false);
		txtPower.setEnabled(false);
		
		//Combat setup
		cbShield1.setEnabled(false);
		cbShield2.setEnabled(false);
		cbShield3.setEnabled(false);
		cbWeap1.setEnabled(false);
		cbWeap2.setEnabled(false);
		cbWeap3.setEnabled(false);
		cbWeap4.setEnabled(false);
		cbWeap5.setEnabled(false);
		
		pbPowerC.setMinimum(0);
		pbPowerC.setMaximum(playerShip.getMaxPower());
		pbPowerC.setValue(playerShip.getMaxPower() - playerShip.getPower());
		pbPowerC.setStringPainted(true);
		pbPowerC.setForeground(new Color(200,180,40));
		pbPowerC.setString("" + (playerShip.getMaxPower() - playerShip.getPower()));

		pbNpcHull.setMinimum(0);
		pbNpcHull.setMaximum(npcShip.getMaxHull());
		pbNpcHull.setValue(npcShip.getHull());
		pbNpcHull.setStringPainted(true);
		pbNpcHull.setForeground(new Color(180,80,80));
		pbNpcHull.setString("");

		pbNpcArmor.setMinimum(0);
		pbNpcArmor.setMaximum(npcShip.getMaxArmor());
		pbNpcArmor.setValue(npcShip.getArmor());
		pbNpcArmor.setStringPainted(true);
		pbNpcArmor.setForeground(new Color(80,180,80));
		pbNpcArmor.setString("");
		
		pbNpcShields.setMinimum(0);
		pbNpcShields.setMaximum(npcShip.getMaxShields());
		pbNpcShields.setValue(npcShip.getShields());
		pbNpcShields.setStringPainted(true);
		pbNpcShields.setForeground(new Color(80,80,180));
		pbNpcShields.setString("");
		
		//Null means no layout
		setLayout(null);
		//Sets coordinates of components and size
		lblCredits.setBounds(10,10,100,20);
		lblXP.setBounds(120,10,100,20);
		lblTurns.setBounds(600,10,100,20);
		lblHull.setBounds(230,35,50,20);
		pbHull.setBounds(230,10,100,20);
		lblArmor.setBounds(340,35,50,20);
		pbArmor.setBounds(340,10,100,20);
		lblShields.setBounds(450,35,50,20);
		pbShields.setBounds(450,10,100,20);
		
		//Main screen
		btnTravel.setBounds(600,50,150,30);
		btnUpgrade.setBounds(600,110,150,30);
		btnInventory.setBounds(600,180,150,30);
		btnHelp.setBounds(600,250,150,30);
		
		//Misc
		btnBack.setBounds(10,500,80,40);
		
		//Upgrade Screen
		txtHull.setBounds(150,420, 100,40);
		txtArmor.setBounds(250,420,100,40);
		txtShields.setBounds(350,420,100,40);
		txtDrive.setBounds(450,420,100,40);
		txtPower.setBounds(550,420,100,40);
		lblCostU.setBounds(90,425,100,30);
		btnHullU.setBounds(150,460,100,30);
		btnArmorU.setBounds(250,460,100,30);
		btnShieldsU.setBounds(350,460,100,30);
		btnDriveU.setBounds(450,460,100,30);
		btnPowerU.setBounds(550,460,100,30);
		lblHullU.setBounds(180,500,50,30);
		lblArmorU.setBounds(280,500,50,30);
		lblShieldsU.setBounds(380,500,50,30);
		lblDriveU.setBounds(480,500,80,30);
		lblPowerU.setBounds(580,500,80,30);
		
		pbHullU.setBounds(175,220,50,200);
		pbArmorU.setBounds(275,220,50,200);
		pbShieldsU.setBounds(375,220,50,200);
		pbDriveU.setBounds(475,220,50,200);
		pbPowerU.setBounds(575,220,50,200);
		
		//Inventory Screen
		lblDesc.setBounds(10,50,300,300);
		lblIWeap1.setBounds(10,420,510,30);
		lblIWeap2.setBounds(170,420,150,30);
		lblIWeap3.setBounds(330,420,150,30);
		lblIWeap4.setBounds(490,420,150,30);
		lblIWeap5.setBounds(650,420,150,30);
		btnIWeap1.setBounds(10,450,150,30);
		btnIWeap2.setBounds(170,450,150,30);
		btnIWeap3.setBounds(330,450,150,30);
		btnIWeap4.setBounds(490,450,150,30);
		btnIWeap5.setBounds(650,450,150,30);
		
		//Travel Screen
		lblLoc1.setBounds(10,100,150,60);
		lblLoc2.setBounds(250,100,150,60);
		lblLoc3.setBounds(10,300,150,60);
		lblLoc4.setBounds(250,300,150,60);
		btnLoc1.setBounds(10,170,150,30);
		btnLoc2.setBounds(250,170,150,30);
		btnLoc3.setBounds(10,370,150,30);
		btnLoc4.setBounds(250,370,150,30);
	
		//Encounter 1
		lblEncDesc.setBounds(10,100,300,300);
		btnExplore.setBounds(700,500,100,40);
		
		//Encounter 2
		btnConfirm.setBounds(10,500,100,40);
		btnAttack.setBounds(110,500,100,40);
	
		//Store
		btnStoreConfirm.setBounds(700,500,80,40);
		lblTransaction.setBounds(540,500,150,40);
		lblStoreDesc.setBounds(10,100,300,450);
	
		btnStoreBuy1.setBounds(480,460,100,30);
		btnStoreBuy2.setBounds(580,460,100,30);
		btnStoreBuy3.setBounds(680,460,100,30);
		btnStoreView1.setBounds(480,430,100,30);
		btnStoreView2.setBounds(580,430,100,30);
		btnStoreView3.setBounds(680,430,100,30);
		lblStore1.setBounds(480,360,100,70);
		lblStore2.setBounds(580,360,100,70);
		lblStore3.setBounds(680,360,100,70);
		lblStore.setBounds(430,380,50,30);
	
		btnSBWeap1.setBounds(480,180,100,30);
		btnSBWeap2.setBounds(580,180,100,30);
		btnSBWeap3.setBounds(680,180,100,30);
		btnSBWeap4.setBounds(480,320,100,30);
		btnSBWeap5.setBounds(580,320,100,30);
		
		btnSVWeap1.setBounds(480,150,100,30);
		btnSVWeap2.setBounds(580,150,100,30);
		btnSVWeap3.setBounds(680,150,100,30);
		btnSVWeap4.setBounds(480,290,100,30);
		btnSVWeap5.setBounds(580,290,100,30);
		
		lblSPlayer.setBounds(380,100,100,30);
		lblSWeap1.setBounds(480,80,100,70);
		lblSWeap2.setBounds(580,80,100,70);
		lblSWeap3.setBounds(680,80,100,70);
		lblSWeap4.setBounds(480,220,100,70);
		lblSWeap5.setBounds(580,220,100,70);
	
		lblRepairHull.setBounds(10,470,100,30);
		lblRepairArmor.setBounds(120,470,100,30);
		btnRepairHull.setBounds(10,500,100,30);
		btnRepairArmor.setBounds(120,500,150,30);
		
		//Event 
		lblEventEnd.setBounds(10,100,300,300);
		lblEventReward.setBounds(400,100,300,300);
		btnEventAccept.setBounds(600,460,200,40);
		btnEventEnd.setBounds(700,500,100,40);
		
		//Ship Trade
		lblTrade.setBounds(300,200,100,40);
		lblTradeFor.setBounds(385,240,40,40);
		lblTradeCost.setBounds(300,240,100,40);
		lblTradeTerm.setBounds(415,240,100,40);
		btnTradeAccept.setBounds(300,280,100,40);
		btnTradeDecline.setBounds(400,280,100,40);
		
		//Combat
		btnCWeap1.setBounds(10,530,100,30);
		btnCWeap2.setBounds(110,530,100,30);
		btnCWeap3.setBounds(210,530,100,30);
		btnCWeap4.setBounds(310,530,100,30);
		btnCWeap5.setBounds(410,530,100,30);
		lblCWeap1.setBounds(10,450,100,80);
		lblCWeap2.setBounds(110,450,100,80);
		lblCWeap3.setBounds(210,450,100,80);
		lblCWeap4.setBounds(310,450,100,80);
		lblCWeap5.setBounds(410,450,100,80);
		cbWeap1.setBounds(10,400,50,50);
		cbWeap2.setBounds(110,400,50,50);
		cbWeap3.setBounds(210,400,50,50);
		cbWeap4.setBounds(310,400,50,50);
		cbWeap5.setBounds(410,400,50,50);
		btnCombatConfirm.setBounds(700,530,100,30);
      btnCombatEnd.setBounds(700,530,100,30);
		lblPowerC.setBounds(540,530,50,30);
		pbPowerC.setBounds(590,530,100,30);
		lblShieldsC.setBounds(10,60,100,40);
		btnShieldsC.setBounds(10,100,150,30);
		cbShield1.setBounds(10,130,50,50);
		cbShield2.setBounds(60,130,50,50);
		cbShield3.setBounds(110,130,50,50);
		btnRetreat.setBounds(700,500,100,30);

		lblNpcHp.setBounds(500,100,200,30);
		pbNpcHull.setBounds(700,100,100,20);
		pbNpcArmor.setBounds(700,120,100,20);
		pbNpcShields.setBounds(700,140,100,20);

		lblCResults.setBounds(10,200,600,200);

		//Combat Success Screen
		lblSuccess.setBounds(10,100,200,50);
		lblSCredits.setBounds(10,150,300,30);
		lblSXP.setBounds(10,180,300,30);
		btnSuccess.setBounds(700,530,100,30);

		//Fail Screen
		lblFailure.setBounds(10,100,200,100);
		lblFinalScore.setBounds(10,200,300,30);
		lblTotalCredits.setBounds(10,230,300,30);
		lblTotalXP.setBounds(10,260,300,30);
	
		//Add Components here
		//Primary UI      
		window.add(lblCredits);
		window.add(lblXP);
		window.add(lblTurns);
		window.add(lblHull);
		window.add(lblArmor);
		window.add(lblShields);
		window.add(pbHull);
		window.add(pbArmor);
		window.add(pbShields);
		
		//Main Screen
		window.add(btnTravel);
		window.add(btnUpgrade);
		window.add(btnInventory);
		window.add(btnHelp);
		
		//Misc
		window.add(btnBack);
		
		//Upgrade
		window.add(txtHull);
		window.add(txtArmor);
		window.add(txtShields);
		window.add(txtDrive);
		window.add(txtPower);
		window.add(lblCostU);
		window.add(lblHullU);
		window.add(lblArmorU);
		window.add(lblShieldsU);
		window.add(lblDriveU);
		window.add(lblPowerU);
		window.add(btnHullU);
		window.add(btnArmorU);
		window.add(btnShieldsU);
		window.add(btnDriveU);
		window.add(btnPowerU);
		window.add(pbHullU);
		window.add(pbArmorU);
		window.add(pbShieldsU);
		window.add(pbDriveU);
		window.add(pbPowerU);
		
		//Inventory
		window.add(lblDesc);
		window.add(lblIWeap1);
		window.add(lblIWeap2);
		window.add(lblIWeap3);
		window.add(lblIWeap4);
		window.add(lblIWeap5);
		window.add(btnIWeap1);
		window.add(btnIWeap2);
		window.add(btnIWeap3);
		window.add(btnIWeap4);
		window.add(btnIWeap5);
	
		//Travel
		window.add(lblLoc1);
		window.add(lblLoc2);
		window.add(lblLoc3);
		window.add(lblLoc4);
		window.add(btnLoc1);
		window.add(btnLoc2);
		window.add(btnLoc3);
		window.add(btnLoc4);
	
		//Encounter 1
		window.add(lblEncDesc);
		window.add(btnExplore);
		
		//Encounter 2
		window.add(btnConfirm);
		window.add(btnAttack);
	
		//Store
		window.add(btnStoreConfirm);
		window.add(lblStoreDesc);
		window.add(lblTransaction);
		window.add(lblStore);
		window.add(lblStore1);
		window.add(lblStore2);
		window.add(lblStore3);
		window.add(btnStoreBuy1);
		window.add(btnStoreBuy2);
		window.add(btnStoreBuy3);
		window.add(btnStoreView1);
		window.add(btnStoreView2);
		window.add(btnStoreView3);
		window.add(lblSWeap1);
		window.add(lblSWeap2);
		window.add(lblSWeap3);
		window.add(lblSWeap4);
		window.add(lblSWeap5);
		window.add(lblSPlayer);
		window.add(btnSVWeap1);
		window.add(btnSVWeap2);
		window.add(btnSVWeap3);
		window.add(btnSVWeap4);
		window.add(btnSVWeap5);
		window.add(btnSBWeap1);
		window.add(btnSBWeap2);
		window.add(btnSBWeap3);
		window.add(btnSBWeap4);
		window.add(btnSBWeap5);
		window.add(lblRepairHull);
		window.add(lblRepairArmor);
		window.add(btnRepairHull);
		window.add(btnRepairArmor);
		
		//Event
		window.add(lblEventEnd);
		window.add(lblEventReward);
		window.add(btnEventAccept);
		window.add(btnEventEnd);
		
		//Ship Trade
		window.add(lblTrade);
		window.add(lblTradeCost);
		window.add(lblTradeFor);
		window.add(lblTradeTerm);
		window.add(btnTradeAccept);
		window.add(btnTradeDecline);
		
		//Combat
		window.add(lblCWeap1);
		window.add(lblCWeap2);
		window.add(lblCWeap3);
		window.add(lblCWeap4);
		window.add(lblCWeap5);
		window.add(btnCWeap1);
		window.add(btnCWeap2);
		window.add(btnCWeap3);
		window.add(btnCWeap4);
		window.add(btnCWeap5);
		window.add(cbWeap1);
		window.add(cbWeap2);
		window.add(cbWeap3);
		window.add(cbWeap4);
		window.add(cbWeap5);
		window.add(btnCombatConfirm);
		window.add(btnCWeap1);
		window.add(btnCWeap2);
		window.add(btnCWeap3);
		window.add(btnCWeap4);
		window.add(btnCWeap5);
		window.add(btnCombatConfirm);
		window.add(lblPowerC);
		window.add(pbPowerC);
		window.add(lblShieldsC);
		window.add(btnShieldsC);
		window.add(cbShield1);
		window.add(cbShield2);
		window.add(cbShield3);
		window.add(btnRetreat);
		
		window.add(lblNpcHp);
		window.add(pbNpcHull);
		window.add(pbNpcShields);
		window.add(pbNpcArmor);
		
		window.add(lblCResults);
		window.add(btnCombatEnd);
		
		//Combat Success
		window.add(lblSuccess);
		window.add(lblSCredits);
		window.add(lblSXP);
		window.add(btnSuccess);

		//Combat Failure
		window.add(lblFailure);
		window.add(lblFinalScore);
		window.add(lblTotalCredits);
		window.add(lblTotalXP);
		
		//Window
		window.add(this);
		window.setSize(850, 600);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Faction f = new Faction();
		factionList.add(f);
		f = new Faction("Merchants Guild",25);
		factionList.add(f);
		f = new Faction("Civilian Core",50);
		factionList.add(f);
		f = new Faction("Steller Industries In.",25);
		factionList.add(f);
		f = new Faction("Bandits",-50);
		factionList.add(f);
		f = new Faction("Red Raven Raiders",-25);
		factionList.add(f);
		f = new Faction("Twin Tail Mauraders", -25);
		factionList.add(f);
		f = new Faction("Maroon Templars",0);
		factionList.add(f);
		f = new Faction("Preservers",0);
		factionList.add(f);
		f = new Faction("Milita",0);
		factionList.add(f);
	
		mainScreen();
		updatePrimaryUI();
		generateLocal();
	
		
		
		btnBack.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e){
					mainScreen();
					updatePrimaryUI();
				}
			});
		
		btnUpgrade.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e){
					upgradeScreen();
					updateUpgradeUI();
				}
			});
		
		btnHullU.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e){
					if(player.getHullLevel() < 10) {
						player.upgradeHull();
						updateUpgradeUI();
						playerShip.improveHull(20);
					
						updatePrimaryUI();
					}
				}
			});
		
		btnArmorU.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e){
					if(player.getArmorLevel() < 10) {
						player.upgradeArmor();
						updateUpgradeUI();
						playerShip.improveArmor(10);
						updatePrimaryUI();
					}
				}
			});
		
		btnShieldsU.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e){
					if(player.getShieldsLevel() < 10) {
						player.upgradeShields();
						updateUpgradeUI();
						playerShip.improveShields(10);
						updatePrimaryUI();
					}
				}
			});
		
		btnDriveU.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e){
					if(player.getDriveLevel() < 5) {
						player.upgradeDrive();
						updateUpgradeUI();
						updatePrimaryUI();
					}
				}
			});
			
			btnPowerU.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e){
					if(player.getDriveLevel() < 10) {
						player.upgradePower();
						updateUpgradeUI();
						updatePrimaryUI();
						playerShip.improvePower(2);
					}
				}
			});
		
		btnInventory.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e){
					inventoryScreen();
					updateInventoryUI();
				}
			});
		
		btnIWeap1.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e){
					int weap = playerShip.getNumWeapons();
					if(weap > 0) {
						Weapon w = playerShip.getWeapon(0);
						lblDesc.setText(w.fullToString());
					}
				
				}
			});
		
		btnIWeap2.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e){
					int weap = playerShip.getNumWeapons();
					if(weap > 1) {
						Weapon w = playerShip.getWeapon(1);
						lblDesc.setText(w.fullToString());
					}
				
				}
			});
		
		btnIWeap3.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e){
					int weap = playerShip.getNumWeapons();
					if(weap > 2) {
						Weapon w = playerShip.getWeapon(2);
						lblDesc.setText(w.fullToString());
					}
				
				}
			});
		
		btnIWeap4.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e){
					int weap = playerShip.getNumWeapons();
					if(weap > 3) {
						Weapon w = playerShip.getWeapon(3);
						lblDesc.setText(w.fullToString());
					}
				
				}
			});
		
		btnIWeap5.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e){
					int weap = playerShip.getNumWeapons();
					if(weap > 4) {
						Weapon w = playerShip.getWeapon(4);
						lblDesc.setText(w.fullToString());
					}
				
				}
			});
	
		btnTravel.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e){
					travelScreen();   
					updateTravelUI(); 
				}   
			});
	
		btnLoc1.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e){
					currentLocation = 0;
					encounter1Screen();
					updateEncounter1UI();
					updateScreen();     
				}
			});
	
		btnLoc2.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e){
					currentLocation = 1;
					encounter1Screen();
					updateEncounter1UI();
					updateScreen();       
				}
			});
	
		btnLoc3.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e){
					currentLocation = 2;
					encounter1Screen();
					updateEncounter1UI();
					updateScreen();       
				}
			});
	
		btnLoc4.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e){
					currentLocation = 3;
					encounter1Screen();
					updateEncounter1UI();
					updateScreen();       
				}
			});
	
		btnExplore.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e){
					if(enc1 == true && enc2 == false) {
						generateEncounter();
					}
					else if(enc2 == true) {
						
						mainScreen();
						turns++;
						playerShip.regenShields();
						player.addScore(50);
						updatePrimaryUI();
					}   
				}
			});
		
		btnConfirm.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e){
				 //Shop
					if(encounter == 1) {
						storeScreen();
						shop = new Shop(locations[currentLocation][0]);
						updateShopUI();
					}
					//Event
					else if(encounter == 2) {
						 eventScreen();
						 updateEventUI();
					}
					//Ship, trade
					else if(encounter == 3) {
						 
						 int roll = generator.nextInt(100); //poor xp trade, good xp trade, poor weapon, good weapon
						 //Poor xp 40%
						 if(roll < 40) {
							tradeType = 0;
						 }
						 //Good xp 15%
						 else if(roll < 55) {
							tradeType = 1;
						 }
						 //Poor weapon 35%
						 else if(roll < 90) {
							tradeType = 2;
						 }
						 //Good weapon 10%
						 else {
							tradeType = 3;
						 }
						 tradeScreen();
						 generateTrade();
						 updateTradeUI();
						 Faction f = factionList.get(currentFaction);
						 f.changeStance(5);
						 factionList.remove(currentFaction);
						 factionList.add(f);
						 currentFaction = factionList.size() - 1;
					}    
				}
			});
		
		
		btnStoreBuy1.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e){
					Weapon w = shop.getWeapon(0);
					if(buy1 == false) {
						if(inventorySize < 5) {
							transaction -= w.getValue();
							updateShopUI();
							buy1 = true;
							inventorySize++;
							
						}
					}
					else {
						transaction += w.getValue();
						updateShopUI();
						buy1 = false;
						inventorySize--;
						
					}
				}
			});
		
		btnStoreBuy2.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e){
					Weapon w = shop.getWeapon(1);
					if(buy2 == false) {
						if(inventorySize < 5) {
							transaction -= w.getValue();
							updateShopUI();
							buy2 = true;
							inventorySize++;
						
						}
					}
					else {
						transaction += w.getValue();
						updateShopUI();
						buy2 = false;
						inventorySize--;
					
					}
				}
			});
		
		btnStoreBuy3.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e){
					Weapon w = shop.getWeapon(2);
					if(buy3 == false) {
						if(inventorySize < 5) {
							transaction -= w.getValue();
							updateShopUI();
							buy3 = true;
							inventorySize++;
						
						}
					}
					else {
						transaction += w.getValue();
						updateShopUI();
						buy3 = false;
						inventorySize--;
						
					}
				}
			});
		
		btnStoreView1.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e){
					Weapon w = shop.getWeapon(0);
					lblStoreDesc.setText(w.fullToString());
				}
			});
		
		btnStoreView2.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e){
					Weapon w = shop.getWeapon(1);
					lblStoreDesc.setText(w.fullToString());
				}
			});
		
		btnStoreView3.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e){
					Weapon w = shop.getWeapon(2);
					lblStoreDesc.setText(w.fullToString());
				}
		});
		
		btnRepairHull.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e){
					if(playerShip.getHull() < playerShip.getMaxHull()) {
						if(player.getCredits() - shop.getHullCost() > 0) {
							playerShip.repairHull(10 * locations[currentLocation][0]);
							player.changeCredits(-1 * shop.getHullCost());
							updateShopUI();
							updatePrimaryUI();
						}
					}
				}
		});
		
		btnRepairArmor.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e){
					if(playerShip.getArmor() < playerShip.getMaxArmor()) {
					
						if(player.getCredits() - shop.getArmorCost() > 0) {
							
							playerShip.repairArmor(5 * locations[currentLocation][0]);
							player.changeCredits(-1 * shop.getArmorCost());
							updateShopUI();
							updatePrimaryUI();
						}
					}
				}
		});
		
		btnSVWeap1.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e){
					int weap = playerShip.getNumWeapons();
					if(weap > 0) {
						Weapon w = playerShip.getWeapon(0);
						lblStoreDesc.setText(w.fullToString());
						
					}
				
				}
			});
		
		btnSVWeap2.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e){
					int weap = playerShip.getNumWeapons();
					if(weap > 1) {
						Weapon w = playerShip.getWeapon(1);
						lblStoreDesc.setText(w.fullToString());
					}
				
				}
			});
		
		btnSVWeap3.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e){
					int weap = playerShip.getNumWeapons();
					if(weap > 2) {
						Weapon w = playerShip.getWeapon(2);
						lblStoreDesc.setText(w.fullToString());
					}
				
				}
			});
		
		btnSVWeap4.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e){
					int weap = playerShip.getNumWeapons();
					if(weap > 3) {
						Weapon w = playerShip.getWeapon(3);
						lblStoreDesc.setText(w.fullToString());
					}
				
				}
			});
		
		btnSVWeap5.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e){
					int weap = playerShip.getNumWeapons();
					if(weap > 4) {
						Weapon w = playerShip.getWeapon(4);
						lblStoreDesc.setText(w.fullToString());
					}
				
				}
			});
			
			btnSBWeap1.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e){
					int weap = playerShip.getNumWeapons();
					if(weap > 0) {
						Weapon w = playerShip.getWeapon(0);
						if(sell1 == false) {
							transaction += w.getValue();
							updateShopUI();
							sell1 = true;
							inventorySize--;
							
						}
						else {
							if(inventorySize < 5) {
								transaction -= w.getValue();
								updateShopUI();
								sell1 = false;
								inventorySize++;
							
							}
						}
					}
				
				}
			});
			
			
			btnSBWeap2.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e){
					int weap = playerShip.getNumWeapons();
					if(weap > 1) {
						Weapon w = playerShip.getWeapon(1);
						if(sell2 == false) {
							transaction += w.getValue();
							updateShopUI();
							sell2 = true;
							inventorySize--;
						}
						else {
							if(inventorySize < 5) {
								transaction -= w.getValue();
								updateShopUI();
								sell2 = false;
								inventorySize++;
							}
						}
					}
				
				}
			});
			
			btnSBWeap3.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e){
					int weap = playerShip.getNumWeapons();
					if(weap > 2) {
						Weapon w = playerShip.getWeapon(2);
						if(sell3 == false) {
							transaction += w.getValue();
							updateShopUI();
							sell3 = true;
							inventorySize--;
						}
						else {
							if(inventorySize < 5) {
								transaction -= w.getValue();
								updateShopUI();
								sell3 = false;
								inventorySize++;
							}
						}
					}
				
				}
			});
			
			btnSBWeap4.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e){
					int weap = playerShip.getNumWeapons();
					if(weap > 3) {
						Weapon w = playerShip.getWeapon(3);
						if(sell4 == false) {
							transaction += w.getValue();
							updateShopUI();
							sell4 = true;
							inventorySize--;
						}
						else {
							if(inventorySize < 5) {
								transaction -= w.getValue();
								updateShopUI();
								sell4 = false;
								inventorySize++;
							}
						}
					}
				
				}
			});
			
			btnSBWeap5.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e){
					int weap = playerShip.getNumWeapons();
					if(weap > 4) {
						Weapon w = playerShip.getWeapon(4);
						if(sell5 == false) {
							transaction += w.getValue();
							updateShopUI();
							sell5 = true;
							inventorySize--;
						}
						else {
							if(inventorySize < 5) {
								transaction -= w.getValue();
								updateShopUI();
								sell5 = false;
								inventorySize++;
							}
						}
					}
				
				}
			});
			
			btnStoreConfirm.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e){
					if(player.getCredits() + transaction >= 0) {
						player.changeCredits(transaction);
						turns++;
						playerShip.regenShields();
						player.addScore(Math.abs(transaction/2));
						updatePrimaryUI();
						//Check for sale
						if(sell1 == true) {
							playerShip.removeWeapon(0);
						}
						if(sell2 == true) {
							playerShip.removeWeapon(1);
						}
						if(sell3 == true) {
							playerShip.removeWeapon(2);
						}
						if(sell4 == true) {
							playerShip.removeWeapon(3);
						}
						if(sell5 == true) {
							playerShip.removeWeapon(4);
						}
						//Check for buy
						if(buy1 == true) {
							playerShip.addShopWeapon(shop.getWeapon(0));
						}
						if(buy2 == true) {
							playerShip.addShopWeapon(shop.getWeapon(1));
						}
						if(buy3 == true) {
							playerShip.addShopWeapon(shop.getWeapon(2));
						}
						
						mainScreen();
					}            
				}
			});
			
			btnEventEnd.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e){
					playerShip.takeDamage(event.getDamage(),"Ex");
					if(playerShip.isAlive() == false) {
						player.addScore(event.getRewardScore());
						failScreen();
						updateFailUI();
					}
					else {
						player.changeCredits(event.getRewardCredits());
						player.increaseXP(event.getRewardXP());
						player.addScore(event.getRewardScore());
						turns++;
						playerShip.regenShields();
						mainScreen();
						updatePrimaryUI();
					}
				}
			});
			
			btnEventAccept.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e){
					playerShip.addShopWeapon(event.getRewardWeapon());
					btnEventAccept.setEnabled(false);
				}
			});
			
			btnTradeAccept.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e){
					playerShip.regenShields();
					turns++;
					player.changeCredits(-1 * tradeCost);
					Faction f = factionList.get(currentFaction);
					f.changeStance(5);
					factionList.remove(currentFaction);
					factionList.add(f);
					currentFaction = factionList.size() - 1;
					//XP trade
					if(tradeType <= 1) {
						player.increaseXP(tradeXP);
						player.addScore(tradeXP + 50);
						
					}
					else{
						playerShip.addShopWeapon(tradeWeapon);
						player.addScore(50);
					}
					updatePrimaryUI();
					mainScreen();
				}
			});
			
			btnTradeDecline.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e){
					playerShip.regenShields();
					turns++;
					player.addScore(50);
					updatePrimaryUI();
					mainScreen();
				}
			});
			
			btnAttack.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e){
					 combatScreen();
					 generateCombat();
					 updateCombatUI();
					 Faction f = factionList.get(currentFaction);
					 f.changeStance(-10);
					 factionList.remove(currentFaction);
					 factionList.add(f);
					 currentFaction = factionList.size() - 1;
						
				}
			});

			btnCWeap1.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e){
					int weap = playerShip.getNumWeapons();
					if (weap > 0){
						Weapon w = playerShip.getWeapon(0); 
						if(fire1 == false){
							fire1 = true;
							playerShip.changePower(-1 * w.getPower());
						}
						else {
							fire1 = false;
							playerShip.changePower(w.getPower());
						}
						updateCombatUI();
					}
				}
			});

			btnCWeap2.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e){
					int weap = playerShip.getNumWeapons();
					if (weap > 1){
						Weapon w = playerShip.getWeapon(1); 
						if(fire2 == false){
							fire2 = true;
							playerShip.changePower(-1 * w.getPower());
						}
						else {
							fire2 = false;
							playerShip.changePower(w.getPower());
						}
						updateCombatUI();
					}
				}
			});
			btnCWeap3.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e){
					int weap = playerShip.getNumWeapons();
					if (weap > 2){
						Weapon w = playerShip.getWeapon(2); 
						if(fire3 == false){
							fire3 = true;
							playerShip.changePower(-1 * w.getPower());
						}
						else {
							fire3 = false;
							playerShip.changePower(w.getPower());
						}
						updateCombatUI();
					}
				}
			});

			btnCWeap4.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e){
					int weap = playerShip.getNumWeapons();
					if (weap > 3){
						Weapon w = playerShip.getWeapon(3); 
						if(fire4 == false){
							fire4 = true;
							playerShip.changePower(-1 * w.getPower());
						}
						else {
							fire4 = false;
							playerShip.changePower(w.getPower());
						}
						updateCombatUI();
					}
				}
			});

			btnCWeap5.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e){
					int weap = playerShip.getNumWeapons();
					if (weap > 4){
						Weapon w = playerShip.getWeapon(4); 
						if(fire5 == false){
							fire5 = true;
							playerShip.changePower(-1 * w.getPower());
						}
						else {
							fire5 = false;
							playerShip.changePower(w.getPower());
						}
						updateCombatUI();
					}
				}
			});

			btnShieldsC.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e){
						if(shieldPower == 0) {
							shieldPower++;
							playerShip.changePower(-2); //Usage 2
							updateCombatUI();
						}
						else if(shieldPower == 1) {
							shieldPower++;
							playerShip.changePower(-3); //Usage 5
							updateCombatUI();
						}
						else if(shieldPower == 2) {
							shieldPower++;
							playerShip.changePower(-5); //Usage 10
							updateCombatUI();
						}
						else if(shieldPower == 3) {
							shieldPower = 0;
							playerShip.changePower(10);
							updateCombatUI();
						}
					}
				});

				btnRetreat.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e){
						comRetreat = true;
						retreatCount = 5 - player.getDriveLevel();
						updateCombatUI();
					}
				});

				btnCombatConfirm.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e){
						if(fire1 == true){
							Weapon w = playerShip.getWeapon(0);
							attackQueue.add(w);
							roundResults += "You fired your " + w.getName() + " <b>|||</b> ";
						}
						if(fire2 == true){
							Weapon w = playerShip.getWeapon(1);
							attackQueue.add(w);
							roundResults += "You fired your " + w.getName() + " <b>|||</b> ";
						}
						if(fire3 == true){
							Weapon w = playerShip.getWeapon(2);
							attackQueue.add(w);
							roundResults += "You fired your " + w.getName() + " <b>|||</b> ";
						}
						if(fire4 == true){
							Weapon w = playerShip.getWeapon(3);
							attackQueue.add(w);
							roundResults += "You fired your " + w.getName() + " <b>|||</b> ";
						}
						if(fire5 == true){
							Weapon w = playerShip.getWeapon(4);
							attackQueue.add(w);
							roundResults += "You fired your " + w.getName() + " <b>|||</b> ";
						}
						computersTurn();
                  endRound();
					}
				});

				btnCombatEnd.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e){
						if(playerShip.isAlive() == false) {
							player.addScore(scoreCReward); 
							failScreen();
							updateFailUI();
						}
						else if(npcShip.isAlive() == true) {
							player.increaseXP(xpCReward);
							player.addScore(scoreCReward);
							creditsCReward = 0;
							successScreen();
							updateSuccessUI();
						}
						else {
							player.increaseXP(xpCReward);
							player.addScore(scoreCReward);
							player.changeCredits(creditsCReward);
							successScreen();
							updateSuccessUI();
						}
					}
				});

				btnSuccess.addActionListener(
					new ActionListener() {
						public void actionPerformed(ActionEvent e){
							updatePrimaryUI();
							mainScreen();
						}
					});
		
		
	}
	
	public void mainScreen () {
		main = true;
		upgr = false;
		inve = false;
		misc = false;
		trav = false;
		enc1 = false;
		enc2 = false;
		stor = false;
		even = false;
		trad = false;
		comb = false;
		succ = false;
		fail = false;
		updateScreen();
	}
	
	public void upgradeScreen() {
		main = false;
		upgr = true;
		inve = false;
		misc = true;
		trav = false;
		enc1 = false;
		enc2 = false;
		stor = false;
		even = false;
		trad = false;
		comb = false;
		succ = false;
		fail = false;
		updateScreen();
	}
	
	public void inventoryScreen() {
		main = false;
		upgr = false;
		inve = true;
		misc = true;
		trav = false;
		enc1 = false;
		enc2 = false;
		stor = false;
		even = false;
		trad = false;
		comb = false;
		succ = false;
		fail = false;
		updateScreen();
	}

	public void travelScreen() {
		main = false;
		upgr = false;
		inve = false;
		misc = true;
		trav = true;
		enc1 = false;
		enc2 = false;
		stor = false;
		even = false;
		trad = false;
		comb = false;
		updateScreen();
	}

	public void encounter1Screen() {
		main = false;
		upgr = false;
		inve = false;
		misc = false;
		trav = false;
		enc1 = true;
		enc2 = false;
		stor = false;
		even = false;
		trad = false;
		comb = false;
		succ = false;
		fail = false;
	}
	
	public void encounter2Screen() {
		main = false;
		upgr = false;
		inve = false;
		misc = false;
		trav = false;
		enc1 = true;
		enc2 = true;
		stor = false;
		even = false;
		trad = false;
		comb = false;
		updateScreen();
		
	}
	
	public void storeScreen() {
		main = false;
		upgr = false;
		inve = false;
		misc = false;
		trav = false;
		enc1 = false;
		enc2 = false;
		stor = true;
		even = false;
		trad = false;
		comb = false;
		succ = false;
		fail = false;
		updateScreen();
	}
	
	public void eventScreen() {
		main = false;
		upgr = false;
		inve = false;
		misc = false;
		trav = false;
		enc1 = false;
		enc2 = false;
		stor = false;
		even = true;
		trad = false;
		comb = false;
		succ = false;
		fail = false;
		updateScreen();
	}
	
	public void tradeScreen() {
		main = false;
		upgr = false;
		inve = false;
		misc = false;
		trav = false;
		enc1 = false;
		enc2 = false;
		stor = false;
		even = false;
		trad = true;
		comb = false;
		succ = false;
		fail = false;
		updateScreen();
	}
	
	public void combatScreen() {
		main = false;
		upgr = false;
		inve = false;
		misc = false;
		trav = false;
		enc1 = false;
		enc2 = false;
		stor = false;
		even = false;
		trad = false;
		comb = true;
		succ = false;
		fail = false;
		updateScreen();
	}

	public void successScreen() {
		main = false;
		upgr = false;
		inve = false;
		misc = false;
		trav = false;
		enc1 = false;
		enc2 = false;
		stor = false;
		even = false;
		trad = false;
		comb = false;
		succ = true;
		fail = false;
		updateScreen();
	}

	public void failScreen() {
		main = false;
		upgr = false;
		inve = false;
		misc = false;
		trav = false;
		enc1 = false;
		enc2 = false;
		stor = false;
		even = false;
		trad = false;
		comb = false;
		succ = false;
		fail = true;
		updateScreen();
	}
	
	public void updateDifficulty() {
		difficulty = (int)(((double)player.getScore()/1000) + ((double)player.getTotalCredits()/2000) + ((double)player.getTotalXP()/100));
	}

	public void updateScreen() {
		updateDifficulty();
		
		//Main set
		btnTravel.setVisible(main);
		btnTravel.setEnabled(main);
		btnUpgrade.setVisible(main);
		btnUpgrade.setEnabled(main);
		btnInventory.setVisible(main);
		btnInventory.setEnabled(main);
		btnHelp.setVisible(main);
		btnHelp.setEnabled(main);
	
		//Misc set
		btnBack.setVisible(misc);
		btnBack.setEnabled(misc);
		
		//Upgrade set
		txtHull.setVisible(upgr);
		txtArmor.setVisible(upgr);
		txtShields.setVisible(upgr);
		txtDrive.setVisible(upgr);
		txtPower.setVisible(upgr);
		lblCostU.setVisible(upgr);
		lblHullU.setVisible(upgr);
		lblArmorU.setVisible(upgr);
		lblShieldsU.setVisible(upgr);
		lblDriveU.setVisible(upgr);
		lblPowerU.setVisible(upgr);
		pbHullU.setVisible(upgr);
		pbArmorU.setVisible(upgr);
		pbShieldsU.setVisible(upgr);
		pbDriveU.setVisible(upgr);
		pbPowerU.setVisible(upgr);
		
		btnHullU.setVisible(upgr);
		btnHullU.setEnabled(upgr);
		btnArmorU.setVisible(upgr);
		btnArmorU.setEnabled(upgr);
		btnShieldsU.setVisible(upgr);
		btnShieldsU.setEnabled(upgr);
		btnDriveU.setVisible(upgr);
		btnDriveU.setEnabled(upgr);
		btnPowerU.setVisible(upgr);
		btnPowerU.setEnabled(upgr);
		
		//Inventory set
		lblDesc.setVisible(inve);
		lblIWeap1.setVisible(inve);
		lblIWeap2.setVisible(inve);
		lblIWeap3.setVisible(inve);
		lblIWeap4.setVisible(inve);
		lblIWeap5.setVisible(inve);
		
		btnIWeap1.setVisible(inve);
		btnIWeap1.setEnabled(inve);
		btnIWeap2.setVisible(inve);
		btnIWeap2.setEnabled(inve);
		btnIWeap3.setVisible(inve);
		btnIWeap3.setEnabled(inve);
		btnIWeap4.setVisible(inve);
		btnIWeap4.setEnabled(inve);
		btnIWeap5.setVisible(inve);
		btnIWeap5.setEnabled(inve);
	
		//Trav set
		lblLoc1.setVisible(trav);
		lblLoc2.setVisible(trav);
		lblLoc3.setVisible(trav);
		lblLoc4.setVisible(trav);
	
		btnLoc1.setVisible(trav);
		btnLoc1.setEnabled(trav);
		btnLoc2.setVisible(trav);
		btnLoc2.setEnabled(trav);
		btnLoc3.setVisible(trav);
		btnLoc3.setEnabled(trav);
		btnLoc4.setVisible(trav);
		btnLoc4.setEnabled(trav);
	
		//Encounter 1 set
		lblEncDesc.setVisible(enc1);
		btnExplore.setVisible(enc1);
		btnExplore.setEnabled(enc1);
		
		//Encounter 2 set
		btnConfirm.setVisible(enc2);
		btnConfirm.setEnabled(enc2);
	
		//Store set
		btnStoreConfirm.setVisible(stor);
		btnStoreConfirm.setEnabled(stor);
		lblStoreDesc.setVisible(stor);
		lblTransaction.setVisible(stor);
		lblStore.setVisible(stor);
		lblStore1.setVisible(stor);
		lblStore2.setVisible(stor);
		lblStore3.setVisible(stor);
		btnStoreBuy1.setVisible(stor);
		btnStoreBuy2.setVisible(stor);
		btnStoreBuy3.setVisible(stor);
		btnStoreView1.setVisible(stor);
		btnStoreView2.setVisible(stor);
		btnStoreView3.setVisible(stor);
		btnStoreBuy1.setEnabled(stor);
		btnStoreBuy2.setEnabled(stor);
		btnStoreBuy3.setEnabled(stor);
		btnStoreView1.setEnabled(stor);
		btnStoreView2.setEnabled(stor);
		btnStoreView3.setEnabled(stor);
		lblSWeap1.setVisible(stor);
		lblSWeap2.setVisible(stor);
		lblSWeap3.setVisible(stor);
		lblSWeap4.setVisible(stor);
		lblSWeap5.setVisible(stor);
		btnSVWeap1.setVisible(stor);
		btnSVWeap2.setVisible(stor);
		btnSVWeap3.setVisible(stor);
		btnSVWeap4.setVisible(stor);
		btnSVWeap5.setVisible(stor);
		btnSBWeap1.setVisible(stor);
		btnSBWeap2.setVisible(stor);
		btnSBWeap3.setVisible(stor);
		btnSBWeap4.setVisible(stor);
		btnSBWeap5.setVisible(stor);
		btnSVWeap1.setEnabled(stor);
		btnSVWeap2.setEnabled(stor);
		btnSVWeap3.setEnabled(stor);
		btnSVWeap4.setEnabled(stor);
		btnSVWeap5.setEnabled(stor);
		btnSBWeap1.setEnabled(stor);
		btnSBWeap2.setEnabled(stor);
		btnSBWeap3.setEnabled(stor);
		btnSBWeap4.setEnabled(stor);
		btnSBWeap5.setEnabled(stor);
		lblRepairHull.setVisible(stor);
		lblRepairArmor.setVisible(stor);
		btnRepairHull.setVisible(stor);
		btnRepairArmor.setVisible(stor);
		btnRepairHull.setEnabled(stor);
		btnRepairArmor.setEnabled(stor);
		lblSPlayer.setVisible(stor);
		
		btnAttack.setVisible(false);
		btnAttack.setEnabled(false);
		
		//Event set
		lblEventEnd.setVisible(even);
		lblEventReward.setVisible(even);
		btnEventAccept.setVisible(even);
		btnEventAccept.setEnabled(even);
		btnEventEnd.setVisible(even);
		btnEventEnd.setEnabled(even);
		
		//Trade set
		lblTrade.setVisible(trad);
		lblTradeFor.setVisible(trad);
		lblTradeCost.setVisible(trad);
		lblTradeTerm.setVisible(trad);
		btnTradeAccept.setVisible(trad);
		btnTradeAccept.setEnabled(trad);
		btnTradeDecline.setVisible(trad);
		btnTradeDecline.setEnabled(trad);
		
		//Combat set
		lblCWeap1.setVisible(comb);
		lblCWeap2.setVisible(comb);
		lblCWeap3.setVisible(comb);
		lblCWeap4.setVisible(comb);
		lblCWeap5.setVisible(comb);
		btnCWeap1.setVisible(comb);
		btnCWeap2.setVisible(comb);
		btnCWeap3.setVisible(comb);
		btnCWeap4.setVisible(comb);
		btnCWeap5.setVisible(comb);
		cbWeap1.setVisible(comb);
		cbWeap2.setVisible(comb);
		cbWeap3.setVisible(comb);
		cbWeap4.setVisible(comb);
		cbWeap5.setVisible(comb);
		btnCombatConfirm.setVisible(comb);
		btnCWeap1.setEnabled(comb);
		btnCWeap2.setEnabled(comb);
		btnCWeap3.setEnabled(comb);
		btnCWeap4.setEnabled(comb);
		btnCWeap5.setEnabled(comb);
		btnCombatConfirm.setEnabled(comb);
		lblPowerC.setVisible(comb);
		pbPowerC.setVisible(comb);
		lblShieldsC.setVisible(comb);
		btnShieldsC.setVisible(comb);
		btnShieldsC.setEnabled(comb);
		cbShield1.setVisible(comb);
		cbShield2.setVisible(comb);
		cbShield3.setVisible(comb);
		btnRetreat.setVisible(comb);
		btnRetreat.setEnabled(comb);
		
		lblNpcHp.setVisible(comb);
		pbNpcHull.setVisible(comb);
		pbNpcShields.setVisible(comb);
		pbNpcArmor.setVisible(comb);
		
		lblCResults.setVisible(comb);
      btnCombatEnd.setEnabled(false);
		btnCombatEnd.setVisible(false);
		
		//Combat success set
		lblSuccess.setVisible(succ);
		lblSCredits.setVisible(succ);
		lblSXP.setVisible(succ);
		btnSuccess.setVisible(succ);
		btnSuccess.setEnabled(succ);

		//Fail set
		lblFailure.setVisible(fail);
		lblFinalScore.setVisible(fail);
		lblTotalCredits.setVisible(fail);
		lblTotalXP.setVisible(fail);
	}
	
	public void updatePrimaryUI() {
		lblCredits.setText("$: " + player.getCredits());
		lblXP.setText("XP: " + player.getXP());
		lblTurns.setText("Turns: " + turns);
		
		pbHull.setMaximum(playerShip.getMaxHull());
		pbHull.setValue(playerShip.getHull());
		pbHull.setString("" + (int)(100 * playerShip.getHullPercent()) + "%");
		
		pbArmor.setMaximum(playerShip.getMaxArmor());
		pbArmor.setValue(playerShip.getArmor());
		pbArmor.setString("" + (int)(100 * playerShip.getArmorPercent()) + "%");
		
		pbShields.setMaximum(playerShip.getMaxShields());
		pbShields.setValue(playerShip.getShields());
		pbShields.setString("" + (int)(100 * playerShip.getShieldsPercent()) + "%");
	}
	
	public void updateUpgradeUI() {
		txtHull.setText("" + player.getHullCost());
		txtArmor.setText("" + player.getArmorCost());
		txtShields.setText("" + player.getShieldsCost());
		txtDrive.setText("" + player.getDriveCost());
		txtPower.setText("" + player.getPowerCost());
		
		pbHullU.setValue(player.getHullLevel());
		pbArmorU.setValue(player.getArmorLevel());
		pbShieldsU.setValue(player.getShieldsLevel());
		pbDriveU.setValue(player.getDriveLevel());
		pbPowerU.setValue(player.getPowerLevel());
	}
	
	public void updateInventoryUI() {
		inventorySize = playerShip.getNumWeapons();
		int weap = playerShip.getNumWeapons();
		lblDesc.setText("");
		
		if(weap > 0) {
			Weapon w = playerShip.getWeapon(0);
			lblIWeap1.setText(w.toString());
		}
		else {
			lblIWeap1.setText("Weapon 1:");
		}
	
		if(weap > 1) {
			Weapon w = playerShip.getWeapon(1);
			lblIWeap2.setText(w.toString());
		}
		else {
			lblIWeap2.setText("Weapon 2:");
		}
	
		if(weap > 2) {
			Weapon w = playerShip.getWeapon(2);
			lblIWeap3.setText(w.toString());
		}
		else {
			lblIWeap3.setText("Weapon 3:");
		}
	
		if(weap > 3) {
			Weapon w = playerShip.getWeapon(3);
			lblIWeap4.setText(w.toString());
		}
		else {
			lblIWeap4.setText("Weapon 4:");
		}
	
		if(weap > 4) {
			Weapon w = playerShip.getWeapon(4);
			lblIWeap5.setText(w.toString());
		}
		else {
			lblIWeap5.setText("Weapon 5:");
		}
	}

	public void generateLocal() {
		for(int i = 0; i < 4; i++) {
			locations[i][0] = generator.nextInt(2) + difficulty + 1;
			locations[i][1] = generator.nextInt(locals.length);
		}
	}
	
	public void updateTravelUI() {
		//[Locations][Risk,Local]
		lblLoc1.setText(locals[locations[0][1]] + ". Risk: " + locations[0][0]);
		lblLoc2.setText(locals[locations[1][1]] + ". Risk: " + locations[1][0]);
		lblLoc3.setText(locals[locations[2][1]] + ". Risk: " + locations[2][0]);
		lblLoc4.setText(locals[locations[3][1]] + ". Risk: " + locations[3][0]);
	}

	public void updateEncounter1UI() {
		lblEncDesc.setText("<HTML>You warm up your FTL drive, and make the jump to faster than light travel. After a few hours you have finally arrived at the " 
			+ locals[locations[currentLocation][1]] + ". The area apears ripe for exploration. You think you may see a few objects out in the distant reaches of space. Do you dare explore further?</HTML>");
		btnExplore.setText("Explore");
	}

	public void generateEncounter() {
		int role = generator.nextInt(100);
		
		//Nothing Happens 10%
		if(role < 10){
			lblEncDesc.setText("You search for hours but are unable to find anything.");
			btnExplore.setText("Countinue");
			encounter = 0;
			encounter2Screen();
			btnConfirm.setVisible(false);
			btnConfirm.setEnabled(false);
		}
		//Store 20%
		else if(role < 30){
			lblEncDesc.setText("<HTML>In your search you find a shop, would you like to enter the shop?</HTML>");
			encounter = 1;
			btnExplore.setText("Ignore");
			btnConfirm.setText("Shop");
			transaction = 0;
			buy1 = false;
			buy2 = false;
			buy3 = false;
			sell1 = false;
			sell2 = false;
			sell3 = false;
			sell4 = false;
			sell5 = false;
			encounter2Screen();
			
		}
		
		//Event 30%
		else if(role < 60){
			event.generate(locations[currentLocation][0]);
			lblEncDesc.setText("<HTML>After searching you find a strange " + event.getName() + ". Do you dare to explore it?</HTML>");
			encounter = 2;
			btnExplore.setText("Ignore");
			btnConfirm.setText("Explore");
			encounter2Screen();
		}
		
		//Ship 40%
		else {
			currentFaction = generator.nextInt(factionList.size());
			Faction f = factionList.get(currentFaction);
			int roll = generator.nextInt(100) + f.getStance();
			if(roll < 50) {
				shipStance = "hositle";
			}
			else {
				shipStance = "neutral";
			}
			 
			lblEncDesc.setText("<HTML>After searching you find a ship from the " + f.getName() + 
			" faction. They are " + shipStance + " to your precence." + " The " + f.getName() + " faction in general " 
			+ f.getStanceName() + " you.");

			encounter = 3;
			btnExplore.setText("Ignore");
			btnConfirm.setText("Trade");
			encounter2Screen();
			btnAttack.setEnabled(true);
			btnAttack.setVisible(true);
			if(shipStance.equals("hositle")) {
				btnExplore.setEnabled(false);
				btnConfirm.setEnabled(false);
			}
			
		}
	}
	
	public void updateShopUI() {
		int weap = playerShip.getNumWeapons();
		lblTransaction.setText("Transaction: " + transaction);
		
		lblStoreDesc.setText("");
		
		if(weap > 0) {
			Weapon w = playerShip.getWeapon(0);
			lblSWeap1.setText(w.toString());
		}
		else {
			lblSWeap1.setText("Weapon 1:");
		}
	
		if(weap > 1) {
			Weapon w = playerShip.getWeapon(1);
			lblSWeap2.setText(w.toString());
		}
		else {
			lblSWeap2.setText("Weapon 2:");
		}
	
		if(weap > 2) {
			Weapon w = playerShip.getWeapon(2);
			lblSWeap3.setText(w.toString());
		}
		else {
			lblSWeap3.setText("Weapon 3:");
		}
	
		if(weap > 3) {
			Weapon w = playerShip.getWeapon(3);
			lblSWeap4.setText(w.toString());
		}
		else {
			lblSWeap4.setText("Weapon 4:");
		}
	
		if(weap > 4) {
			Weapon w = playerShip.getWeapon(4);
			lblSWeap5.setText(w.toString());
		}
		else {
			lblSWeap5.setText("Weapon 5:");
		}
		
		Weapon ws = shop.getWeapon(0);
		lblStore1.setText(ws.toString());
		ws = shop.getWeapon(1);
		lblStore2.setText(ws.toString());
		ws = shop.getWeapon(2);
		lblStore3.setText(ws.toString());
		
		lblRepairHull.setText("Cost: " + shop.getHullCost());
		lblRepairArmor.setText("Cost: " + shop.getArmorCost());
	}
	
	public void updateEventUI() {
		lblEventEnd.setText(event.getEndResult());
		lblEventReward.setText(event.getEndReward());
		if(event.haveWeapon()) {
			btnEventAccept.setVisible(true);
			if(playerShip.getNumWeapons() < 5) {
				btnEventAccept.setEnabled(true);
			}
			else {
				btnEventAccept.setEnabled(false);
			}
		}
		else {
			btnEventAccept.setEnabled(false);
			btnEventAccept.setVisible(false);
		}
	}
	
	public void generateTrade() {
		//Poor xp trade
		if(tradeType == 0) {
			tradeXP = generator.nextInt(10) + locations[currentLocation][0];
			tradeCost = ((generator.nextInt(10)+1)* 10 * tradeXP) * locations[currentLocation][0];
		}
		//Good XP trade
		else if(tradeType == 1) {
			tradeXP = generator.nextInt(10) + (3*locations[currentLocation][0]);
			tradeCost = ((generator.nextInt(10)+1) * 5 * tradeXP) * locations[currentLocation][0];
		}
		//Poor weapon trade
		else if(tradeType == 2) {
			tradeWeapon = new Weapon(generator.nextInt(9),locations[currentLocation][0]);
			tradeCost = (int)((double)tradeWeapon.getValue() * 1 + ((double)(generator.nextInt(10))/10)); 
		}
		//Good weapon trade
		else  {
			tradeWeapon = new Weapon(generator.nextInt(9),locations[currentLocation][0]+1);
			tradeCost = (int)((double)tradeWeapon.getValue() * 1 + ((double)(generator.nextInt(5))/10)); 
		}
	}
	
	public void updateTradeUI() {
		//XP trade
		if(tradeType <=1) {
			lblTradeCost.setText("$" + tradeCost);
			lblTradeTerm.setText("XP: " + tradeXP);
		}
		else {
			lblTradeCost.setText("$" + tradeCost);
			lblTradeTerm.setText(tradeWeapon.toString());
			if(playerShip.getNumWeapons() >= 5) {
				btnTradeAccept.setEnabled(false);
			}
			if(player.getCredits() - tradeCost < 0) {
				btnTradeAccept.setEnabled(false);
			}
		}
	}

	public void updateCombatUI() {
		int weap = playerShip.getNumWeapons();
		
		if(weap > 0) {
			Weapon w = playerShip.getWeapon(0);
			lblCWeap1.setText(w.toString());
		}
		else {
			lblCWeap1.setText("Weapon 1:");
		}
	
		if(weap > 1) {
			Weapon w = playerShip.getWeapon(1);
			lblCWeap2.setText(w.toString());
		}
		else {
			lblCWeap2.setText("Weapon 2:");
		}
	
		if(weap > 2) {
			Weapon w = playerShip.getWeapon(2);
			lblCWeap3.setText(w.toString());
		}
		else {
			lblCWeap3.setText("Weapon 3:");
		}
	
		if(weap > 3) {
			Weapon w = playerShip.getWeapon(3);
			lblCWeap4.setText(w.toString());
		}
		else {
			lblCWeap4.setText("Weapon 4:");
		}
	
		if(weap > 4) {
			Weapon w = playerShip.getWeapon(4);
			lblCWeap5.setText(w.toString());
		}
		else {
			lblCWeap5.setText("Weapon 5:");
		}

		pbPowerC.setMinimum(0);
		pbPowerC.setMaximum(playerShip.getMaxPower());
		pbPowerC.setValue(playerShip.getPower());
		pbPowerC.setString("" + (playerShip.getPower()));

		pbNpcHull.setMinimum(0);
		pbNpcHull.setMaximum(npcShip.getMaxHull());
		pbNpcHull.setValue(npcShip.getHull());

		pbNpcArmor.setMinimum(0);
		pbNpcArmor.setMaximum(npcShip.getMaxArmor());
		pbNpcArmor.setValue(npcShip.getArmor());
		
		pbNpcShields.setMinimum(0);
		pbNpcShields.setMaximum(npcShip.getMaxShields());
		pbNpcShields.setValue(npcShip.getShields());

		cbWeap1.setSelected(fire1);
		cbWeap2.setSelected(fire2);
		cbWeap3.setSelected(fire3);
		cbWeap4.setSelected(fire4);
		cbWeap5.setSelected(fire5);

		if(shieldPower == 0){
			cbShield1.setSelected(false);
			cbShield2.setSelected(false);
			cbShield3.setSelected(false);
		}
		else if(shieldPower == 1){
			cbShield1.setSelected(true);
			cbShield2.setSelected(false);
			cbShield3.setSelected(false);
		}
		else if(shieldPower == 2){
			cbShield1.setSelected(true);
			cbShield2.setSelected(true);
			cbShield3.setSelected(false);
		}
		else{
			cbShield1.setSelected(true);
			cbShield2.setSelected(true);
			cbShield3.setSelected(true);
		}

		Faction f = factionList.get(currentFaction);
		lblNpcHp.setText(f.getName() + ":");

		if(comRetreat == true) {
			btnRetreat.setEnabled(false);
			btnRetreat.setText("" + retreatCount);
		}
		else{
			btnRetreat.setEnabled(true);
			btnRetreat.setText("Retreat");
		}
	}

	public void generateCombat() {
		int risk = locations[currentLocation][0];
		roundResults = "<HTML>";
		lblCResults.setText("");
      npcAttackQueue.clear();
	  attackQueue.clear();
	  speedList.clear();
	  npcSpeedList.clear();
		comRetreat = false;
		NpcRetreat = false;
      combatEnd = false;
		shieldPower = 0;
		fire1 = false;
		fire2 = false;
		fire3 = false;
		fire4 = false;
		fire5 = false;
		playerShip.resetPower();

		//Generate NPC
		npc.generate(risk);
		npcShip.generate(risk); 
		npcShip.improvePower(2 * npc.getPowerLevel());
		for(int i = 0; i < 5; i++) {
			if(i < risk) {
				npcShip.addRandomWeapon(risk - 1);
			}
		}

		creditsCReward = npc.getCredits();
		xpCReward = npc.getXP();
		for(int i = 0; i < npcShip.getNumWeapons(); i++){
			Weapon w = npcShip.getWeapon(i);
			creditsCReward += (int)((double)w.getValue() * (1 + ((double)generator.nextInt(7)/10)));
		}

		scoreCReward = (20 * xpCReward) + (int)((double)creditsCReward * 0.2);
	}

	public void computersTurn() {
		npcShip.resetPower();
		
		//Scan Weapons
		int en = 0;
		int enD = 0;
		int ex = 0;
		int exD = 0;
		int ki = 0;
		int kiD = 0;
		int maxWeaponEnergy = 0;
		int smallWeaponEnergy = 1000;
		int[] fireList = new int[npcShip.getNumWeapons()];
		int[] powerList = new int[npcShip.getNumWeapons()];
		int[] speedList = new int[npcShip.getNumWeapons()];
		for(int i = 0; i < npcShip.getNumWeapons(); i++) {
			Weapon w = npcShip.getWeapon(i);
			maxWeaponEnergy += w.getPower();
			powerList[i] = w.getPower();
			speedList[i] = w.getSpeed();
			if(w.getDamageType().equals("En")) {
				en++;
			}
			else if(w.getDamageType().equals("Ex")) {
				ex++;
			}
			else {
				ki++;
			}
			if(smallWeaponEnergy > w.getPower()) {
				smallWeaponEnergy = w.getPower();
			}
		}
		ArrayList<Integer> fireQueue = new ArrayList<Integer>();

		//Priority
		String priority;
		double npcRisk = (double)(generator.nextInt(5)+5)/10;
		if(npcShip.getHullPercent() < npcRisk && npcShip.getHullPercent() < playerShip.getHullPercent()){
			priority = "Retreat";
		}
		else if(npcShip.getHullPercent() < npcRisk && npcShip.getHullPercent() > playerShip.getHullPercent()) {
			priority = "Desperate";
		}
		else if(npcShip.getArmorPercent() < npcRisk && npcShip.getArmorPercent() < playerShip.getArmorPercent()){
			priority = "Defensive";
		}
		else if(npcShip.getArmorPercent() < npcRisk && npcShip.getArmorPercent() > playerShip.getArmorPercent()){
			priority = "Cautious";
		}
		else {
			priority = "Aggressive";
		}
		
		//First focus is staying alive
		//Second focus is allocating remaining power weapons
		if(priority.equals("Retreat")){
			if(NpcRetreat == false) {
				NpcRetreat = true;
				NpcRetreatCount = 5 - npc.getDriveLevel();
			}
			if(npcShip.getPower() >= 10) {
				NpcShieldPower = 3;
				npcShip.changePower(-10);
			}
			else {
				NpcShieldPower = 2;
				npcShip.changePower(-5);
			}
			
			//Firing Weapons
			//If there is more free power than the total potential energy usage, it will use every weapon
			if(npcShip.getPower() >= maxWeaponEnergy) {
				for(int i = 0; i < fireList.length; i++) {
					fireQueue.add(i);
					Weapon w = npcShip.getWeapon(i);
					npcShip.changePower(-1 * w.getPower());
				}
			}
			//Tries to allocate power based on largest power concuming weapon
			else {
				int fired = 0;
				while(npcShip.getPower() >= smallWeaponEnergy && fired < fireList.length) {
					fired++;
					int maxPower = 0;
					int position = 0;
					for(int i = 0; i < powerList.length;i++) {
						if(powerList[i] > maxPower && powerList[i] <= npcShip.getPower() && fireQueue.contains(i) == false) {
							position = i;
							maxPower = powerList[i];
						}
					}
					fireQueue.add(position);
					npcShip.changePower(-1 * maxPower);
				}
			}
		}
		//Focus on firing all big guns that are a speed of 0
		else if(priority.equals("Desperate")) {
			NpcShieldPower = 0;
         int fired = 0;
		 	//Firing Weapons
		 	//First tries to find hardest hitting speed 0
		 	while(npcShip.getPower() >= smallWeaponEnergy && fired < fireList.length) {
			 	fired++;
					
				int maxDamage = 0;
				int position = -1;
				
				for(int i = 0; i < fireList.length;i++){
					Weapon w = npcShip.getWeapon(i);
					if(speedList[i] == 0 && w.getDamage() > maxDamage && fireQueue.contains(i) == false){
						maxDamage = w.getDamage();
						position = i;
					}
					}

					if(position != -1){
						fireQueue.add(position);
                  Weapon w = npcShip.getWeapon(position);
						npcShip.changePower(-1 * w.getPower());
					}
					//If it fails to find a speed 0 weapon
					else {
						int maxPower = 0;
						position = 0;
						for(int i = 0; i < powerList.length;i++) {
							if(powerList[i] > maxPower && powerList[i] <= npcShip.getPower()) {
								position = i;
								maxPower = powerList[i];
							}
						}
						
						fireQueue.add(position);
						npcShip.changePower(-1 * maxPower);
					}
			}
				
					
					
		}
		else{
			//Defensive prioritize shield regen
			if(priority.equals("Defensive")) {
				if(npcShip.getPower() > 10) {
					NpcShieldPower = 3;
					npcShip.changePower(-10);
				}
				else {
					NpcShieldPower = 2;
					npcShip.changePower(-5);
				}
			}
			//Either regen 1 or 2
			else if(priority.equals("Cautious")){
				NpcShieldPower = generator.nextInt(2)+1;
				if(NpcShieldPower == 2){
					npcShip.changePower(-5);
				}
				else {
					npcShip.changePower(-2);
				}
			}
			//Either regen 0 or 1
			else {
				NpcShieldPower = generator.nextInt(2);
				if(NpcShieldPower == 1) {
					npcShip.changePower(-2);
				}
            //System.out.println(NpcShieldPower);
			}

			int fired = 0;
			while(npcShip.getPower() >= smallWeaponEnergy && fired < fireList.length) {
				fired++;
            //System.out.println(fired);
				//Use energy weapons against shields
				if(playerShip.getShieldsPercent() > 0.2 && en > 0 && enD < playerShip.getShields()) {
					int position = 0;
					int maxEnD = 0;
					for(int i = 0; i < fireList.length;i++) {
						Weapon w = npcShip.getWeapon(i);
						if(w.getDamageType().equals("En") && w.getPower() < npcShip.getPower() && fireQueue.contains(i) == false && maxEnD < w.getDamage()) {
							position = i;
							maxEnD = w.getDamage();
						}
					}
               //System.out.println(maxEnD);
					
					Weapon w = npcShip.getWeapon(position); 
					enD += w.getDamage();
					npcShip.changePower(-1 * w.getPower());
					fireQueue.add(position);
				}
				//Use weapons against armor
				else if(playerShip.getShieldsPercent() < 0.2 && playerShip.getArmorPercent() > 0.2 && ki > 0 && kiD < playerShip.getArmor()) {
					int position = 0;
					int maxKiD = 0;
					for(int i = 0; i < fireList.length;i++) {
						Weapon w = npcShip.getWeapon(i);
						if(w.getDamageType().equals("Ki") && w.getPower() < npcShip.getPower() && fireQueue.contains(i) == false && maxKiD < w.getDamage()) {
							position = i;
							maxKiD = w.getDamage();
						}
					}
               //System.out.println(maxKiD);
					
					Weapon w = npcShip.getWeapon(position); 
					kiD += w.getDamage();
					npcShip.changePower(-1 * w.getPower());
					fireQueue.add(position);
				}
				else if(playerShip.getArmorPercent() < 0.2 && ex > 0 && exD < playerShip.getHull()) {
					int position = 0;
					int maxExD = 0;
					for(int i = 0; i < fireList.length;i++) {
						Weapon w = npcShip.getWeapon(i);
						if(w.getDamageType().equals("Ex") && w.getPower() < npcShip.getPower() && fireQueue.contains(i) == false && maxExD < w.getDamage()) {
							position = i;
							maxExD = w.getDamage();
						}
					}
					
					//System.out.println(maxExD);
               Weapon w = npcShip.getWeapon(position); 
					exD += w.getDamage();
					npcShip.changePower(-1 * w.getPower());
					fireQueue.add(position);
				}
				else {
						int maxPower = 0;
						int position = 0;
						for(int i = 0; i < powerList.length;i++) {
							if(powerList[i] > maxPower && powerList[i] <= npcShip.getPower()) {
								position = i;
								maxPower = powerList[i];
							}
						}
						
						//System.out.println(maxPower);
                  fireQueue.add(position);
						npcShip.changePower(-1 * maxPower);
					}
			}
		}
      for(int i = 0; i < fireQueue.size();i++) {
         int p = fireQueue.get(i);
         Weapon w = npcShip.getWeapon(p);
         npcAttackQueue.add(w);
			roundResults += "They fired their " + w.getName() + " <b>|||</b> ";
      }
	}
   
   public void endRound() {
		roundResults += "<br>";
		if(comRetreat == true) {
         if(retreatCount > 0) {
            roundResults += "You are attempting to retreat. You will retreat in " + retreatCount +" turns. ";
            retreatCount--;
         }
         else {
            roundResults += "You have retreated! ";
            combatEnd = true;
            attackQueue.clear();
            npcAttackQueue.clear();
         }
      }
      if(NpcRetreat == true) {
         if(NpcRetreatCount > 0) {
            roundResults += "They are attempting to retreat. They will retreat in " + NpcRetreatCount + " turns. ";
            NpcRetreatCount--;
         }
         else {
            roundResults += "They have retreated! ";
            combatEnd = true;
            attackQueue.clear();
            npcAttackQueue.clear();
         }
	  }
	  
	  //Power Strain
	  if(playerShip.getPower() < 0){
		  playerShip.repairHull(playerShip.getPower());
		  roundResults += "Your ship strains under the heavy power usage for " + Math.abs(playerShip.getPower()) + " damage <b>|||</b> ";
	  }
	  if(npcShip.getPower() < 0){
		npcShip.repairHull(npcShip.getPower());
		roundResults += "Their ship strains under the heavy power usage for " + Math.abs(npcShip.getPower()) + " damage <b>|||</b> ";
	}
	  
		roundResults += "<br>";
		ArrayList<Weapon> roundList = new ArrayList<Weapon>(attackQueue);
		ArrayList<Weapon> npcRoundList = new ArrayList<Weapon>(npcAttackQueue);
		for(int i = 0; i < roundList.size(); i++) {
			Weapon w = roundList.get(i);
			speedList.add(w.getSpeed());
		}
		for(int i = 0; i < npcRoundList.size(); i++) {
			Weapon w = npcRoundList.get(i);
			npcSpeedList.add(w.getSpeed());
		}
		ArrayList<Integer> roundSpeedList = new ArrayList<Integer>(speedList);
		ArrayList<Integer> npcRoundSpeedList = new ArrayList<Integer>(npcSpeedList);
		attackQueue.clear();
		npcAttackQueue.clear();
		speedList.clear();
		npcSpeedList.clear();

      //Attacks
      int playerTurns = roundList.size();
      int playerTurn = 0;
      int npcTurns = npcRoundList.size();
      int npcTurn = 0;
      while(playerTurns > playerTurn || npcTurns > npcTurn) {
         if(playerTurns > playerTurn){
            Weapon w = roundList.get(playerTurn);
            if(roundSpeedList.get(playerTurn) == 0) {
               roundResults += "You attack with your " + w.getName() + " it Lands: ";
               for(int i = 0; i < w.getAttacks(); i++) {
                  String r = w.makeAttack();
                  //System.out.println("player attack " + r);
                  if(r.equals("M")) {
                     roundResults += "Miss! ";
                  }
                  else if(r.equals("W")) {
                     npcShip.takeDamage(w.getDamage()/2,w.getDamageType());
					 roundResults += "Weak Hit ";
					 scoreCReward += 5;
                  }
                  else if(r.equals("C")) {
                     npcShip.takeDamage(w.getDamage()*2,w.getDamageType());
					 roundResults += "Crit ";
					 scoreCReward += 30;
					 xpCReward++;
                  }
                  else {
                     npcShip.takeDamage(w.getDamage(),w.getDamageType());
					 roundResults += "Hit ";
					 scoreCReward += 10;
                  }
               }
               
               roundResults += " <b>|||</b> ";
			   playerTurn ++;
			   
               
            }
            else {
				speedList.add(roundSpeedList.get(playerTurn) - 1);
				roundResults += "Your attack with" + w.getName() + " will arrive in " + speedList.get(playerTurn) + " turns <b>|||</b> ";
            	attackQueue.add(w);
            	playerTurn++;
            }
         }
         if(npcTurns > npcTurn){
            Weapon w = npcRoundList.get(npcTurn);
            if(npcRoundSpeedList.get(npcTurn) == 0) {
               //System.out.println("npc attack ");
               roundResults += "They attack with their " + w.getName() + " it Lands: ";
               for(int i = 0; i < w.getAttacks(); i++) {
                  String r = w.makeAttack();
                  //System.out.println("npc attack " + r);
                  if(r.equals("M")) {
							roundResults += "Miss! ";
							scoreCReward += 5;
                  }
                  else if(r.equals("W")) {
                     playerShip.takeDamage(w.getDamage()/2,w.getDamageType());
                     roundResults += "Weak Hit ";
                  }
                  else if(r.equals("C")) {
                     playerShip.takeDamage(w.getDamage()*2,w.getDamageType());
                     roundResults += "Crit ";
                  }
                  else {
                     playerShip.takeDamage(w.getDamage(),w.getDamageType());
                     roundResults += "Hit ";
                  }
               }
               
               roundResults += " <b>|||</b> ";
               npcTurn++;
               
            }
            else {
            	npcSpeedList.add(npcRoundSpeedList.get(npcTurn) - 1);
				npcAttackQueue.add(w);
				roundResults += "Their attack with" + w.getName() + " will arrive in " + npcSpeedList.get(npcTurn) + " turns <b>|||</b> ";
            	npcTurn++;
            }
         }

      }
      
      //Shields
      if(shieldPower > 0) {
         roundResults += "Your shields regen " + 20 * shieldPower + "% <b>|||</b> ";
         for(int i = 0; i < shieldPower; i++) {
            playerShip.regenShields();
         }
      }
      if(NpcShieldPower > 0) {
         roundResults += "Their shields regen " + 20 * NpcShieldPower + "% <b>|||</b> ";
         for(int i = 0; i < NpcShieldPower; i++) {
            npcShip.regenShields();
         }
      }
      
      if(playerShip.isAlive() == false) {
         combatEnd = true;
         roundResults += "You have perished!";
      }
      if(npcShip.isAlive() == false) {
         combatEnd = true;
         roundResults += "They have perished!";
      }
      
      updatePrimaryUI();
	  updateCombatUI();
	  roundResults += "</HTML>";
      lblCResults.setText(roundResults);
      roundResults = "<HTML>";
      
      if(combatEnd == true) {
         btnCombatEnd.setVisible(true);
         btnCombatEnd.setEnabled(true);
         btnCombatConfirm.setVisible(false);
         btnCombatConfirm.setEnabled(false);
   		btnCWeap1.setEnabled(false);
   		btnCWeap2.setEnabled(false);
   		btnCWeap3.setEnabled(false);
   		btnCWeap4.setEnabled(false);
   		btnCWeap5.setEnabled(false);
         btnShieldsC.setEnabled(false);
   		btnRetreat.setEnabled(false);
      }
      
      
	}
	
	public void updateSuccessUI() {
		lblSCredits.setText("Credits: " + creditsCReward);
		lblSXP.setText("XP: " + xpCReward);
	}

	public void updateFailUI() {
		lblFinalScore.setText("Final Score: " + player.getScore());
		lblTotalCredits.setText("Total Credits: " + player.getTotalCredits());
		lblTotalXP.setText("Total XP: " + player.getTotalXP());
	}
	
	public static void main(String[] args) {
		new FTLDriver();
	}
}

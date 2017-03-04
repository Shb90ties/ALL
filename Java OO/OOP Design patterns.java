abstract method
	// a method signature to be used by sub class
		// found in abstract class and interface
abstract class
	// class that has BOTH full methods and abstract methods
		// has ONE inheritance, cannot be inheritance of ingeritance
			// has constructure , A member can be static
			class subClass extends abstractClass
Polymorphism design
	// allows to write methods that don't need to change if new sub class appears
		// super.doMethod(); , uses abstract
			// can also @Override methods but doesn't have to
interface class
	// has ONLY abstract methods
		// support MULTIPLE inheritances
			// doesn't have constucture , A member cannot be static
private vars => Get(); Set();
	// needed for security reason and monitorying reason
		// ex: Set(int){ if(int < 10) return; else this.int = int }
Stategy pattern (Decupling)
	// Animal has Bird and Dog, all Birds needs to use fly, Dog doesn't fly
		itFLY,cantFLY implements FLY interface
		Dog,Bird implements Animal interface { FLY = null; }
		Dog{ Dog(){ super(); FLY = cantFLY(); } }
		Bird{ Bird(){ super(); FLY = itFLY(); } }
Factory pattern/method
	// A Method that returns multiple classes that belong to the same Super class
		// generate new classes under the same Super class
		public SHIP factory(string);
			smallShip,bigShip -> interface SHIP
abstract factory
	// Like Factory ^ but everything is encapsulated
		// everything is abstract
			// need to be used on interface that has multiple inheritance
Singleton pattern
	// When u need just ONE object of that class
		// ex: shared info object accross Threads
			private static Singleton = null;
			private Singleton(){..}
			public static Singleton getOBJ(){
				if(null){ create Singleton }
				else return the Singleton;
			}
Builder Desgin pattern
	// used to create object made out of other objects
		// the creation of these parts to be independent of the main object
			partA = new part(); partB = new ddd();
			mainObj(partA,partB);
Prototype pattern
	// use : clonning, copying
		// reduce the need to create multiple sub classes
			// creates a clone with the same info but different ID
				usually done with CloneFactory // clone methods will be in the objs
				Sheep{ makeCopy(){ return clone.this; } }
Decorator desgin
	// allows to modify object dynamically
		// when needed inheritance with some extra functionally 
			interface topping has Pizza obj = new basicPizza
				basicPizza implements Pizza interface
			CheezeTopping implements topping { return obj.price()+4 }
Command pattern
	// allows storing list of codes to be used later many times from the invoker
		// invoker transfers the command to the reciever(got all the code)
			TVturnON implements Command interface
			TV implements Device interface
			TVrunON{ Device TV; @Override void execute(){ TV.on(); } }
Adapter Desgin
	// allows to incompatible interface to work together
		// ex: got 3 plugs but only 2 holes, adapter to one hole extened to 3 holes
	EnemyRobot need only 1 method from EnemyAttacker interface
	Adapter{ EnemyRobot; when uneeded method is called do nothing }
Facade Design pattern
	// when an interface performs many actions behind the scene
		// ex: ATM.Withdrawel(50$), ATM gives 50$, remove 50$ from account
Bridge Design
	// Decouple abstract from objects so the two will work independently
		// Add functionality while seperating differences with abstract classes
	TV1, TV2 extends abstract TV { on(); & off(); }
	remote class { button3(); TV; }
	TV1{ onButton3(){ do AA; }} TV2{ onButton3(){ do BB; } }
Tamplete Method
	// create GROUP of subclass that has to execute GROUP of similar methods
	Anima[] a = {new Dog, new Bird}
	for{ a[i].MakeNoise(); }
Iterator Design pattern
	// let you go through alot of different types of objects from the same family
	ArrayList<Animal>(); add(new Cat); add(new Dog);
	ArrayList.Pop().MakeNoise();
Composite design
	// Lets you treat indevidual objects uniformly
	SongGroup implements SongComponents interface
	Song class || SongGroup{ Song[] songs,groupName,songComponents }
Flyweight
	// when needed to create ALOT of objects
		// Flyweight reduce memory usage by sharing objects that are similar
State Design
	// lets change status of an object
		ATM interface status = {hasCard , noCard} implements ATM
		insertCard() => ATM = new hasCard();
		EjectCard() => ATM = new noCard();
Proxy Design pattern
	// 1) done for security reason, Provide limited access to another class
		// 2) object is in a bad location and proxy is acting for it
	ATMProxy,ATMmachine implements ATM interface { methodA(); methodB(); }
	ATMProxy{ ATMmachine; methodA(){ ATMmachine.methodA() } methodB(){return} }
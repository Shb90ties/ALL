Common include
using System.Runtime.Remoting.Messaging;

[Serializable]
public class Request

public interface myICommon
Request AnalyzeRequest(Request r);
_________________________________________________________
using System.IO;
using System.Runtime.Serialization;
using System.Runtime.Serialization.Formatters.Binary;

using Common;

using System.Runtime.Remoting;
using System.Runtime.Remoting.Channels;
using System.Runtime.Remoting.Channels.Http;
	{ include in Reference Remoting Channels}
	
HttpChannel channel = new HttpChannel(1234);
ChannelServices.RegisterChannel(channel,false);
RemotingConfiguration.RegisterWellKnownServiceType(typeof(myServer),
                "myServer", WellKnownObjectMode.SingleCall);

public class myServer : MarshalByRefObject, myICommon

_________________________________________________________
Client same using as Server
....

HttpChannel channel = new HttpChannel();
ChannelServices.RegisterChannel(channel,false);
MyServer = (myICommon)Activator.GetObject(typeof(myICommon),"http://localhost:1234/myServer');

try
{
	serverobject.method....
}
catch
{
}
______________________________________________________________
____________
________
_________
___________
Saving Files_________________________________

using System.IO;
using System.Runtime.Serialization;
using System.Runtime.Serialization.Formatters.Binary;

FileStream FS = new FileStream("file1.dat",FileMode(typeof(class));
BinaryFormatters BF = new BinaryFormatters();
BF.Serialize(FS,new class...);
FS.Close();

_______________________________________________
Load File_____________________________

FileStream FS = null;
try{
FS = new FileStream("file1.dat",FileMode.Open);
BinaryFormatter BF = new BinaryFormatter();
class temp = (class)BF.Deserialize(FS);
}
____________________________________________________________
____________________________________________________________
Threads_____________________________
using System.Threading;
using System.Threading.Tasks;
using System.Timers;

if(this.invokeRequired){
	this.Invoke((MethodInvoker)delegate{....});
}else{ .... }

static AutoResetEvent AutoReset = new AutoResetEvent(false);
AutoReset.WaitOne();
AutoReset.Set();

Thread t = new Thread(new ParameterizedThreadStart(func));
t.start(args);

lock(this){....} // if more than one Thread tries to enter it on start

One way will Randomly work______________________
1) put WaitOne at start of function 
for(threads){ start all }
then SET one time, making the first thread to get there to run
2) Set when its over to call the next one

________________________________________________________________
________________________________________________________________
Drag Drop___________________

Draggin Button
	b.MouseDown += MouseEventHandler(function);
	or
	b.MouseDown += delegate(Object s,MouseEventArgs e){
		function(s,e,other...);
	}
	function(object sender,MouseEventArgs e,...){
		Button Drag = (Button)sender;
		Drag.DoDragDrop(argsClass, DragDropEffects.All);
	}

Dropping button
	b.AllowDrop = true;
	b.DragEnter += new DragEventHandler(functionInstallEffects);
	b.DragDrop += new DragEventHandler(function);
	
	functionInstallEffects(object s,DragEventArgs e){
		e.Effect = DragDropEffects.ALL;
	}
	
	function(object s,DragEventArgs e){
		Button D = (Button)sender;
		info = (String)e.Data.GetData(typeof(argsClass));
	}

________________________________________________________________
________________________________________________________________
	name space___
	public delegate void myEventFunction(string);
	class______
	event myEventClass E;
	Form1_____
	E += new myEventFunction(function);
	E += delegate(text){ function(text,other); }
	
	basic
	event EventHandler Ev;
	Ev += new EventHandler...

________________________________________________________________
________________________________________________________________
OO inheritance
   class Shape 
   {
      public void setWidth(int w)
      {
         width = w;
      }
      public void setHeight(int h)
      {
         height = h;
      }
      protected int width;
      protected int height;
   }
   
   class Rectangle: Shape
   {
      public int getArea()
      { 
         return (width * height); 
      }
   }
   
   abstract class Shape
   {
      public abstract int area();
   }
   class Rectangle:  Shape
   {
      private int length;
      private int width;
      public Rectangle( int a=0, int b=0)
      {
         length = a;
         width = b;
      }
      public override int area ()
      { 
         Console.WriteLine("Rectangle class area :");
         return (width * length); 
      }
   }
 ________________________________________________________________
 ________________________________________________________________
var ~ Object in C# ~ dynamic type, dynamic a = 50; dynamic a = 'sss';
Types :
	bool,byte(0-255,8bit),char,decimal(128bit),double,float(32bit),int,long,sbyte,short(16bit)
	uint,ulong,ushort // same size just unsinged
	sizeof(int) = 4 , int = 32 bit, long = 64 bit, byte = 8 bit
	sizeof(byte) = 1 // bits/8
	sizeof(decimal) = 16
Console.WriteLine("this is old")
.ToChar
.ToByte
.ToBoolean
....
DateTime value = new DateTime(2010, 1, 18);
DateTime.Today
DateTime x = new DateTime(-1, 1, 1); // error
DateTime.Today.AddDays(-1); // AddHours, AddMiliseconds, AddYears....
DateTime d = GetTomorrow();
DateTime.Now.ToString(); // 17/03/2016 // Now,Date,....
DateTime.Now.ToShortTimeString(); // 22:33
DateTime.Now.Day.ToString(); // Day,Year...
//__________
DateTime d = DateTime.Now;
DateTime dd = DateTime.Now.AddDays(-1);
b.Text = (d - dd).TotalHours.ToString(); // TotalDays... TotalMinutes...
List<Control> list // 
c.GetType() == typeof(Button)
// Generic
public Boolean ExistsList<T>(List<T> list,T obj)
{
	foreach (T i in list)
	{ if (i.Equals(obj)) return true; }
	return false;
}
Color.FromArgb(RED,GREEN,BLUE);
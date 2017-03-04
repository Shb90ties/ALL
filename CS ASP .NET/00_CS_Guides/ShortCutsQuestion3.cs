//________Client class___________//

using System.Runtime.Remoting;
using System.Runtime.Remoting.Channels.Http;
using System.Runtime.Remoting.Channels;

using Common;

using System.IO;
using System.Runtime.Serialization;
using System.Runtime.Serialization.Formatters.Binary;

ControlArgsFuncs CAF = new ControlArgsFuncs();
private ICommon myICommon;

HttpChannel channel = new HttpChannel();
ChannelServices.RegisterChannel(channel, false);
myICommon = (ICommon)Activator.GetObject(typeof(ICommon),"http://localhost:1234/_Server_");

//______Client GET function________//

myRequest result;
try
{ result = myICommon.getUpdated(request); }
catch
{ MessageBox.Show("Can't reach server"); return; }


//__________Server Class____________//

using System.Runtime.Remoting;
using System.Runtime.Remoting.Channels.Http;
using System.Runtime.Remoting.Channels;
using System.Collections;

using Common;

using System.IO;
using System.Runtime.Serialization;
using System.Runtime.Serialization.Formatters.Binary;

HttpChannel chnl = new HttpChannel(1234);
ChannelServices.RegisterChannel(chnl, false);
RemotingConfiguration.RegisterWellKnownServiceType(typeof(ServerPart),"_Server_",WellKnownObjectMode.Singleton);




class ServerPart : MarshalByRefObject, ICommon
{
	ControlArgsFuncs CAF = new ControlArgsFuncs();
	List<ControlArgs>[] Lst = new List<ControlArgs>[3];
	Boolean firstRun = true;
	
	public myRequest getUpdated(myRequest clientCurrent)
	{
		if(firstRun)
		{ for(int i=0; i<3; i++)
			{	// Server virables installation
				Lst[i] = new List<ControlArgs>();
			}}
		firstRun = false;
		// Actions
		return new myRequest(5);
	}
	
	static int myCompare(ControlArgs A,ControlArgs B)
    {
		if (A.getColorSum() > B.getColorSum()) return 1;
		if (A.getColorSum() < B.getColorSum()) return -1;
		return 0;
    }
}

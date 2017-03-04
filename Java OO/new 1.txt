Selection Sort // n^2
	remove smallest from old array put in new array
BaseBubble // n^2
	biggest element moves forward
MergeSort // n*logN
	split array then rebuilt it sorted
bucketSort // n+m
	[3,7,3] => [0,0,2,0,0,0,1]
QuickSort
	take the last element
		then scan the array all the numbers smaller than it on the left
			then place itself at end of the left
				and switch the number that was there to last
Dijkstra
	E * log V
Floyd warshall
	put distance from i to j in table [i,j], replace it if found smaller
	V^3
Bellman Ford
	checks if a loop exists
Ford
	return true/false if loop exists
MST, prim
	V^2 , builds singular tree
Union
	uniunize ^ the singular trees
DFS
	depth search
________________________________________________________________
ASP.NET
	ADO.NET
		using System.Data.SqlClient;
		using System.Data.OracleClient;
		using System.Data.OleDb;
		using System.Data.Odbc;
			SqlConnection con = new SqlConnection("data source=.; database=ChatProjectSQL; integrated security=SSPI");
			SqlCommand cmd = new SqlCommand("SELECT * FROM [dbo].[UsersStatus]", con);
			con.Open();
			SqlDataReader sdr = cmd.ExecuteReader();
			while(sdr.Read()){
				Label1.Text += (string)sdr["userName"]; }
		con.Close();
	ASP:FORM
		using System.Web.UI.HtmlControls;
			protected HiddenField[] serverClient;
			if (!Page.IsPostBack)
			HiddenField clientServer = new HiddenField();
            clientServer.ID = i.ToString() + 't';
			form1.Controls.Add(clientServer);
			var hiddn = document.getElementById(k.toString() + 't');
			<asp:Button ID="ZZZ" Text="B" runat="server" />
			ZZZ.Text = "R";
	ASP:Handler
		Updater = new ActiveXObject("Microsoft.XMLHTTP");
			Updater = new XMLHttpRequest();
				Updater.open("POST", url, true);
				Updater.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
				Updater.onreadystatechange = Anlyze;
				Updater.send();
					if( Updater.readyState == 4 )
						Updater.responseText;
					var array = string_.split("|");
		
		using System.Threading;
		using System.Web.Script.Serialization;
		Handler : IHttpAsyncHandler, System.Web.SessionState.IReadOnlySessionState
		IAsyncResult BeginProcessRequest(HttpContext ctx, AsyncCallback cb, Object obj)
			AsyncResult current = new AsyncResult(ctx, cb, obj);
			ThreadPool.QueueUserWorkItem(new WaitCallback(Analyze_Request), current);
			return current;
				Analyze_Request
				client.contxt.Response.ContentType = "application/x-www-form-urlencoded";
				client.contxt.Request.QueryString["cmd"];
		EndProcessRequest
		ProcessRequest
		IsReusable
		
		using System.Threading;
		using System.Collections.Generic;
		AsyncResult : IAsyncResult
		public HttpContext contxt;
		public AsyncCallback callBack;
		AsyncResult(HttpContext context, AsyncCallback callback, object data)
			this.contxt = context;
		Set_CompletedStatus
		public WaitHandle AsyncWaitHandle
		{
			get
			{
				return new ManualResetEvent(false);
			}
		}
		
		using System.Threading;
		private static object lock_ = new object();
		a.contxt.Response.Write("postIt|BBBB");
		
	Page.ClientScript.RegisterStartupScript(this.GetType(), "key", "DoDat()",true);
	
	Response.Redirect("http://www." + ((LinkButton)sender).Text);
	Request.QueryString["B"];
	
	Page.IsPostBack // when you click on a rerun="server" object
	
	Button1.Style["Position"] = "Absolute";
	
	document.onmousedown = mouseDownFunction;
    document.onmouseup = mouseUpFunction;
		in mouseDownFunction
			event.offsetX
			event.offsetY // of the mouse
			
	Toggle menu___________________________
	
	<button onclick="func">
	<div id="D" class="DD">...links..</div>
	
	func(){ document.element("D").classList.toggle("show"); }
	
	<style> DD{ display : none; position:absolute; background color: overflow: auto}
	
	option B_______________
	
	<script>
        $("#select").click(function () { $("#menu").slideToggle("fast"); });
    </script>
	
	
C#
	using System.Threading.Tasks;
	
	static AutoResetEvent AutoReset = new AutoResetEvent(false);
	AutoReset.WaitOne();
	AutoReset.Set();
	if (this.InvokeRequired)
    {
		this.Invoke((MethodInvoker)delegate { ChangePanelAndLabel(p, c, l, s); });
    }
	
	panels[i].Size = new Size(r.Next(30, 80), r.Next(30, 80));
	panels[i].Location = new Point(left, 30);
	
	myEvent += new EventHandler<myEventArgs>(myEventFunction);
	class myEventArgs : EventArgs
	myEventFunction(object sender,myEventArgs e)
	
	button1.MouseDown += new MouseEventHandler(SimpleDragFunction);
		// The Drop Button
	button2.AllowDrop = true;
	button2.DragEnter += new DragEventHandler(DropSETUP);
	button2.DragDrop += new DragEventHandler(DragDropped);

		// Drag with Extra elements
	button3.MouseDown += delegate(object s, MouseEventArgs e) { DragDelegateFunc(s, e, textBox1.Text); };
	
	public delegate void myEventFunction(string Text);
	public event myEventFunction myEvent;
	theEvent.myEvent += new myEventFunction(myFunctionA);
	
	Timer.Enabled:
	Timer.Interval:
	Timer.Start:
	Timer.Start:


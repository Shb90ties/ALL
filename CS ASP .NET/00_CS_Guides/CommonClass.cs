using System;
using System.Collections.Generic;
using System.Text;
using System.Runtime.Remoting.Messaging;
using System.Drawing;
using System.Collections;

namespace Common
{
    public interface ICommon 
    {
        myRequest getUpdated(myRequest clientCurrent);
    }

    [Serializable]
    public class myRequest
    {
        private ControlArgs[][] controls_ { get; set; }
		private Boolean emptyControls { get; set; }
        public int returnArrN { get; set; }
        public String myText { get; set; }
		
        public myRequest(int numberOfLists)
        {
            controls_ = new ControlArgs[numberOfLists][]; emptyControls = true;
            for(int i=0; i<numberOfLists; i++)
            { controls_[i] = new ControlArgs[1]; }
            returnArrN = 0;
            myText = "null";
        }
		
        public String ToMyString()
        {
            String string_ = "";
            string_ += returnArrN.ToString() + " ,";
            string_ += myText.ToString() + " ,";
            string_ += "Arrays : "+controls_.Length.ToString() + " ,\n";
			if (emptyControls) { return string_; }
            for (int i = 0; i < controls_.Length; i++ )
            {
                for (int j = 0; j < controls_[i].Length; j++ )
                { string_ += controls_[i][j].getColorSum().ToString() + " ,"; }
                string_ += "\n";
            }
            return string_;
        }

        public void setControls_(List<ControlArgs> listI,int index)
        {
			emptyControls = false;
            controls_[index] = new ControlArgs[listI.Count];
            int i = 0;
            foreach(ControlArgs j in listI)
            { controls_[index][i] = j; i++; }
        }

        public List<ControlArgs> getControls_(int index)
        {
            List<ControlArgs> temp = new List<ControlArgs>();
            for(int i=0; i<controls_[index].Length; i++)
            { temp.Add(controls_[index][i]); }
            return temp;
        }
    }

    [Serializable]
    public class ControlArgs
    {
        public int sWidth { get; set; }
        public int sHeight { get; set; }
        public int cRed { get; set; }
        public int cGreen { get; set; }
        public int cBlue { get; set; }
        public String tType { get; set; }
        public String tText { get; set; }
        public int getColorSum()
        { return (cRed + cGreen + cBlue); }
        public ControlArgs(){ tText = "null"; }
    }
}

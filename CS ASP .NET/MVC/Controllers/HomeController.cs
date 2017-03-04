using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace MvcApplication1.Controllers
{
    public class HomeController : Controller
    {

        public string Index()
        {
            return "MVC app";
        }

        // run function : http://localhost:port/Home/GetDetails
        public string GetDetails()
        {
            return "Dets";
        }

        // run function : http://localhost:port/Home/getReValue/?D=valll
        public string getReValue(string S)
        {
            return "from MVC : " + Request.QueryString["D"];
        }

    }
}

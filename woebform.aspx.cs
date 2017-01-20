using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Diagnostics;

namespace helloworld
{
    public partial class woebform : System.Web.UI.Page

    {
        private Stopwatch sw = null;
        protected void Page_Load(object sender, EventArgs e)
        {
            //string time = DateTime.Now.ToString("hh:mm:ss tt");
            //Response.Write(time);
            //dplShift.SelectedIndex = -1;
            if (sw != null)
            {
                sw.Stop();
                Response.Write("took " + sw.Elapsed.TotalSeconds.ToString("0.#######") + " seconds to generate this page");
            }

            if (!Page.IsPostBack)
            {
                dplShift.Items.Insert(0, new ListItem(string.Empty, string.Empty));
                dplShift.Items.Insert(1, new ListItem("Morning", "Morning"));
                dplShift.Items.Insert(2, new ListItem("Afternnon", "Afternnon"));
                dplShift.Items.Insert(3, new ListItem("Evening", "Evening"));
                dplShift.SelectedIndex = 0;
                sw = Stopwatch.StartNew();
            }
            else
            {

            }

        }

        protected void Page_PreInit(object sender, EventArgs e)
        {
            sw = Stopwatch.StartNew();
        }

        protected void btnSubmit_Click(object sender, EventArgs e)
        {
            ScriptManager.RegisterClientScriptBlock(this, this.GetType(), "alertMessage", "alert(' " + txtUserName.Text + "')", true);
            if (sw != null)
            {
                sw.Stop();
                Response.Write("took " + sw.Elapsed.TotalSeconds.ToString("0.#######") + " seconds to generate this page");
            }

        }


        //protected void validateCheckBoxes_ServerValidate(object source, ServerValidateEventArgs args)
        //{
        //    args.IsValid = (!chbEnglish.Checked && !chbKhmer.Checked && !chbFrench.Checked);
        //}


    }      
}

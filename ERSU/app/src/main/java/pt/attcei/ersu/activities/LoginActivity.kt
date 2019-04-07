package pt.attcei.ersu.activities

import android.content.Intent
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import pt.attcei.ersu.R
import pt.attcei.ersu.exceptions.ErseException
import pt.attcei.ersu.objects.LoginResponse
import pt.attcei.ersu.objects.Session
import pt.attcei.ersu.utils.ExceptionUtils
import java.lang.Exception
import java.lang.ref.WeakReference

class LoginActivity : AppCompatActivity() {

    lateinit var session : Session;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginTask = LoginTask(this)
        loginTask.execute("ID_TRUCK-1")
    }

    fun initSession(loginResponse : LoginResponse?){
        try{
            if (loginResponse == null){
                throw ErseException("001");
            }

            this.session = Session("testToken");
        }catch (e: ErseException){
            ExceptionUtils.Companion.buildErrorDialog(this,e);
        }

        //Launching next activity
        val intent = Intent(this, NavigationActivity::class.java)
        this.startActivity(intent);

    }

    companion object {
        class LoginTask(val activity : LoginActivity) : AsyncTask<String, Void, LoginResponse>(){

            private val context: WeakReference<LoginActivity> = WeakReference(activity);

            override fun doInBackground(vararg p0: String?): LoginResponse? {
                Thread.sleep(3000);
                return null;
            }


            override fun onPostExecute(result: LoginResponse?) {
                val activityContext = context.get();
                if(activityContext == null || activityContext.isFinishing) return

                activityContext.initSession(result);
            }

        }
    }
}

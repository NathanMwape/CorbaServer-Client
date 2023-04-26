import corbaBanque.Compte;
import corbaBanque.IBanqueRemote;
import corbaBanque.IBanqueRemoteHelper;
import org.omg.CORBA.Object;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ClientCORBA {
    public static void main(String[] args) {
        try {
            Context ctx= new InitialContext();
            Object ref = (Object) ctx.lookup("BK");
            IBanqueRemote stub= IBanqueRemoteHelper.narrow((Object) ref);
            System.out.println(stub.conversion(600));
            Compte c= stub.getCompte(4);
            System.out.println("Solde = "+c.solde);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

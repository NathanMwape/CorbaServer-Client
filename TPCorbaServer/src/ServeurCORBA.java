import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import service.BanqueImpl;

import javax.naming.Context;
import javax.naming.InitialContext;

public class ServeurCORBA {
    public static void main(String[] args) {
        try {
            ORB orb = ORB.init(args,null);
            Context ctx = new InitialContext();
            POA poa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            poa.the_POAManager().activate();
            BanqueImpl od = new BanqueImpl();
            ctx.rebind("BK",poa.servant_to_reference(od));
            orb.run();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

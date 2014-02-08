package jp.ac.aiit.jointry_broker;

import java.util.logging.Level;
import java.util.logging.Logger;
import jp.ac.aiit.jointry_broker.app.JointryBroker;
import jp.ac.aiit.jointry_broker.app.JointryBrokerDialog;
import jp.ac.aiit.jointry_broker.core.Broker;

public class JointryBrokerMain {

    private static Broker broker;
    private static final int PORT = 8081;

    public static void main(String[] args) {
        if (broker != null) {
            return;
        }

        try {
            broker = new JointryBroker(PORT, "jointry");
            broker.multiServer(true);

            JointryBrokerDialog.install();
        } catch (Exception ex) {
            System.out.println("既に起動している可能性があります。");
            System.out.println("止めるときはプロセス殺してください。");
            Logger.getLogger(JointryBrokerMain.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }

        broker.start(); //止めるときはプロセス殺してください

    }

}
